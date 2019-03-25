package cn.com.nantian.pojo;

import java.util.Date;

public class NtLeave {
    private Integer perId;

    private Date begDate;

    private Date endDate;

    private String leaveType;

    private Float leaveCount;

    private String leaveRemark;

    private String applyStatus;

    private Date approveDate;

    private Integer managerId;

    private String approveOpn;

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public Date getBegDate() {
        return begDate;
    }

    public void setBegDate(Date begDate) {
        this.begDate = begDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType == null ? null : leaveType.trim();
    }

    public Float getLeaveCount() {
        return leaveCount;
    }

    public void setLeaveCount(Float leaveCount) {
        this.leaveCount = leaveCount;
    }

    public String getLeaveRemark() {
        return leaveRemark;
    }

    public void setLeaveRemark(String leaveRemark) {
        this.leaveRemark = leaveRemark == null ? null : leaveRemark.trim();
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus == null ? null : applyStatus.trim();
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getApproveOpn() {
        return approveOpn;
    }

    public void setApproveOpn(String approveOpn) {
        this.approveOpn = approveOpn == null ? null : approveOpn.trim();
    }
}