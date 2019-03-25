package cn.com.nantian.mapper;

import cn.com.nantian.pojo.NtPersonnelApply;
import cn.com.nantian.pojo.NtPersonnelApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NtPersonnelApplyMapper {
    int countByExample(NtPersonnelApplyExample example);

    int deleteByExample(NtPersonnelApplyExample example);

    int deleteByPrimaryKey(Integer applySeq);

    int insert(NtPersonnelApply record);

    int insertSelective(NtPersonnelApply record);

    List<NtPersonnelApply> selectByExample(NtPersonnelApplyExample example);

    NtPersonnelApply selectByPrimaryKey(Integer applySeq);

    int updateByExampleSelective(@Param("record") NtPersonnelApply record, @Param("example") NtPersonnelApplyExample example);

    int updateByExample(@Param("record") NtPersonnelApply record, @Param("example") NtPersonnelApplyExample example);

    int updateByPrimaryKeySelective(NtPersonnelApply record);

    int updateByPrimaryKey(NtPersonnelApply record);
}