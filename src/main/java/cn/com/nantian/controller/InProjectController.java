package cn.com.nantian.controller;

import cn.com.nantian.common.ObjectUtils;
import cn.com.nantian.common.StringUtils;
import cn.com.nantian.pojo.NtPerInProject;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.service.InProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
  * @description: 员工所在项目管理
  * @auther: Mr.Kong
  * @date: 2019/5/8 16:46
  **/
@Controller
@RequestMapping("/user/project")
public class InProjectController {
    private static final Logger logger = LoggerFactory.getLogger(InProjectController.class);

    @InitBinder("ntPerInProject")
    public void initBindNtPerInProject(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.setFieldDefaultPrefix("ntPerInProject.");
    }

    @Resource
    private InProjectService inProjectService;

    /**
      * @description: 添加员工所在项目信息
      * @auther: Mr.Kong
      * @date: 2019/5/8 16:50
      * @Param:  [ntPerInProject]
      * @return: ResponseData
      **/
    @RequestMapping("/add")
    @ResponseBody
    public ResponseData addPerInProject(@ModelAttribute("ntPerInProject") NtPerInProject ntPerInProject){
        try {
            //效验传入参数值
            String result=inProjectService.checkAttribute(ntPerInProject);
            if (StringUtils.isNotEmpty(result)){
                return ResponseData.isfailed().putDataValue("error",result);
            }
            //效验数据是否已存在
            boolean repeat=inProjectService.checkWhetherRepeat(ntPerInProject);
            if (repeat){
                return ResponseData.isfailed().putDataValue("error","数据已存在 请修改！");
            }else{
                int a = inProjectService.addPerInProject(ntPerInProject);
                return ResponseData.ok().putDataValue("添加成功",a);
            }
        } catch (Exception e) {
            logger.error("InProjectController.addPerInProject", e);
            return ResponseData.serverInternalError();
        }
    }

    /**
      * @description: 查询员工所在项目列表数据
      * @auther: Mr.Kong
      * @date: 2019/5/9 14:31
      * @Param:  [ntPerInProject]
      * @return: ResponseData
      **/
    @RequestMapping("/findAll")
    @ResponseBody
    public ResponseData findAll(@ModelAttribute("ntPerInProject") NtPerInProject ntPerInProject){
        try {
            List<NtPerInProject> ntPerInProjectList = inProjectService.queryNtPerInProjectList(ntPerInProject);
            inProjectService.setWorkStatus(ntPerInProjectList);
            return ResponseData.ok().putDataValue("data",ntPerInProjectList);
        } catch (Exception e) {
            logger.error("InProjectController.findAll", e);
            return ResponseData.serverInternalError() ;
        }
    }

    /**
      * @description: 查询员工所在项目详情信息
      * @auther: Mr.Kong
      * @date: 2019/5/9 15:49
      * @Param:  [id]
      * @return: ResponseData
      **/
    @RequestMapping("/findInfo")
    @ResponseBody
    public ResponseData findInfo(@RequestParam("id") int id){
        try {
            NtPerInProject ntPerInProject = inProjectService.queryPerInProjectInfo(id);
            return ResponseData.ok().putDataValue("data",ntPerInProject);
        } catch (Exception e) {
            logger.error("InProjectController.findInfo", e);
            return ResponseData.serverInternalError() ;
        }
    }

    /**
      * @description: 更新员工所在项目信息
      * @auther: Mr.Kong
      * @date: 2019/5/9 16:34
      * @Param:  [ntPerInProject]
      * @return: ResponseData
      **/
    @RequestMapping("/update")
    @ResponseBody
    public ResponseData updatePerInProject(@ModelAttribute("ntPerInProject") NtPerInProject ntPerInProject){
        try {
            //效验传入参数值
            String result=inProjectService.checkAttribute(ntPerInProject);
            if (ObjectUtils.isNull(ntPerInProject.getId())){
                result="主键id 不能为空！";
            }
            if (StringUtils.isNotEmpty(result)){
                return ResponseData.isfailed().putDataValue("error",result);
            }
            //效验数据是否已存在
            boolean repeat=inProjectService.checkUpdateWhetherRepeat(ntPerInProject);
            if (repeat){
                return ResponseData.isfailed().putDataValue("error","数据已存在 请修改！");
            }else{
                int a = inProjectService.updateNtPerInProject(ntPerInProject);
                return ResponseData.ok().putDataValue("修改成功",a);
            }
        } catch (Exception e) {
            logger.error("InProjectController.updatePerInProject", e);
            return ResponseData.serverInternalError().putDataValue("", e.toString());
        }
    }
}





