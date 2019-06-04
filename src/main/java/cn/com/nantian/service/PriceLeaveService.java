package cn.com.nantian.service;

import cn.com.nantian.pojo.NtLeaveInfo;
import cn.com.nantian.pojo.NtProjectInfo;

import java.util.List;
import java.util.Map;

/**
 * @description: 单价级别信息管理
 * @Author：Mr.Wind
 * @date: 2019/3/21 11:15
 * @Version：1.0
 */
public interface PriceLeaveService {

    /**
     * @description: 检查传入属性值是否为空
     * @auther: Mr.Wind
     * @date: 2019/5/7 15:04
     * @Param:  [leaveInfo]
     * @return: java.lang.String
     **/
    public String checkAttribute(NtLeaveInfo leaveInfo) throws Exception;
    /**
     * @description: 查询单价级别列表
     * @Param: [ntLeaveInfo] 查询条件
     * @return: List<NtLeaveInfo>
     * @auther: Mr.Wind
     * @date: 2019/3/21 14:51
     **/
    List<NtLeaveInfo> selectLeaveInfoList(NtLeaveInfo ntLeaveInfo) throws Exception;

    /**
     * @description: 设置客户类别、工作类别、技术等级名称
     * @Param: [ntLeaveInfoList]  单价级别集合
     * @return: void
     * @auther: Mr.Wind
     * @date: 2019/3/21 15:25
     **/
    void setLeaveInfoName(List<NtLeaveInfo> ntLeaveInfoList);

    /**
     * @description: 设置客户类别、工作类别、技术等级名称
     * @Param: [ntLeaveInfoList]  单价级别实体
     * @return: void
     * @auther: Mr.Wind
     * @date: 2019/3/21 15:25
     **/
    void setLeaveInfoName(NtLeaveInfo ntLeaveInfo);

    /**
     * @description: 删除单价级别信息
     * @Param: [ntLeaveInfo]
     * @return: int
     * @auther: Mr.Wind
     * @date: 2019/3/21 16:50
     **/
    int deleteLeaveInfo(int priceId);

    /**
     * @description: 新增单价级别信息
     * @Param: [ntLeaveInfo]
     * @return: int
     * @auther: Mr.Wind
     * @date: 2019/3/21 16:54
     **/
    int addLeaveInfo(NtLeaveInfo ntLeaveInfo) throws Exception;

    /**
     * @description: 更新单价级别信息
     * @Param: [ntLeaveInfo]
     * @return: int
     * @auther: Mr.Wind
     * @date: 2019/3/21 16:59
     **/
    int updateLeaveInfo(NtLeaveInfo ntLeaveInfo) throws Exception;

    /**
     * @description: 查询 单价级别信息
     * @Param: [ntLeaveInfo]
     * @return: NtLeaveInfo
     * @auther: Mr.Wind
     * @date: 2019/3/21 17:08
     **/
    NtLeaveInfo selectLeaveInfo(int priceId);
    /**
      * @description: 检查是否有重复数据
      * @Param: [ntLeaveInfo]
      * @return: boolean true 有 , false 无
      * @auther: Mr.Wind
      * @date: 2019/3/22 9:52
      **/
    boolean checkWhetherRepeat(NtLeaveInfo ntLeaveInfo) throws Exception;

    /**
     * @description: 更新时 检查是否有重复数据
     * @auther: Mr.Wind
     * @date: 2019/5/7 15:10
     * @Param:  [ntLeaveInfo]
     * @return: boolean
     **/
    public boolean checkUpdateWhetherRepeat(NtLeaveInfo ntLeaveInfo) throws Exception;

    /**
     * @description:客户管理
     * @Author：Mr.Wind
     * @date: 2019/3/19 9:34
     * @Version：1.0
     */
    interface ProjectInfoService {

        /**
         * @description: 查询客户信息列表
         * @Param: [example]
         * @return: List<NtProjectInfo>
         * @auther: Mr.Wind
         * @date: 2019/3/19 10:32
         **/
        public List<NtProjectInfo> selectPerInProjectList(NtProjectInfo NtProjectInfo);
        /**
         * @description: 设置客户类型名称 项目人数
         * @Param: [NtProjectInfoList]
         * @return: void
         * @auther: Mr.Wind
         * @date: 2019/3/19 16:55
         **/
        public void setNtProjectInfoTypeName(List<NtProjectInfo> NtProjectInfoList);
        /**
         * @description: 根据项目编号删除一条数据
         * @Param: [projectNumber]
         * @return: int
         * @auther: Mr.Wind
         * @date: 2019/3/20 10:38
         **/
        public int deleteNtProjectInfo(int projectNumber);
        /**
         * @description: 新增客户信息
         * @Param: [NtProjectInfo]
         * @return: int
         * @auther: Mr.Wind
         * @date: 2019/3/20 13:51
         **/
        public int addNtProjectInfo(NtProjectInfo NtProjectInfo);
        /**
         * @description: 更新客户信息
         * @Param: [NtProjectInfo]
         * @return: int
         * @auther: Mr.Wind
         * @date: 2019/3/20 14:29
         **/
        public int updateNtProjectInfo(NtProjectInfo NtProjectInfo);

        //添加类别信息
        public  void addCustType(String projectName, Map<String, String> type, String leave);


    }
}
