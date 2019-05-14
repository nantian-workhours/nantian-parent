package cn.com.nantian.controller;

import cn.com.nantian.common.ObjectUtils;
import cn.com.nantian.common.StringUtils;
import cn.com.nantian.pojo.Item1;
import cn.com.nantian.pojo.NtPersonnel;
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

/**
 * @description: 员工录入信息
 * @author: Mr.Kong
 * @date: 2019/4/26 14:12
 **/
@Controller
@RequestMapping("/content")
public class UserController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @InitBinder("personnel")
    public void initBindNtPersonnel(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.setFieldDefaultPrefix("personnel.");
    }

    @Resource
    private UserService userService;
    @Resource
    private DepartmentService departmentService;

    /**
     * 添加员工基本信息NT_PERSONNEL
     *
     * @param personnel
     * @return
     */
    @RequestMapping("/adduser")
    @ResponseBody
    public ResponseData addUser(@ModelAttribute("personnel") NtPersonnel personnel) {
        try {
            String msg = userService.checkAddUserParameter(personnel);
            if (StringUtils.isNotEmpty(msg)) {
                return ResponseData.isfailed().putDataValue("errorMessage", msg);
            }
            int d = userService.addUser(personnel);
            return ResponseData.ok().putDataValue("add number", d);
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
    public ResponseData selectDepart(int deptId) {
        try {
            String d = departmentService.selectDepart(deptId);
            return ResponseData.ok().putDataValue("select name ", d);

       } catch (Exception e) {
            logger.error("UserController.selectDepart", e);
            return ResponseData.forbidden();
        }
    }

    /**
     * 根据部门deptId和员工name查询员工信息
     *
     * @param personnel
     * @return
     */
    @RequestMapping(value = "/findbyidandname")
    @ResponseBody
    public ResponseData queryPersonnelList(@ModelAttribute("personnel") NtPersonnel personnel) {
        try {
            List<NtPersonnel> personnelList = userService.queryPersonnelList(personnel);
            userService.setWorkStates(personnelList);
            return ResponseData.ok().putDataValue("data", personnelList);
        } catch (Exception e) {
            logger.error("UserController.queryPersonnelList", e);
            return ResponseData.forbidden();
        }
    }

    /**
     * 获取员工基本信息NT_PERSONNEL根据身份证号
     *
     * @param idNo
     * @return
     */
    @RequestMapping("/selectbyidno")
    @ResponseBody
    public ResponseData selectByidno(String idNo) {
        try {
            NtPersonnel d = userService.findPersonnlByIdno(idNo);
            return ResponseData.ok().putDataValue("select number", d);
        } catch (Exception e) {
            logger.error("UserController.selectByidno", e);
            return ResponseData.forbidden();
        }
    }

    /**
     * 根据公司邮箱(格式xxx@nantian.com.cn) ,或者手机号(格式:必须是11位),或者身份证号(格式:必须是18位)
     * 获取员工信息
     *
     * @param username
     * @return
     */
    @RequestMapping("/findone")
    @ResponseBody
    public ResponseData selectBymob(String username) {
        try {
            String msg = userService.checkLoginName(username);
            if (StringUtils.isNotEmpty(msg)) {
                return ResponseData.isfailed().putDataValue("errorMessage", msg);
            }
            NtPersonnel personnel = userService.findOne(username);
            if (ObjectUtils.isNull(personnel)) {
                return ResponseData.isfailed().putDataValue("errorMessage", "用户不存在！");
            } else {
                return ResponseData.ok().putDataValue("success", personnel);
            }
        } catch (Exception e) {
            logger.error("UserController.selectBymob", e);
            return ResponseData.forbidden();
        }
    }


    /**
     * 根据员工编号获取员工信息
     * @param perId
     * @return
     */
    @RequestMapping("/selectpersonnel")
    @ResponseBody
    public ResponseData selectPersonnel(int perId) {
        try {
            NtPersonnel d = userService.findPersonnlByPerId(perId);
            return ResponseData.ok().putDataValue("data", d);
        } catch (Exception e) {
            logger.error("UserController.selectPersonnel", e);
            return ResponseData.forbidden();
        }
    }

    /**
     * 根据身份证号和别名删除员工信息
     *
     * @param item1
     * @return
     */
    @RequestMapping(value = "/deletebyidno")
    @ResponseBody
    public ResponseData deleteByIdNo(@RequestBody Item1 item1) {
        try {
            String d = userService.deleteByIdNo(item1.getIdNo(), item1.getInProjectName());
            return ResponseData.ok().putDataValue("status", d);
        } catch (Exception e) {
            logger.error("UserController.deleteByIdNo", e);
            return ResponseData.forbidden();
        }
    }

    /**
      * @description: 修改员工信息
      * @auther: Mr.Kong
      * @date: 2019/5/5 15:18
      * @Param:  [personnel]
      * @return: ResponseData
      **/
    @RequestMapping(value = "/update/user")
    @ResponseBody
    public ResponseData updateUser(@ModelAttribute("personnel") NtPersonnel personnel) {
        try {
            String msg=userService.checkUpdateUserParameter(personnel);
            if (StringUtils.isNotEmpty(msg)) {
                return ResponseData.isfailed().putDataValue("errorMessage", msg);
            }
            int d = userService.updateByIdNo(personnel);
            return ResponseData.ok().putDataValue("status", "update success"+d);
        } catch (Exception e) {
            logger.error("UserController.updateUser", e);
            return ResponseData.forbidden().putDataValue("系统异常", e.toString());
        }
    }


    /**
     * 根据员工姓名 员工信息
     *
     * @param name
     * @return
     */
    @RequestMapping("/findbyname")
    @ResponseBody
    public ResponseData selectByName(String name) {
        try {
            List<NtPersonnel> personnelList = userService.findByName(name);
            if (personnelList.size() > 0) {
                return ResponseData.ok().putDataValue("data", personnelList);
            } else {
                return ResponseData.notFound().putDataValue("code", "Without the employee");
            }
        } catch (Exception e) {
            logger.error("UserController.selectByName", e);
            return ResponseData.forbidden().putDataValue("系统异常", e.toString());
        }
    }


    /**
      * @description: 查询用户信息列表
      * @auther: Mr.Kong
      * @date: 2019/4/29 14:17
      * @Param:  [personnel]
      * @return: ResponseData
      **/
    @RequestMapping(value = "/personnel/list")
    @ResponseBody
    public ResponseData queryPersonnelListDate(@ModelAttribute("personnel") NtPersonnel personnel) {
        try {
            List<NtPersonnel> personnelList = userService.queryPersonnelListDate(personnel);
            personnelList=userService.setPersonnelDate(personnelList);
            return ResponseData.ok().putDataValue("select list ", personnelList);
        } catch (Exception e) {
            logger.error("UserController.queryPersonnelListDate", e);
            return ResponseData.forbidden();
        }
    }

    /**
     * 根据身份证号修改用户密码
     *
     * @param idNo
     * @param password
     * @return
     */
    @RequestMapping("/update/password")
    @ResponseBody
    public ResponseData updatePassword(String idNo, String oldPassword, String password) {
        try {
            //根据身份证修改密码
            int a = userService.byIdNoUpdatePW(idNo, oldPassword, password);
            if (a > 0) {
                return ResponseData.ok().putDataValue("update pw success", a);
            } else {
                return ResponseData.isfailed().putDataValue("update failed", a);
            }
        } catch (Exception e) {
            logger.error("LoginController.updatePassword", e);
            return ResponseData.forbidden().putDataValue("", e.toString());
        }
    }

    /**
     * @description: 重置密码
     * @auther: Mr.Kong
     * @date: 2019/5/13 10:43
     * @param: [perId]
     * @return: ResponseData
     **/
    @RequestMapping(value = "/reset/password")
    @ResponseBody
    public ResponseData resetPassWord(@RequestParam("perId") int perId) {
        try {
            int a = userService.resetPassWord(perId);
            return ResponseData.ok().putDataValue("重置密码成功", a);
        } catch (Exception e) {
            logger.error("LoginController.updatePassWord", e);
            return ResponseData.serverInternalError().putDataValue("系统异常", e.toString());
        }
    }
}