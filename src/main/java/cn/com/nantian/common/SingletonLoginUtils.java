package cn.com.nantian.common;

import cn.com.nantian.pojo.NtPersonnel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static cn.com.nantian.controller.BaseController.getSession;

/**
 * @description :
 * @Create Date : 2019-4-11
 */
public class SingletonLoginUtils {

    static MemCache memCache = MemCache.getInstance();

    public static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    public static JsonParser jsonParser = new JsonParser();

    /**
     * 获取登陆用户的id(前台用)
     *
     * @return int
     * @throws Exception
     */
    public static Long getLoginUserId(HttpServletRequest request) {
        JsonObject useObject = getLoginUser(request);
        if (ObjectUtils.isNotNull(useObject)) {
            if (StringUtils.isNotEmpty(useObject.get("id").toString())) {
                return Long.valueOf(useObject.get("id").toString());
            } else {
                return 0L;
            }
        } else {
            return 0L;
        }
    }

    /**
     * 获取登陆用户的教师id(前台用)
     *
     * @param request
     * @return
     */
    public static Long getLoginTeacherId(HttpServletRequest request) {
        JsonObject useObject = getLoginUser(request);
        if (ObjectUtils.isNotNull(useObject)) {
            if (ObjectUtils.isNotNull(useObject.get("teacherId"))) {
                return Long.valueOf(useObject.get("teacherId").toString());
            } else {
                return 0L;
            }
        } else {
            return 0L;
        }
    }

