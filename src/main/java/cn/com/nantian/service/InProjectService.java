package cn.com.nantian.service;

import cn.com.nantian.pojo.NtPerInProject;

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

    /**
     * @Description: 更新时 效验数据是否已存在
     * @Auther: Mr.Kong
     * @Date: 2019/5/9 15:58
     * @Param: [ntPerInProject]
     * @Return: boolean
     **/
    boolean checkUpdateWhetherRepeat(NtPerInProject ntPerInProject);

    /**
      * @Description: 查询员工所在项目列表数据
      * @Auther: Mr.Kong
      * @Date: 2019/5/9 16:33
      * @Param:  [perInProject]
      * @Return: java.util.List<cn.com.nantian.pojo.NtPerInProject>
      **/
    List<NtPerInProject> queryNtPerInProjectList(NtPerInProject perInProject);

    /**
      * @Description: 查询员工所在项目详情信息
      * @Auther: Mr.Kong
      * @Date: 2019/5/9 16:34
      * @Param:  [id]
      * @Return: cn.com.nantian.pojo.NtPerInProject
      **/
    NtPerInProject queryPerInProjectInfo(int id);

    /**
      * @Description: 更新员工所在项目信息
      * @Auther: Mr.Kong
      * @Date: 2019/5/9 16:35
      * @Param:  [ntPerInProject]
      * @Return: int
      **/
    int updateNtPerInProject(NtPerInProject ntPerInProject);

    /**
     * 添加员工所在项目信息
     * @param perInProject
     * @return
     */
    int addPerInProject(NtPerInProject perInProject);

    /**
     * @Description: 设置在场状态
     * @Auther: Mr.Kong
     * @Date: 2019/5/9 16:47
     * @Param:  [ntPerInProjectList]
     * @Return: void
     **/
    public void setWorkStatus(List<NtPerInProject> ntPerInProjectList);
}
