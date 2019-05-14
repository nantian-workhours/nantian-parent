package cn.com.nantian.service;

import cn.com.nantian.pojo.NtDepartment;
import cn.com.nantian.pojo.NtPersonnel;

import java.util.List;

public interface DepartmentService {

    /**
      * @description:  添加 部门信息
      * @auther: Mr.Kong
      * @date: 2019/4/26 9:55
      * @Param:  [department]
      * @return: int
      **/
    int addDepartment(NtDepartment department);

    /**
     * @description: 检查传入放入参数是否为空
     * @auther: Mr.Kong
     * @date: 2019/4/26 10:01
     * @Param:  [department]
     * @return: java.lang.String
     **/
    public String checkParameter(NtDepartment department);


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
      * @description: 设置服务类别名称
      * @auther: Mr.Kong
      * @date: 2019/4/23 16:42
      * @Param:  [departmentList]
      * @return: java.util.List<java.lang.String>
      **/
    public void setServiceTypeName(List<NtDepartment> departmentList);


}
