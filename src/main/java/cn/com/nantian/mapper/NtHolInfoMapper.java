package cn.com.nantian.mapper;

import cn.com.nantian.pojo.NtHolInfo;

import java.util.List;

public interface NtHolInfoMapper {

    List<NtHolInfo> selectHolInfoList(NtHolInfo ntHolInfo);

    int deleteByPrimaryKey(Integer perId);

    int insert(NtHolInfo record);

    int insertSelective(NtHolInfo record);

    NtHolInfo selectByPrimaryKey(Integer perId);

    int updateByPrimaryKeySelective(NtHolInfo record);

    int updateByPrimaryKey(NtHolInfo record);
}