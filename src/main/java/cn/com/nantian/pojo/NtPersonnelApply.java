package cn.com.nantian.pojo;

import java.util.Date;

public class NtPersonnelApply {
    private Integer applySeq;

    private Integer perId;

    private Date applyDate;

    private String applyType;

    private String applyValue;

    private Date workDate;

    private String applyStatus;

    private String errDescribe;

    private Date approveDate;

    private Integer managerId;

    private String filePath;

    private String fileName;

    private String approveOpn;

    public Integer getApplySeq() {
        return applySeq;
    }

    public void setApplySeq(Integer applySeq) {
        this.applySeq = applySeq;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType == null ? null : applyType.trim();
    }

    public String getApplyValue() {
        return applyValue;
    }

    public void setApplyValue(String applyValue) {
        this.applyValue = applyValue == null ? null : applyValue.trim();
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus == null ? null : applyStatus.trim();
    }

    public String getErrDescribe() {
        return errDescribe;
    }

    public void setErrDescribe(String errDescribe) {
        this.errDescribe = errDescribe == null ? null : errDescribe.trim();
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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getApproveOpn() {
        return approveOpn;
    }

    public void setApproveOpn(String approveOpn) {
        this.approveOpn = approveOpn == null ? null : approveOpn.trim();
    }
}