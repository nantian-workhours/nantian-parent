/**
 * @description:
 * @ClassName: BaseController
 * @author： Mr.Kong
 * @date: 2019/4/26 14:48
 * @Version： 1.0
 */
package cn.com.nantian.controller;

import cn.com.nantian.common.ObjectUtils;
import cn.com.nantian.common.WebUtils;
import cn.com.nantian.pojo.entity.PageEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
    public static Gson gson = (new GsonBuilder()).setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    public static JsonParser jsonParser = new JsonParser();
    private PageEntity page;
    public Map<String, Object> json = new HashMap(4);
    protected String errmsg;
    protected static final String ERROR = "/common/error";
    public String changeSuccess = "/admin/common/success.json";
    protected static String ADMIN_SUCCESS = "redirect:/admin/sys/success.json";

    public BaseController() {
    }

    public Map<String, Object> getJsonMap(boolean success, String message, Object entity) {
        Map<String, Object> json = new HashMap(4);
        json.put("success", success);
        json.put("message", message);
        json.put("entity", entity);
        return json;
    }

    @InitBinder({"page"})
    public void initBinderPage(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("page.");
    }

    public String getUuid() {
        return UUID.randomUUID().toString();
    }

    public String setExceptionRequest(HttpServletRequest request, Exception e) {
        logger.error(request.getContextPath(), e);
        StackTraceElement[] messages = e.getStackTrace();
        if (!ObjectUtils.isNull(messages)) {
            StringBuffer buffer = new StringBuffer();
            buffer.append(e.toString()).append("<br/>");

            for(int i = 0; i < messages.length; ++i) {
                buffer.append(messages[i].toString()).append("<br/>");
            }

            request.setAttribute("myexception", buffer.toString());
        }

        return "/common/error";
    }

    public void setSessionAttribute(HttpServletRequest request, String name, Object v) {
        request.getSession().setAttribute(name, v);
    }

    public Object getSessionAttribute(HttpServletRequest request, String name) {
        HttpSession session = getSession(request, false);
        return session != null ? session.getAttribute(name) : null;
    }

    public static HttpSession getSession(HttpServletRequest request) {
        return request.getSession();
    }

    public static HttpSession getSession(HttpServletRequest request, boolean isNew) {
        return request.getSession(isNew);
    }

    public void sendMessage(HttpServletRequest request, HttpServletResponse response, String content) throws IOException {
        try {
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(content);
        } catch (Exception var5) {
            logger.error("sendMessage", var5);
        }

    }

    public PageEntity getPage() {
        if (this.page == null) {
            this.page = new PageEntity();
        }

        return this.page;
    }

    public void setPage(PageEntity page) {
        if (page != null) {
            this.page = page;
        }

    }

    protected void replaceScript(HttpServletRequest resquest) throws Exception {
        Enumeration e = resquest.getParameterNames();

        String str;
        String value;
        do {
            if (!e.hasMoreElements()) {
                return;
            }

            str = (String)e.nextElement();
            value = resquest.getParameter(str);
        } while(value.indexOf("script") == -1 && value.indexOf("javascript") == -1 && value.indexOf("eval") == -1);

        String ip = WebUtils.getIpAddr(resquest);
        logger.info("[疑似攻击],refer url:" + str + " 用户ip:" + ip);
        throw new Exception();
    }

    public String getRealPath(HttpServletRequest request, String path) {
        return request.getSession().getServletContext().getRealPath(path);
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
