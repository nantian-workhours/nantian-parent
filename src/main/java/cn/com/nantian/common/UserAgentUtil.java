package cn.com.nantian.common;
import cn.com.nantian.pojo.*;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import javax.servlet.http.HttpServletRequest;

/**
  * @description:  获取用户操作系统 浏览器信息
  * @auther: Mr.Wind
  * @date: 2019/5/20 11:16
  **/
public class UserAgentUtil {

	/**
	  * @description:  获得用户浏览器ua
	  * @auther: Mr.Wind
	  * @date: 2019/5/20 11:16
	  * @param:  [request]
	  * @return: java.lang.String 浏览器类型
	  **/
	public static String getUserAgent(HttpServletRequest request) {
		String uabrow = request.getHeader("User-Agent");//获取浏览器信息
		UserAgent userAgent =UserAgent.parseUserAgentString(uabrow);
		Browser browser = userAgent.getBrowser();
		OperatingSystem os = userAgent.getOperatingSystem();
		return browser.getName().toLowerCase()+";"+os.getName().toLowerCase();
	}

	/**
	  * @description: 设置用户查询数据权限条件(若为普通用户,则只能看自己的信息)
	  * @auther: Mr.Wind
	  * @date: 2019/6/6 10:57
	  * @param:  [request, personnel]
	  * @return: void
	  **/
	public static void setUserJurisdiction(HttpServletRequest request,NtPersonnel personnel){
		NtPersonnel ntPersonnel=SingletonLoginUtils.getSysUser(request);
		if (ObjectUtils.isNotNull(ntPersonnel)){
			if (ntPersonnel.getJurisdiction().equals("2")){
				personnel.setPerId(ntPersonnel.getPerId());
			}
		}
	}

	public static void setUserJurisdiction(HttpServletRequest request, NtPerAlias perAlias){
		NtPersonnel ntPersonnel=SingletonLoginUtils.getSysUser(request);
		if (ObjectUtils.isNotNull(ntPersonnel)){
			if (ntPersonnel.getJurisdiction().equals("2")){
				perAlias.setPerId(ntPersonnel.getPerId());
			}
		}
	}

	public static void setUserJurisdiction(HttpServletRequest request, NtPerInProject perInProject){
		NtPersonnel ntPersonnel=SingletonLoginUtils.getSysUser(request);
		if (ObjectUtils.isNotNull(ntPersonnel)){
			if (ntPersonnel.getJurisdiction().equals("2")){
				perInProject.setPerId(ntPersonnel.getPerId());
			}
		}
	}

	public static void setUserJurisdiction(HttpServletRequest request, NtLeave leave){
		NtPersonnel ntPersonnel=SingletonLoginUtils.getSysUser(request);
		if (ObjectUtils.isNotNull(ntPersonnel)){
			if (ntPersonnel.getJurisdiction().equals("2")){
				leave.setPerId(ntPersonnel.getPerId());
			}
		}
	}

	public static void setUserJurisdiction(HttpServletRequest request, NtHolInfo holInfo){
		NtPersonnel ntPersonnel=SingletonLoginUtils.getSysUser(request);
		if (ObjectUtils.isNotNull(ntPersonnel)){
			if (ntPersonnel.getJurisdiction().equals("2")){
				holInfo.setPerId(ntPersonnel.getPerId());
			}
		}
	}
}
