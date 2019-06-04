package cn.com.nantian.service;

import cn.com.nantian.pojo.NtCustType;

import java.util.List;

/**
 * @description: 客户类型管理
 * @Author：Mr.Wind
 * @date: 2019/3/20 14:58
 * @Version：1.0
 */
public interface CustTypeService {

    /**
     * @description: 查询客户类型集合
     * @Param: [custType]
     * @return: List<NtCustType>
     * @auther: Mr.Wind
     * @date: 2019/3/20 15:04
     **/
    public List<NtCustType> selectCustTypeList(NtCustType custType);

    /**
     * @description: 设置客户类别、工作类别、技术等级 名称
     * @Param: [custTypeList]
     * @return: void
     * @auther: Mr.Wind
     * @date: 2019/3/20 15:17
     **/
    public void setCustTypeName(List<NtCustType> custTypeList);

    /**
     * @description: 设置客户类别、工作类别、技术等级 名称
     * @Param: [custType]
     * @return: void
     * @auther: Mr.Wind
     * @date: 2019/3/20 17:17
     **/
    public void setCustTypeName(NtCustType custType);

    /**
     * @description: 删除客户类别
     * @Param: [custType] 删除条件
     * @return: int
     * @auther: Mr.Wind
     * @date: 2019/3/20 15:55
     **/
    public int deleteCustType(int custType);

    /**
     * @description: 新增客户类别
     * @Param: [custType]
     * @return: int
     * @auther: Mr.Wind
     * @date: 2019/3/20 16:48
     **/
    public int addCustType(NtCustType custType);

    /**
     * @description: 更新客户类别
     * @Param: [custType]
     * @return: int
     * @auther: Mr.Wind
     * @date: 2019/3/20 17:03
     **/
    int updateCustType(NtCustType custType);

    /**
     * @description: 查询客户类型
     * @Param: [custType]
     * @return: NtCustType
     * @auther: Mr.Wind
     * @date: 2019/3/20 17:12
     **/
    NtCustType selectCustType(int custId);

    /**
     * @description: 检查客户类别属性值是否为空
     * @auther: Mr.Wind
     * @date: 2019/3/26 14:19
     * @Param: [NtCustType]
     * @return: java.lang.String
     **/
    public String checkAttribute(NtCustType NtCustType);

    /**
     * @description: 检查传入的对象所有属性值，在表中是否已存在
     * @auther: Mr.Wind
     * @date: 2019/3/26 14:20
     * @Param: [NtCustType]
     * @return: boolean false 不存在，true 存在
     **/
    public boolean checkWhetherRepeat(NtCustType NtCustType);

    /**
     * @description: 更新 检查传入的对象所有属性值，在表中是否已存在
     * @auther: Mr.Wind
     * @date: 2019/5/7 11:28
     * @Param:  [ntCustType]
     * @return: boolean
     **/
    public boolean checkUpdateWhetherRepeat(NtCustType ntCustType);
}
