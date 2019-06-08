package cn.com.nantian.controller;


import cn.com.nantian.common.*;
import cn.com.nantian.pojo.LoginLog;
import cn.com.nantian.pojo.NtLeave;
import cn.com.nantian.pojo.NtPersonnel;
import cn.com.nantian.pojo.NtPersonnelApply;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.service.LeaveService;
import cn.com.nantian.service.LoginLogService;
import cn.com.nantian.service.NtPersonnelApplyService;
import cn.com.nantian.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 登录的controller
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private UserService userService;
    @Resource
    private LoginLogService loginLogService;
    @Resource
    private LeaveService leaveService;
    @Resource
    private NtPersonnelApplyService personnelApplyService;

    /**
      * @description:  系统登录
      * @auther: Mr.Wind
      * @date: 2019/5/17 16:48
      * @param:  [response, name, password]
      * @return: ResponseData
      **/
    @RequestMapping("/login")
    @ResponseBody
    public ResponseData login(HttpServletRequest request, HttpServletResponse response,
                              String name, String password) {
        try {
            Map<String,Object> dataMap=new HashMap<>();
            //效验传入的登录用户名、密码
            String result = userService.checkLoginParameter(name,password);
            if (StringUtils.isNotEmpty(result)) {
                return ResponseData.isfailed().putDataValue("error", result);
            }
            NtPersonnel personnel = userService.findOne(name);
            String uuid = StringUtils.createUUID().replace("-", "");
            dataMap.put("personnel",personnel);
            WebUtils.setCookie(response, SysUserConstants.sidadmin, uuid,2);
            this.setSessionAttribute(request,uuid,personnel);
            //本月请假天数
            NtLeave ntLeave=new NtLeave();
            ntLeave.setBegDate(DateUtils.getMonthFirstDayDate());
            ntLeave.setEndDate(DateUtils.getMonthLastDayDate());
            List<NtLeave> ntLeaveList = leaveService.selectLeaveList(ntLeave);
            Float leaveDays=0f;
            if (ObjectUtils.isNotNull(ntLeaveList)){
                for (NtLeave leave:ntLeaveList){
                    leaveDays+=leave.getLeaveCount();
                }
            }
            dataMap.put("leaveDays",leaveDays);
            //本月加班小时数
            dataMap.put("workHours","30");
            //本月正常上班天数
            dataMap.put("workDays","20");
            //代办事项-异议申请待审核
            NtPersonnelApply personnelApply=new NtPersonnelApply();
            personnelApply.setApplyStatus(ParamUntil.R);
            List<NtPersonnelApply> personApplyList = personnelApplyService.queryPersonApplyList(personnelApply);
            dataMap.put("personApplyList",personApplyList);
            //代办事项-请假待审核
            NtLeave leave=new NtLeave();
            leave.setApplyStatus(ParamUntil.R);
            List<NtLeave> leaveList = leaveService.selectLeaveList(leave);
            dataMap.put("leaveList",leaveList);
            //最新一条登录日志信息
            LoginLog loginLog=loginLogService.queryLoginLogNewestOne(null);
            dataMap.put("loginLog",loginLog);
            // 添加登录日志记录
            loginLogService.insertLoginLog(request,personnel);
            logger.info(" ++++ sysUser login success: " + personnel.getName() + " is logined ok !");
            return ResponseData.ok().putDataValue("data",dataMap);
        } catch (Exception e) {
            logger.error("LoginController.login", e);
            return ResponseData.forbidden().putDataValue("error","系统异常，请稍后再试！");
        }
    }

    /**
      * @description: 退出系统操作
      * @auther: Mr.Wind
      * @date: 2019/6/6 11:12
      * @param:  [request, response]
      * @return: ResponseData
      **/
    @RequestMapping("/exit")
    @ResponseBody
    public ResponseData logout(HttpServletRequest request, HttpServletResponse response) {
        String sid = WebUtils.getCookie(request, SysUserConstants.sidadmin);
        request.getSession().removeAttribute(sid);
        WebUtils.deleteCookie(request,response,SysUserConstants.sidadmin);
        return ResponseData.ok().putDataValue("data","退出系统操作成功！");
    }
}
