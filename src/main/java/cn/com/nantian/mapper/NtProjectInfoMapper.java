package cn.com.nantian.mapper;

import cn.com.nantian.pojo.NtProjectInfo;
import cn.com.nantian.pojo.NtProjectInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NtProjectInfoMapper {
    /**
     * @description: 查询客户信息集合
     * @Param: [perInProject]
     * @return: List<NtPerInProject>
     * @auther: Mr.Kong
     * @date: 2019/3/20 10:16
     **/
    List<NtProjectInfo> selectNtProjectInfoList(NtProjectInfo ntProjectInfo);

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