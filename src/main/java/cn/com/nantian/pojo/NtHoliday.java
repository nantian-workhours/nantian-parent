package cn.com.nantian.pojo;

import lombok.Data;

import java.util.Date;
import java.util.Objects;

/**
  * @Description: 节假日信息实体
  * @auther: Mr.Kong
  * @date: 2019/5/10 13:58
  **/
@Data
public class NtHoliday {
    /**节假日编号*/
    private Integer holidayId;
    /**名称*/
    private String holidayName;
    /**类型*/
    private String holidayType;
    /**开始日期*/
    private Date beginDate;
    /**结束日期*/
    private Date endDate;
    /**说明*/
    private String description;

    //=======================================
    /**开始日期*/
    private String beginDateStr;
    /**结束日期*/
    private String endDateStr;
    /**类型名称*/
    private String holidayTypeName;




    public boolean equals(Object o) {
        if (this == o) {
            return true;  //先判断o是否为本对象，如果是就肯定是同一对象了，this 指向当前的对象
        }
        if (o == null || getClass() != o.getClass()) {
            return false; //再判断o是否为null，和o.类对象和本类对象是否一致
        }
        NtHoliday ntHoliday = (NtHoliday) o;  //再把o对象强制转化为Transport类对象
        return Objects.equals(holidayName, ntHoliday.holidayName)
                && Objects.equals(holidayType, ntHoliday.holidayType)
                && Objects.equals(beginDate, ntHoliday.beginDate)
                && Objects.equals(endDate, ntHoliday.endDate);  //查看两个对象属性值是否相等,返回结果
    }

}