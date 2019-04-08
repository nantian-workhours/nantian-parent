package cn.com.nantian.service;

import cn.com.nantian.pojo.InProjectItem;
import cn.com.nantian.pojo.NtPerInProject;
import cn.com.nantian.pojo.NtPersonnel;
import cn.com.nantian.pojo.NtProjectInfo;

import java.util.List;

/**
     * 员工所在项目管理
     * Created by ydz on 2019/3/18
     */


    public interface InProjectService {

    /**
     * 添加员工所在项目信息
     * @param perInProject
     * @return
     */
    int addPerInProject(NtPerInProject perInProject);

    /**
     * 查询所有的客户信息
     * @return
     */
    List<NtProjectInfo> selectAllProject();


    /**
     * 根据客户类别,项目名称,员工姓名查询员工所在项目信息
     * @param custType
     * @param projectName
     * @param perId
     * @return
     */
    List<InProjectItem> selectPerInProject2(String custType, String projectName, int perId);

    List<NtPersonnel> select2(String name);

    /**
     * 修改员工所在项目
     * @param perInProject
     * @return
     */
    int updatePerInpro( NtPerInProject perInProject);



}
