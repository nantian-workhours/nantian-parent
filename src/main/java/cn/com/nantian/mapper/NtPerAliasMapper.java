package cn.com.nantian.mapper;

import cn.com.nantian.pojo.NtPerAlias;
import cn.com.nantian.pojo.NtPerAliasExample;
import java.util.List;

import cn.com.nantian.pojo.entity.ProList;
import org.apache.ibatis.annotations.Param;

public interface NtPerAliasMapper {

    /**
      * @description: 更新员工别名
      * @auther: Mr.Wind
      * @date: 2019/5/8 15:53
      * @Param:  [ntPerAlias]
      * @return: int
      **/
    int updateNtPerAlias(NtPerAlias ntPerAlias);

    /**
      * @description: 查询员工项目别名列表数据
      * @auther: Mr.Wind
      * @date: 2019/5/8 14:24
      * @Param:  []
      * @return: List<NtPerAlias>
      **/
    List<NtPerAlias> queryNtPerAliasList(NtPerAlias ntPerAlias);

    /**
     * 根据员工编号查询别名表信息
     * @param perId
     * @return
     */
    List<NtPerAlias> selectByPerId(int perId);
    /**
     * 根据员工编号查询别名表信息
     * @param name
     * @return
     */
    List<NtPerAlias> selectByName(String name);


    /**
     * 根据身份证号删除别名信息
     * @param idNo
     * @return int
     */
     int deleteByIdNo(String idNo);

    /**
     * 根据身份证号和别名去查询条数
     * @param perId
     * @param inProjectName
     * @return
     */
      int  selectByPerIdAndName(@Param("perId")int perId,@Param("inProjectName")String inProjectName);

    /**
     * 根据姓名/身份证号查询别名列表
     * @param inCompanyName
     * @param idNo

     * @return
     */
    List<NtPerAlias> selectByNameOrIdNo(@Param("inCompanyName")String inCompanyName,@Param("idNo")String idNo);

    /**
     * 根据项目编号查询别名信息
     * @return
     */
    List<NtPerAlias> selectByProjectNum(int projectNumber);

    /**
     * 修改别名表
     * @param idNo
     * @param inProjectNumber
     * @return
     */
    int updateByIdNoAndProjectNum(@Param("idNo")String idNo,@Param("inProjectName")int inProjectNumber);

    /**
     * /根据客户类别查询项目编号
     * @param projectNumber
     * @param inProjectName
     * @return
     */
    NtPerAlias selectByInProNameAndPronum(@Param("projectNumber")int projectNumber,@Param("inProjectName")String inProjectName);

    List<NtPerAlias> selectByNumList(@Param("projectNumberArr")Integer[] projectNumberArr);

    List<NtPerAlias>   selectByAliasList(ProList aliasList);

    int countByExample(NtPerAliasExample example);

    int deleteByExample(NtPerAliasExample example);

    int insert(NtPerAlias record);

    int insertSelective(NtPerAlias record);

    List<NtPerAlias> selectByExample(NtPerAliasExample example);

    int updateByExampleSelective(@Param("record") NtPerAlias record, @Param("example") NtPerAliasExample example);

    int updateByExample(@Param("record") NtPerAlias record, @Param("example") NtPerAliasExample example);
}