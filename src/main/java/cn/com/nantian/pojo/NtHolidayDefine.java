package cn.com.nantian.pojo;

import java.util.Date;

public class NtHolidayDefine {
    private Integer holidayId;

    private Date holidayDate;

    private String holidayName;

    private String holidayFunction;

    private String holidayType;

    public Integer getHolidayId() {
        return holidayId;
    }

    public void setHolidayId(Integer holidayId) {
        this.holidayId = holidayId;
    }

    public Date getHolidayDate() {
        return holidayDate;
    }

    public void setHolidayDate(Date holidayDate) {
        this.holidayDate = holidayDate;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName == null ? null : holidayName.trim();
    }

    public String getHolidayFunction() {
        return holidayFunction;
    }

    public void setHolidayFunction(String holidayFunction) {
        this.holidayFunction = holidayFunction == null ? null : holidayFunction.trim();
    }

    public String getHolidayType() {
        return holidayType;
    }

    public void setHolidayType(String holidayType) {
        this.holidayType = holidayType == null ? null : holidayType.trim();
    }
}