    /**
     * 是否登录
     *
     * @param request
     * @return
     */
    public static boolean isLogin(HttpServletRequest request) {
        try {
            if (getLoginUserId(request).intValue() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获取登陆用户
     *
     * @return User
     * @throws Exception
     */
    public static JsonObject getLoginUser(HttpServletRequest request) {
        String sid = WebUtils.getCookie(request, CommonConstants.USER_SINGEL_ID);
        if (StringUtils.isNotEmpty(sid)) {
            Object ob = memCache.get(sid);
            if (ObjectUtils.isNotNull(ob)) {
                JsonObject user = jsonParser.parse(ob.toString()).getAsJsonObject();
                return user;
            }
        }
        return null;
    }

    /**
     * 后台登陆用户（后台）
     *
     * @return SysUser
     */
     public static JsonObject getSysUser(HttpServletRequest request) {
        String sid = WebUtils.getCookie(request, SysUserConstants.sidadmin);
        if (StringUtils.isNotEmpty(sid)) {
            Object ob = memCache.get(sid);
            if (ObjectUtils.isNotNull(ob)) {
                JsonObject user = jsonParser.parse(ob.toString()).getAsJsonObject();
                return user;
            }
        }
        return null;
     }

   /**
     * @description: 后台登陆用户（后台）
     * @auther: Mr.Wind
     * @date: 2019/6/6 10:46
     * @param:  [request]
     * @return: cn.com.nantian.pojo.NtPersonnel
     **/
    public static NtPersonnel getSysUsers(HttpServletRequest request) {
        String sid = WebUtils.getCookie(request, SysUserConstants.sidadmin);
        if (StringUtils.isNotEmpty(sid)) {
            NtPersonnel ntPersonnel =(NtPersonnel)getSessionAttribute(request, sid);
            return ntPersonnel;
        }
        return null;
    }


    /**
     * 后台登陆用户（后台）
     *
     * @return SysUser
     */
    public static Long getSysUserId(HttpServletRequest request) {
        JsonObject jsonObject = getSysUser(request);
        if (ObjectUtils.isNotNull(jsonObject)) {
            return jsonObject.get("userId").getAsLong();
        }
        return 0L;
    }

    public static String getSysLoginLoginName(HttpServletRequest request) {
        JsonObject syuser = SingletonLoginUtils.getSysUser(request);
        if (ObjectUtils.isNotNull(syuser)) {
            return syuser.get("loginName").getAsString();
        }
        return "";
    }

    /*public static void setLoginInfo(String sid, UserExpandDto userExpandDto, String autoThirty) {
        JsonParser jsonParser = new JsonParser();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String userString = gson.toJson(userExpandDto);
        JsonObject jsonObject = jsonParser.parse(userString).getAsJsonObject();
        if (autoThirty != null && autoThirty.equals("true")) {//30天自动登录
            memCache.set(sid, jsonObject.toString(), MemConstans.USER_AUTO_TIME);
        } else {
            memCache.set(sid, jsonObject.toString(), MemConstans.USER_TIME);
        }
    }*/

    //判断是否为手机浏览器
    public static boolean JudgeIsMoblie(HttpServletRequest request) {
        boolean isMoblie = false;
        String[] mobileAgents = {"iphone", "android", "ipad", "phone", "mobile", "wap", "netfront", "java", "opera mobi",
                "opera mini", "ucweb", "windows ce", "symbian", "series", "webos", "sony", "blackberry", "dopod",
                "nokia", "samsung", "palmsource", "xda", "pieplus", "meizu", "midp", "cldc", "motorola", "foma",
                "docomo", "up.browser", "up.link", "blazer", "helio", "hosin", "huawei", "novarra", "coolpad", "webos",
                "techfaith", "palmsource", "alcatel", "amoi", "ktouch", "nexian", "ericsson", "philips", "sagem",
                "wellcom", "bunjalloo", "maui", "smartphone", "iemobile", "spice", "bird", "zte-", "longcos",
                "pantech", "gionee", "portalmmm", "jig browser", "hiptop", "benq", "haier", "^lct", "320x320",
                "240x320", "176x220", "w3c ", "acs-", "alav", "alca", "amoi", "audi", "avan", "benq", "bird", "blac",
                "blaz", "brew", "cell", "cldc", "cmd-", "dang", "doco", "eric", "hipt", "inno", "ipaq", "java", "jigs",
                "kddi", "keji", "leno", "lg-c", "lg-d", "lg-g", "lge-", "maui", "maxo", "midp", "mits", "mmef", "mobi",
                "mot-", "moto", "mwbp", "nec-", "newt", "noki", "oper", "palm", "pana", "pant", "phil", "play", "port",
                "prox", "qwap", "sage", "sams", "sany", "sch-", "sec-", "send", "seri", "sgh-", "shar", "sie-", "siem",
                "smal", "smar", "sony", "sph-", "symb", "t-mo", "teli", "tim-", "tosh", "tsm-", "upg1", "upsi", "vk-v",
                "voda", "wap-", "wapa", "wapi", "wapp", "wapr", "webc", "winw", "winw", "xda", "xda-",
                "Googlebot-Mobile"};
        if (request.getHeader("User-Agent") != null) {
            System.out.println("User-Agent:" + request.getHeader("User-Agent"));
            String agent = request.getHeader("User-Agent");
            for (String mobileAgent : mobileAgents) {
                if (agent.toLowerCase().indexOf(mobileAgent) >= 0 && agent.toLowerCase().indexOf("windows nt") <= 0 && agent.toLowerCase().indexOf("macintosh") <= 0) {
                    isMoblie = true;
                    break;
                }
            }
        }
        return isMoblie;
    }

    /**
     * 得到当前地区id(前台线下课用)
     *
     * @param request
     * @return
     */
    public static Long getCurrentRegionId(HttpServletRequest request) {
        String regionId = WebUtils.getCookie(request, CommonConstants.USER_DEFAULT_REGION);
        if (StringUtils.isEmpty(regionId)) {
            regionId = CommonConstants.USER_DEFAULT_REGION_ID;
        }
        return Long.parseLong(regionId);
    }

    public static void setSessionAttribute(HttpServletRequest request, String name, Object v) {
        request.getSession().setAttribute(name, v);
    }

    public static Object getSessionAttribute(HttpServletRequest request, String name) {
        HttpSession session = getSession(request, false);
        return session != null ? session.getAttribute(name) : null;
    }
}
