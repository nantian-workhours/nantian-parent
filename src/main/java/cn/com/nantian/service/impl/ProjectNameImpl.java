package cn.com.nantian.service.impl;

import cn.com.nantian.common.ObjectUtils;
import cn.com.nantian.common.RegExpressionUtils;
import cn.com.nantian.common.StringUtils;
import cn.com.nantian.mapper.NtPerAliasMapper;
import cn.com.nantian.mapper.NtPersonnelMapper;
import cn.com.nantian.pojo.NtPerAlias;
import cn.com.nantian.pojo.NtPersonnel;
import cn.com.nantian.service.ProjectNameService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ProjectNameImpl implements ProjectNameService {


    @Resource
    private NtPerAliasMapper perAliasMapper;
    @Resource
    private NtPersonnelMapper personnelMapper;


    /**
     * @description: 更新员工别名
     * @auther: Mr.Kong
     * @date: 2019/5/8 15:53
     * @Param: [ntPerAlias]
     * @return: int
     **/
    @Override
    public int updateNtPerAlias(NtPerAlias ntPerAlias) {
        return perAliasMapper.updateNtPerAlias(ntPerAlias);
    }

    /**
     * @description: 查询员工项目别名列表数据
     * @auther: Mr.Kong
     * @date: 2019/5/8 14:27
     * @Param: [ntPerAlias]
     * @return: List<NtPerAlias>
     **/
    @Override
    public List<NtPerAlias> queryNtPerAliasList(NtPerAlias ntPerAlias) {
        return perAliasMapper.queryNtPerAliasList(ntPerAlias);
    }

    /**
     * 添加别名内容
     *
     * @param perAlias
     * @return
     */
    @Override
    public int addProjectName(NtPerAlias perAlias) {
        return perAliasMapper.insert(perAlias);
    }


    /**
     * 根据员工身份证号,别名,客户名称删除员工别名信息
     *
     * @param idNo
     * @return int
     */
    @Override
    public int deleteByIdNo(String idNo) {
        return perAliasMapper.deleteByIdNo(idNo);
    }

    /**
     * @description: 效验传入的参数值是否为空
     * @auther: Mr.Kong
     * @date: 2019/5/8 11:00
     * @Param: [ntPerAlias]
     * @return: java.lang.String
     **/
    @Override
    public String checkAttribute(NtPerAlias ntPerAlias) {
        if (ObjectUtils.isNotNull(ntPerAlias)) {
            if (ObjectUtils.isNull(ntPerAlias.getProjectNumber())) {
                return "项目编号 不能为空！";
            }
            if (StringUtils.isEmpty(ntPerAlias.getIdNo())) {
                return "身份证号 不能为空！";
            } else if (!RegExpressionUtils.isIDNumber(ntPerAlias.getIdNo())) {
                return "身份证号 格式不正确！";
            } else {
                NtPersonnel ntPersonnel = personnelMapper.selectByPrimaryIdNo(ntPerAlias.getIdNo());
                if (ObjectUtils.isNull(ntPersonnel)) {
                    return "身份证号 不存在！";
                } else {
                    ntPerAlias.setPerId(ntPersonnel.getPerId());
                }
            }
            if (ObjectUtils.isNull(ntPerAlias.getInProjectName())) {
                return "别名 不能为空！";
            }
        }
        return null;
    }

    /**
     * @description: 创建时 效验数据是否已存在
     * @auther: Mr.Kong
     * @date: 2019/5/8 14:28
     * @Param: [ntPerAlias]
     * @return: boolean true 存在 ,false 不存在
     **/
    @Override
    public boolean checkWhetherRepeat(NtPerAlias ntPerAlias) {
        NtPerAlias perAlias = new NtPerAlias();
        perAlias.setPerId(ntPerAlias.getPerId());
        List<NtPerAlias> ntPerAliasList = this.queryNtPerAliasList(perAlias);
        boolean repeat = false;
        if (ObjectUtils.isNotNull(ntPerAliasList)) {
            repeat = true;
        }
        return repeat;
    }

    /**
     * @description: 更新时 效验数据是否已存在
     * @auther: Mr.Kong
     * @date: 2019/5/8 16:01
     * @Param: [ntPerAlias]
     * @return: boolean
     **/
    public boolean checkUpdateWhetherRepeat(NtPerAlias ntPerAlias) {
        NtPerAlias perAlias = new NtPerAlias();
        perAlias.setPerId(ntPerAlias.getPerId());
        List<NtPerAlias> ntPerAliasList = this.queryNtPerAliasList(perAlias);
        boolean repeat = false;
        if (ObjectUtils.isNotNull(ntPerAliasList) && ntPerAliasList.size() > 1) {
            repeat = true;
        }
        return repeat;
    }
}

