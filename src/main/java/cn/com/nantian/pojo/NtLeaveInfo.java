package cn.com.nantian.pojo;

import lombok.Data;

import java.util.Date;
import java.util.Objects;
@Data
public class NtLeaveInfo {
    /**主键id*/
    private Integer priceId;
    /**客户类别*/
    private String custType;
    /**工作种类*/
    private String workType;
    /**等级*/
    private String workLevel;
    /**等级单价*/
    private Double levelPrice;
    /**开始日期*/
    private Date projectBegdate;
    /**结束日期*/
    private Date projectEnddate;
    /**项目编号*/
    private Integer projectNumber;

    //====================================
    /**等级单价*/
    private String levelPriceStr;
    /**开始日期*/
    private String projectBegdateStr;
    /**结束日期*/
    private String projectEnddateStr;


    /**客户类别名称*/
    private String custTypeName;
    /**工作类别名称*/
    private String workTypeName;
    /**技术等级名称*/
    private String workLevelName;


    public boolean equals(Object o) {
        if (this == o) {
            return true;  //先判断o是否为本对象，如果是就肯定是同一对象了，this 指向当前的对象
        }
        if (o == null || getClass() != o.getClass()) {
            return false; //再判断o是否为null，和o.类对象和本类对象是否一致
        }
        NtLeaveInfo ntLeaveInfo = (NtLeaveInfo) o;  //再把o对象强制转化为Transport类对象
        return Objects.equals(custType, ntLeaveInfo.custType)
                && Objects.equals(workType, ntLeaveInfo.workType)
                && Objects.equals(workLevel, ntLeaveInfo.workLevel)
                && Objects.equals(levelPrice, ntLeaveInfo.levelPrice)
                && Objects.equals(projectBegdate, ntLeaveInfo.projectBegdate)
                && Objects.equals(projectEnddate, ntLeaveInfo.projectEnddate)
                && Objects.equals(projectNumber, ntLeaveInfo.projectNumber);  //查看两个对象属性值是否相等,返回结果
    }
}