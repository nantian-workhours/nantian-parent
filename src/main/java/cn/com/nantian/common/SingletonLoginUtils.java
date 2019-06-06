package cn.com.nantian.common;

import cn.com.nantian.pojo.NtPersonnel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static cn.com.nantian.controller.BaseController.getSession;

/**
  * @description: 登录公共方法
  * @auther: Mr.Wind
  * @date: 2019/6/6 11:20
  **/


public class SingletonLoginUtils {

   /**
     * @description: 后台登陆用户（后台）
     * @auther: Mr.Wind
     * @date: 2019/6/6 10:46
     * @param:  [request]
     * @return: cn.com.nantian.pojo.NtPersonnel
     **/
    public static NtPersonnel getSysUser(HttpServletRequest request) {
        String sid = WebUtils.getCookie(request, SysUserConstants.sidadmin);
        if (StringUtils.isNotEmpty(sid)) {
            NtPersonnel ntPersonnel =(NtPersonnel)getSessionAttribute(request, sid);
            return ntPersonnel;
        }
        return null;
    }




    public static void setSessionAttribute(HttpServletRequest request, String name, Object v) {
        request.getSession().setAttribute(name, v);
    }

    public static Object getSessionAttribute(HttpServletRequest request, String name) {
        HttpSession session = getSession(request, false);
        return session != null ? session.getAttribute(name) : null;
    }
}
