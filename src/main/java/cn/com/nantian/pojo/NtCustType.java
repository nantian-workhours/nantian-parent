package cn.com.nantian.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * 客户类型实体1
 */
@Data
public class NtCustType implements Serializable {
    /**主键id*/
    private Integer custId;
    /**客户类别*/
    private String custType;
    /**工作类别*/
    private String workType;
    /**技术等级*/
    private String workLevel;

    //============================
    /**客户类别名称*/
    private String custTypeName;
    /**工作类别名称*/
    private List<String> workTypeNameList;
    /**工作级别名称*/
    private List<String> workLevelNameList;

    /**
      * @description: 重写equals方法
      * @auther: Mr.Kong
      * @date: 2019/3/26 14:31
      * @Param: [o]
      * @return: boolean
      **/
    public boolean equals(Object o) {
        if (this == o) {
            return true;  //先判断o是否为本对象，如果是就肯定是同一对象了，this 指向当前的对象
        }
        if (o == null || getClass() != o.getClass()) {
            return false; //再判断o是否为null，和o.类对象和本类对象是否一致
        }
        NtCustType ntCustType = (NtCustType) o;  //再把o对象强制转化为Transport类对象
        return Objects.equals(custType, ntCustType.custType)
                && Objects.equals(workType, ntCustType.workType)
                && Objects.equals(workLevel, ntCustType.workLevel);  //查看两个对象属性值是否相等,返回结果
    }

}