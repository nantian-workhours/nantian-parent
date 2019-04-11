package cn.com.nantian.common;

/**
 * @description : Memcache 缓存相关常量
 * @Create Date : 2019-4-11
 */
public class MemConstans {

    public static PropertyUtil webPropertyUtil = PropertyUtil.getInstance("memtimes");

    /**
     * 项目统一存MemCache值时的前缀
     */
    public static final String MEMFIX = webPropertyUtil.getProperty("memfix");
    /**
     * 缓存24小时;key为随机生成的
     */
    public static final int SYS_USER_TIME = Integer.parseInt(webPropertyUtil.getProperty("SYS_USER_TIME"));
    /**
     * 缓存24小时
     */
    public static final int SYS_USER_ALL_FUNCTION_TIME = Integer.parseInt(webPropertyUtil.getProperty("SYS_USER_ALL_FUNCTION_TIME"));
    /**
     * 网站统计显示6小时
     */
    public static final int WEB_STATISTICS_TIME = Integer.parseInt(webPropertyUtil.getProperty("WEB_STATISTICS_TIME"));
}
