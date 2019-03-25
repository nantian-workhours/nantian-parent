package cn.com.nantian.pojo;

import java.util.List;

public class PersonnelItem {


    //部门编号

    private int deptId;

    //身份证号
    private String idNo;

    //在职状态
    private String status;
    //别名表集合
    private String  inProjectName;

    //项目类别表集合
    private String custType ;




    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status== null ? null : status.trim();
    }

    public String getInProjectName() {
        return inProjectName;
    }

    public void setInProjectName(String inProjectName) {
        this.inProjectName = inProjectName ==null ? null :inProjectName.trim();
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType ==null ? null :custType.trim();
    }
}
