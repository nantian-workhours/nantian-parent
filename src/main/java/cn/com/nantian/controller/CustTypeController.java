package cn.com.nantian.controller;

import cn.com.nantian.pojo.NtCustTypeKey;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.service.CustTypeService;
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

/**
 * @Description: 客户类别管理
 * @Author： Fly
 * @Date: 2019/3/20 14:46
 * @Version： 1.0
 */
@Controller
@RequestMapping("/custType")
public class CustTypeController {
    private static final Logger logger = LoggerFactory.getLogger(CustTypeController.class);

    @Resource
    private CustTypeService custTypeService;


    @InitBinder("ntCustType")
    public void initBindNtCustType(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.setFieldDefaultPrefix("ntCustType.");
    }

    /**
     * @Description: 查询客户信息列表
     * @Param: [customer] 客户实体
     * @Return: cn.com.nantian.pojo.entity.ResponseData
     * @Auther: Fly
     * @Date: 2019/3/19 14:21
     **/
    @RequestMapping("/findAll")
    @ResponseBody
    public ResponseData findAll(@ModelAttribute("ntCustType") NtCustTypeKey ntCustType) {
        try {
            //查询客户类型集合
            List<NtCustTypeKey> customerList = custTypeService.selectCustTypeList(ntCustType);
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
     * @Auther: Fly
     * @Date: 2019/3/20 11:21
     **/
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData deleteCustType(@ModelAttribute("ntCustType") NtCustTypeKey ntCustType) {
        try {
            int num = custTypeService.deleteCustType(ntCustType);
            return ResponseData.ok().putDataValue("delete number", num);
        } catch (Exception e) {
            logger.error("CustTypeController.deleteCustType", e);
            return ResponseData.forbidden();
        }
    }

    /**
     * @Description: 新增客户类别
     * @Param: [custType]
     * @Return: cn.com.nantian.pojo.entity.ResponseData
     * @Auther: Fly
     * @Date: 2019/3/20 16:50
     **/
    @RequestMapping("/add")
    @ResponseBody
    public ResponseData addCustomer(@ModelAttribute("ntCustType") NtCustTypeKey ntCustType) {
        try {
            int id = custTypeService.addCustType(ntCustType);
            return ResponseData.ok().putDataValue(" Add success num ", id);
        } catch (Exception e) {
            logger.error("CustTypeController.addCustomer", e);
            return ResponseData.forbidden();
        }
    }

    /**
     * @Description: 更新客户信息
     * @Param: [customer]
     * @Return: cn.com.nantian.pojo.entity.ResponseData
     * @Auther: Fly
     * @Date: 2019/3/20 14:30
     **/
    @RequestMapping("/update")
    @ResponseBody
    public ResponseData updateCustType(@ModelAttribute("ntCustType") NtCustTypeKey ntCustType) {
        try {
            int d = custTypeService.updateCustType(ntCustType);
            return ResponseData.ok().putDataValue("update number", d);
        } catch (Exception e) {
            logger.error("CustTypeController.updateCustType", e);
            return ResponseData.forbidden();
        }
    }

    /**
     * @Description: 查询客户类别详情
     * @Param: [custType]
     * @Return: cn.com.nantian.pojo.entity.ResponseData
     * @Auther: Fly
     * @Date: 2019/3/20 17:19
     **/
    @RequestMapping("/findDetail")
    @ResponseBody
    public ResponseData findDetail(@ModelAttribute("ntCustType") NtCustTypeKey ntCustType) {
        try {
            //查询客户类型集合
            NtCustTypeKey custTypeKey = custTypeService.selectCustType(ntCustType);
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
