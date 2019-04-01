package cn.com.nantian.pojo;

import lombok.Data;

@Data
public class NtHolInfo {
    /**员工编号*/
    private Integer perId;
    /**年假天数*/
    private Float yearDays;
    /**剩余年假天数*/
    private Float overYearDays;
    /**调休天数*/
    private Float dayOffDays;
    /**剩余调休天数*/
    private Float overDayOffDays;
    //===================================
    /**员工姓名*/
    private String userName;
}