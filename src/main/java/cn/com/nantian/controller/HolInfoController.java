/**
 * @description: 年假信息管理
 * @ClassName: HolInfoController
 * @Author： Mr.Wind
 * @date: 2019/3/29 16:13
 * @Version： 1.0
 */
package cn.com.nantian.controller;

import cn.com.nantian.common.UserAgentUtil;
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

    /**
     * @description: 查询年假信息列表
     * @auther: Mr.Wind
     * @date: 2019/3/29 16:39
     * @Param: [ntHolInfo]
     * @return: ResponseData
     **/
    @RequestMapping("/ntHolInfo/findAll")
    @ResponseBody
    public ResponseData findAll(HttpServletRequest request,
                                @ModelAttribute("ntHolInfo") NtHolInfo ntHolInfo) {
        try {
            //设置用户查询数据权限条件
            UserAgentUtil.setUserJurisdiction(request,ntHolInfo);
            List<NtHolInfo> holInfoList = holInfoService.selectHolInfoList(ntHolInfo);
            return ResponseData.ok().putDataValue("data", holInfoList);
        } catch (Exception e) {
            logger.error("HolInfoController.findAll", e);
            return ResponseData.forbidden();
        }
    }


}
