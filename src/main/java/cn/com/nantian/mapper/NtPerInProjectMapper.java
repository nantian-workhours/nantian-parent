package cn.com.nantian.mapper;

import cn.com.nantian.pojo.NtPerInProject;
import cn.com.nantian.pojo.NtPerInProjectExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NtPerInProjectMapper {

    /**
     * @Description: 查询员工项目集合
     * @Param: [perInProject]
     * @Return: java.util.List<cn.com.nantian.pojo.NtPerInProject>
     * @Auther: Fly
     * @Date: 2019/3/20 10:16
     **/
    List<NtPerInProject> selectPerInProjectList(NtPerInProject perInProject);
    int countByExample(NtPerInProjectExample example);

    int deleteByExample(NtPerInProjectExample example);

    int insert(NtPerInProject record);

    int insertSelective(NtPerInProject record);

    List<NtPerInProject> selectByExample(NtPerInProjectExample example);

    int updateByExampleSelective(@Param("record") NtPerInProject record, @Param("example") NtPerInProjectExample example);

    int updateByExample(@Param("record") NtPerInProject record, @Param("example") NtPerInProjectExample example);


    /**
     * 根据部门编号和身份证号查询
     * @param projectNumber
     * @param idNo
     * @return
     */
    List<NtPerInProject> selectByIdNoAndproNum(int projectNumber, String idNo);

    List<NtPerInProject> selectByIdNo(String idNo);

    List<NtPerInProject> selectByProNum(int projectNumber);

}