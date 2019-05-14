package cn.com.nantian.service;

import cn.com.nantian.pojo.NtProjectInfo;

import java.util.List;
import java.util.Map;
/**
 * @description:客户管理
 * @Author：Mr.Kong
 * @date: 2019/3/19 9:34
 * @Version：1.0
 */
public interface ProjectInfoService {

    /**
     * @description: 查询客户信息列表
     * @Param: [example]
     * @return: List<NtProjectInfo>
     * @auther: Mr.Kong
     * @date: 2019/3/19 10:32
     **/
    public List<NtProjectInfo> selectNtProjectInfoList(NtProjectInfo ntProjectInfo);
    /**
      * @description: 根据项目编号查询详情
      * @auther: Mr.Kong
      * @date: 2019/3/27 14:25
      * @Param: [projectNumber]
      * @return: NtProjectInfo
      **/
    NtProjectInfo selectByPrimaryKey(Integer projectNumber);
    /**
     * @description: 设置客户类型名称 项目人数
     * @Param: [NtProjectInfoList]
     * @return: void
     * @auther: Mr.Kong
     * @date: 2019/3/19 16:55
     **/
    public void setNtProjectInfoTypeName(List<NtProjectInfo> NtProjectInfoList);
    /**
     * @description: 设置客户类型名称 项目人数
     * @auther: Mr.Kong
     * @date: 2019/3/27 14:38
     * @Param: [ntProjectInfo]
     * @return: void
     **/
    public void setNtProjectInfoTypeName(NtProjectInfo ntProjectInfo);
    /**
     * @description: 根据项目编号删除一条数据
     * @Param: [projectNumber]
     * @return: int
     * @auther: Mr.Kong
     * @date: 2019/3/20 10:38
     **/
    public int deleteNtProjectInfo(int projectNumber);
    /**
     * @description: 新增客户信息
     * @Param: [NtProjectInfo]
     * @return: int
     * @auther: Mr.Kong
     * @date: 2019/3/20 13:51
     **/
    public int addNtProjectInfo(NtProjectInfo NtProjectInfo);
    /**
     * @description: 更新客户信息
     * @Param: [NtProjectInfo]
     * @return: int
     * @auther: Mr.Kong
     * @date: 2019/3/20 14:29
     **/
    public int updateNtProjectInfo(NtProjectInfo NtProjectInfo);


    /**
     * @description: 检查客户信息属性值是否为空
     * @auther: Mr.Kong
     * @date: 2019/3/26 11:08
     * @Param: [ntProjectInfo] 客户信息实体
     * @return: java.lang.String
     **/
    public String checkAttribute(NtProjectInfo ntProjectInfo);
    /**
     * @description: 检查传入的对象所有属性值，在表中是否已存在
     * @auther: Mr.Kong
     * @date: 2019/3/26 10:51
     * @Param: [ntProjectInfoList, ntProjectInfo]
     * @return: boolean false 不存在，true 存在
     **/
    public boolean checkWhetherRepeat(NtProjectInfo ntProjectInfo);

    /**
     * @description: 更新时 检查传入的对象所有属性值，在表中是否已存在
     * @auther: Mr.Kong
     * @date: 2019/5/8 10:18
     * @Param:  [ntProjectInfo]
     * @return: boolean
     **/
    public boolean checkUpdateWhetherRepeat(NtProjectInfo ntProjectInfo);

    //添加类别信息
    public  void addCustType(String projectName, Map<String ,String> type, String leave);


}
