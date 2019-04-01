package cn.com.nantian.pojo;

import java.util.Date;

public class NtWorkingHours extends NtWorkingHoursKey {
    //正常工时
    private Float normalHours;
    //加班工时
    private Float overtimeHours;
    //签到时间
    private Date signinTime;
    //签退时间
    private Date signbackTime;

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