package cn.com.nantian.mapper;

import cn.com.nantian.pojo.NtDepartment;
import cn.com.nantian.pojo.NtDepartmentExample;
import java.util.List;

import cn.com.nantian.pojo.NtPersonnel;
import org.apache.ibatis.annotations.Param;

public interface NtDepartmentMapper {
    NtDepartment queryDepartmentByName(String deptName);

    int countByExample(NtDepartmentExample example);

    int deleteByExample(NtDepartmentExample example);

    int deleteByPrimaryKey(Integer deptId);

    int insert(NtDepartment record);

    //查询最大的key值
    int seletByMaxKey();

    int insertSelective(NtDepartment record);

    List<NtDepartment> selectByExample(NtDepartmentExample example);

    /**
     *
     * @param deptId
     * @return
     */
    NtDepartment selectByPrimaryKey(int deptId);

    int updateByExampleSelective(@Param("record") NtDepartment record, @Param("example") NtDepartmentExample example);

    int updateByExample(@Param("record") NtDepartment record, @Param("example") NtDepartmentExample example);

    int updateByPrimaryKeySelective(NtDepartment record);

    int updateByPrimaryKey(NtDepartment record);


}