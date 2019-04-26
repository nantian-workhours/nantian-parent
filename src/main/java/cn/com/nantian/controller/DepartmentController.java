package cn.com.nantian.controller;

import cn.com.nantian.common.StringUtils;
import cn.com.nantian.pojo.NtDepartment;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.service.DepartmentService;
import cn.com.nantian.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController  {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);


    @InitBinder("department")
    public void initBindNtLeave(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.setFieldDefaultPrefix("department.");
    }

    @Resource
    private DepartmentService departmentService;

    @Resource
    private UserService userService;

    /**
      * @Description:  添加部门信息
      * @Auther: Mr.Kong
      * @Date: 2019/4/26 10:04
      * @Param:  [department]
      * @Return: cn.com.nantian.pojo.entity.ResponseData
      **/
    @RequestMapping("/add")
    @ResponseBody
    public ResponseData  addDepartment(@ModelAttribute("department") NtDepartment department){
        try {
            String msg=departmentService.checkParameter(department);
            if (StringUtils.isNotEmpty(msg)){
                return ResponseData.isfailed().putDataValue("errorMessage",msg);
            }
            int id =   departmentService.addDepartment(department);
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
        public ResponseData updateDepartment(@ModelAttribute("department") NtDepartment department) {
            try {
                String msg=departmentService.checkParameter(department);
                if (StringUtils.isNotEmpty(msg)){
                    return ResponseData.isfailed().putDataValue("errorMessage",msg);
                }
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
            departmentService.setServiceTypeName(departmentList);
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
