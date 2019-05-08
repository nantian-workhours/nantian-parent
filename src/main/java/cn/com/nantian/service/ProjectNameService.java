package cn.com.nantian.service;

import cn.com.nantian.pojo.NtPerAlias;
import cn.com.nantian.pojo.NtProjectInfo;

import java.util.List;

/**
 * 别名管理
 */
public interface ProjectNameService {

    /**
     * @Description: 更新员工别名
     * @Auther: Mr.Kong
     * @Date: 2019/5/8 15:53
     * @Param:  [ntPerAlias]
     * @Return: int
     **/
    int updateNtPerAlias(NtPerAlias ntPerAlias);

    /**
     * @Description: 查询员工项目别名列表数据
     * @Auther: Mr.Kong
     * @Date: 2019/5/8 14:24
     * @Param:  []
     * @Return: java.util.List<cn.com.nantian.pojo.NtPerAlias>
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
     * @Description: 效验传入的参数值是否为空
     * @Auther: Mr.Kong
     * @Date: 2019/5/8 11:00
     * @Param:  [ntPerAlias]
     * @Return: java.lang.String
     **/
    public String checkAttribute(NtPerAlias ntPerAlias);
    /**
     * @Description: 效验数据是否已存在
     * @Auther: Mr.Kong
     * @Date: 2019/5/8 14:28
     * @Param:  [ntPerAlias]
     * @Return: boolean
     **/
    public boolean checkWhetherRepeat(NtPerAlias ntPerAlias);
    /**
     * @Description: 更新时 效验数据是否已存在
     * @Auther: Mr.Kong
     * @Date: 2019/5/8 16:01
     * @Param:  [ntPerAlias]
     * @Return: boolean
     **/
    public boolean checkUpdateWhetherRepeat(NtPerAlias ntPerAlias);
}
