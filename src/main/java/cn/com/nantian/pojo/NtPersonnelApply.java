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
    private Integer applySeq;

    private Integer perId;

    private Date applyDate;

    private String applyType;

    private String applyValue;

    private Date workDate;

    private String applyStatus;

    private String errDescribe;

    private Date approveDate;

    private Integer managerId;

    private String filePath;

    private String fileName;

    private String approveOpn;
}