package cn.com.nantian.pojo;

import java.util.Date;

public class NtWorkingHoursKey {
    private Integer perId;

    private Date workDate;

    public Integer getPerId() {
        return perId;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

}