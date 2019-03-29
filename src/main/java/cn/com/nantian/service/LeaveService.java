package cn.com.nantian.service;

import cn.com.nantian.pojo.NtLeave;

import java.util.List;

public interface LeaveService {

    List<NtLeave> selectLeaveList(NtLeave leave);

    int deleteByPrimaryKey(Integer leaveId);

    int insert(NtLeave record);

    int insertSelective(NtLeave record);

    NtLeave selectByPrimaryKey(Integer leaveId);

    int updateByPrimaryKeySelective(NtLeave record);

    int updateByPrimaryKey(NtLeave record);
}
