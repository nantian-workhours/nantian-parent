package cn.com.nantian.pojo;

import java.util.Date;

public class NtLeaveInfo {
    private String custType;

    private String workType;

    private String workLeave;

    private Double leavePrice;

    private Date projectBegdate;

    private Date projectEnddate;

    private Integer projectNumber;

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType == null ? null : custType.trim();
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType == null ? null : workType.trim();
    }

    public String getWorkLeave() {
        return workLeave;
    }

    public void setWorkLeave(String workLeave) {
        this.workLeave = workLeave == null ? null : workLeave.trim();
    }

    public Double getLeavePrice() {
        return leavePrice;
    }

    public void setLeavePrice(Double leavePrice) {
        this.leavePrice = leavePrice;
    }

    public Date getProjectBegdate() {
        return projectBegdate;
    }

    public void setProjectBegdate(Date projectBegdate) {
        this.projectBegdate = projectBegdate;
    }

    public Date getProjectEnddate() {
        return projectEnddate;
    }

    public void setProjectEnddate(Date projectEnddate) {
        this.projectEnddate = projectEnddate;
    }

    public Integer getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(Integer projectNumber) {
        this.projectNumber = projectNumber;
    }
}