/**
 * @Description:
 * @ClassName: LeaveController
 * @Author： Mr.Kong
 * @Date: 2019/3/29 15:02
 * @Version： 1.0
 */
package cn.com.nantian.controller;

import cn.com.nantian.pojo.NtLeave;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.service.LeaveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LeaveController {

    private static final Logger logger = LoggerFactory.getLogger(LeaveController.class);

    @Resource
    private LeaveService leaveService;

    @InitBinder("ntLeave")
    public void initBindNtLeave(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.setFieldDefaultPrefix("ntLeave.");
    }

    /**
     * @Description: 查询请假信息列表
     * @Param: [NtProjectInfo] 客户实体
     * @Return: cn.com.nantian.pojo.entity.ResponseData
     * @Auther: Fly
     * @Date: 2019/3/19 14:21
     **/
    @RequestMapping("/ntLeave/findAll")
    @ResponseBody
    public ResponseData findAll(@ModelAttribute("ntLeave") NtLeave leave) {
        try {
            List<NtLeave> leaveList = leaveService.selectLeaveList(leave);
            leaveService.setLeaveTypeName(leaveList);
            return ResponseData.ok().putDataValue("data", leaveList);
        } catch (Exception e) {
            logger.error("LeaveController.findAll", e);
            return ResponseData.forbidden();
        }
    }

    /**
     * @Description: 请假申请录入
     * @Auther: Mr.Kong
     * @Date: 2019/3/29 15:45
     * @Param: [leave]
     * @Return: cn.com.nantian.pojo.entity.ResponseData
     **/
    @RequestMapping("/ntLeave/add")
    @ResponseBody
    public ResponseData insert(@ModelAttribute("ntLeave") NtLeave leave) {
        try {
            int id = leaveService.insertSelective(leave);
            return ResponseData.ok().putDataValue(" Add success num ", id);
        } catch (Exception e) {
            logger.error("LeaveController.insert", e);
            return ResponseData.forbidden();
        }
    }

    /**
     * @Description: 更新审批状态(R 审核中, Y 通过, N 退回)
     * @Auther: Mr.Kong
     * @Date: 2019/3/29 15:50
     * @Param: [leave]
     * @Return: cn.com.nantian.pojo.entity.ResponseData
     **/
    @RequestMapping("/ntLeave/update")
    @ResponseBody
    public ResponseData update(@ModelAttribute("ntLeave") NtLeave leave) {
        try {
            int d = leaveService.updateLeaveStatus(leave);
            return ResponseData.ok().putDataValue("update number", d);
        } catch (Exception e) {
            logger.error("LeaveController.update", e);
            return ResponseData.forbidden();
        }
    }
}
