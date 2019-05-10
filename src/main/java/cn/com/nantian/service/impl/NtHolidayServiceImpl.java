/**
 * @Description: 节假日信息管理
 * @ClassName: NtHolidayServiceImpl
 * @author： Mr.Kong
 * @date: 2019/5/10 14:02
 * @Version： 1.0
 */
package cn.com.nantian.service.impl;


import cn.com.nantian.mapper.NtHolidayMapper;
import cn.com.nantian.pojo.NtHoliday;
import cn.com.nantian.pojo.NtHolidayExample;
import cn.com.nantian.service.NtHolidayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class NtHolidayServiceImpl implements NtHolidayService {

    @Resource
    private NtHolidayMapper holidayMapper;


    @Override
    public int countByDay(Date holidayDate) {
        return holidayMapper.countByDay(holidayDate);
    }

    @Override
    public int selectByDay(Date holidayDate) {
        return holidayMapper.selectByDay(holidayDate);
    }

    @Override
    public int countByExample(NtHolidayExample example) {
        return holidayMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(NtHolidayExample example) {
        return holidayMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer holidayId) {
        return holidayMapper.deleteByPrimaryKey(holidayId);
    }

    @Override
    public int insert(NtHoliday record) {
        return holidayMapper.insert(record);
    }

    @Override
    public int insertSelective(NtHoliday record) {
        return holidayMapper.insertSelective(record);
    }

    @Override
    public List<NtHoliday> selectByExample(NtHolidayExample example) {
        return holidayMapper.selectByExample(example);
    }

    @Override
    public NtHoliday selectByPrimaryKey(Integer holidayId) {
        return holidayMapper.selectByPrimaryKey(holidayId);
    }

    @Override
    public int updateByExampleSelective(NtHoliday record, NtHolidayExample example) {
        return holidayMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(NtHoliday record, NtHolidayExample example) {
        return holidayMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(NtHoliday record) {
        return holidayMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(NtHoliday record) {
        return holidayMapper.updateByPrimaryKey(record);
    }
}
