package cn.com.nantian.controller;

import cn.com.nantian.pojo.InProjectItem;
import cn.com.nantian.pojo.NtPerInProject;
import cn.com.nantian.pojo.NtPersonnel;
import cn.com.nantian.pojo.NtProjectInfo;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.service.InProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ydz on 2019/3/18
 */


@Controller
@RequestMapping("inproject")
public class InProjectController {

    @Resource
    private InProjectService inProjectService;

    /**
     * 添加员工所在项目信息
     * @param perInProject
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public ResponseData addPerInProject(@RequestBody NtPerInProject perInProject){
            int a = 0;
        try {
            a = inProjectService.addPerInProject(perInProject);
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
            //被禁止
            return ResponseData.serverInternalError();
        }
    }

    /**
     *查询所有项目信息
     * @return
     */
    @RequestMapping("selectall")
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
     * @param name
     * @return
     */
    @RequestMapping("selectperinpro")
    @ResponseBody
    public ResponseData selectPerInProject(String custType,String projectName, String name){
        try {
//           List<InProjectItem> inProjectItemList =  inProjectService.selectPerInProject(custType,projectName,name);
           List<InProjectItem> inProjectItemList =  inProjectService.selectPerInProject1(custType,projectName,name);
               if(!inProjectItemList.isEmpty() || inProjectItemList.size()>0) {
                   //查询成功
                return ResponseData.ok().putDataValue("data",inProjectItemList);
               }else {
                   //查询失败
                   return ResponseData.isfailed().putDataValue("data", "select failed");
               }
        } catch (Exception e) {
            //被禁止
            return ResponseData.serverInternalError().putDataValue("",e.toString() );
        }
    }




    @RequestMapping("select")
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





