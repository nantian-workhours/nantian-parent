package cn.com.nantian.service;

import cn.com.nantian.pojo.NtCustTypeKey;

import java.util.List;

/**
 * @Description: 客户类型管理
 * @Author：Fly
 * @Date: 2019/3/20 14:58
 * @Version：1.0
 */
public interface CustTypeService {

    /**
     * @Description: 查询客户类型集合
     * @Param: [custTypeKey]
     * @Return: java.util.List<cn.com.nantian.pojo.NtCustTypeKey>
     * @Auther: Fly
     * @Date: 2019/3/20 15:04
     **/
    public List<NtCustTypeKey> selectCustTypeList(NtCustTypeKey custTypeKey);
    /**
      * @Description: 设置客户类别、工作类别、技术等级 名称
      * @Param: [custTypeKeyList]
      * @Return: void
      * @Auther: Fly
      * @Date: 2019/3/20 15:17
      **/
    public void setCustTypeName(List<NtCustTypeKey> custTypeKeyList);

    /**
     * @Description: 设置客户类别、工作类别、技术等级 名称
     * @Param: [custTypeKey]
     * @Return: void
     * @Auther: Fly
     * @Date: 2019/3/20 17:17
     **/
    public void setCustTypeName(NtCustTypeKey custTypeKey);
    /**
      * @Description: 删除客户类别
      * @Param: [custTypeKey] 删除条件
      * @Return: int
      * @Auther: Fly
      * @Date: 2019/3/20 15:55
      **/
    public int deleteCustType(NtCustTypeKey custTypeKey);
    /**
      * @Description: 新增客户类别
      * @Param: [custTypeKey]
      * @Return: int
      * @Auther: Fly
      * @Date: 2019/3/20 16:48
      **/
    public int addCustType(NtCustTypeKey custTypeKey);

    /**
     * @Description: 更新客户类别
     * @Param: [custTypeKey]
     * @Return: int
     * @Auther: Fly
     * @Date: 2019/3/20 17:03
     **/
    int updateCustType(NtCustTypeKey custTypeKey);

    /**
     * @Description: 查询客户类型
     * @Param: [custTypeKey]
     * @Return: cn.com.nantian.pojo.NtCustTypeKey
     * @Auther: Fly
     * @Date: 2019/3/20 17:12
     **/
    NtCustTypeKey selectCustType(NtCustTypeKey custTypeKey);



}
