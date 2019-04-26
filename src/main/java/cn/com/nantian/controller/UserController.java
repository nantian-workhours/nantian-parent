package cn.com.nantian.controller;

import cn.com.nantian.common.StringUtils;
import cn.com.nantian.pojo.Item1;
import cn.com.nantian.pojo.NtPersonnel;
import cn.com.nantian.pojo.PersonnelItem;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.service.DepartmentService;
import cn.com.nantian.service.PerAliasService;
import cn.com.nantian.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:  员工录入信息
 * @author: Mr.Kong
 * @date: 2019/4/26 14:12
 **/
@Controller
@RequestMapping("/content")
public class UserController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @InitBinder("personnel")
    public void initBindNtPersonnel(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.setFieldDefaultPrefix("personnel.");
    }

    @Resource
    private UserService userService;

    @Resource
    private DepartmentService departmentService;
    @Resource
    private PerAliasService perAliasService;


    /**添加员工基本信息NT_PERSONNEL
     *
     * @param personnel
     * @return
     */
    @RequestMapping("/adduser")
    @ResponseBody
    public ResponseData addUser(@ModelAttribute("personnel") NtPersonnel personnel){
        try {
            String msg=userService.checkUserParameter(personnel);
            if(StringUtils.isNotEmpty(msg)){
                return ResponseData.isfailed().putDataValue("errorMessage",msg);
            }
            int d= userService.addUser(personnel);
            return ResponseData.ok().putDataValue("add number",d);
        } catch (Exception e) {
            logger.error("UserController.addUser", e);
            return ResponseData.isfailed();
        }
    }

    /**
     * 根据部门编号查询部门名称
     * @param deptId
     * @return
     */
    @RequestMapping("/selectdepart")
    @ResponseBody
    public ResponseData selectDepart( int deptId){
        try {
            String  d= departmentService.selectDepart(deptId);
            return ResponseData.ok().putDataValue("select name ",d);

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

    /**
     * 根据部门deptId和员工name查询员工信息
     * @param personnel
     * @return
     */
    @RequestMapping(value = "/findbyidandname")
    @ResponseBody
    public ResponseData queryPersonnelList(@ModelAttribute("personnel") NtPersonnel personnel){
        try {
            List<NtPersonnel> personnelList=userService.queryPersonnelList(personnel);
            return ResponseData.ok().putDataValue("select list ",personnelList);
        } catch (Exception e) {
            logger.error("UserController.queryPersonnelList", e);
            return ResponseData.forbidden();
        }

    }

    /**获取员工基本信息NT_PERSONNEL根据身份证号
     *
     * @param idNo
     * @return
     */
    @RequestMapping("/selectbyidno")
    @ResponseBody
    public ResponseData selectByidno( String idNo){
        try {
            NtPersonnel d= userService.findPersonnlByIdno(idNo);

            return ResponseData.ok().putDataValue("select number",d);
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

    /**
     * 根据公司邮箱(格式xxx@nantian.com.cn) ,或者手机号(格式:必须是11位),或者身份证号(格式:必须是18位)
     * 获取员工信息
     * @param username
     * @return
     */
    @RequestMapping("/findone")
    @ResponseBody
    public ResponseData selectBymob( String username){
        NtPersonnel d= userService.findOne(username);
        return ResponseData.ok().putDataValue("select seccuss",d);
    }


    /**
     * 根据员工编号获取员工信息
     * @param perId
     * @return
     */
    @RequestMapping("/selectpersonnel")
    @ResponseBody
    public ResponseData selectPersonnel(int perId){
        try {
            NtPersonnel d= userService.findPersonnlByPerId(perId);

            return ResponseData.ok().putDataValue("data",d);
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

    /**
     *根据身份证号和别名删除员工信息
     * @param item1
     * @return
     */
    @RequestMapping(value = "/deletebyidno" )
    @ResponseBody
    public ResponseData deleteByIdNo(@RequestBody Item1 item1){
        try {
            String  d= userService.deleteByIdNo(item1.getIdNo(),item1.getInProjectName());
            return ResponseData.ok().putDataValue("status",d);
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

    /**
     * 修改员工信息
     * @param personnel
     * @return
     */
    @RequestMapping(value = "/updatebyidno" )
    @ResponseBody
    public ResponseData updateByIdNo(@RequestBody  NtPersonnel personnel){
        try {
            String  d= userService.updateByIdNo(personnel);
            return ResponseData.ok().putDataValue("status",d);
        }catch (NullPointerException e) {
            //系统异常
            return ResponseData.serverInternalError();
        }catch (IllegalArgumentException e) {
            //没有权限
            return ResponseData.unauthorized();
        } catch (Exception e) {
            //被禁止
            return ResponseData.forbidden().putDataValue(" ",e.toString());
        }
    }



    /**
     * 根据员工姓名 员工信息
     * @param name
     * @return
     */
    @RequestMapping("/findbyname")
    @ResponseBody
    public ResponseData selectByName( String name){
        Map<String, Object> objectObjectHashMap = new HashMap<>();
        List<NtPersonnel> personnelList = userService.findByName(name);
        if(personnelList.size() > 0){
            return ResponseData.ok().putDataValue("data",personnelList);
        }else{
            return ResponseData.notFound().putDataValue("code","Without the employee");
        }
    }



}


