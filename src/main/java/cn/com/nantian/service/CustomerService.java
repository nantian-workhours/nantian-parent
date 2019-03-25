package cn.com.nantian.service;



import cn.com.nantian.pojo.NtProjectInfo;

import java.util.Map;

/**
 * 客户接口
 */
public interface CustomerService {


    /**
     * 添加项目信息
     * @param deptName
     * @param customerName
     * @param projectName
     * @param jobAdress
     * @param projectCharge
     */
    public  void addCustomer(String deptName, String customerName, String projectName, String jobAdress, String projectCharge);

    /**
     * 添加类别信息
     * @param projectName
     * @param type
     * @param leave
     */
    public  void addCustType(String projectName, Map<String ,String> type, String leave);


    /**
     * 根据项目编号查询项目信息
     * @param projectNumber
     * @return
     */
    NtProjectInfo selectByNumber(int projectNumber);

}
