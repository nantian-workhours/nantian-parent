/**
 * @description: 员工考勤异常处理申请管理
 * @auther: Mr.Wind
 * @date: 2019/5/13 16:46
 **/
package cn.com.nantian.mapper;

import cn.com.nantian.pojo.NtPersonnelApply;

import java.util.List;

public interface NtPersonnelApplyMapper {

    int updateApplyStatus(NtPersonnelApply personnelApply);

    List<NtPersonnelApply> queryPersonApplyList(NtPersonnelApply personnelApply);

    int deleteByPrimaryKey(Integer applySeq);

    int insert(NtPersonnelApply record);

    int insertSelective(NtPersonnelApply record);

    NtPersonnelApply selectByPrimaryKey(Integer applySeq);

    int updateByPrimaryKeySelective(NtPersonnelApply record);

    int updateByPrimaryKey(NtPersonnelApply record);
}