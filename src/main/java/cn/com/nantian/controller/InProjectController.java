package cn.com.nantian.controller;

import cn.com.nantian.pojo.InProjectItem;
import cn.com.nantian.pojo.NtPerInProject;
import cn.com.nantian.pojo.NtPersonnel;
import cn.com.nantian.pojo.NtProjectInfo;
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
  * @Description: 员工所在项目管理
  * @Auther: Mr.Kong
  * @Date: 2019/5/8 16:46
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
      * @Description: 添加员工所在项目信息
      * @Auther: Mr.Kong
      * @Date: 2019/5/8 16:50
      * @Param:  [ntPerInProject]
      * @Return: cn.com.nantian.pojo.entity.ResponseData
      **/
    @RequestMapping("/add")
    @ResponseBody
    public ResponseData addPerInProject(@ModelAttribute("ntPerInProject") NtPerInProject ntPerInProject){
            int a = 0;
        try {
            //效验传入参数值
            a = inProjectService.addPerInProject(ntPerInProject);
            if(a > 0){
                //添加成功
                return ResponseData.ok().putDataValue("status","add success " + a);
            }else  if(a == -1){
                //该员工在这个项目组中新建的时间是否比结束时间早
                return ResponseData.customerError().putDataValue("status","The employee hasn't finished the project yet");
            }else  if(a == -2){
                //开始时间比接受时间早
                return ResponseData.customerError().putDataValue("status","The end time is earlier than the start time");
            }else {
                //查询失败
                return ResponseData.isfailed().putDataValue("status","add failed");
            }
        } catch (Exception e) {
            logger.error("CustTypeController.addPerInProject", e);
            return ResponseData.serverInternalError();
        }
    }

    /**
     *查询所有项目信息
     * @return
     */
    @RequestMapping("/selectall")
    @ResponseBody
    public ResponseData selectAllProjectInfo(){
        List<NtProjectInfo> projectInfoList=null;

        try {
            projectInfoList = inProjectService.selectAllProject();
            if(!projectInfoList.isEmpty() || projectInfoList.size()>0){
                //查询成功
                return ResponseData.ok().putDataValue("data",projectInfoList);
            }else{
                //查询失败
                return ResponseData.isfailed().putDataValue("data","select failed");
            }

        } catch (Exception e) {
            //被禁止
            return ResponseData.serverInternalError() ;
        }
    }


    /**
     * 根据客户类别,项目名称,员工姓名查询员工所在项目信息
     * @param custType
     * @param projectName
     * @param perId
     * @return
     */
    @RequestMapping("/selectperinpro")
    @ResponseBody
    public ResponseData selectPerInProject(String custType,String projectName, Integer perId){
        try {
            if( perId != null || "".equals(perId) ) {
                List<InProjectItem> inProjectItemList =  inProjectService.selectPerInProject2(custType,projectName,perId);
                //查询成功
                return ResponseData.ok().putDataValue("data", inProjectItemList);
            }else{
                return ResponseData.notFound().putDataValue("data","The user name cannot be empty");
            }
        } catch (Exception e) {
            //被禁止
            return ResponseData.serverInternalError().putDataValue("",e.toString() );
        }
    }




    @RequestMapping("/select")
    @ResponseBody
    public ResponseData select2(String name) {
        try {
            List<NtPersonnel> personnelList = inProjectService.select2(name);
            return ResponseData.ok().putDataValue("", personnelList);
        } catch (Exception e) {
            return ResponseData.ok().putDataValue("", e.toString());
        }


    }


    /**
     * 修改员工所在项目
     * @param perInProject
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public ResponseData updatePerInpro(@RequestBody NtPerInProject perInProject){
        int a =0;
        try {

            a = inProjectService.updatePerInpro(perInProject);
            if(a>0){
                return ResponseData.ok().putDataValue("data", "update success " + a);
            }else{
                return ResponseData.isfailed().putDataValue("data", "update failed");
            }
        } catch (Exception e) {
            //被禁止
            return ResponseData.serverInternalError().putDataValue("", e.toString());
        }


    }
}





