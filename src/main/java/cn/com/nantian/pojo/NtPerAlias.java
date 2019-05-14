package cn.com.nantian.pojo;

import lombok.Data;

import java.util.Objects;

/**
  * @description:  别名实体
  * @auther: Mr.Kong
  * @date: 2019/5/8 10:53
  **/
@Data
public class NtPerAlias {
    /**员工编号*/
    private Integer perId;
    /**项目编号*/
    private Integer projectNumber;
    /**别名*/
    private String inProjectName;
    /**员工姓名*/
    private String inCompanyName;
    /**身份证号*/
    private String idNo;

    //=====================================
    /**客户类别*/
    private String custType;
    /**项目名称*/
    private String projectName;



    public boolean equals(Object o) {
        if (this == o) {
            return true;  //先判断o是否为本对象，如果是就肯定是同一对象了，this 指向当前的对象
        }
        if (o == null || getClass() != o.getClass()) {
            return false; //再判断o是否为null，和o.类对象和本类对象是否一致
        }
        NtPerAlias ntPerAlias = (NtPerAlias) o;  //再把o对象强制转化为Transport类对象
        return Objects.equals(perId, ntPerAlias.perId)
                && Objects.equals(projectNumber, ntPerAlias.projectNumber)
                && Objects.equals(inProjectName, ntPerAlias.inProjectName)
                && Objects.equals(inCompanyName, ntPerAlias.inCompanyName)
                && Objects.equals(idNo, ntPerAlias.idNo);  //查看两个对象属性值是否相等,返回结果
    }


}