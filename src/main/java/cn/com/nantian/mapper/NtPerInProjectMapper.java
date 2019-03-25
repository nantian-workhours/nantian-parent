package cn.com.nantian.mapper;

import cn.com.nantian.pojo.NtPerInProject;
import cn.com.nantian.pojo.NtPerInProjectExample;
import java.util.List;

import cn.com.nantian.pojo.NtProjectInfo;
import org.apache.ibatis.annotations.Param;

public interface NtPerInProjectMapper {
    int countByExample(NtPerInProjectExample example);

    int deleteByExample(NtPerInProjectExample example);

    int insert(NtPerInProject record);

    int insertSelective(NtPerInProject record);

    List<NtPerInProject> selectByExample(NtPerInProjectExample example);

    int updateByExampleSelective(@Param("record") NtPerInProject record, @Param("example") NtPerInProjectExample example);

    int updateByExample(@Param("record") NtPerInProject record, @Param("example") NtPerInProjectExample example);


    /**
     * 根据部门编号和身份证号查询
     * @param projectNumber
     * @param idNo
     * @return
     */
    List<NtPerInProject> selectByIdNoAndproNum(int projectNumber, String idNo);

    List<NtPerInProject> selectByIdNo(String idNo);

    List<NtPerInProject> selectByProNum(int projectNumber);

}