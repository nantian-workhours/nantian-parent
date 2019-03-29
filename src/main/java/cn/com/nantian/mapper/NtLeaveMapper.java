package cn.com.nantian.mapper;

import cn.com.nantian.pojo.NtLeave;

import java.util.List;

public interface NtLeaveMapper {
    /**
     * @Description: 更新审批状态(R 审核中, Y 通过, N 退回)
     * @Auther: Mr.Kong
     * @Date: 2019/3/29 15:52
     * @Param: [leave]
     * @Return: int
     **/
    int updateLeaveStatus(NtLeave leave);

    /**
     * @Description: 查询请假信息列表
     * @Auther: Mr.Kong
     * @Date: 2019/3/29 15:52
     * @Param: [leave]
     * @Return: java.util.List<cn.com.nantian.pojo.NtLeave>
     **/
    List<NtLeave> selectLeaveList(NtLeave leave);

    int deleteByPrimaryKey(Integer leaveId);

    int insert(NtLeave record);

    int insertSelective(NtLeave record);

    NtLeave selectByPrimaryKey(Integer leaveId);

    int updateByPrimaryKeySelective(NtLeave record);

    int updateByPrimaryKey(NtLeave record);
}