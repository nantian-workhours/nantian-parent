package cn.com.nantian.pojo;

import lombok.Data;

import java.util.List;

@Data
public class NtDepartment  {
    /**部门id*/
    private Integer deptId;
    /**部门名称*/
    private String deptName;
    /**部门简称*/
    private String deptAbbreviation;
    /**部门负责人编号*/
    private Integer managerId;
    /**部门助理编号*/
    private Integer assistantId;
    /**服务类别*/
    private String serviceType;
    /**上级部门编号*/
    private Integer prioDeptId;

    /**部门负责人姓名*/
    private String managerName;
    /**部门助理姓名*/
    private String assistantName;
    /**服务类别名称集合*/
    private List<String> serTypeNameList;

    }