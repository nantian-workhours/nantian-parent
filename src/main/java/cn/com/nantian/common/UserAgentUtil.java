package cn.com.nantian.common;
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
}
