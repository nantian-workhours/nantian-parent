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

    /**
     * @Description: 更新时 效验是否已存在
     * @auther: Mr.Kong
     * @date: 2019/5/10 16:54
     * @param:  [ntHoliday]
     * @return: boolean
     **/
    boolean checkUpdateWhetherRepeat(NtHoliday ntHoliday);

    /**
      * @Description: 创建时 效验是否已存在
      * @auther: Mr.Kong
      * @date: 2019/5/10 16:54
      * @param:  [ntHoliday]
      * @return: boolean
      **/
    boolean checkWhetherRepeat(NtHoliday ntHoliday);

    /**
      * @Description: 效验传入的参数值
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
      * @Description: 查询节假日信息列表
      * @auther: Mr.Kong
      * @date: 2019/5/10 16:55
      * @param:  [record]
      * @return: java.util.List<cn.com.nantian.pojo.NtHoliday>
      **/
    List<NtHoliday> queryHolidayList(NtHoliday record);

    /**
      * @Description: 根据主键ID 删除
      * @auther: Mr.Kong
      * @date: 2019/5/10 16:55
      * @param:  [holidayId]
      * @return: int
      **/
    int deleteByPrimaryKey(Integer holidayId);

    /**
      * @Description: 新增
      * @auther: Mr.Kong
      * @date: 2019/5/10 16:57
      * @param:  [record]
      * @return: int
      **/
    int insert(NtHoliday record);
    /**
     * @Description: 新增
     * @auther: Mr.Kong
     * @date: 2019/5/10 16:57
     * @param:  [record]
     * @return: int
     **/
    int insertSelective(NtHoliday record);
    /**
      * @Description: 根据主键ID 查询单条数据详情
      * @auther: Mr.Kong
      * @date: 2019/5/10 16:58
      * @param:  [holidayId]
      * @return: cn.com.nantian.pojo.NtHoliday
      **/
    NtHoliday selectByPrimaryKey(Integer holidayId);

    /**
      * @Description: 更新
      * @auther: Mr.Kong
      * @date: 2019/5/10 16:59
      * @param:  [record]
      * @return: int
      **/
    int updateByPrimaryKeySelective(NtHoliday record);

    int updateByPrimaryKey(NtHoliday record);
}
