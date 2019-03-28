package cn.com.nantian.service;

import cn.com.nantian.pojo.NtProjectInfo;

import java.util.List;
import java.util.Map;
/**
 * @Description:客户管理
 * @Author：Fly
 * @Date: 2019/3/19 9:34
 * @Version：1.0
 */
public interface ProjectInfoService {

    /**
     * @Description: 查询客户信息列表
     * @Param: [example]
     * @Return: java.util.List<cn.com.nantian.pojo.NtProjectInfo>
     * @Auther: Fly
     * @Date: 2019/3/19 10:32
     **/
    public List<NtProjectInfo> selectNtProjectInfoList(NtProjectInfo ntProjectInfo);
    /**
      * @Description: 根据项目编号查询详情
      * @Auther: Mr.Kong
      * @Date: 2019/3/27 14:25
      * @Param: [projectNumber]
      * @Return: cn.com.nantian.pojo.NtProjectInfo
      **/
    NtProjectInfo selectByPrimaryKey(Integer projectNumber);
    /**
     * @Description: 设置客户类型名称 项目人数
     * @Param: [NtProjectInfoList]
     * @Return: void
     * @Auther: Fly
     * @Date: 2019/3/19 16:55
     **/
    public void setNtProjectInfoTypeName(List<NtProjectInfo> NtProjectInfoList);
    /**
     * @Description: 设置客户类型名称 项目人数
     * @Auther: Mr.Kong
     * @Date: 2019/3/27 14:38
     * @Param: [ntProjectInfo]
     * @Return: void
     **/
    public void setNtProjectInfoTypeName(NtProjectInfo ntProjectInfo);
    /**
     * @Description: 根据项目编号删除一条数据
     * @Param: [projectNumber]
     * @Return: int
     * @Auther: Fly
     * @Date: 2019/3/20 10:38
     **/
    public int deleteNtProjectInfo(int projectNumber);
    /**
     * @Description: 新增客户信息
     * @Param: [NtProjectInfo]
     * @Return: int
     * @Auther: Fly
     * @Date: 2019/3/20 13:51
     **/
    public int addNtProjectInfo(NtProjectInfo NtProjectInfo);
    /**
     * @Description: 更新客户信息
     * @Param: [NtProjectInfo]
     * @Return: int
     * @Auther: Fly
     * @Date: 2019/3/20 14:29
     **/
    public int updateNtProjectInfo(NtProjectInfo NtProjectInfo);


    /**
     * @Description: 检查客户信息属性值是否为空
     * @Auther: Mr.Kong
     * @Date: 2019/3/26 11:08
     * @Param: [ntProjectInfo] 客户信息实体
     * @Return: java.lang.String
     **/
    public String checkAttribute(NtProjectInfo ntProjectInfo);
    /**
     * @Description: 检查传入的对象所有属性值，在表中是否已存在
     * @Auther: Mr.Kong
     * @Date: 2019/3/26 10:51
     * @Param: [ntProjectInfoList, ntProjectInfo]
     * @Return: boolean false 不存在，true 存在
     **/
    public boolean checkWhetherRepeat(NtProjectInfo ntProjectInfo);

    //添加类别信息
    public  void addCustType(String projectName, Map<String ,String> type, String leave);


}
