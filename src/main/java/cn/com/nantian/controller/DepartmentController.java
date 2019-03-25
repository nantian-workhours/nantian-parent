package cn.com.nantian.controller;

import cn.com.nantian.pojo.NtDepartment;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.pojo.entity.Result;
import cn.com.nantian.service.DepartmentService;
import cn.com.nantian.service.UserService;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController  {

    @Resource
    private DepartmentService departmentService;

    @Resource
    private UserService userService;

    /**添加部门信息
     *
     * @param deptName
     * @param deptAbbreviation
     * @param managerId
     * @param assistantId
     * @param serviceType
     * @return
     */
    @RequestMapping(value = "/add",produces = {"text/html;charset=UTF-8"})
    @ResponseBody
    public ResponseData  addDepartment(String deptName, String deptAbbreviation, int managerId,int assistantId,String serviceType){
        try {
            int id =   departmentService.addDepartment(deptName,deptAbbreviation,managerId,assistantId,serviceType);
                return ResponseData.ok().putDataValue(" Add success num ",id);
        }catch (NullPointerException e) {
            //系统异常
            return ResponseData.serverInternalError();
        }catch (IllegalArgumentException e) {
            //没有权限
            return ResponseData.unauthorized();
        } catch (Exception e) {
            //被禁止
            return ResponseData.forbidden();
        }
    }

    /**删除一条信息
     *
     * @param deptId
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public  ResponseData deleteone(int deptId){
        try {
            int d = departmentService.deleteone(deptId);
            return ResponseData.ok().putDataValue("delete number",d);
        }catch (NullPointerException e) {
            //系统异常
            return ResponseData.serverInternalError();
        }catch (IllegalArgumentException e) {
            //没有权限
            return ResponseData.unauthorized();
        } catch (Exception e) {
            //被禁止
            return ResponseData.forbidden();
        }
    }


    /**根据id查询员工姓名
     *
     * @param perId
     * @return
     */
    @RequestMapping("/findone")
    @ResponseBody
    public ResponseData selectUserName(int perId){
        try {
            String username = userService.selectByUserId(perId);
            if(" ".equals(username)  || username !=null){
                return ResponseData.ok().putDataValue("name",username);
            }else {
                return ResponseData.ok().putDataValue( "name",username);
            }
        }catch (NullPointerException e) {
            //系统异常
            return ResponseData.serverInternalError();
        }catch (IllegalArgumentException e) {
            //没有权限
            return ResponseData.unauthorized();
        } catch (Exception e) {
            //被禁止
            return ResponseData.forbidden();
        }
    }

        @RequestMapping("/update")
        @ResponseBody
        public ResponseData updateDepartment(@RequestBody NtDepartment department) {
            try {
                int d = departmentService.updateDepartment(department);
                return ResponseData.ok().putDataValue("update number",d);
            }catch (NullPointerException e) {
                //系统异常
                return ResponseData.serverInternalError();
            }catch (IllegalArgumentException e) {
                //没有权限
                return ResponseData.unauthorized();
            } catch (Exception e) {
                //被禁止
                return ResponseData.forbidden();
            }
        }
    @RequestMapping("/findall")
    @ResponseBody
    public ResponseData findAll(){
        try {
            List<NtDepartment> departmentList =  departmentService.findAll();
                return  ResponseData.ok().putDataValue("data",departmentList);
        }catch (NullPointerException e) {
            //系统异常
            return ResponseData.serverInternalError();
        }catch (IllegalArgumentException e) {
            //没有权限
            return ResponseData.unauthorized();
        }catch (Exception e) {
            //被禁止
            return ResponseData.forbidden();
        }
    }


}
