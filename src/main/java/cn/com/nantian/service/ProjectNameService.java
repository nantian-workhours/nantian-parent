package cn.com.nantian.service;

import cn.com.nantian.pojo.NtPerAlias;
import cn.com.nantian.pojo.NtProjectInfo;

import java.util.List;

/**
 * 别名管理
 */
public interface ProjectNameService {

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
     * 添加别名
     * @param perAlias
     * @return
     */
    int addProjectName(NtPerAlias perAlias);

    /**
     * 根据员工身份证号删除员工别名信息
     * @param idNo
     * @return int
     */
    int deleteByIdNo(String idNo);

    /**
     * @description: 效验传入的参数值是否为空
     * @auther: Mr.Wind
     * @date: 2019/5/8 11:00
     * @Param:  [ntPerAlias]
     * @return: java.lang.String
     **/
    public String checkAttribute(NtPerAlias ntPerAlias);
    /**
     * @description: 效验数据是否已存在
     * @auther: Mr.Wind
     * @date: 2019/5/8 14:28
     * @Param:  [ntPerAlias]
     * @return: boolean
     **/
    public boolean checkWhetherRepeat(NtPerAlias ntPerAlias);
    /**
     * @description: 更新时 效验数据是否已存在
     * @auther: Mr.Wind
     * @date: 2019/5/8 16:01
     * @Param:  [ntPerAlias]
     * @return: boolean
     **/
    public boolean checkUpdateWhetherRepeat(NtPerAlias ntPerAlias);
}
