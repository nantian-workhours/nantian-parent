/**
 * @Description: 节假日信息管理
 * @ClassName: NtHolidayService
 * @author： Mr.Kong
 * @date: 2019/5/10 14:01
 * @Version： 1.0
 */
package cn.com.nantian.service;

import cn.com.nantian.pojo.NtHoliday;
import cn.com.nantian.pojo.NtHolidayExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


public interface NtHolidayService {

    int countByExample(NtHolidayExample example);

    int deleteByExample(NtHolidayExample example);

    int deleteByPrimaryKey(Integer holidayId);

    int insert(NtHoliday record);

    int insertSelective(NtHoliday record);

    List<NtHoliday> selectByExample(NtHolidayExample example);

    NtHoliday selectByPrimaryKey(Integer holidayId);

    int updateByExampleSelective(@Param("record") NtHoliday record, @Param("example") NtHolidayExample example);

    int updateByExample(@Param("record") NtHoliday record, @Param("example") NtHolidayExample example);

    int updateByPrimaryKeySelective(NtHoliday record);

    int updateByPrimaryKey(NtHoliday record);

    /**
     *查询该日期是否是节假日
     * @param holidayDate
     * @return
     */
    int countByDay(Date holidayDate);

    /**
     * 查询该周末是否是工作日
     * @param holidayDate
     * @return
     */
    int  selectByDay(Date holidayDate);
}
