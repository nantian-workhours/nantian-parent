package cn.com.nantian.controller;

import cn.com.nantian.pojo.NtPerAlias;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.service.ProjectNameService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;



/**
 * 别名管理(项目组中的名字)
 */
@Controller
@RequestMapping("/othername")
public class ProjectNameController {


    @Resource
    private ProjectNameService projectNameService;


    /**
     * 添加项目别名
     * @param perAlias
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public ResponseData addProjectName(@RequestBody NtPerAlias perAlias) {
        try {
            int a = projectNameService.addProjectName(perAlias);
            if (a == 1) {
                return ResponseData.ok().putDataValue("status", "add success " + a);
            } else {
                return ResponseData.isfailed().putDataValue("status", "add failed");
            }
        } catch (Exception e) {
            //被禁止
            return ResponseData.serverInternalError();
        }

    }
        /**
         * 根据员工姓名/身份证号/客户类型查询
         */
        @RequestMapping("/selectall")
        @ResponseBody
        public ResponseData selectAllName(String inCompanyName ,String idNo,String custType){
            List<NtPerAlias> perAliasList=null;
            try {
                //根据姓名,身份证号  或者客户类型查询信息
                perAliasList = projectNameService.selectAllName(inCompanyName,idNo,custType);
                if(perAliasList != null ){
                    return ResponseData.ok().putDataValue("data",perAliasList);
                }else{
                    return ResponseData.isfailed().putDataValue("data","select failed");
                }
            } catch (Exception e) {
                //被禁止
                return ResponseData.serverInternalError() ;
            }
    }

    /**
     * 根据员工身份证号,别名删除员工别名信息
     * @param idNo
     * @param inProjectName
     *
     * @return
     */
    @RequestMapping("/deleteothname")
    @ResponseBody
    public ResponseData deleteOtherName(String idNo,String inProjectName){
        try {

            //删除别名信息 ,只删别名表 ,不删员工表
            int a = projectNameService.deleteOtherName(idNo,inProjectName);
            if(a>0){
                return ResponseData.ok().putDataValue("status","delete success  "+ a);
            }else{
                return ResponseData.isfailed().putDataValue("status","delete failed");
            }
        } catch (Exception e) {
            //被禁止
            return ResponseData.serverInternalError() ;
        }

    }

    /**
     * 修改别名信息
     * @param perAlias
     * @return
     */
    @RequestMapping("/updateothname")
    @ResponseBody
    public ResponseData updateOtherName(@RequestBody NtPerAlias perAlias){
        try {

            //修改别名信息 ,只修改别名表 ,不修改员工表
            int a = projectNameService.updateOtherName(perAlias);

            if(a>0){
                return ResponseData.ok().putDataValue("status","update success  "+ a);
            }else{
                return ResponseData.isfailed().putDataValue("status","update failed");
            }
        } catch (Exception e) {
            //被禁止
            return ResponseData.serverInternalError() ;
        }

    }


}
