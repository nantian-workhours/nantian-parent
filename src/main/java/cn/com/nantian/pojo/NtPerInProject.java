package cn.com.nantian.pojo;
import lombok.Data;

import java.util.Date;
import java.util.Objects;

/**
  * @Description: 员工所在项目实体
  * @Auther: Mr.Kong
  * @Date: 2019/5/8 16:47 
  **/

@Data
public class NtPerInProject {
    /**主键id*/
    private Integer Id;
    /**员工编号*/
    private Integer perId;
    /**身份证号*/
    private String idNo;
    /**客户类别*/
    private String custType;
    /**项目编号*/
    private Integer projectNumber;
    /**工作类型*/
    private String workType;
    /**技术等级*/
    private String workLevel;
    /**项目开始时间*/
    private Date projectBegdate;
    /**项目结束时间*/
    private Date projectEnddate;
    /**创建时间*/
    private Date createTime;
    /**状态 (0正常 1删除)*/
    private Integer status;

    //====================================
    /**项目开始时间*/
    private String projectBegdateStr;
    /**项目结束时间*/
    private String projectEnddateStr;
    /**客户类别名称*/
    private String custTypeName;
    /**工作类型名称*/
    private String workTypeName;
    /**技术等级名称*/
    private String workLevelName;
    /**项目名称*/
    private String projectName;
    /**员工姓名*/
    private String userName;
    /**部门名称*/
    private String deptName;
    /**在场状态*/
    private String workStatus;



    public boolean equals(Object o) {
        if (this == o) {
            return true;  //先判断o是否为本对象，如果是就肯定是同一对象了，this 指向当前的对象
        }
        if (o == null || getClass() != o.getClass()) {
            return false; //再判断o是否为null，和o.类对象和本类对象是否一致
        }
        NtPerInProject ntPerInProject = (NtPerInProject) o;  //再把o对象强制转化为Transport类对象
        return Objects.equals(perId, ntPerInProject.perId)
                && Objects.equals(idNo, ntPerInProject.idNo)
                && Objects.equals(custType, ntPerInProject.custType)
                && Objects.equals(projectNumber, ntPerInProject.projectNumber)
                && Objects.equals(workType, ntPerInProject.workType)
                && Objects.equals(workLevel, ntPerInProject.workLevel)
                && Objects.equals(projectBegdate, ntPerInProject.projectBegdate)
                && Objects.equals(projectEnddate, ntPerInProject.projectEnddate);  //查看两个对象属性值是否相等,返回结果
    }
    
    
}