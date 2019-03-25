package cn.com.nantian.mapper;

import cn.com.nantian.pojo.NtCustTypeExample;
import cn.com.nantian.pojo.NtCustTypeKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NtCustTypeMapper {
    /**
     * @Description: 查询客户类型集合
     * @Param: [custTypeKey]
     * @Return: java.util.List<cn.com.nantian.pojo.NtCustTypeKey>
     * @Auther: Fly
     * @Date: 2019/3/20 15:04
     **/
    List<NtCustTypeKey> selectCustTypeList(NtCustTypeKey custTypeKey);
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

    int countByExample(NtCustTypeExample example);

    int deleteByExample(NtCustTypeExample example);

    int deleteByPrimaryKey(NtCustTypeKey key);

    //int addCustType(NtCustTypeKey key);

    int insert(NtCustTypeKey record);

    int insertSelective(NtCustTypeKey record);

    List<NtCustTypeKey> selectByExample(NtCustTypeExample example);

    int updateByExampleSelective(@Param("record") NtCustTypeKey record, @Param("example") NtCustTypeExample example);

    int updateByExample(@Param("record") NtCustTypeKey record, @Param("example") NtCustTypeExample example);
}