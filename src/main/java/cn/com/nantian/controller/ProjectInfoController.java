package cn.com.nantian.controller;

import cn.com.nantian.pojo.NtProjectInfo;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.pojo.entity.Result;
import cn.com.nantian.service.ProjectInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

//客户管理
@Controller
@RequestMapping("/NtProjectInfo")
public class ProjectInfoController {
    private static final Logger logger = LoggerFactory.getLogger(ProjectInfoController.class);

    @Resource
    private ProjectInfoService NtProjectInfoService;

    @InitBinder("NtProjectInfo")
    public void initBindNtProjectInfo(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.setFieldDefaultPrefix("NtProjectInfo.");
    }

    /**
     * @Description: 查询客户信息列表
     * @Param: [NtProjectInfo] 客户实体
     * @Return: cn.com.nantian.pojo.entity.ResponseData
     * @Auther: Fly
     * @Date: 2019/3/19 14:21
     **/
    @RequestMapping("/findAll")
    @ResponseBody
    public ResponseData findAll(@ModelAttribute("NtProjectInfo") NtProjectInfo NtProjectInfo) {
        try {
            List<NtProjectInfo> NtProjectInfoList = NtProjectInfoService.selectPerInProjectList(NtProjectInfo);
            NtProjectInfoService.setNtProjectInfoTypeName(NtProjectInfoList);
            return ResponseData.ok().putDataValue("data", NtProjectInfoList);
        } catch (Exception e) {
            logger.error("NtProjectInfoController.findAll", e);
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
    public ResponseData deleteNtProjectInfo(@RequestParam("projectNumber") int projectNumber) {
        try {
            int num = NtProjectInfoService.deleteNtProjectInfo(projectNumber);
            return ResponseData.ok().putDataValue("delete number", num);
        } catch (Exception e) {
            logger.error("NtProjectInfoController.deleteNtProjectInfo", e);
            return ResponseData.forbidden();
        }
    }

    /**
     * @Description: 新增客户信息内容
     * @Param: [NtProjectInfo]
     * @Return: cn.com.nantian.pojo.entity.ResponseData
     * @Auther: Fly
     * @Date: 2019/3/20 13:55
     **/
    @RequestMapping("/add")
    @ResponseBody
    public ResponseData addNtProjectInfo(@ModelAttribute("NtProjectInfo") NtProjectInfo NtProjectInfo) {
        try {
            int id = NtProjectInfoService.addNtProjectInfo(NtProjectInfo);
            return ResponseData.ok().putDataValue(" Add success num ", id);
        } catch (Exception e) {
            logger.error("NtProjectInfoController.addNtProjectInfo", e);
            return ResponseData.forbidden();
        }
    }

    /**
     * @Description: 更新客户信息
     * @Param: [NtProjectInfo]
     * @Return: cn.com.nantian.pojo.entity.ResponseData
     * @Auther: Fly
     * @Date: 2019/3/20 14:30
     **/
    @RequestMapping("/update")
    @ResponseBody
    public ResponseData updateNtProjectInfo(@ModelAttribute("NtProjectInfo") NtProjectInfo NtProjectInfo) {
        try {
            int d = NtProjectInfoService.updateNtProjectInfo(NtProjectInfo);
            return ResponseData.ok().putDataValue("update number", d);
        } catch (Exception e) {
            logger.error("NtProjectInfoController.updateNtProjectInfo", e);
            return ResponseData.forbidden();
        }
    }

    //新增客户类别管理
    @RequestMapping("addtype")
    @ResponseBody
    public Result addType(String projectName, Map<String, String> type, String leave) {
        try {
            NtProjectInfoService.addCustType(projectName, type, leave);
            return new Result(true, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "添加失败");
        }
    }
}
