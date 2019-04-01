package cn.com.nantian.pojo;

import java.util.Date;

public class NtWorkingHoursKey {
    //员工id
    private Integer perId;
    //工作日期
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