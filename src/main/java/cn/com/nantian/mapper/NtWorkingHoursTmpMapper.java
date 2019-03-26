package cn.com.nantian.mapper;

import cn.com.nantian.pojo.NtWorkingHoursTmp;
import cn.com.nantian.pojo.NtWorkingHoursTmpExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NtWorkingHoursTmpMapper {
    int countByExample(NtWorkingHoursTmpExample example);

    int deleteByExample(NtWorkingHoursTmpExample example);

    int insert(NtWorkingHoursTmp record);

    int insertSelective(NtWorkingHoursTmp record);

    List<NtWorkingHoursTmp> selectByExample(NtWorkingHoursTmpExample example);

    int updateByExampleSelective(@Param("record") NtWorkingHoursTmp record, @Param("example") NtWorkingHoursTmpExample example);

    int updateByExample(@Param("record") NtWorkingHoursTmp record, @Param("example") NtWorkingHoursTmpExample example);
    /**
     * 插入工时数据
     * @param perId
     * @param workDate
     * @param normalHours
     * @param overtimeHours
     * @return
     */
    int insertOneTmp(@Param("perId")int perId, @Param("workDate")Date workDate, @Param("normalHours")Float normalHours, @Param("overtimeHours")Float overtimeHours);

}