/**
 * @description: 员工考勤异常处理申请管理
 * @ClassName: NtPersonnelApplyServiceImpl
 * @author： Mr.Kong
 * @date: 2019/5/13 16:49
 * @Version： 1.0
 */
package cn.com.nantian.service.impl;

import cn.com.nantian.common.DateUtils;
import cn.com.nantian.common.ObjectUtils;
import cn.com.nantian.common.StringUtils;
import cn.com.nantian.mapper.NtPersonnelApplyMapper;
import cn.com.nantian.pojo.NtPersonnelApply;
import cn.com.nantian.service.NtPersonnelApplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NtPersonnelApplyServiceImpl implements NtPersonnelApplyService {

    @Resource
    private NtPersonnelApplyMapper personnelApplyMapper;

    /**
     * @description: 查询员工异议申请信息列表
     * @auther: Mr.Kong
     * @date: 2019/5/14 15:15
     * @param: [personnelApply]
     * @return: List<NtPersonnelApply>
     **/
    @Override
    public List<NtPersonnelApply> queryPersonApplyList(NtPersonnelApply personnelApply) {
        return personnelApplyMapper.queryPersonApplyList(personnelApply);
    }

    /**
     * @description: 创建时 效验传入的参数值
     * @auther: Mr.Kong
     * @date: 2019/5/14 14:08
     * @param: [personnelApply]
     * @return: java.lang.String
     **/
    public String checkAttribute(NtPersonnelApply personnelApply) throws Exception {
        if (ObjectUtils.isNull(personnelApply.getPerId())) {
            return "员工编号 不能为空！";
        }
        if (StringUtils.isEmpty(personnelApply.getWorkDateStr())) {
            return "异议日期 不能为空！";
        } else if (!DateUtils.checkDateReg(personnelApply.getWorkDateStr())) {
            return "异议日期 格式不正确！";
        } else {
            personnelApply.setWorkDate(DateUtils.parseToDate(personnelApply.getWorkDateStr(), "yyyy-MM-dd"));
        }
        if (ObjectUtils.isNotNull(personnelApply.getNormalHoursStr())) {
            if (!StringUtils.isOnePointNumber(personnelApply.getNormalHoursStr())){
                return "正常工时 格式不正确！";
            }
            personnelApply.setNormalHours(Float.valueOf(personnelApply.getNormalHoursStr()));
        }

        if (ObjectUtils.isNotNull(personnelApply.getWorkHoursStr())) {
            if (!StringUtils.isOnePointNumber(personnelApply.getWorkHoursStr())){
                return "加班工时 格式不正确！";
            }
            personnelApply.setWorkHours(Float.valueOf(personnelApply.getWorkHoursStr()));
        }
        if (ObjectUtils.isNotNull(personnelApply.getLeaveHoursStr())) {
            if (!StringUtils.isOnePointNumber(personnelApply.getLeaveHoursStr())){
                return "请假工时 格式不正确！";
            }
            personnelApply.setLeaveHours(Float.valueOf(personnelApply.getLeaveHoursStr()));
        }
        if (ObjectUtils.isNull(personnelApply.getNormalHoursStr())
             && ObjectUtils.isNull(personnelApply.getWorkHoursStr())
             && ObjectUtils.isNull(personnelApply.getLeaveHoursStr())){
            return "工时 不能都为空！";
        }
        if (StringUtils.isEmpty(personnelApply.getErrDescribe())) {
            return "申请理由 不能为空！";
        }
        if (StringUtils.isEmpty(personnelApply.getFileName())) {
            return "附件名称 不能为空！";
        }
        if (StringUtils.isEmpty(personnelApply.getFilePath())) {
            return "附件路径 不能为空！";
        }
        personnelApply.setApplyStatus("R");//审核中
        return "";
    }

    @Override
    public int deleteByPrimaryKey(Integer applySeq) {
        return personnelApplyMapper.deleteByPrimaryKey(applySeq);
    }

    @Override
    public int insert(NtPersonnelApply record) {
        return personnelApplyMapper.insert(record);
    }

    @Override
    public int insertSelective(NtPersonnelApply record) {
        return personnelApplyMapper.insertSelective(record);
    }

    /**
     * @description: 查询员工异议申请信息详情
     * @auther: Mr.Kong
     * @date: 2019/5/14 15:48
     * @param: [applySeq]
     * @return: NtPersonnelApply
     **/
    @Override
    public NtPersonnelApply selectByPrimaryKey(Integer applySeq) {
        return personnelApplyMapper.selectByPrimaryKey(applySeq);
    }

    @Override
    public int updateByPrimaryKeySelective(NtPersonnelApply record) {
        return personnelApplyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(NtPersonnelApply record) {
        return personnelApplyMapper.updateByPrimaryKey(record);
    }

    /**
     * @description: 更新处理状态
     * @auther: Mr.Kong
     * @date: 2019/5/14 15:46
     * @param: [personnelApply]
     * @return: int
     **/
    @Override
    public int updateApplyStatus(NtPersonnelApply personnelApply) {
        personnelApply.setManagerId(1);//审批人编号
        return personnelApplyMapper.updateApplyStatus(personnelApply);
    }
}
