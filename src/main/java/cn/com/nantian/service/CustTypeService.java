package cn.com.nantian.service;

import cn.com.nantian.pojo.NtCustType;

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
     * @Param: [custType]
     * @Return: java.util.List<cn.com.nantian.pojo.NtCustType>
     * @Auther: Fly
     * @Date: 2019/3/20 15:04
     **/
    public List<NtCustType> selectCustTypeList(NtCustType custType);

    /**
     * @Description: 设置客户类别、工作类别、技术等级 名称
     * @Param: [custTypeList]
     * @Return: void
     * @Auther: Fly
     * @Date: 2019/3/20 15:17
     **/
    public void setCustTypeName(List<NtCustType> custTypeList);

    /**
     * @Description: 设置客户类别、工作类别、技术等级 名称
     * @Param: [custType]
     * @Return: void
     * @Auther: Fly
     * @Date: 2019/3/20 17:17
     **/
    public void setCustTypeName(NtCustType custType);

    /**
     * @Description: 删除客户类别
     * @Param: [custType] 删除条件
     * @Return: int
     * @Auther: Fly
     * @Date: 2019/3/20 15:55
     **/
    public int deleteCustType(NtCustType custType);

    /**
     * @Description: 新增客户类别
     * @Param: [custType]
     * @Return: int
     * @Auther: Fly
     * @Date: 2019/3/20 16:48
     **/
    public int addCustType(NtCustType custType);

    /**
     * @Description: 更新客户类别
     * @Param: [custType]
     * @Return: int
     * @Auther: Fly
     * @Date: 2019/3/20 17:03
     **/
    int updateCustType(NtCustType custType);

    /**
     * @Description: 查询客户类型
     * @Param: [custType]
     * @Return: cn.com.nantian.pojo.NtCustType
     * @Auther: Fly
     * @Date: 2019/3/20 17:12
     **/
    NtCustType selectCustType(NtCustType custType);

    /**
     * @Description: 检查客户类别属性值是否为空
     * @Auther: Mr.Kong
     * @Date: 2019/3/26 14:19
     * @Param: [NtCustType]
     * @Return: java.lang.String
     **/
    public String checkAttribute(NtCustType NtCustType);

    /**
     * @Description: 检查传入的对象所有属性值，在表中是否已存在
     * @Auther: Mr.Kong
     * @Date: 2019/3/26 14:20
     * @Param: [NtCustType]
     * @Return: boolean false 不存在，true 存在
     **/
    public boolean checkWhetherRepeat(NtCustType NtCustType);

    /**
     * @Description: 更新 检查传入的对象所有属性值，在表中是否已存在
     * @Auther: Mr.Kong
     * @Date: 2019/5/7 11:28
     * @Param:  [ntCustType]
     * @Return: boolean
     **/
    public boolean checkUpdateWhetherRepeat(NtCustType ntCustType);
}
