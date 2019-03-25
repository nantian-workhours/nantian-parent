package cn.com.nantian.service;

import cn.com.nantian.pojo.NtPerAlias;
import cn.com.nantian.pojo.NtProjectInfo;

import java.util.List;

/**
 * 别名管理
 */
public interface ProjectNameService {

    /**
     * 添加别名
     * @param perAlias
     * @return
     */
    int addProjectName(NtPerAlias perAlias);

    /**
     * 查询别名信息
     * @param name
     * @param idNo
     * @param custType
     * @return
     */
    List<NtPerAlias> selectAllName(String name,String idNo,String custType);


    /**
     * 根据员工身份证号,别名,客户名称删除员工别名信息
     * @param idNo
     * @param inProjectName
     * @param
     * @return
     */
    int deleteOtherName(String idNo,String inProjectName);

    /**
     * 修改别名信息
     * @param perAlias
     * @return
     */
    int updateOtherName(NtPerAlias perAlias);

}
