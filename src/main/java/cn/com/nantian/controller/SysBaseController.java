package cn.com.nantian.controller;

import cn.com.nantian.common.SingletonLoginUtils;
import cn.com.nantian.pojo.NtPersonnel;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.http.HttpServletRequest;

/**
 * @author :
 * @description 通用的action.所有的Controller继承，公用的写到此方法中
 * @Create Date : 2019-4-11
 */

public class SysBaseController {

    /**
     * 获得系统登录用户
     *
     * @param request
     * @return
     */
    public NtPersonnel getSysLoginedUser(HttpServletRequest request) {
    	JsonObject jsonObject= SingletonLoginUtils.getSysUser(request);
		Gson gson=new Gson();
        NtPersonnel sysUser=gson.fromJson(gson.toJson(jsonObject),NtPersonnel.class);
        return  sysUser;
    }
}
