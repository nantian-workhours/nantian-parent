/**
 * @Description:
 * @ClassName: LeaveServiceImpl
 * @Author： Mr.Kong
 * @Date: 2019/3/29 15:03
 * @Version： 1.0
 */
package cn.com.nantian.service.impl;

import cn.com.nantian.common.ObjectUtils;
import cn.com.nantian.common.ParamUntil;
import cn.com.nantian.common.StringUtils;
import cn.com.nantian.mapper.NtLeaveMapper;
import cn.com.nantian.pojo.NtDictionariesKey;
import cn.com.nantian.pojo.NtLeave;
import cn.com.nantian.service.DictionariesService;
import cn.com.nantian.service.LeaveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService{

    @Resource
    private NtLeaveMapper leaveMapper;
    @Resource
    private DictionariesService dictionariesService;
    /**
      * @Description: 设置请假类别名称、审批状态名称
      * @Auther: Mr.Kong
      * @Date: 2019/3/29 15:32
      * @Param: [leaveList]
      * @Return: void
      **/
    public void setLeaveTypeName(List<NtLeave> leaveList){
        if (ObjectUtils.isNotNull(leaveList)){
            for (NtLeave leave:leaveList){
                //设置请假类别名称
                NtDictionariesKey dictionariesKey = dictionariesService.selectDictionaries(ParamUntil.hol, leave.getLeaveType());
                if (ObjectUtils.isNotNull(dictionariesKey)){
                    leave.setLeaveTypeName(dictionariesKey.getDicValue());
                }
                //设置审批状态名称 R 审核中，Y 通过，N 退回
                if (StringUtils.isNotEmpty(leave.getApplyStatus()) && leave.getApplyStatus().equals("R")){
                    leave.setApplyStatusName("审核中");
                }else if (StringUtils.isNotEmpty(leave.getApplyStatus()) && leave.getApplyStatus().equals("Y")){
                    leave.setApplyStatusName("通过");
                }else if (StringUtils.isNotEmpty(leave.getApplyStatus()) && leave.getApplyStatus().equals("N")){
                    leave.setApplyStatusName("退回");
                }
            }
        }
    }
    /**
      * @Description: 设置请假类别名称、审批状态名称
      * @Auther: Mr.Kong
      * @Date: 2019/3/29 15:33
      * @Param: [leave]
      * @Return: void
      **/
    public void setLeaveTypeName(NtLeave leave){
        if (ObjectUtils.isNotNull(leave)){
                //设置请假类别名称
                NtDictionariesKey dictionariesKey = dictionariesService.selectDictionaries(ParamUntil.hol, leave.getLeaveType());
                if (ObjectUtils.isNotNull(dictionariesKey)){
                    leave.setLeaveTypeName(dictionariesKey.getDicValue());
                }
                //设置审批状态名称 R 审核中，Y 通过，N 退回
                if (StringUtils.isNotEmpty(leave.getApplyStatus()) && leave.getApplyStatus().equals("R")){
                    leave.setApplyStatusName("审核中");
                }
                if (StringUtils.isNotEmpty(leave.getApplyStatus()) && leave.getApplyStatus().equals("Y")){
                    leave.setApplyStatusName("通过");
                }else if (StringUtils.isNotEmpty(leave.getApplyStatus()) && leave.getApplyStatus().equals("N")){
                    leave.setApplyStatusName("退回");
                }
        }
    }

    /**
      * @Description: 查询请假信息列表
      * @Auther: Mr.Kong
      * @Date: 2019/3/29 15:25
      * @Param: [leave]
      * @Return: java.util.List<cn.com.nantian.pojo.NtLeave>
      **/
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
