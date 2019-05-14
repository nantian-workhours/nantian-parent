package cn.com.nantian.pojo;

import lombok.Data;

import java.util.Objects;

/**
 * 客户信息实体
 */
@Data
public class NtProjectInfo {
    /**项目编号*/
    private Integer projectNumber;
    /**项目名称*/
    private String projectName;
    /**客户类别*/
    private String custType;
    /**部门编号*/
    private Integer deptId;
    /**在场负责人id*/
    private Integer chargeId;
    /**办公地址*/
    private String address;

    //======================
    /**部门名称*/
    private String deptName;
    /**在场负责人姓名*/
    private String chargeName;
    /**客户类别名称*/
    private String custTypeName;
    /**项目人数*/
    private Integer peopleNumber;

    /**
     * @description: 重写equals方法
     * @auther: Mr.Kong
     * @date: 2019/3/26 14:12
     * @Param: [o]
     * @return: boolean
     **/
    public boolean equals(Object o) {
        if (this == o) return true;  //先判断o是否为本对象，如果是就肯定是同一对象了，this 指向当前的对象
        if (o == null || getClass() != o.getClass()) return false; //再判断o是否为null，和o.类对象和本类对象是否一致
        NtProjectInfo proInfo = (NtProjectInfo) o;  //再把o对象强制转化为Transport类对象
        return Objects.equals(projectName, proInfo.projectName)
                && Objects.equals(custType, proInfo.custType)
                && Objects.equals(deptId, proInfo.deptId)
                && Objects.equals(chargeId, proInfo.chargeId)
                && Objects.equals(address, proInfo.address);  //查看两个对象的属性值是否相等,返回结果
    }
}