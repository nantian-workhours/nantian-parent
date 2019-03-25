package cn.com.nantian.mapper;

import cn.com.nantian.pojo.NtProjectInfo;
import cn.com.nantian.pojo.NtProjectInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NtProjectInfoMapper {
    int countByExample(NtProjectInfoExample example);

    int deleteByExample(NtProjectInfoExample example);

    int deleteByPrimaryKey(Integer projectNumber);

    int insert(NtProjectInfo record);

    int insertSelective(NtProjectInfo record);

    List<NtProjectInfo> selectByExample(NtProjectInfoExample example);

    NtProjectInfo selectByPrimaryKey(Integer projectNumber);

    int updateByExampleSelective(@Param("record") NtProjectInfo record, @Param("example") NtProjectInfoExample example);

    int updateByExample(@Param("record") NtProjectInfo record, @Param("example") NtProjectInfoExample example);

    int updateByPrimaryKeySelective(NtProjectInfo record);

    int updateByPrimaryKey(NtProjectInfo record);

    /**
     * 根据类别查询项目信息
     * @param custType
     * @return
     */
    List<NtProjectInfo> selectByCustType(String custType);


    List<NtProjectInfo> selectBycustAndProjectName(@Param("custType") String custType, @Param("projectName") String projectName);

}