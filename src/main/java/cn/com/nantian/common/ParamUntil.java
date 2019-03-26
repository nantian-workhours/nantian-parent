package cn.com.nantian.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by ydz on 2019/3/19   kong
 */


public class ParamUntil {

    public  static String sex=null; //性别
    public static String cust=null; //客户类别
    public static String dc=null;  //开发级别
    public static String dept=null; //部门
    public static String dis=null;  //异议
    public static String hol=null; //请假
    public static String st=null;  //服务类别
    public static String tc=null;  //测试级别
    public static String wt=null;  //工作类别
    public static String excelPath=null;  //excel保存路径
    public static String excelPath1=null;  //excel保存路径
    public static String _1;  //客户类别.中国银行
    public static String _2;  //客户类别.中国人寿


    static {
        String propertyFile = "properties/arg.properties";
        InputStream in=null;
        Properties prop = new Properties();
        try {
//            C:/Users/Administrator/Desktop/newproject/branches/dev/nantian-parent/src/main/resources/properties/arg.properties
//            in = PropertyUntil.class.getClassLoader().getResourceAsStream("C:/Users/Administrator/Desktop/newproject/branches/dev/nantian-parent/src/main/resources/properties/arg.properties");
            in = ParamUntil.class.getClassLoader().getResourceAsStream(propertyFile);

            prop.load(in);

            System.out.println(in);
            //获取参数值
            sex=prop.getProperty("sex");
            cust=prop.getProperty("cust");
            dc=prop.getProperty("dc");
            dept=prop.getProperty("dept") ;
            dis=prop.getProperty("dis");
            hol=prop.getProperty("hol");
            st=prop.getProperty("st");
            tc=prop.getProperty("tc");
            wt=prop.getProperty("wt");
            excelPath=prop.getProperty("excelPath");
            excelPath1=prop.getProperty("excelPath1");
            _1=prop.getProperty("_1");
            _2=prop.getProperty("_2");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
