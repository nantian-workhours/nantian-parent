package cn.com.nantian.mapper;

import cn.com.nantian.pojo.PersonnelItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 员工客户信息内容
 * */
public interface PersonnelItemMapper {

    /**
     * 根据部门id和员工姓名信息查询
     * @param deptId
     * @param name
     * @return
     */
    List<PersonnelItem> selectPersonnel(@Param("deptId")int deptId, @Param("name")String name);

}
