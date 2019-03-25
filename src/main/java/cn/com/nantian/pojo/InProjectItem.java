package cn.com.nantian.pojo;

import java.util.Date;

/**
 * Created by ydz on 2019/3/19
 * 所在项目返回内容
 */


public class InProjectItem {

    //项目编号
    private String projectName;

    //在项目中的等级
    private String inProjectLeave;

    //项目开始时间
    private Date projectBegdate;

    //项目结束时间
    private Date projectEnddate;

    //工作类型
    private String workType;

    //身份证号
    private String idNo;

    //姓名
    private String name;

    //部门
    private String deptName;

    //客户类别
    private   String custType;
    //在场离场
    private String status;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getInProjectLeave() {
        return inProjectLeave;
    }

    public void setInProjectLeave(String inProjectLeave) {
        this.inProjectLeave = inProjectLeave;
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

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
