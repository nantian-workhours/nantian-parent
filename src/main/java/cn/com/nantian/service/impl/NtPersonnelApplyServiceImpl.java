/**
 * @Description: 员工考勤异常处理申请管理
 * @ClassName: NtPersonnelApplyServiceImpl
 * @author： Mr.Kong
 * @date: 2019/5/13 16:49
 * @Version： 1.0
 */
package cn.com.nantian.service.impl;

import cn.com.nantian.mapper.NtPersonnelApplyMapper;
import cn.com.nantian.pojo.NtPersonnelApply;
import cn.com.nantian.service.NtPersonnelApplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class NtPersonnelApplyServiceImpl  implements NtPersonnelApplyService {

    @Resource
    private NtPersonnelApplyMapper personnelApplyMapper;

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
}
