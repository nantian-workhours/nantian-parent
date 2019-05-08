package cn.com.nantian.pojo;
import lombok.Data;

import java.util.Date;

/**
  * @Description: 员工所在项目实体
  * @Auther: Mr.Kong
  * @Date: 2019/5/8 16:47 
  **/

@Data
public class NtPerInProject {
    /**员工编号*/
    private Integer perId;
    /**项目编号*/
    private Integer projectNumber;
    /**在项目中的等级*/
    private String inProjectLeave;
    /**项目开始时间*/
    private Date projectBegdate;
    /**项目结束时间*/
    private Date projectEnddate;
    /**工作类型*/
    private String workType;
    /**身份证号*/
    private String idNo;
    
    
}