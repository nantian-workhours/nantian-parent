package cn.com.nantian.mapper;

import cn.com.nantian.pojo.NtDictionariesExample;
import cn.com.nantian.pojo.NtDictionariesKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NtDictionariesMapper {
    /**
     * 根据参数类型和code值查询
     * @param dicType
     * @param dicCode
     * @return
     */
    NtDictionariesKey selectByTypeAndCode(@Param("dicType")String dicType,@Param("dicCode")String dicCode);

    int countByExample(NtDictionariesExample example);

    int deleteByExample(NtDictionariesExample example);

    int deleteByPrimaryKey(String dicCode);
    
    int deleteByDicType(String dicType);

    int insert(NtDictionariesKey record);

    int insertSelective(NtDictionariesKey record);

    List<NtDictionariesKey> selectByExample(String dicType);

    int updateByExampleSelective(@Param("record") NtDictionariesKey record, @Param("example") NtDictionariesExample example);

    int updateByExample(@Param("record") NtDictionariesKey record, @Param("example") NtDictionariesExample example);
}