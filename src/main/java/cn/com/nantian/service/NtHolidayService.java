/**
 * @description: 节假日信息管理
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

    /**
     * @description: 更新时 效验是否已存在
     * @auther: Mr.Kong
     * @date: 2019/5/10 16:54
     * @param:  [ntHoliday]
     * @return: boolean
     **/
    boolean checkUpdateWhetherRepeat(NtHoliday ntHoliday);

    /**
      * @description: 创建时 效验是否已存在
      * @auther: Mr.Kong
      * @date: 2019/5/10 16:54
      * @param:  [ntHoliday]
      * @return: boolean
      **/
    boolean checkWhetherRepeat(NtHoliday ntHoliday);

    /**
      * @description: 效验传入的参数值
      * @auther: Mr.Kong
      * @date: 2019/5/10 16:54
      * @param:  [ntHoliday]
      * @return: java.lang.String
      **/
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

    /**
      * @description: 查询节假日信息列表
      * @auther: Mr.Kong
      * @date: 2019/5/10 16:55
      * @param:  [record]
      * @return: List<NtHoliday>
      **/
    List<NtHoliday> queryHolidayList(NtHoliday record);

    /**
      * @description: 根据主键ID 删除
      * @auther: Mr.Kong
      * @date: 2019/5/10 16:55
      * @param:  [holidayId]
      * @return: int
      **/
    int deleteByPrimaryKey(Integer holidayId);

    /**
      * @description: 新增
      * @auther: Mr.Kong
      * @date: 2019/5/10 16:57
      * @param:  [record]
      * @return: int
      **/
    int insert(NtHoliday record);
    /**
     * @description: 新增
     * @auther: Mr.Kong
     * @date: 2019/5/10 16:57
     * @param:  [record]
     * @return: int
     **/
    int insertSelective(NtHoliday record);
    /**
      * @description: 根据主键ID 查询单条数据详情
      * @auther: Mr.Kong
      * @date: 2019/5/10 16:58
      * @param:  [holidayId]
      * @return: NtHoliday
      **/
    NtHoliday selectByPrimaryKey(Integer holidayId);

    /**
      * @description: 更新
      * @auther: Mr.Kong
      * @date: 2019/5/10 16:59
      * @param:  [record]
      * @return: int
      **/
    int updateByPrimaryKeySelective(NtHoliday record);

    int updateByPrimaryKey(NtHoliday record);
}
