package cn.com.nantian.controller;


import cn.com.nantian.common.*;
import cn.com.nantian.pojo.LoginLog;
import cn.com.nantian.pojo.NtPersonnel;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.service.LoginLogService;
import cn.com.nantian.service.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


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
    @Resource
    private LoginLogService loginLogService;


    /**
      * @description:  系统登录
      * @auther: Mr.Kong
      * @date: 2019/5/17 16:48
      * @param:  [response, name, password]
      * @return: cn.com.nantian.pojo.entity.ResponseData
      **/
    @RequestMapping("/login")
    @ResponseBody
    public ResponseData login(HttpServletRequest request, HttpServletResponse response,
                              String name, String password) {
        try {
            Map<String,Object> dataMap=new HashMap<>();
            //效验传入的登录用户名、密码
            String result = userService.checkLoginParameter(name,password);
            if (StringUtils.isNotEmpty(result)) {
                return ResponseData.isfailed().putDataValue("error", result);
            }
            NtPersonnel personnel = userService.findOne(name);

            /*String uuid = StringUtils.createUUID().replace("-", "");
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = jsonParser.parse(new Gson().toJson(personnel)).getAsJsonObject();
            memCache.set(uuid, jsonObject.toString(), MemConstans.SYS_USER_TIME);
            WebUtils.setCookie(response, SysUserConstants.sidadmin, uuid,2);*/
            dataMap.put("personnel",personnel);
            //查询最新一条登录日志信息
            LoginLog loginLog=loginLogService.queryLoginLogNewestOne(null);
            dataMap.put("loginLog",loginLog);
            // 添加登录日志记录
            loginLogService.insertLoginLog(request,personnel);
            logger.info(" ++++ sysUser login success: " + personnel.getName() + " is logined ok !");
            return ResponseData.ok().putDataValue("data",dataMap);
        } catch (Exception e) {
            logger.error("LoginController.login", e);
            return ResponseData.forbidden().putDataValue("error","系统异常，请稍后再试！");
        }
    }
}
