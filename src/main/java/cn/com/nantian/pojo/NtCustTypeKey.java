package cn.com.nantian.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Objects;

/**
 * 客户类型实体1
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

    /**
      * @Description: 重写equals方法
      * @Auther: Mr.Kong
      * @Date: 2019/3/26 14:31
      * @Param: [o]
      * @Return: boolean
      **/
    public boolean equals(Object o) {
        if (this == o) return true;  //先判断o是否为本对象，如果是就肯定是同一对象了，this 指向当前的对象
        if (o == null || getClass() != o.getClass()) return false; //再判断o是否为null，和o.类对象和本类对象是否一致
        NtCustTypeKey ntCustTypeKey = (NtCustTypeKey) o;  //再把o对象强制转化为Transport类对象
        return Objects.equals(custType, ntCustTypeKey.custType)
                && Objects.equals(workType, ntCustTypeKey.workType)
                && Objects.equals(workLeave, ntCustTypeKey.workLeave);  //查看两个对象属性值是否相等,返回结果
    }

}