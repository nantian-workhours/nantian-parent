package cn.com.nantian.mapper;

import cn.com.nantian.pojo.NtHolidayDefine;
import cn.com.nantian.pojo.NtHolidayDefineExample;

import java.util.Date;
import java.util.List;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.apache.ibatis.annotations.Param;

public interface NtHolidayDefineMapper {
     int countByExample(NtHolidayDefineExample example);

    int deleteByExample(NtHolidayDefineExample example);

    int deleteByPrimaryKey(Integer holidayId);

    int insert(NtHolidayDefine record);

    int insertSelective(NtHolidayDefine record);

    List<NtHolidayDefine> selectByExample(NtHolidayDefineExample example);

    NtHolidayDefine selectByPrimaryKey(Integer holidayId);

    int updateByExampleSelective(@Param("record") NtHolidayDefine record, @Param("example") NtHolidayDefineExample example);

    int updateByExample(@Param("record") NtHolidayDefine record, @Param("example") NtHolidayDefineExample example);

    int updateByPrimaryKeySelective(NtHolidayDefine record);

    int updateByPrimaryKey(NtHolidayDefine record);

    /**
     *
     * @param holidayDate
     * @return
     */
    int countByDay(Date holidayDate);

}