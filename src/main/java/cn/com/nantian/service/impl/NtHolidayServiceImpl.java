/**
 * @Description: 节假日信息管理
 * @ClassName: NtHolidayServiceImpl
 * @author： Mr.Kong
 * @date: 2019/5/10 14:02
 * @Version： 1.0
 */
package cn.com.nantian.service.impl;


import cn.com.nantian.common.DateUtils;
import cn.com.nantian.common.ObjectUtils;
import cn.com.nantian.common.StringUtils;
import cn.com.nantian.mapper.NtHolidayMapper;
import cn.com.nantian.pojo.NtHoliday;
import cn.com.nantian.service.NtHolidayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class NtHolidayServiceImpl implements NtHolidayService {

    @Resource
    private NtHolidayMapper holidayMapper;

    /**
     * @Description: 更新时 效验是否已存在
     * @auther: Mr.Kong
     * @date: 2019/5/10 16:54
     * @param: [ntHoliday]
     * @return: boolean
     **/
    public boolean checkUpdateWhetherRepeat(NtHoliday ntHoliday) {
        List<NtHoliday> ntHolidayList = this.queryHolidayList(null);
        boolean repeat = false;
        if (ObjectUtils.isNotNull(ntHolidayList) && ObjectUtils.isNotNull(ntHoliday)) {
            for (NtHoliday holiday : ntHolidayList) {
                if (holiday.getHolidayId() != ntHoliday.getHolidayId() && holiday.equals(ntHoliday)) {
                    repeat = true;
                    break;
                }
            }
        }
        return repeat;
    }

    /**
     * @Description: 创建时 效验是否已存在
     * @auther: Mr.Kong
     * @date: 2019/5/10 16:54
     * @param: [ntHoliday]
     * @return: boolean
     **/
    public boolean checkWhetherRepeat(NtHoliday ntHoliday) {
        List<NtHoliday> ntHolidayList = this.queryHolidayList(ntHoliday);
        boolean repeat = false;
        if (ObjectUtils.isNotNull(ntHolidayList) && ObjectUtils.isNotNull(ntHoliday)) {
            for (NtHoliday holiday : ntHolidayList) {
                if (holiday.equals(ntHoliday)) {
                    repeat = true;
                    break;
                }
            }
        }
        return repeat;
    }

    /**
     * @Description: 效验传入的参数值
     * @auther: Mr.Kong
     * @date: 2019/5/10 16:54
     * @param: [ntHoliday]
     * @return: java.lang.String
     **/
    public String checkAttribute(NtHoliday ntHoliday) throws Exception {
        if (StringUtils.isEmpty(ntHoliday.getHolidayName())) {
            return "名称 不能为空！";
        }
        if (StringUtils.isEmpty(ntHoliday.getHolidayType())) {
            return "类型 不能为空！";
        }
        if (StringUtils.isEmpty(ntHoliday.getBeginDateStr())) {
            return "开始日期 不能为空！";
        } else if (!DateUtils.checkDateReg(ntHoliday.getBeginDateStr())) {
            return "开始日期 格式不正确！";
        } else {
            ntHoliday.setBeginDate(DateUtils.parseToDate(ntHoliday.getBeginDateStr(), "yyyy-MM-dd"));
        }
        if (StringUtils.isEmpty(ntHoliday.getEndDateStr())) {
            return "结束日期 不能为空！";
        } else if (!DateUtils.checkDateReg(ntHoliday.getEndDateStr())) {
            return "开始日期 格式不正确！";
        } else {
            ntHoliday.setEndDate(DateUtils.parseToDate(ntHoliday.getEndDateStr(), "yyyy-MM-dd"));
        }
        if (ObjectUtils.isNotNull(ntHoliday.getBeginDate()) && ObjectUtils.isNotNull(ntHoliday.getEndDate())) {
            if (ntHoliday.getBeginDate().getTime() >= ntHoliday.getEndDate().getTime()) {
                return "结束日期必须大于开始日期！";
            }
        }
        return "";
    }

    @Override
    public int countByDay(Date holidayDate) {
        return holidayMapper.countByDay(holidayDate);
    }

    @Override
    public int selectByDay(Date holidayDate) {
        return holidayMapper.selectByDay(holidayDate);
    }

    /**
     * @Description: 查询节假日信息列表
     * @auther: Mr.Kong
     * @date: 2019/5/10 16:55
     * @param: [record]
     * @return: java.util.List<cn.com.nantian.pojo.NtHoliday>
     **/
    @Override
    public List<NtHoliday> queryHolidayList(NtHoliday record) {
        return holidayMapper.queryHolidayList(record);
    }

    /**
     * @Description: 根据主键ID 删除
     * @auther: Mr.Kong
     * @date: 2019/5/10 16:55
     * @param: [holidayId]
     * @return: int
     **/
    @Override
    public int deleteByPrimaryKey(Integer holidayId) {
        return holidayMapper.deleteByPrimaryKey(holidayId);
    }

    /**
     * @Description: 新增
     * @auther: Mr.Kong
     * @date: 2019/5/10 16:57
     * @param: [record]
     * @return: int
     **/
    @Override
    public int insert(NtHoliday record) {
        return holidayMapper.insert(record);
    }

    /**
     * @Description: 新增
     * @auther: Mr.Kong
     * @date: 2019/5/10 16:57
     * @param: [record]
     * @return: int
     **/
    @Override
    public int insertSelective(NtHoliday record) {
        return holidayMapper.insertSelective(record);
    }

    /**
     * @Description: 根据主键ID 查询单条数据详情
     * @auther: Mr.Kong
     * @date: 2019/5/10 16:58
     * @param: [holidayId]
     * @return: cn.com.nantian.pojo.NtHoliday
     **/
    @Override
    public NtHoliday selectByPrimaryKey(Integer holidayId) {
        return holidayMapper.selectByPrimaryKey(holidayId);
    }

    /**
     * @Description: 更新
     * @auther: Mr.Kong
     * @date: 2019/5/10 16:59
     * @param: [record]
     * @return: int
     **/
    @Override
    public int updateByPrimaryKeySelective(NtHoliday record) {
        return holidayMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(NtHoliday record) {
        return holidayMapper.updateByPrimaryKey(record);
    }
}
