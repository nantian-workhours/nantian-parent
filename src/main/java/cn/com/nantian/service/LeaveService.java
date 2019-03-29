package cn.com.nantian.service;

import cn.com.nantian.pojo.NtLeave;

import java.util.List;

public interface LeaveService {

    /**
     * @Description: 设置请假类别名称、审批状态名称
     * @Auther: Mr.Kong
     * @Date: 2019/3/29 15:32
     * @Param: [leaveList]
     * @Return: void
     **/
    public void setLeaveTypeName(List<NtLeave> leaveList);

    /**
     * @Description: 设置请假类别名称、审批状态名称
     * @Auther: Mr.Kong
     * @Date: 2019/3/29 15:33
     * @Param: [leave]
     * @Return: void
     **/
    public void setLeaveTypeName(NtLeave leave);

    /**
     * @Description: 查询请假信息列表
     * @Auther: Mr.Kong
     * @Date: 2019/3/29 15:25
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
