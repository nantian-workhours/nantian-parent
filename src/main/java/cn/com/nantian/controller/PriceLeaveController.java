package cn.com.nantian.controller;

import cn.com.nantian.pojo.NtLeaveInfo;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.service.PriceLeaveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description: 单价级别信息管理
 * @Author：Fly
 * @Date: 2019/3/21 11:05
 * @Version：1.0
 */
@Controller
public class PriceLeaveController {
    private static final Logger logger = LoggerFactory.getLogger(PriceLeaveController.class);
    @Resource
    private PriceLeaveService priceLeaveService;

    @InitBinder("ntLeaveInfo")
    public void initBindNtLeaveInfo(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.setFieldDefaultPrefix("ntLeaveInfo.");
    }

    /**
     * @Description: 查询单价级别信息列表
     * @Param: [ntLeaveInfo] 单价级别实体
     * @Return: cn.com.nantian.pojo.entity.ResponseData
     * @Auther: Fly
     * @Date: 2019/3/21 11:14
     **/
    @RequestMapping("/priceLeave/findAll")
    @ResponseBody
    public ResponseData findAll(@ModelAttribute("ntLeaveInfo") NtLeaveInfo ntLeaveInfo) {
        try {
            //查询单价级别列表
            List<NtLeaveInfo> ntLeaveInfoList = priceLeaveService.selectLeaveInfoList(ntLeaveInfo);
            //设置客户类别、工作类别、技术等级名称
            priceLeaveService.setLeaveInfoName(ntLeaveInfoList);
            //返回数据
            return ResponseData.ok().putDataValue("data", ntLeaveInfoList);
        } catch (Exception e) {
            logger.error("PriceLeaveController.findAll", e);
            return ResponseData.forbidden();
        }
    }

    /**
     * @Description: 删除一条单价级别信息数据
     * @Param: [ntLeaveInfo] 条件
     * @Return: cn.com.nantian.pojo.entity.ResponseData
     * @Auther: Fly
     * @Date: 2019/3/21 16:41
     **/
    @RequestMapping("/priceLeave/delete")
    @ResponseBody
    public ResponseData deleteNtLeaveInfo(@RequestParam("priceId") int priceId) {
        try {
            int num = priceLeaveService.deleteLeaveInfo(priceId);
            return ResponseData.ok().putDataValue("delete number", num);
        } catch (Exception e) {
            logger.error("PriceLeaveController.deleteNtLeaveInfo", e);
            return ResponseData.forbidden();
        }
    }

    /**
     * @Description: 新增单价级别信息
     * @Param: [ntLeaveInfo]
     * @Return: cn.com.nantian.pojo.entity.ResponseData
     * @Auther: Fly
     * @Date: 2019/3/21 16:56
     **/
    @RequestMapping("/priceLeave/add")
    @ResponseBody
    public ResponseData addNtLeaveInfo(@ModelAttribute("ntLeaveInfo") NtLeaveInfo ntLeaveInfo) {
        try {
            boolean isWhether= priceLeaveService.checkWhetherRepeat(ntLeaveInfo);
            if(!isWhether){//无
                int id = priceLeaveService.addLeaveInfo(ntLeaveInfo);
                return ResponseData.ok().putDataValue(" Add success num ", id);
            }else {//有
                return ResponseData.ok().putDataValue(" Add fail num ", "数据已存在，不能新增！");
            }
        } catch (Exception e) {
            logger.error("PriceLeaveController.addNtLeaveInfo", e);
            return ResponseData.forbidden();
        }
    }

    /**
     * @Description: 更新单价级别信息
     * @Param: [ntLeaveInfo] 条件
     * @Return: cn.com.nantian.pojo.entity.ResponseData
     * @Auther: Fly
     * @Date: 2019/3/21 16:58
     **/
    @RequestMapping("/priceLeave/update")
    @ResponseBody
    public ResponseData updateNtLeaveInfo(@ModelAttribute("ntLeaveInfo") NtLeaveInfo ntLeaveInfo) {
        try {
            int d = priceLeaveService.updateLeaveInfo(ntLeaveInfo);
            return ResponseData.ok().putDataValue("update number", d);
        } catch (Exception e) {
            logger.error("PriceLeaveController.updateNtLeaveInfo", e);
            return ResponseData.forbidden();
        }
    }

    /**
     * @Description: 查询单价级别信息详情
     * @Param: [priceId]
     * @Return: cn.com.nantian.pojo.entity.ResponseData
     * @Auther: Fly
     * @Date: 2019/3/22 9:46
     **/
    @RequestMapping("/priceLeave/findDetail")
    @ResponseBody
    public ResponseData findDetailNtLeaveInfo(@RequestParam("priceId") int priceId) {
        try {
            //查询客户类型集合
            NtLeaveInfo ntLeaveInfo = priceLeaveService.selectLeaveInfo(priceId);
            //设置客户类别、工作类别、技术等级 名称
            priceLeaveService.setLeaveInfoName(ntLeaveInfo);
            //返回数据
            return ResponseData.ok().putDataValue("data", ntLeaveInfo);
        } catch (Exception e) {
            logger.error("PriceLeaveController.findDetailNtLeaveInfo", e);
            return ResponseData.forbidden();
        }
    }
}
