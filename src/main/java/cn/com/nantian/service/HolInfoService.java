package cn.com.nantian.service;

import cn.com.nantian.pojo.NtHolInfo;

import java.util.List;

public interface HolInfoService {

    List<NtHolInfo> selectHolInfoList(NtHolInfo ntHolInfo);

    int deleteByPrimaryKey(Integer perId);

    int insert(NtHolInfo record);

    int insertSelective(NtHolInfo record);

    NtHolInfo selectByPrimaryKey(Integer perId);

    int updateByPrimaryKeySelective(NtHolInfo record);

    int updateByPrimaryKey(NtHolInfo record);
}
