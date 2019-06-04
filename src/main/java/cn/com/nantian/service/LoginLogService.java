/**
 * @description: 系统登录日志管理
 * @auther: Mr.Wind
 * @date: 2019/5/20 10:14
 **/
package cn.com.nantian.service;

import cn.com.nantian.pojo.LoginLog;
import cn.com.nantian.pojo.NtPersonnel;

import javax.servlet.http.HttpServletRequest;

public interface LoginLogService {


    int insertLoginLog(HttpServletRequest request, NtPersonnel personnel);

    LoginLog queryLoginLogNewestOne(LoginLog loginLog);

    int deleteByPrimaryKey(Integer id);

    int insert(LoginLog record);

    int insertSelective(LoginLog record);

    LoginLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoginLog record);

    int updateByPrimaryKey(LoginLog record);
}
