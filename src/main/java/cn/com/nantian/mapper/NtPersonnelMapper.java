package cn.com.nantian.mapper;

import cn.com.nantian.pojo.NtPersonnel;
import cn.com.nantian.pojo.NtPersonnelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NtPersonnelMapper {
    int countByExample(NtPersonnelExample example);

    int deleteByExample(NtPersonnelExample example);

    int deleteByPrimaryKey(Integer perId);

    int insert(NtPersonnel record);

    int insertSelective(NtPersonnel record);

    List<NtPersonnel> selectByExample(NtPersonnelExample example);

    NtPersonnel selectByPrimaryKey(Integer perId);

    int updateByExampleSelective(@Param("record") NtPersonnel record, @Param("example") NtPersonnelExample example);

    int updateByExample(@Param("record") NtPersonnel record, @Param("example") NtPersonnelExample example);

    int updateByPrimaryKeySelective(NtPersonnel record);

    int updateByPrimaryKey(NtPersonnel record);
	
	
    /**
     * 根据员工身份证号查询
     * @param idNo
     * @return
     */
    NtPersonnel selectByPrimaryIdNo(String idNo);

    /**
     * 查询员工姓名
     * @param perId
     * @return
     */
    String selectByUserId(int perId);


    /**
     * 根据部门deptId和员工name查询员工信息
     * @param deptId
     * @param name
     * @return
     */
    List<NtPersonnel> findPersonnelBydeptIdAndName(@Param("deptId") int deptId, @Param("name") String name);

    /**
     * 根据公司邮箱获取员工信息
     * @param companyEmail
     * @return
     */
    NtPersonnel selectByEmial(String companyEmail);


    /**
     * 根据手机号获取员工信息
     * @param mobileNo
     * @return
     */
    NtPersonnel selectByPrimaryMobileNo(String mobileNo);

    /**
     * 根据身份证号删除用户
     * @param idNo
     * @return
     */
    int deleteByIdNo(String idNo);

    /**
     * 根据员工姓名查询查询
     * @param name
     * @return
     */
    List<NtPersonnel>  selectByName(String name);

}