package cn.com.nantian.mapper;

import cn.com.nantian.pojo.NtCustTypeExample;
import cn.com.nantian.pojo.NtCustTypeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NtCustTypeMapper {
    int countByExample(NtCustTypeExample example);

    int deleteByExample(NtCustTypeExample example);

    int deleteByPrimaryKey(NtCustTypeKey key);

    //int addCustType(NtCustTypeKey key);

    int insert(NtCustTypeKey record);

    int insertSelective(NtCustTypeKey record);

    List<NtCustTypeKey> selectByExample(NtCustTypeExample example);

    int updateByExampleSelective(@Param("record") NtCustTypeKey record, @Param("example") NtCustTypeExample example);

    int updateByExample(@Param("record") NtCustTypeKey record, @Param("example") NtCustTypeExample example);
}