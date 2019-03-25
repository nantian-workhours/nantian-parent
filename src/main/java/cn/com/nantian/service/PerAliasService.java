package cn.com.nantian.service;

import cn.com.nantian.pojo.NtPerAlias;

import java.util.List;

/**
 * 别名管理接口
 */

public interface PerAliasService {

    /**
     * 根据员工编号查询用户别名
     * @param perId
     * @return
     */
    List<NtPerAlias> selectByPerId(int perId);

    /**
     * 根据员工姓名查询用户别名
     * @param name
     * @return
     */
    List<NtPerAlias> selectByName(String name);

}
