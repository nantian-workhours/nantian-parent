package cn.com.nantian.service;

import cn.com.nantian.pojo.NtDepartment;
import cn.com.nantian.pojo.NtPersonnel;

import java.util.List;

public interface DepartmentService {

    //添加 部门信息
//    int addDepartment(NtDepartment department);

    int addDepartment(String deptName, String deptAbbreviation, int managerId,int assistantId,String serviceType);


    /**删除部门信息
    */
     int deleteone(int deptId);

    /**
     *
     * @param department
     * @return
     */
    int updateDepartment(NtDepartment department);

    /**
     * 查询所有部门信息
     * @return
     */
    List<NtDepartment> findAll();


    /**
     * 查询部门信息
     * @param deptId
     * @return
     */
    String selectDepart(int deptId);

    /**
      * @Description: 设置服务类别名称
      * @Auther: Mr.Kong
      * @Date: 2019/4/23 16:42
      * @Param:  [departmentList]
      * @Return: java.util.List<java.lang.String>
      **/
    public void setServiceTypeName(List<NtDepartment> departmentList);


}
