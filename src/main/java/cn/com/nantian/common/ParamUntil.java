package cn.com.nantian.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by ydz on 2019/3/19
 */


public class ParamUntil {

    public  static String applyStatus=null; //审核状态
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
    public static String _2;  //客户类别.中国邮储
    public static String _3;  //客户类别.中国人寿
    public static String R;  //审核中
    public static String Y;  //通过
    public static String N;  //退回
    public static String C;  //产品开发
    public static String H;  //人员外包
    public static String P;  //项目外包
    public static String WORK_STATES;  //在职状态
    public static String POST;  //岗位
    public static String imagePath;//图片地址


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
            applyStatus=prop.getProperty("applyStatus");
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
            _3=prop.getProperty("_3");
            R=prop.getProperty("R");
            Y=prop.getProperty("Y");
            N=prop.getProperty("N");
            C=prop.getProperty("C");
            H=prop.getProperty("H");
            P=prop.getProperty("P");
            WORK_STATES=prop.getProperty("WORK_STATES");
            POST=prop.getProperty("POST");
            imagePath=prop.getProperty("imagePath");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
