package cn.com.nantian.mapper;

import cn.com.nantian.pojo.NtCustTypeExample;
import cn.com.nantian.pojo.NtCustType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NtCustTypeMapper {
    /**
     * @description: 查询客户类型集合
     * @Param: [custType]
     * @return: List<NtCustType>
     * @auther: Mr.Wind
     * @date: 2019/3/20 15:04
     **/
    List<NtCustType> selectCustTypeList(NtCustType custType);
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

    int countByExample(NtCustTypeExample example);

    int deleteByExample(NtCustTypeExample example);

    int deleteByPrimaryKey(int custId);

    int insert(NtCustType record);

    int insertSelective(NtCustType record);

    List<NtCustType> selectByExample(NtCustTypeExample example);

    int updateByExampleSelective(@Param("record") NtCustType record, @Param("example") NtCustTypeExample example);

    int updateByExample(@Param("record") NtCustType record, @Param("example") NtCustTypeExample example);
}