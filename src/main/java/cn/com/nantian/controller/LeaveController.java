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
     * @Description: 查询客户信息列表
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






















}
