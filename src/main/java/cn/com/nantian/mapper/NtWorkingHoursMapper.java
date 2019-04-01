package cn.com.nantian.mapper;

import cn.com.nantian.pojo.NtWorkingHours;
import cn.com.nantian.pojo.NtWorkingHoursExample;
import cn.com.nantian.pojo.NtWorkingHoursKey;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NtWorkingHoursMapper {
    int countByExample(NtWorkingHoursExample example);

    int deleteByExample(NtWorkingHoursExample example);

    int deleteByPrimaryKey(NtWorkingHoursKey key);

    int insert(NtWorkingHours record);

    int insertSelective(NtWorkingHours record);

    List<NtWorkingHours> selectByExample(NtWorkingHoursExample example);

    NtWorkingHours selectByPrimaryKey(NtWorkingHoursKey key);

    int updateByExampleSelective(@Param("record") NtWorkingHours record, @Param("example") NtWorkingHoursExample example);

    int updateByExample(@Param("record") NtWorkingHours record, @Param("example") NtWorkingHoursExample example);

    int updateByPrimaryKeySelective(NtWorkingHours record);

    int updateByPrimaryKey(NtWorkingHours record);

    /**
     * 插入工时数据
     * @param perId
     * @param workDate
     * @param normalHours
     * @param overtimeHours
     * @return
     */
    int insertOne(@Param("perId")int perId, @Param("workDate")Date workDate, @Param("normalHours")Float normalHours, @Param("overtimeHours")Float overtimeHours);

    /**
     * 插入工时数据(人寿)
     * @param perId
     * @param workDate
     * @param signinTime
     * @param signbackTime
     * @return
     */
    int insertOneTmpLife(@Param("perId")int perId, @Param("workDate")Date workDate, @Param("signinTime")Time signinTime, @Param("signbackTime")Time signbackTime);


    /**
     * 根据员工id和日期查询是否有该数据
     * @param perId
     * @param workDate
     * @return
     */
    NtWorkingHours selectByOne(@Param("perId")int perId,@Param("workDate")Date workDate);


    /**
     * 根据perId查询工时信息
     * @param perId
     * @return
     */
    List<NtWorkingHours> selectByPerId(int perId);
}