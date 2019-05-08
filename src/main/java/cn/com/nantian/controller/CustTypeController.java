package cn.com.nantian.controller;

import cn.com.nantian.common.ObjectUtils;
import cn.com.nantian.common.StringUtils;
import cn.com.nantian.pojo.NtCustType;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.service.CustTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description: 客户类别管理
 * @Author： Mr.Kong
 * @Date: 2019/3/20 14:46
 * @Version： 1.0
 */
@Controller
@RequestMapping("/custType")
public class CustTypeController {
    private static final Logger logger = LoggerFactory.getLogger(CustTypeController.class);

    @InitBinder("ntCustType")
    public void initBindNtCustType(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.setFieldDefaultPrefix("ntCustType.");
    }

    @Resource
    private CustTypeService custTypeService;

    /**
     * @Description: 查询客户信息列表
     * @Param: [customer] 客户实体
     * @Return: cn.com.nantian.pojo.entity.ResponseData
     * @Auther: Mr.Kong
     * @Date: 2019/3/19 14:21
     **/
    @RequestMapping("/findAll")
    @ResponseBody
    public ResponseData findAll(@ModelAttribute("ntCustType") NtCustType ntCustType) {
        try {
            //查询客户类型集合
            List<NtCustType> customerList = custTypeService.selectCustTypeList(ntCustType);
            //设置客户类别、工作类别、技术等级 名称
            custTypeService.setCustTypeName(customerList);
            //返回数据
            return ResponseData.ok().putDataValue("data", customerList);
        } catch (Exception e) {
            logger.error("CustTypeController.findAll", e);
            return ResponseData.forbidden();
        }
    }

    /**
     * @Description: 根据项目编号删除一条数据
     * @Param: [projectNumber]  项目编号
     * @Return: cn.com.nantian.pojo.entity.ResponseData
     * @Auther: Mr.Kong
     * @Date: 2019/3/20 11:21
     **/
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData deleteCustType(@RequestParam("custId") int custId) {
        try {
            int num = custTypeService.deleteCustType(custId);
            return ResponseData.ok().putDataValue("delete number", num);
        } catch (Exception e) {
            logger.error("CustTypeController.deleteCustType", e);
            return ResponseData.forbidden();
        }
    }

    /**
     * @Description: 新增客户类别 1
     * @Param: [custType]
     * @Return: cn.com.nantian.pojo.entity.ResponseData
     * @Auther: Mr.Kong
     * @Date: 2019/3/20 16:50
     **/
    @RequestMapping("/add")
    @ResponseBody
    public ResponseData addCustType(@ModelAttribute("ntCustType") NtCustType ntCustType) {
        try {
            String result = custTypeService.checkAttribute(ntCustType);
            if (StringUtils.isNotEmpty(result)) {//判断属性值是否为空
                return ResponseData.isfailed().putDataValue("error", result);
            }
            boolean repeat = custTypeService.checkWhetherRepeat(ntCustType);
            if (repeat) {//判断是否存在重复数据
                return ResponseData.isfailed().putDataValue("error", "数据已存在，请修改！");
            } else {
                int id = custTypeService.addCustType(ntCustType);
                return ResponseData.ok().putDataValue("success", id);
            }
        } catch (Exception e) {
            logger.error("CustTypeController.addCustType", e);
            return ResponseData.forbidden();
        }
    }

    /**
     * @Description: 更新客户信息
     * @Param: [customer]
     * @Return: cn.com.nantian.pojo.entity.ResponseData
     * @Auther: Mr.Kong
     * @Date: 2019/3/20 14:30
     **/
    @RequestMapping("/update")
    @ResponseBody
    public ResponseData updateCustType(@ModelAttribute("ntCustType") NtCustType ntCustType) {
        try {
            String result = custTypeService.checkAttribute(ntCustType);
            if (ObjectUtils.isNull(ntCustType.getCustId())) {
                result = "主键ID 不能为空";
            }
            if (StringUtils.isNotEmpty(result)) {//判断属性值是否为空
                return ResponseData.isfailed().putDataValue("error", result);
            }
            boolean repeat = custTypeService.checkUpdateWhetherRepeat(ntCustType);
            if (repeat) {//判断是否存在重复数据
                return ResponseData.isfailed().putDataValue("error", "数据已存在，请修改！");
            } else {
                int d = custTypeService.updateCustType(ntCustType);
                return ResponseData.ok().putDataValue("success", d);
            }
        } catch (Exception e) {
            logger.error("CustTypeController.updateCustType", e);
            return ResponseData.forbidden();
        }
    }

    /**
     * @Description: 查询客户类别详情
     * @Param: [custType]
     * @Return: cn.com.nantian.pojo.entity.ResponseData
     * @Auther: Mr.Kong
     * @Date: 2019/3/20 17:19
     **/
    @RequestMapping("/findDetail")
    @ResponseBody
    public ResponseData findDetail(@RequestParam("custId") int custId) {
        try {
            //查询客户类型集合
            NtCustType custTypeKey = custTypeService.selectCustType(custId);
            //设置客户类别、工作类别、技术等级 名称
            custTypeService.setCustTypeName(custTypeKey);
            //返回数据
            return ResponseData.ok().putDataValue("data", custTypeKey);
        } catch (Exception e) {
            logger.error("CustTypeController.findDetail", e);
            return ResponseData.forbidden();
        }
    }
}
