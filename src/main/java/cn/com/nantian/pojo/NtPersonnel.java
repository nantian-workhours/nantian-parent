package cn.com.nantian.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class NtPersonnel {

    /**员工id*/
    private Integer perId;
    /**部门id*/
    private Integer deptId;
    /**性别*/
    private String sex;
    /**姓名*/
    private String name;
    /**手机号*/
    private String mobileNo;
    /**身份证号*/
    private String idNo;
    /**生日*/
    private Date birthday;
    /**民族*/
    private String ethnic;
    /**学历*/
    private String education;
    /**毕业院校*/
    private String university;
    /**专业*/
    private String major;
    /**毕业日期*/
    private Date graduationDate;
    /**入司日期*/
    private Date entryDate;
    /**离职日期*/
    private Date leaveDate;
    /**状态*/
    private String status;
    /**职位*/
    private String position;
    /**公司邮箱*/
    private String companyEmail;
    /**个人邮箱*/
    private String personEmail;
    /**岗位*/
    private String post;
    /**密码*/
    private String password;
    /**籍贯*/
    private String nativePlace;
    /**婚姻*/
    private String marriageStatus;
    /**权限*/
    private String jurisdiction;
    //===============================

    /**生日*/
    private String birthdayStr;
    /**毕业日期*/
    private String graduationDateStr;
    /**入司日期*/
    private String entryDateStr;
    /**离职日期*/
    private String leaveDateStr;

    /**部门负责人编号*/
    private Long managerId;
    /**部门助理编号*/
    private Long assistantId;
    /**部门名称*/
    private String deptName;
    /**员工别名*/
    private String inProjectName;
    /**客户类别名称*/
    private String custType;
    /**状态说明（在职 或 离职）*/
    private String workStatus;

  }