package cn.com.nantian.mapper;

import cn.com.nantian.pojo.NtLeaveInfo;
import cn.com.nantian.pojo.NtLeaveInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NtLeaveInfoMapper {
    /**
     * @Description: 查询单价级别列表
     * @Param: [ntLeaveInfo] 查询条件
     * @Return: java.util.List<cn.com.nantian.pojo.NtLeaveInfo>
     * @Auther: Mr.Kong
     * @Date: 2019/3/21 14:51
     **/
    List<NtLeaveInfo> selectLeaveInfoList(NtLeaveInfo ntLeaveInfo);
    /**
     * @Description: 删除单价级别信息
     * @Param: [priceId]
     * @Return: int
     * @Auther: Mr.Kong
     * @Date: 2019/3/21 16:49
     **/
    int deleteByPrimaryKey(int priceId);
    /**
     * @Description: 查询 单价级别信息
     * @Param: [ntLeaveInfo]
     * @Return: cn.com.nantian.pojo.NtLeaveInfo
     * @Auther: Mr.Kong
     * @Date: 2019/3/21 17:08
     **/
    NtLeaveInfo selectLeaveInfo(int priceId);
    int countByExample(NtLeaveInfoExample example);

    int deleteByExample(NtLeaveInfoExample example);

    int insert(NtLeaveInfo record);

    int insertSelective(NtLeaveInfo record);

    List<NtLeaveInfo> selectByExample(NtLeaveInfoExample example);

    int updateByExampleSelective(NtLeaveInfo ntLeaveInfo);

    int updateByExample(@Param("record") NtLeaveInfo record, @Param("example") NtLeaveInfoExample example);
}