/**
 * @Description:
 * @ClassName: LeaveServiceImpl
 * @Author： Mr.Kong
 * @Date: 2019/3/29 15:03
 * @Version： 1.0
 */
package cn.com.nantian.service.impl;

import cn.com.nantian.mapper.NtLeaveMapper;
import cn.com.nantian.pojo.NtLeave;
import cn.com.nantian.service.LeaveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService{

    @Resource
    private NtLeaveMapper leaveMapper;

    @Override
    public List<NtLeave> selectLeaveList(NtLeave leave) {
        return leaveMapper.selectLeaveList(leave);
    }

    @Override
    public int deleteByPrimaryKey(Integer leaveId) {
        return leaveMapper.deleteByPrimaryKey(leaveId);
    }

    @Override
    public int insert(NtLeave record) {
        return leaveMapper.insert(record);
    }

    @Override
    public int insertSelective(NtLeave record) {
        return leaveMapper.insertSelective(record);
    }

    @Override
    public NtLeave selectByPrimaryKey(Integer leaveId) {
        return leaveMapper.selectByPrimaryKey(leaveId);
    }

    @Override
    public int updateByPrimaryKeySelective(NtLeave record) {
        return leaveMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(NtLeave record) {
        return leaveMapper.updateByPrimaryKey(record);
    }
}
