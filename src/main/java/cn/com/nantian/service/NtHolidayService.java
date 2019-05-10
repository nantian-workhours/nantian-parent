/**
 * @Description: 节假日信息管理
 * @ClassName: NtHolidayService
 * @author： Mr.Kong
 * @date: 2019/5/10 14:01
 * @Version： 1.0
 */
package cn.com.nantian.service;

import cn.com.nantian.pojo.NtHoliday;

import java.util.Date;
import java.util.List;


public interface NtHolidayService {

    boolean checkUpdateWhetherRepeat(NtHoliday ntHoliday);

    boolean checkWhetherRepeat(NtHoliday ntHoliday);

    String checkAttribute(NtHoliday ntHoliday) throws Exception;

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

    List<NtHoliday> queryHolidayList(NtHoliday record);

    int deleteByPrimaryKey(Integer holidayId);

    int insert(NtHoliday record);

    int insertSelective(NtHoliday record);

    NtHoliday selectByPrimaryKey(Integer holidayId);

    int updateByPrimaryKeySelective(NtHoliday record);

    int updateByPrimaryKey(NtHoliday record);
}
