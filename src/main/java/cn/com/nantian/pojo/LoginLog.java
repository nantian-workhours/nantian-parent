/**
 * @description: 系统登录日志实体
 * @auther: Mr.Kong
 * @date: 2019/5/20 10:14
 **/
package cn.com.nantian.pojo;
import lombok.Data;
import java.util.Date;

@Data
public class LoginLog {
    /**主键*/
    private Integer id;
    /**登录时间*/
    private Date loginTime;
    /**IP*/
    private String ip;
    /**用户ID*/
    private Integer userId;
    /**登录地址*/
    private String address;
    /**操作系统*/
    private String osname;
    /**浏览器名称*/
    private String userAgent;

}