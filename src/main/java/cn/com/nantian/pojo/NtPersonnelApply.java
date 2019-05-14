/**
  * @Description: 员工考勤异常处理申请实体
  * @auther: Mr.Kong
  * @date: 2019/5/13 16:46
  **/
package cn.com.nantian.pojo;
import lombok.Data;
import java.util.Date;

@Data
public class NtPersonnelApply {
    /**任务号*/
    private Integer applySeq;
    /**员工编号*/
    private Integer perId;
    /**申请日期*/
    private Date applyDate;
    /**申请类型*/
    private String applyType;
    /**申请值*/
    private String applyValue;
    /**考勤日期*/
    private Date workDate;
    /**处理状态*/
    private String applyStatus;
    /**错误描述*/
    private String errDescribe;
    /**审批日期*/
    private Date approveDate;
    /**审批人编号*/
    private Integer managerId;
    /**附件路径*/
    private String filePath;
    /**附件名称*/
    private String fileName;
    /**审批意见*/
    private String approveOpn;
    //========================================
    /**申请日期*/
    private String applyDateStr;
    /**考勤日期*/
    private String workDateStr;
    /**员工姓名*/
    private String userName;
    /**申请类型名称*/
    private String applyTypeName;
    /**申请状态名称*/
    private String applyStatusName;

}