package cn.com.nantian.service;

import cn.com.nantian.pojo.NtPerInProject;

import java.util.List;
import java.util.Map;

/**
  * @description: 员工所在项目管理
  * @auther: Mr.Wind
  * @date: 2019/5/8 16:52
  **/
public interface InProjectService {

    public Map<String,Object> getStatisticsUserNum(NtPerInProject perInProject);

    List<NtPerInProject> queryStatisticsUserNum(NtPerInProject perInProject);

    /**
     * @description: 根据客户分类 统计员人数
     * @auther: Mr.Wind
     * @date: 2019/6/8 15:31
     * @param:  [perInProject]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     **/
    Map<String,Object> getStatisticsNumByCustType(NtPerInProject perInProject);

    List<NtPerInProject> queryStatisticsNumByCustType(NtPerInProject perInProject);

    /**
     * @description: 创建时 效验传入的参数值
     * @auther: Mr.Wind
     * @date: 2019/5/9 11:07
     * @Param:  [ntPerInProject]
     * @return: java.lang.String
     **/
    String checkAttribute(NtPerInProject ntPerInProject) throws Exception;

    /**
      * @description: 效验数据是否已存在
      * @auther: Mr.Wind
      * @date: 2019/5/9 14:28
      * @Param:  [ntPerInProject]
      * @return: boolean
      **/
    boolean checkWhetherRepeat(NtPerInProject ntPerInProject);

    /**
     * @description: 更新时 效验数据是否已存在
     * @auther: Mr.Wind
     * @date: 2019/5/9 15:58
     * @Param: [ntPerInProject]
     * @return: boolean
     **/
    boolean checkUpdateWhetherRepeat(NtPerInProject ntPerInProject);

    /**
      * @description: 查询员工所在项目列表数据
      * @auther: Mr.Wind
      * @date: 2019/5/9 16:33
      * @Param:  [perInProject]
      * @return: List<NtPerInProject>
      **/
    List<NtPerInProject> queryNtPerInProjectList(NtPerInProject perInProject);

    /**
      * @description: 查询员工所在项目详情信息
      * @auther: Mr.Wind
      * @date: 2019/5/9 16:34
      * @Param:  [id]
      * @return: NtPerInProject
      **/
    NtPerInProject queryPerInProjectInfo(int id);

    /**
      * @description: 更新员工所在项目信息
      * @auther: Mr.Wind
      * @date: 2019/5/9 16:35
      * @Param:  [ntPerInProject]
      * @return: int
      **/
    int updateNtPerInProject(NtPerInProject ntPerInProject);

    /**
     * 添加员工所在项目信息
     * @param perInProject
     * @return
     */
    int addPerInProject(NtPerInProject perInProject);

    /**
     * @description: 设置在场状态
     * @auther: Mr.Wind
     * @date: 2019/5/9 16:47
     * @Param:  [ntPerInProjectList]
     * @return: void
     **/
    public void setWorkStatus(List<NtPerInProject> ntPerInProjectList);
}
