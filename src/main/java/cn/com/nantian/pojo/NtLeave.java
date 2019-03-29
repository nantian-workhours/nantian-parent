package cn.com.nantian.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class NtLeave {
    /**主键id*/
    private Integer leaveId;
    /**员工编号*/
    private Integer perId;
    /**请假开始日期*/
    private Date begDate;
    /**请假结束日期*/
    private Date endDate;
    /**请假类型*/
    private String leaveType;
    /**请假天数*/
    private Float leaveCount;
    /**请假说明*/
    private String leaveRemark;
    /**审批状态 R 审核中，Y 通过，N 退回*/
    private String applyStatus;
    /**审批时间*/
    private Date approveDate;
    /**审批人ID*/
    private Integer managerId;
    /**审批意见*/
    private String approveOpn;

    //============================
    /**员工姓名*/
    private String userName;
    /**部门id*/
    private String deptId;
    /**部门名称*/
    private String deptName;
    /**请假类型名称*/
    private String leaveTypeName;
    /**审批状态名称 R 审核中，Y 通过，N 退回*/
    private String applyStatusName;




}