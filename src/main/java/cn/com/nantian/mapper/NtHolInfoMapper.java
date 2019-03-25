package cn.com.nantian.mapper;

import cn.com.nantian.pojo.NtHolInfo;
import cn.com.nantian.pojo.NtHolInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NtHolInfoMapper {
    int countByExample(NtHolInfoExample example);

    int deleteByExample(NtHolInfoExample example);

    int deleteByPrimaryKey(Integer perId);

    int insert(NtHolInfo record);

    int insertSelective(NtHolInfo record);

    List<NtHolInfo> selectByExample(NtHolInfoExample example);

    NtHolInfo selectByPrimaryKey(Integer perId);

    int updateByExampleSelective(@Param("record") NtHolInfo record, @Param("example") NtHolInfoExample example);

    int updateByExample(@Param("record") NtHolInfo record, @Param("example") NtHolInfoExample example);

    int updateByPrimaryKeySelective(NtHolInfo record);

    int updateByPrimaryKey(NtHolInfo record);
}