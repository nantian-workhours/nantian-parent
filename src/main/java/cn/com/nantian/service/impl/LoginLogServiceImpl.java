/**
 * @Description: 系统登录日志管理
 * @ClassName: LoginLogServiceImpl
 * @author： Mr.Wind
 * @date: 2019/5/20 10:31
 * @Version： 1.0
 */
package cn.com.nantian.service.impl;

import cn.com.nantian.common.StringUtils;
import cn.com.nantian.common.UserAgentUtil;
import cn.com.nantian.common.WebUtils;
import cn.com.nantian.mapper.LoginLogMapper;
import cn.com.nantian.pojo.LoginLog;
import cn.com.nantian.pojo.NtPersonnel;
import cn.com.nantian.service.LoginLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Resource
    private LoginLogMapper loginLogMapper;

    /**
      * @description: 添加系统后台登录日志记录
      * @auther: Mr.Wind
      * @date: 2019/5/20 14:24
      * @param:  [request, personnel]
      * @return: int
      **/
    @Override
    public int insertLoginLog(HttpServletRequest request, NtPersonnel personnel) {
        String ip = WebUtils.getIpAddr(request); // 获取登录人的IP并记录
        LoginLog loginLog = new LoginLog();
        loginLog.setLoginTime(new Date());
        loginLog.setIp(ip);
        loginLog.setUserId(personnel.getPerId());
        String userAgent= UserAgentUtil.getUserAgent(request);
        if(StringUtils.isNotEmpty(userAgent)){
            loginLog.setUserAgent(userAgent.split(";")[0]);//浏览器
            loginLog.setOsname(userAgent.split(";")[1]);//操作系统
        }
        return loginLogMapper.insert(loginLog);
    }

    @Override
    public LoginLog queryLoginLogNewestOne(LoginLog loginLog) {
        return loginLogMapper.queryLoginLogNewestOne(loginLog);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return loginLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(LoginLog record) {
        return loginLogMapper.insert(record);
    }

    @Override
    public int insertSelective(LoginLog record) {
        return loginLogMapper.insertSelective(record);
    }

    @Override
    public LoginLog selectByPrimaryKey(Integer id) {
        return loginLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(LoginLog record) {
        return loginLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(LoginLog record) {
        return loginLogMapper.updateByPrimaryKey(record);
    }
}
