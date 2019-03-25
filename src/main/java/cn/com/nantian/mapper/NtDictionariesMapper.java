package cn.com.nantian.mapper;

import cn.com.nantian.pojo.NtDictionariesExample;
import cn.com.nantian.pojo.NtDictionariesKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NtDictionariesMapper {

    /**
     * @Description: 根据条件查询字典数据
     * @Param: [dictionariesKey]
     * @Return: java.util.List<cn.com.nantian.pojo.NtDictionariesKey>
     * @Auther: Fly
     * @Date: 2019/3/19 16:46
     **/
    List<NtDictionariesKey> selectDictionariesList(NtDictionariesKey dictionariesKey);

    /**
     * @Description: 根据条件查询字典数据
     * @Param: [dictionariesKey]
     * @Return: cn.com.nantian.pojo.NtDictionariesKey
     * @Auther: Fly
     * @Date: 2019/3/20 15:25
     **/
    NtDictionariesKey selectDictionaries(NtDictionariesKey dictionariesKey);
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