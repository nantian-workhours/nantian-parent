package cn.com.nantian.mapper;

import cn.com.nantian.pojo.NtTypeDictionaries;
import cn.com.nantian.pojo.NtTypeDictionariesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NtTypeDictionariesMapper {
    int countByExample(NtTypeDictionariesExample example);
    
    List<NtTypeDictionaries> queryAllType();

    int deleteByExample(NtTypeDictionariesExample example);

    int deleteByPrimaryKey(String typeCode);

    int insert(NtTypeDictionaries record);

    int insertSelective(NtTypeDictionaries record);

    List<NtTypeDictionaries> selectByExample(NtTypeDictionariesExample example);

    NtTypeDictionaries selectByPrimaryKey(String typeCode);

    int updateByExampleSelective(@Param("record") NtTypeDictionaries record, @Param("example") NtTypeDictionariesExample example);

    int updateByExample(@Param("record") NtTypeDictionaries record, @Param("example") NtTypeDictionariesExample example);

    int updateByPrimaryKeySelective(NtTypeDictionaries record);

    int updateByPrimaryKey(NtTypeDictionaries record);
}