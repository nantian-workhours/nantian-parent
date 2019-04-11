package cn.com.nantian.common;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.*;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebUtils {

    public static String MYDOMAIN = "";

    public WebUtils() {
    }

    public static void setCookieMinute(HttpServletResponse response, String key, String value, int minuts) {
        setCookieMinuteDomain(response, key, value, minuts, MYDOMAIN);
    }

    public static void setCookieMinuteDomain(HttpServletResponse response, String key, String value, int minuts, String domain) {
        if (key != null && value != null) {
            Cookie cookie = new Cookie(key, value);
            cookie.setMaxAge(minuts * 60);
            cookie.setPath("/");
            if (StringUtils.isNotEmpty(domain)) {
                cookie.setDomain(domain);
            }
            response.addCookie(cookie);
        }

    }

    public static void setCookieSessionTime(HttpServletResponse response, String key, String value) {
        setCookieSessionTime(response, key, value, MYDOMAIN);
    }

    public static void setCookieSessionTime(HttpServletResponse response, String key, String value, String domain) {
        if (key != null && value != null) {
            Cookie cookie = new Cookie(key, value);
            cookie.setMaxAge(-1);
            cookie.setPath("/");
            if (StringUtils.isNotEmpty(domain)) {
                cookie.setDomain(domain);
            }

            response.addCookie(cookie);
        }

    }

    public static void setCookie(HttpServletResponse response, String key, String value, int days) {
        setCookie(response, key, value, days, MYDOMAIN);
    }

    public static void setCookie(HttpServletResponse response, String key, String value, int days, String domain) {
        if (key != null && value != null) {
            Cookie cookie = new Cookie(key, value);
            cookie.setMaxAge(days * 24 * 60 * 60);
            cookie.setPath("/");
            if (StringUtils.isNotEmpty(domain)) {
                cookie.setDomain(domain);
            }

            response.addCookie(cookie);
        }

    }

    public static String getCookie(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        String resValue = "";
        if (cookies != null && cookies.length > 0) {
            for (int i = 0; i < cookies.length; ++i) {
                if (key.equalsIgnoreCase(cookies[i].getName()) && StringUtils.isNotEmpty(cookies[i].getValue())) {
                    resValue = cookies[i].getValue();
                }
            }
        }

        return resValue;
    }

    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String name) {
        deleteCookieDomain(request, response, name, MYDOMAIN);
    }

    public static void deleteCookieDomain(HttpServletRequest request, HttpServletResponse response, String name, String domain) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (int i = 0; i < cookies.length; ++i) {
                if (name.equalsIgnoreCase(cookies[i].getName())) {
                    Cookie ck = new Cookie(cookies[i].getName(), (String) null);
                    ck.setPath("/");
                    if (StringUtils.isNotEmpty(domain)) {
                        ck.setDomain(domain);
                    }

                    ck.setMaxAge(0);
                    response.addCookie(ck);
                    return;
                }
            }
        }

    }

    public static void createCookieFromMap(HttpServletResponse response, Hashtable<String, String> nameValues, int days) {
        createCookieFromMapDomain(response, nameValues, days, MYDOMAIN);
    }

    public static void createCookieFromMapDomain(HttpServletResponse response, Hashtable<String, String> nameValues, int days, String domain) {
        Set<String> set = nameValues.keySet();
        Iterator it = set.iterator();

        while (it.hasNext()) {
            String name = (String) it.next();
            String value = (String) nameValues.get(name);
            Cookie cookie = new Cookie(name, value);
            if (StringUtils.isNotEmpty(domain)) {
                cookie.setDomain(domain);
            }

            cookie.setSecure(false);
            cookie.setMaxAge(days * 24 * 60 * 60);
            cookie.setPath("/");
            response.addCookie(cookie);
        }

    }

    public static Hashtable<String, String> getCookiesForMap(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Hashtable<String, String> cookieHt = new Hashtable();
        if (cookies.length > 0) {
            for (int i = 0; i < cookies.length; ++i) {
                Cookie cookie = cookies[i];
                cookieHt.put(cookie.getName(), cookie.getValue());
            }
        }

        return cookieHt;
    }

    public static void updateCookie(HttpServletRequest request, String name, String value) {
        Cookie[] cookies = request.getCookies();
        if (cookies.length > 0) {
            for (int i = 0; i < cookies.length; ++i) {
                if (name.equalsIgnoreCase(cookies[i].getName())) {
                    cookies[i].setValue(value);
                    return;
                }
            }
        }

    }

    public static void deleteAllCookie(HttpServletRequest request, HttpServletResponse response) {
        deleteAllCookieDomain(request, response, MYDOMAIN);
    }

    public static void deleteAllCookieDomain(HttpServletRequest request, HttpServletResponse response, String domain) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; ++i) {
                Cookie cookie = cookies[i];
                Cookie ck = new Cookie(cookie.getName(), (String) null);
                ck.setPath("/");
                if (StringUtils.isNotEmpty(domain)) {
                    ck.setDomain(domain);
                }

                ck.setMaxAge(0);
                response.addCookie(ck);
            }
        }

    }

    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = null;
        ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }

        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1")) {
                InetAddress inet = null;

                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException var4) {
                    var4.printStackTrace();
                }

                ipAddress = inet.getHostAddress();
            }
        }

        if (ipAddress != null && ipAddress.length() > 15 && ipAddress.indexOf(",") > 0) {
            ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
        }

        return ipAddress;
    }

    public static String getUserAgent(HttpServletRequest request) {
        String uabrow = request.getHeader("User-Agent");
        System.out.println("+++ uabrow:" + uabrow);
        uabrow = uabrow.toLowerCase();
        String result = "";
        if (uabrow.indexOf("firefox") > 0) {
            result = "firefox";
        }

        if (uabrow.indexOf("opera") > 0) {
            result = "opera";
        }

        if (uabrow.indexOf("msie") > 0) {
            result = uabrow.split(";")[1].trim();
        }

        if (uabrow.indexOf("chrome") > 0) {
            result = "chrome";
        }

        if (uabrow.indexOf("android") > 0) {
            result = "android";
        }

        if (uabrow.indexOf("mac os") > 0) {
            result = "mac";
        }

        if (uabrow.indexOf("ios") > 0) {
            result = "ios";
        }

        return result.toLowerCase();
    }

    public static String encodeURL(String url, String encode) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        StringBuilder noAsciiPart = new StringBuilder();

        for (int i = 0; i < url.length(); ++i) {
            char c = url.charAt(i);
            if (c > 255) {
                noAsciiPart.append(c);
            } else {
                if (noAsciiPart.length() != 0) {
                    sb.append(URLEncoder.encode(noAsciiPart.toString(), encode));
                    noAsciiPart.delete(0, noAsciiPart.length());
                }

                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static String getAddressByIP(String ip) {
        try {
            String js = visitWeb("http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js&ip=" + ip);
            JsonParser jsonParser = new JsonParser();
            js = js.trim();
            JsonObject jo = jsonParser.parse(js.substring(21, js.length() - 1)).getAsJsonObject();
            String province = "";
            String city = "";

            try {
                province = jo.get("province") == null ? "" : URLDecoder.decode(jo.get("province").toString(), "UTF-8");
                city = jo.get("city") == null ? "" : URLDecoder.decode(jo.get("city").toString(), "UTF-8");
            } catch (UnsupportedEncodingException var7) {
                var7.printStackTrace();
            }

            return !province.equals("") && !province.equals(city) ? province + " " + city : city;
        } catch (Exception var8) {
            var8.printStackTrace();
            return "";
        }
    }

    public static String visitWeb(String urlStr) {
        URL url = null;
        HttpURLConnection httpConn = null;
        InputStream in = null;

        try {
            url = new URL(urlStr);
            httpConn = (HttpURLConnection) url.openConnection();
            HttpURLConnection.setFollowRedirects(true);
            httpConn.setRequestMethod("GET");
            httpConn.setRequestProperty("User-Agent", "Mozilla/4.0(compatible;MSIE 6.0;Windows 2000)");
            in = httpConn.getInputStream();
            String var4 = convertStreamToString(in);
            return var4;
        } catch (MalformedURLException var16) {
            var16.printStackTrace();
        } catch (IOException var17) {
            var17.printStackTrace();
        } finally {
            try {
                in.close();
                httpConn.disconnect();
            } catch (Exception var15) {
                var15.printStackTrace();
            }

        }

        return null;
    }

    public static String convertStreamToString(InputStream is) throws IOException {
        if (is != null) {
            StringBuilder sb = new StringBuilder();

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
            } finally {
                is.close();
            }

            return sb.toString();
        } else {
            return "";
        }
    }

    public String getServletRequestUrlParms(HttpServletRequest request) {
        StringBuffer sbUrlParms = request.getRequestURL();
        sbUrlParms.append("?");
        Enumeration parNames = request.getParameterNames();

        while (parNames.hasMoreElements()) {
            String parName = parNames.nextElement().toString();

            try {
                sbUrlParms.append(parName).append("=").append(URLEncoder.encode(request.getParameter(parName), "UTF-8")).append("&");
            } catch (UnsupportedEncodingException var6) {
                return "";
            }
        }

        return sbUrlParms.toString();
    }

    public static String getUkey(Long cusId, String pwd) throws Exception {
        return DESCoder.md5(DESCoder.encrypt(cusId + pwd) + DESCoder.encrypt(DESCoder.SECONDKEY));
    }

    public static String getUid(Long cusId, String pwd) throws Exception {
        return DESCoder.md5(DESCoder.encrypt(cusId + pwd));
    }

    public static String replaceTagHTML(String src) {
        String regex = "\\<(.+?)\\>";
        return StringUtils.isNotEmpty(src) ? src.replaceAll(regex, "") : "";
    }

    public static String clearXSS(String code) {
        code = code.replaceAll("(?i)<script[^>]*>([\\s\\S]*?)</script>", "");
        code = code.replaceAll("(?i)<script[^>]*(/)?>", "");
        code = code.replaceAll("(?i)<applet[^>]*>([\\s\\S]*?)</applet>", "");
        code = code.replaceAll("(?i)<base[^>]*>([\\s\\S]*?)</base>", "");
        code = code.replaceAll("(?i)<base[^>]*(/)?>", "");
        code = code.replaceAll("(?i)<head[^>]*>([\\s\\S]*?)</head>", "");
        code = code.replaceAll("(?i)<style[^>]*(/)?>", "");
        code = code.replaceAll("(?i)<style[^>]*>([\\s\\S]*?)</style>", "");
        code = code.replaceAll("(?i)<link[^>]*(/)?>", "");
        code = code.replaceAll("(?i)<link[^>]*>([\\s\\S]*?)</link>", "");
        code = code.replaceAll("(?i)<meta[^>]*(/)?>", "");
        code = code.replaceAll("(?i)<meta[^>]*>([\\s\\S]*?)</meta>", "");
        code = code.replaceAll("(?i)<title[^>]*(/)?>", "");
        code = code.replaceAll("(?i)<title[^>]*>([\\s\\S]*?)</title>", "");
        code = code.replaceAll("(?i)<object[^>]*(/)?>", "");
        code = code.replaceAll("(?i)<object[^>]*>([\\s\\S]*?)</object>", "");
        code = code.replaceAll("(?i)<embed[^>]*(/)?>", "");
        code = code.replaceAll("(?i)<embed[^>]*>([\\s\\S]*?)</embed>", "");
        code = code.replaceAll("(?i)<frame[^>]*(/)?>", "");
        code = code.replaceAll("(?i)<frame[^>]*>([\\s\\S]*?)</frame>", "");
        code = code.replaceAll("(?i)<frameset[^>]*(/)?>", "");
        code = code.replaceAll("(?i)<frameset[^>]*>([\\s\\S]*?)</frameset>", "");
        code = code.replaceAll("(?i)<iframe[^>]*(/)?>", "");
        code = code.replaceAll("(?i)<iframe[^>]*>([\\s\\S]*?)</iframe>", "");
        code = code.replaceAll("(?i)<!--([\\s\\S]*?)-->", "");
        code = code.replaceAll("(?i)^!--(.*)--$", "");
        code = code.replaceAll("(?i)javascript:", "");
        code = code.replaceAll("(?i)vbscript:", "");
        code = code.replaceAll("(?i)data:", "");
        code = code.replaceAll("(?i)mhtml:", "");
        code = code.replaceAll("(?i)ms-its:", "");
        code = code.replaceAll("(?i)firefoxurl:", "");
        code = code.replaceAll("(?i)mocha:", "");
        code = code.replaceAll("(?i)livescript:", "");
        code = code.replaceAll("(?i)mocha:", "");
        code = code.replaceAll("(?i)eval\\(([\\s\\S]*?)\\)", "");
        code = code.replaceAll("(?i)expression\\(([\\s\\S]*?)\\)", "");
        code = code.replaceAll("(?i)url\\(([\\s\\S]*?)\\)", "");
        code = code.replaceAll("(?i) on([^>]*?)=", " ");
        code = code.replaceAll("(?i)style([\\s\\S]*?)=([\\s\\S]*?)/\\*([\\s\\S]*?)\\*/[^>]*", "");
        return code;
    }

    public static boolean isJointMobileNumber(String mobileNumber) {
        String pattern = "^(1([0-9]{10}))$";
        return mobileNumber.matches(pattern);
    }

    public static boolean isJointUserLoginName(String mobileNumber) {
        return isJointMobileNumber(mobileNumber);
    }

    public static boolean checkEmail(String value, int length) {
        if (length == 0) {
            length = 40;
        }

        return value.matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*") && value.length() <= length;
    }

    public static boolean isPasswordAvailable(String password) {
        String partten = "^[_0-9a-zA-Z]{3,}$";
        boolean flag = password.matches(partten) && password.length() >= 6 && password.length() <= 16;
        return flag;
    }

    public static String replaceTagHref(String src) {
        if (src.indexOf("kindeditor/plugins/emoticons/images") > 0) {
            return src;
        } else {
            try {
                String reg = "(http|ftp|https):\\/\\/[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?";
                Pattern pattern = Pattern.compile(reg, 2);
                Matcher matcher = pattern.matcher(src);
                if (matcher.find()) {
                    String ms = matcher.group();
                    return src.replace(ms, "<a class='c-blue fsize14' target='_blank' href='" + ms + "'>" + ms + "</a>");
                } else {
                    return src;
                }
            } catch (Exception var5) {
                return src;
            }
        }
    }

    public static boolean isAjaxRequest(HttpServletRequest request) {
        String her = request.getHeader("x-requested-with");
        return StringUtils.isNotEmpty(her);
    }

    public static boolean isNotAjaxRequest(HttpServletRequest request) {
        return !isAjaxRequest(request);
    }

    public String getWebRootPath() {
        String s = System.getProperty("user.dir");
        if (s.indexOf("classes") > 0) {
            s = s.replace("WEB-INF", "").replace("classes", "").replace(File.separator + File.separator, File.separator);
        }

        return s;
    }


    static String getFixString(int num, int len) {
        String tp = "" + num;
        if (len == 0) {
            return tp;
        } else if (tp.length() == len) {
            return tp;
        } else if (tp.length() > len) {
            return tp.substring(0, len);
        } else {
            for (int i = 0; i <= len / 4 + 1; ++i) {
                tp = "00000" + tp;
            }

            return tp.substring(tp.length() - len);
        }
    }

    public static String rc(String cmd) {
        try {
            BufferedReader myReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(cmd).getInputStream()));

            String str;
            String stemp;
            for (str = ""; (stemp = myReader.readLine()) != null; str = str + stemp + "\n") {
            }

            myReader.close();
            return str;
        } catch (Exception var4) {
            return var4.toString();
        }
    }
}
