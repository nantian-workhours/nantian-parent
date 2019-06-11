package cn.com.nantian.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class NtWorkingHoursKey {
    //员工id
    private Integer perId;
    //工作日期
    private Date workDate;
    //==================================
    //工作日期
    private String workDateStr;

}