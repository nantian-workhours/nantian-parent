package cn.com.nantian.controller;


import cn.com.nantian.common.*;
import cn.com.nantian.pojo.*;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
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
    @Resource
    private WorkHoursService workHoursService;


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
            //本月请假总天数
            NtLeave ntLeave=new NtLeave();
            ntLeave.setPerId(personnel.getPerId());
            ntLeave.setBegDate(DateUtils.getMonthFirstDayDate());
            ntLeave.setEndDate(DateUtils.getMonthLastDayDate());
            Float leaveDays = leaveService.queryMonthLeaveCount(ntLeave);
            dataMap.put("leaveDays",leaveDays);
            NtWorkingHoursKey work=new NtWorkingHoursKey();
            work.setPerId(personnel.getPerId());
            work.setWorkDate(new Date());
            //本月加班总小时数
            Float workHours = workHoursService.queryMonthWorkHours(work);
            dataMap.put("workHours",workHours);
            //本月正常上班总天数
            int workDays = workHoursService.queryMonthWorkDays(work);
            dataMap.put("workDays",workDays);
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
