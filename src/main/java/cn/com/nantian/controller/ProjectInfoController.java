package cn.com.nantian.controller;

import cn.com.nantian.common.ObjectUtils;
import cn.com.nantian.common.StringUtils;
import cn.com.nantian.pojo.NtProjectInfo;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.service.ProjectInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description: 客户管理
 * @auther: Mr.Wind
 **/
@Controller
@RequestMapping("/ntProjectInfo")
public class ProjectInfoController {
    private static final Logger logger = LoggerFactory.getLogger(ProjectInfoController.class);

    @Resource
    private ProjectInfoService projectInfoService;

    @InitBinder("ntProjectInfo")
    public void initBindNtProjectInfo(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.setFieldDefaultPrefix("ntProjectInfo.");
    }

    /**
     * @description: 查询客户信息列表
     * @Param: [NtProjectInfo] 客户实体
     * @return: ResponseData
     * @auther: Mr.Wind
     * @date: 2019/3/19 14:21
     **/
    @RequestMapping("/findAll")
    @ResponseBody
    public ResponseData findAll(@ModelAttribute("ntProjectInfo") NtProjectInfo ntProjectInfo) {
        try {
            List<NtProjectInfo> ntProjectInfoList = projectInfoService.selectNtProjectInfoList(ntProjectInfo);
            projectInfoService.setNtProjectInfoTypeName(ntProjectInfoList);
            return ResponseData.ok().putDataValue("data", ntProjectInfoList);
        } catch (Exception e) {
            logger.error("NtProjectInfoController.findAll", e);
            return ResponseData.forbidden();
        }
    }


    /**
     * @description: 根据项目编号删除一条数据
     * @Param: [projectNumber]  项目编号
     * @return: ResponseData
     * @auther: Mr.Wind
     * @date: 2019/3/20 11:21
     **/
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData deleteNtProjectInfo(@RequestParam("projectNumber") int projectNumber) {
        try {
            int num = projectInfoService.deleteNtProjectInfo(projectNumber);
            return ResponseData.ok().putDataValue("delete number", num);
        } catch (Exception e) {
            logger.error("NtProjectInfoController.deleteNtProjectInfo", e);
            return ResponseData.forbidden();
        }
    }

    /**
     * @description: 新增客户信息内容
     * @Param: [NtProjectInfo]
     * @return: ResponseData
     * @auther: Mr.Wind
     * @date: 2019/3/20 13:55
     **/
    @RequestMapping("/add")
    @ResponseBody
    public ResponseData addNtProjectInfo(@ModelAttribute("ntProjectInfo") NtProjectInfo ntProjectInfo) {
        try {
            String result = projectInfoService.checkAttribute(ntProjectInfo);
            if (StringUtils.isNotEmpty(result)) {//判断属性值是否为空
                return ResponseData.isfailed().putDataValue("error", result);
            }
            boolean repeat = projectInfoService.checkWhetherRepeat(ntProjectInfo);
            if (repeat) {//判断是否存在重复数据
                return ResponseData.isfailed().putDataValue("error", "数据已存在，请修改！");
            } else {
                int id = projectInfoService.addNtProjectInfo(ntProjectInfo);
                return ResponseData.ok().putDataValue(" Add success num ", id);
            }
        } catch (Exception e) {
            logger.error("NtProjectInfoController.addNtProjectInfo", e);
            return ResponseData.forbidden();
        }
    }

    /**
     * @description: 更新客户信息
     * @Param: [NtProjectInfo]
     * @return: ResponseData
     * @auther: Mr.Wind
     * @date: 2019/3/20 14:30
     **/
    @RequestMapping("/update")
    @ResponseBody
    public ResponseData updateNtProjectInfo(@ModelAttribute("ntProjectInfo") NtProjectInfo ntProjectInfo) {
        try {
            String result = projectInfoService.checkAttribute(ntProjectInfo);
            if (ObjectUtils.isNull(ntProjectInfo.getProjectNumber())) {
                result = "项目编号 不能为空！";
            }
            if (StringUtils.isNotEmpty(result)) {//判断属性值是否为空
                return ResponseData.isfailed().putDataValue("error", result);
            }
            boolean repeat = projectInfoService.checkUpdateWhetherRepeat(ntProjectInfo);
            if (repeat) {//判断是否存在重复数据
                return ResponseData.isfailed().putDataValue("error", "数据已存在，请修改！");
            } else {
                int d = projectInfoService.updateNtProjectInfo(ntProjectInfo);
                return ResponseData.ok().putDataValue("update number", d);
            }
        } catch (Exception e) {
            logger.error("NtProjectInfoController.updateNtProjectInfo", e);
            return ResponseData.forbidden();
        }
    }


    /**
     * @description: 根据项目编号查询详情
     * @auther: Mr.Wind
     * @date: 2019/3/27 14:28
     * @Param: [projectNumber] 项目编号
     * @return: ResponseData
     **/
    @RequestMapping("/findOne")
    @ResponseBody
    public ResponseData selectNtProjectInfoOne(@RequestParam("projectNumber") int projectNumber) {
        try {
            NtProjectInfo ntProjectInfo = projectInfoService.selectByPrimaryKey(projectNumber);
            projectInfoService.setNtProjectInfoTypeName(ntProjectInfo);
            return ResponseData.ok().putDataValue("data", ntProjectInfo);
        } catch (Exception e) {
            logger.error("NtProjectInfoController.addNtProjectInfo", e);
            return ResponseData.forbidden();
        }
    }
}
