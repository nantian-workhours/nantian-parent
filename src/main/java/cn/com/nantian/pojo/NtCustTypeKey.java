package cn.com.nantian.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 客户类型实体
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NtCustTypeKey implements Serializable {
    /**客户类别*/
    private String custType;
    /**工作类别*/
    private String workType;
    /**工作级别*/
    private String workLeave;

    //============================
    /**客户类别名称*/
    private String custTypeName;
    /**工作类别名称*/
    private String workTypeName;
    /**工作级别名称*/
    private String workLeaveName;

}