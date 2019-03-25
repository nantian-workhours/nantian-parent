package cn.com.nantian.mapper;

import cn.com.nantian.pojo.NtLeaveInfo;
import cn.com.nantian.pojo.NtLeaveInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NtLeaveInfoMapper {
    int countByExample(NtLeaveInfoExample example);

    int deleteByExample(NtLeaveInfoExample example);

    int insert(NtLeaveInfo record);

    int insertSelective(NtLeaveInfo record);

    List<NtLeaveInfo> selectByExample(NtLeaveInfoExample example);

    int updateByExampleSelective(@Param("record") NtLeaveInfo record, @Param("example") NtLeaveInfoExample example);

    int updateByExample(@Param("record") NtLeaveInfo record, @Param("example") NtLeaveInfoExample example);
}