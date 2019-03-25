package cn.com.nantian.service;

import cn.com.nantian.pojo.NtLeaveInfo;

import java.util.List;

/**
 * @Description: 单价级别信息管理
 * @Author：Fly
 * @Date: 2019/3/21 11:15
 * @Version：1.0
 */
public interface PriceLeaveService {
    /**
     * @Description: 查询单价级别列表
     * @Param: [ntLeaveInfo] 查询条件
     * @Return: java.util.List<cn.com.nantian.pojo.NtLeaveInfo>
     * @Auther: Fly
     * @Date: 2019/3/21 14:51
     **/
    List<NtLeaveInfo> selectLeaveInfoList(NtLeaveInfo ntLeaveInfo);

    /**
     * @Description: 设置客户类别、工作类别、技术等级名称
     * @Param: [ntLeaveInfoList]  单价级别集合
     * @Return: void
     * @Auther: Fly
     * @Date: 2019/3/21 15:25
     **/
    void setLeaveInfoName(List<NtLeaveInfo> ntLeaveInfoList);

    /**
     * @Description: 设置客户类别、工作类别、技术等级名称
     * @Param: [ntLeaveInfoList]  单价级别实体
     * @Return: void
     * @Auther: Fly
     * @Date: 2019/3/21 15:25
     **/
    void setLeaveInfoName(NtLeaveInfo ntLeaveInfo);

    /**
     * @Description: 删除单价级别信息
     * @Param: [ntLeaveInfo]
     * @Return: int
     * @Auther: Fly
     * @Date: 2019/3/21 16:50
     **/
    int deleteLeaveInfo(int priceId);

    /**
     * @Description: 新增单价级别信息
     * @Param: [ntLeaveInfo]
     * @Return: int
     * @Auther: Fly
     * @Date: 2019/3/21 16:54
     **/
    int addLeaveInfo(NtLeaveInfo ntLeaveInfo);

    /**
     * @Description: 更新单价级别信息
     * @Param: [ntLeaveInfo]
     * @Return: int
     * @Auther: Fly
     * @Date: 2019/3/21 16:59
     **/
    int updateLeaveInfo(NtLeaveInfo ntLeaveInfo);

    /**
     * @Description: 查询 单价级别信息
     * @Param: [ntLeaveInfo]
     * @Return: cn.com.nantian.pojo.NtLeaveInfo
     * @Auther: Fly
     * @Date: 2019/3/21 17:08
     **/
    NtLeaveInfo selectLeaveInfo(int priceId);
    /**
      * @Description: 检查是否有重复数据
      * @Param: [ntLeaveInfo]
      * @Return: boolean true 有 , false 无
      * @Auther: Fly
      * @Date: 2019/3/22 9:52
      **/
    boolean checkWhetherRepeat(NtLeaveInfo ntLeaveInfo);

}
