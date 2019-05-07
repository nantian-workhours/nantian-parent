package cn.com.nantian.mapper;

import cn.com.nantian.pojo.NtCustTypeExample;
import cn.com.nantian.pojo.NtCustType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NtCustTypeMapper {
    /**
     * @Description: 查询客户类型集合
     * @Param: [custType]
     * @Return: java.util.List<cn.com.nantian.pojo.NtCustType>
     * @Auther: Fly
     * @Date: 2019/3/20 15:04
     **/
    List<NtCustType> selectCustTypeList(NtCustType custType);
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
    NtCustType selectCustType(int custId);

    int countByExample(NtCustTypeExample example);

    int deleteByExample(NtCustTypeExample example);

    int deleteByPrimaryKey(int custId);

    int insert(NtCustType record);

    int insertSelective(NtCustType record);

    List<NtCustType> selectByExample(NtCustTypeExample example);

    int updateByExampleSelective(@Param("record") NtCustType record, @Param("example") NtCustTypeExample example);

    int updateByExample(@Param("record") NtCustType record, @Param("example") NtCustTypeExample example);
}