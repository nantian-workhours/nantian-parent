package cn.com.nantian.mapper;

import cn.com.nantian.pojo.NtLeave;
import cn.com.nantian.pojo.NtLeaveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NtLeaveMapper {
    int countByExample(NtLeaveExample example);

    int deleteByExample(NtLeaveExample example);

    int insert(NtLeave record);

    int insertSelective(NtLeave record);

    List<NtLeave> selectByExample(NtLeaveExample example);

    int updateByExampleSelective(@Param("record") NtLeave record, @Param("example") NtLeaveExample example);

    int updateByExample(@Param("record") NtLeave record, @Param("example") NtLeaveExample example);
}