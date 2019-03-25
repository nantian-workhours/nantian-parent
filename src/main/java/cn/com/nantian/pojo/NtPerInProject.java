package cn.com.nantian.pojo;

import java.util.Date;

public class NtPerInProject {
    //员工编号
    private Integer perId;

    //项目编号
    private Integer projectNumber;

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

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public Integer getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(Integer projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getInProjectLeave() {
        return inProjectLeave;
    }

    public void setInProjectLeave(String inProjectLeave) {
        this.inProjectLeave = inProjectLeave == null ? null : inProjectLeave.trim();
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
        this.workType = workType == null ? null : workType.trim();
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }
}