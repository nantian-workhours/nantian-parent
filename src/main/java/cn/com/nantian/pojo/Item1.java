package cn.com.nantian.pojo;

public class Item1 {

    //部门编号
    private   int deptId ;
    //姓名
    private String name;
    //别名
    private  String inProjectName;
    //身份证号
    private String idNo;

    public String getInProjectName() {
        return inProjectName;
    }

    public void setInProjectName(String inProjectName) {
        this.inProjectName = inProjectName;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
