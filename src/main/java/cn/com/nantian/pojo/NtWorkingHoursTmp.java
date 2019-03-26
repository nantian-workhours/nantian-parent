package cn.com.nantian.pojo;

import java.util.Date;

public class NtWorkingHoursTmp {
    //员工bianhoa
    private Integer perId;
    //日期
    private Date workDate;
    //正常工时
    private Float normalHours;
    //加班工时
    private Float overtimeHours;
    //开始时间
    private Date signinTime;
    //结束时间
    private Date signbackTime;

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public Float getNormalHours() {
        return normalHours;
    }

    public void setNormalHours(Float normalHours) {
        this.normalHours = normalHours;
    }

    public Float getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(Float overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public Date getSigninTime() {
        return signinTime;
    }

    public void setSigninTime(Date signinTime) {
        this.signinTime = signinTime;
    }

    public Date getSignbackTime() {
        return signbackTime;
    }

    public void setSignbackTime(Date signbackTime) {
        this.signbackTime = signbackTime;
    }
}