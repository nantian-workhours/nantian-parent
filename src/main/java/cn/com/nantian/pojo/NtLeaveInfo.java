package cn.com.nantian.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;


@Data
@EqualsAndHashCode(callSuper = false)
public class NtLeaveInfo {
    /**主键id*/
    private Integer priceId;

    private String custType;

    private String workType;

    private String workLeave;

    private Double leavePrice;

    private Date projectBegdate;

    private Date projectEnddate;

    private Integer projectNumber;

    //====================================
    /**客户类别名称*/
    private String custTypeName;
    /**工作类别名称*/
    private String workTypeName;
    /**技术等级名称*/
    private String workLeaveName;



}