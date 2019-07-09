package cn.com.nantian.common;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author wcyong
 * @date 2013-6-21
 */
public class Test01 {
    public static void main(String[] args) {
        String a = "afsddgfs.png";
        String parentId = a.substring(0,a.indexOf(".")).trim();//逗号前面
        String levelCode = a.substring(a.indexOf(".")+1).trim();//逗号后面



        System.out.println(parentId);
        System.out.println(levelCode);


    }

}