/**
 * @Description: 员工考勤异常处理申请管理
 * @ClassName: NtPersonnelApplyService
 * @author： Mr.Kong
 * @date: 2019/5/13 16:48
 * @Version： 1.0
 */
package cn.com.nantian.service;

import cn.com.nantian.pojo.NtPersonnelApply;

public interface NtPersonnelApplyService {
    int deleteByPrimaryKey(Integer applySeq);

    int insert(NtPersonnelApply record);

    int insertSelective(NtPersonnelApply record);

    NtPersonnelApply selectByPrimaryKey(Integer applySeq);

    int updateByPrimaryKeySelective(NtPersonnelApply record);

    int updateByPrimaryKey(NtPersonnelApply record);
}
