package cn.com.nantian.pojo;

import java.io.Serializable;

public class NtDepartment implements Serializable {
    //部门id
    private Integer deptId;
    //部门名称
    private String deptName;
    //部门简称
    private String deptAbbreviation;
    //部门负责人编号
    private Integer managerId;
    //部门助理编号
    private Integer assistantId;
    //服务类别
    private String serviceType;
    //上级部门编号
    private Integer prioDeptId;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getDeptAbbreviation() {
        return deptAbbreviation;
    }

    public void setDeptAbbreviation(String deptAbbreviation) {
        this.deptAbbreviation = deptAbbreviation == null ? null : deptAbbreviation.trim();
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getAssistantId() {
        return assistantId;
    }

    public void setAssistantId(Integer assistantId) {
        this.assistantId = assistantId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    public Integer getPrioDeptId() {
        return prioDeptId;
    }

    public void setPrioDeptId(Integer prioDeptId) {
        this.prioDeptId = prioDeptId;
    }
}