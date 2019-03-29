/**
 * @Description: 年假信息管理
 * @ClassName: HolInfoServiceImpl
 * @Author： Mr.Kong
 * @Date: 2019/3/29 16:05
 * @Version： 1.0
 */
package cn.com.nantian.mapper;

import cn.com.nantian.pojo.NtHolInfo;

import java.util.List;

public interface NtHolInfoMapper {

    /**
     * @Description: 查询年假信息列表
     * @Auther: Mr.Kong
     * @Date: 2019/3/29 16:40
     * @Param: [ntHolInfo]
     * @Return: java.util.List<cn.com.nantian.pojo.NtHolInfo>
     **/
    List<NtHolInfo> selectHolInfoList(NtHolInfo ntHolInfo);

    int deleteByPrimaryKey(Integer perId);

    int insert(NtHolInfo record);

    int insertSelective(NtHolInfo record);

    NtHolInfo selectByPrimaryKey(Integer perId);

    int updateByPrimaryKeySelective(NtHolInfo record);

    int updateByPrimaryKey(NtHolInfo record);
}