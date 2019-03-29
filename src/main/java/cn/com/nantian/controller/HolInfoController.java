/**
 * @Description:
 * @ClassName: HolInfoController
 * @Author： Mr.Kong
 * @Date: 2019/3/29 16:13
 * @Version： 1.0
 */
package cn.com.nantian.controller;

import cn.com.nantian.pojo.NtHolInfo;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.service.HolInfoService;
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
public class HolInfoController {
    private static final Logger logger = LoggerFactory.getLogger(HolInfoController.class);

    @Resource
    private HolInfoService holInfoService;

    @InitBinder("ntHolInfo")
    public void initBindNtHolInfo(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.setFieldDefaultPrefix("ntHolInfo.");
    }


    @RequestMapping("/ntHolInfo/findAll")
    @ResponseBody
    public ResponseData findAll(@ModelAttribute("ntHolInfo") NtHolInfo ntHolInfo) {
        try {
            List<NtHolInfo> holInfoList = holInfoService.selectHolInfoList(ntHolInfo);
            //leaveService.setLeaveTypeName(leaveList);
            return ResponseData.ok().putDataValue("data", holInfoList);
        } catch (Exception e) {
            logger.error("HolInfoController.findAll", e);
            return ResponseData.forbidden();
        }
    }
















}
