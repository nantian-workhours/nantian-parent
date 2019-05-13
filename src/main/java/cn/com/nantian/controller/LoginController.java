package cn.com.nantian.controller;


import cn.com.nantian.common.ObjectUtils;
import cn.com.nantian.common.StringUtils;
import cn.com.nantian.pojo.NtPersonnel;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.service.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/login")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    //MemCache memCache = MemCache.getInstance();

    @Resource
    private UserService userService;

    /**
     * 根据用户名判断密码是否正确
     *
     * @param name
     * @param password
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public ResponseData login(HttpServletResponse response, String name, String password) {
        try {
            //效验登录用户名是否为空、格式
            String msg = userService.checkLoginName(name);
            if (StringUtils.isEmpty(msg)) {
                return ResponseData.isfailed().putDataValue("message", msg);
            }
            //效验登录密码是否为空
            if (StringUtils.isEmpty(password)) {
                return ResponseData.isfailed().putDataValue("message", "登录密码不能为空！");
            }
            //查询这个用户的信息
            NtPersonnel personnel = userService.findOne(name);
            //判断用户是否存在
            if (ObjectUtils.isNull(personnel)) {
                return ResponseData.isfailed().putDataValue("message", "登录用户不存在！");
            }
            //判断这个用户的密码是否正确
            if (DigestUtils.md5DigestAsHex(password.getBytes()).equals(personnel.getPassword())) {
                String uuid = StringUtils.createUUID().replace("-", "");
                JsonParser jsonParser = new JsonParser();
                JsonObject jsonObject = jsonParser.parse(new Gson().toJson(personnel)).getAsJsonObject();
                //memCache.set(uuid, jsonObject.toString(), MemConstans.SYS_USER_TIME);
                // WebUtils.setCookie(response, SysUserConstants.sidadmin, uuid,2);
                //正确返回权限
                return ResponseData.ok().putDataValue(personnel.getName() + "login success ", personnel.getJurisdiction());
            } else {
                //不正确返回密码错误
                return ResponseData.isfailed().putDataValue(" The password is wrong  ", personnel.getName());
            }
        } catch (Exception e) {
            logger.error("LoginController.login", e);
            return ResponseData.forbidden().putDataValue("", e.toString());
        }
    }
}
