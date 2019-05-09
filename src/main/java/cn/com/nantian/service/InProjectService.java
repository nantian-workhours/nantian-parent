package cn.com.nantian.service;

import cn.com.nantian.pojo.NtPerInProject;
import cn.com.nantian.pojo.NtProjectInfo;

import java.util.List;
/**
  * @Description: 员工所在项目管理
  * @Auther: Mr.Kong
  * @Date: 2019/5/8 16:52
  **/
public interface InProjectService {

    /**
     * @Description: 创建时 效验传入的参数值
     * @Auther: Mr.Kong
     * @Date: 2019/5/9 11:07
     * @Param:  [ntPerInProject]
     * @Return: java.lang.String
     **/
    String checkAttribute(NtPerInProject ntPerInProject) throws Exception;

    /**
      * @Description: 效验数据是否已存在
      * @Auther: Mr.Kong
      * @Date: 2019/5/9 14:28
      * @Param:  [ntPerInProject]
      * @Return: boolean
      **/
    boolean checkWhetherRepeat(NtPerInProject ntPerInProject);

    List<NtPerInProject> queryNtPerInProjectList(NtPerInProject perInProject);

    NtPerInProject queryPerInProjectInfo(int id);

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
    int updatePerInpro( NtPerInProject perInProject);



}
