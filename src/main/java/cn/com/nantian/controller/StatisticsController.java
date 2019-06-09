/**
 * @Description: 网站数据统计
 * @ClassName: StatisticsController
 * @author： Mr.Wind
 * @date: 2019/5/21 14:42
 * @Version： 1.0
 */
package cn.com.nantian.controller;

import cn.com.nantian.pojo.NtLeave;
import cn.com.nantian.pojo.NtPerInProject;
import cn.com.nantian.pojo.NtPersonnel;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.service.InProjectService;
import cn.com.nantian.service.LeaveService;
import cn.com.nantian.service.LoginLogService;
import cn.com.nantian.service.UserService;
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
import java.util.Map;

@Controller
public class StatisticsController {

    private static final Logger logger = LoggerFactory.getLogger(StatisticsController.class);

    @InitBinder("ntLeave")
    public void initBindNtLeave(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.setFieldDefaultPrefix("ntLeave.");
    }

    @InitBinder("ntPersonnel")
    public void initBindNtPersonnel(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.setFieldDefaultPrefix("ntPersonnel.");
    }

    @InitBinder("ntPerInProject")
    public void initBindNtPerInProject(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.setFieldDefaultPrefix("ntPerInProject.");
    }


    @Resource
    private LeaveService leaveService;
    @Resource
    private UserService userService;
    @Resource
    private LoginLogService loginLogService;
    @Resource
    private InProjectService inProjectService;


    /**
      * @description: 登录统计（活跃人数）信息
      * @auther: Mr.Wind
      * @date: 2019/5/21 14:46
      * @param:  [request]
      * @return: ResponseData
      **/
    @RequestMapping("/statistics/login")
    @ResponseBody
    public ResponseData getLoginStatistics(HttpServletRequest request) {
        try {
            return ResponseData.ok().putDataValue("data", null);
        } catch (Exception e) {
            logger.error("StatisticsController.getLoginStatistics", e);
            return ResponseData.forbidden();
        }
    }

    /**
     * @description: 工时统计信息
     * @auther: Mr.Wind
     * @date: 2019/5/21 14:46
     * @param:  [request]
     * @return: ResponseData
     **/
    @RequestMapping("/statistics/work/hours")
    @ResponseBody
    public ResponseData getWorkHoursStatistics(HttpServletRequest request) {
        try {
            return ResponseData.ok().putDataValue("data", null);
        } catch (Exception e) {
            logger.error("StatisticsController.getWorkHoursStatistics", e);
            return ResponseData.forbidden();
        }
    }


    /**
      * @description: 员工统计信息
      * @auther: Mr.Wind
      * @date: 2019/5/22 14:14
      * @param:  [request]
      * @return: ResponseData
      **/
    @RequestMapping("/statistics/user")
    @ResponseBody
    public ResponseData getUserStatistics(@ModelAttribute("ntPersonnel") NtPersonnel ntPersonnel) {
        try {
            Map<String,Object> data=userService.getStatisticalPersonnelNum(ntPersonnel);
            return ResponseData.ok().putDataValue("data", data);
        } catch (Exception e) {
            logger.error("StatisticsController.getUserStatistics", e);
            return ResponseData.forbidden();
        }
    }



    /**
     * @description: 根据客户类别分类 -统计员工人数
     * @auther: Mr.Wind
     * @date: 2019/5/22 14:14
     * @param:  [request]
     * @return: ResponseData
     **/
    @RequestMapping("/statistics/CustType/user")
    @ResponseBody
    public ResponseData getUserStatisticsCustType(@ModelAttribute("ntPerInProject") NtPerInProject perInProject) {
        try {
            Map<String,Object> data=inProjectService.getStatisticsNumByCustType(perInProject);
            return ResponseData.ok().putDataValue("data", data);
        } catch (Exception e) {
            logger.error("StatisticsController.getUserStatistics", e);
            return ResponseData.forbidden();
        }
    }

    /**
     * @description: 根据部门名称 -统计员工人数
     * @auther: Mr.Wind
     * @date: 2019/5/22 14:14
     * @param:  [request]
     * @return: ResponseData
     **/
    @RequestMapping("/statistics/dept/user")
    @ResponseBody
    public ResponseData getUserStatisticsDept(@ModelAttribute("ntPersonnel") NtPersonnel personnel) {
        try {
            Map<String, Object> statisticsUserNum = userService.getStatisticsUserNum(personnel);
            return ResponseData.ok().putDataValue("data", statisticsUserNum);
        } catch (Exception e) {
            logger.error("StatisticsController.getUserStatistics", e);
            return ResponseData.forbidden();
        }
    }

    /**
      * @description: 根据客户类型、部门名称查询时-统计员工人数
      * @auther: Mr.Wind
      * @date: 2019/6/9 12:33
      * @param:  [perInProject]
      * @return: cn.com.nantian.pojo.entity.ResponseData
      **/
    @RequestMapping("/statistics/cusType/dept/user")
    @ResponseBody
    public ResponseData getUserStatisticsCusTypeAndDept(@ModelAttribute("ntPerInProject") NtPerInProject perInProject) {
        try {
            Map<String, Object> statisticsUserNum = inProjectService.getStatisticsUserNum(perInProject);
            return ResponseData.ok().putDataValue("data", statisticsUserNum);
        } catch (Exception e) {
            logger.error("StatisticsController.getUserStatistics", e);
            return ResponseData.forbidden();
        }
    }


    /**
     * @description: 请假统计信息
     * @auther: Mr.Wind
     * @date: 2019/5/21 14:46
     * @param:  [request]
     * @return: ResponseData
     **/
    @RequestMapping("/statistics/leave")
    @ResponseBody
    public ResponseData getLeaveStatistics(@ModelAttribute("ntLeave") NtLeave ntLeave) {
        try {
            Map<String,Object> data=leaveService.getStatisticalLeaveTotal(ntLeave);
            return ResponseData.ok().putDataValue("data", data);
        } catch (Exception e) {
            logger.error("StatisticsController.getLeaveStatistics", e);
            return ResponseData.forbidden();
        }
    }


    /**
      * @description: 最近七天的用户访问量
      * @auther: Mr.Wind
      * @date: 2019/6/5 14:58
      * @param:  [ntLeave]
      * @return: ResponseData
      **/
    @RequestMapping("/statistics/views")
    @ResponseBody
    public ResponseData getViewsStatistics(HttpServletRequest request) {
        try {
            Map<String, Map<String,Object>> dataMap=loginLogService.getLoginLogStatisticsViews();
            return ResponseData.ok().putDataValue("data", dataMap);
        } catch (Exception e) {
            logger.error("StatisticsController.getViewsStatistics", e);
            return ResponseData.forbidden();
        }
    }

}
