package cn.com.nantian.pojo;

public class NtPerAlias {
    //员工编号
    private Integer perId;

    //项目编号
    private Integer projectNumber;

    //项目中的名字
    private String inProjectName;

    //公司中的名字
    private String inCompanyName;

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

    public String getInProjectName() {
        return inProjectName;
    }

    public void setInProjectName(String inProjectName) {
        this.inProjectName = inProjectName;
    }

    public String getInCompanyName() {
        return inCompanyName;
    }

    public void setInCompanyName(String inCompanyName) {
        this.inCompanyName = inCompanyName;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }
}