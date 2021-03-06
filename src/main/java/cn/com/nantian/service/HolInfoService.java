/**
 * @description: 年假信息管理
 * @ClassName: HolInfoServiceImpl
 * @Author： Mr.Wind
 * @date: 2019/3/29 16:05
 * @Version： 1.0
 */
package cn.com.nantian.service;

import cn.com.nantian.pojo.NtHolInfo;

import java.util.List;

public interface HolInfoService {

    /**
     * @description: 查询年假信息列表
     * @auther: Mr.Wind
     * @date: 2019/3/29 16:40
     * @Param: [ntHolInfo]
     * @return: List<NtHolInfo>
     **/
    List<NtHolInfo> selectHolInfoList(NtHolInfo ntHolInfo);

    int deleteByPrimaryKey(Integer perId);

    int insert(NtHolInfo record);

    int insertSelective(NtHolInfo record);

    NtHolInfo selectByPrimaryKey(Integer perId);

    int updateByPrimaryKeySelective(NtHolInfo record);

    int updateByPrimaryKey(NtHolInfo record);
}
