package cn.com.nantian.pojo;

import java.io.Serializable;

public class NtCustTypeKey implements Serializable {
    private String custType;

    private String workType;

    private String workLeave;

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
}