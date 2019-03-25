package cn.com.nantian.service.impl;

import cn.com.nantian.mapper.NtPerAliasMapper;
import cn.com.nantian.pojo.NtPerAlias;
import cn.com.nantian.service.PerAliasService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *别名管理实现
 */
@Service
public class PerAliasImpl implements PerAliasService {

    @Resource
    private NtPerAliasMapper perAliasMapper;

    /**
     * 根据员工姓名查询用户别名
     * @param name
     * @return
     */
    @Override
    public List<NtPerAlias> selectByName(String name) {
        return perAliasMapper.selectByName(name);
    }

    /**
     * 根据员工编号查询用户别名
     * @param perId
     * @return
     */
    @Override
    public List<NtPerAlias> selectByPerId(int perId) {
        return perAliasMapper.selectByPerId(perId);
    }
}
