package cn.com.nantian.pojo;

import lombok.Data;

import java.util.Date;

/**
  * @Description: 节假日信息实体
  * @auther: Mr.Kong
  * @date: 2019/5/10 13:58
  **/
@Data
public class NtHoliday {
    /**节假日编号*/
    private Integer holidayId;
    /**节假日日期*/
    private Date holidayDate;
    /**节假日名称*/
    private String holidayName;
    /**说明*/
    private String holidayFunction;
    /**节假日类型*/
    private String holidayType;
}