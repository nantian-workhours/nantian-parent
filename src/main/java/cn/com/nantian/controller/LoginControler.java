package cn.com.nantian.controller;


import cn.com.nantian.common.*;
import cn.com.nantian.pojo.NtPersonnel;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.service.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;


/**
 * 登录的controller
 */
@Controller
@RequestMapping("login")
public class LoginControler {

    MemCache memCache = MemCache.getInstance();

    @Resource
    private UserService userService;

    /**
     *根据用户名判断密码是否正确
     * @param name
     * @param password
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public ResponseData login(HttpServletResponse response, String name, String password){
        try {
            //查询这个用户的信息
            NtPersonnel personnel = userService.findOne(name);
            //判断这个用户的密码是否正确
            if(DigestUtils.md5DigestAsHex(password.getBytes()).equals(personnel.getPassword())){
                String uuid = StringUtils.createUUID().replace("-", "");
                JsonParser jsonParser = new JsonParser();
                JsonObject jsonObject  = jsonParser.parse(new Gson().toJson(personnel)).getAsJsonObject();
                memCache.set(uuid, jsonObject.toString(), MemConstans.SYS_USER_TIME);
                WebUtils.setCookie(response, SysUserConstants.sidadmin, uuid,2);
                //正确返回权限
                return ResponseData.ok().putDataValue( personnel.getName()+"login success ",personnel.getJurisdiction());
            }else{
                //不正确返回密码错误
                return ResponseData.isfailed().putDataValue(" The password is wrong  ",personnel.getName());
            }
        }catch (NullPointerException e) {
            //系统异常
            return ResponseData.serverInternalError();
        }catch (IllegalArgumentException e) {
            //没有权限
            return ResponseData.unauthorized();
        } catch (Exception e) {
            //被禁止
            return ResponseData.forbidden().putDataValue("",e.toString());
        }
    }


    /**
     * 根据身份证号修改用户密码
     * @param idNo
     * @param password
     * @return
     */
    @RequestMapping("updatepw")
    @ResponseBody
    public ResponseData updatePassword(String idNo,String oldPassword,String password) {
        try {
            //根据身份证修改密码
            int a = userService.byIdNoUpdatePW(idNo,oldPassword, password);
            if(a> 0){
                return ResponseData.ok().putDataValue("update pw success", a);
            }else{
                return ResponseData.isfailed().putDataValue("update failed", a);
            }
        } catch (NullPointerException e) {
            //系统异常
            return ResponseData.serverInternalError();
        } catch (IllegalArgumentException e) {
            //没有权限
            return ResponseData.unauthorized();
        } catch (Exception e) {
            //被禁止
            return ResponseData.forbidden().putDataValue("", e.toString());
        }
    }


    /**
     * 重置密码
     * @param idNo
     * @return
     */
    @RequestMapping(value = "/resetpw" )
    @ResponseBody
    public ResponseData resetPassWord(String idNo ){
        try{
            //修改密码
           int a =  userService.resetPassWord(idNo);
            return ResponseData.ok().putDataValue("data","seccuss " +a );
        } catch (Exception e) {
            //被禁止
            return ResponseData.serverInternalError().putDataValue("",e.toString() );
        }
    }



}
