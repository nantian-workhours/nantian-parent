/**
 * @Description: 网站数据统计
 * @ClassName: StatisticsController
 * @author： Mr.Kong
 * @date: 2019/5/21 14:42
 * @Version： 1.0
 */
package cn.com.nantian.controller;

import cn.com.nantian.pojo.entity.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StatisticsController {

    private static final Logger logger = LoggerFactory.getLogger(StatisticsController.class);


    /**
      * @description: 登录统计（活跃人数）信息
      * @auther: Mr.Kong
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
     * @auther: Mr.Kong
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
     * @description: 请假统计信息
     * @auther: Mr.Kong
     * @date: 2019/5/21 14:46
     * @param:  [request]
     * @return: ResponseData
     **/
    @RequestMapping("/statistics/leave")
    @ResponseBody
    public ResponseData getLeaveStatistics(HttpServletRequest request) {
        try {
            return ResponseData.ok().putDataValue("data", null);
        } catch (Exception e) {
            logger.error("StatisticsController.getLeaveStatistics", e);
            return ResponseData.forbidden();
        }
    }
}
