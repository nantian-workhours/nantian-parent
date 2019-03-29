/**
 * @Description:
 * @ClassName: HolInfoServiceImpl
 * @Author： Mr.Kong
 * @Date: 2019/3/29 16:05
 * @Version： 1.0
 */
package cn.com.nantian.service.impl;

import cn.com.nantian.mapper.NtHolInfoMapper;
import cn.com.nantian.pojo.NtHolInfo;
import cn.com.nantian.service.HolInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class HolInfoServiceImpl implements HolInfoService{

    @Resource
    private NtHolInfoMapper holInfoMapper;

    @Override
    public List<NtHolInfo> selectHolInfoList(NtHolInfo ntHolInfo) {
        return holInfoMapper.selectHolInfoList(ntHolInfo);
    }

    @Override
    public int deleteByPrimaryKey(Integer perId) {
        return 0;
    }

    @Override
    public int insert(NtHolInfo record) {
        return 0;
    }

    @Override
    public int insertSelective(NtHolInfo record) {
        return 0;
    }

    @Override
    public NtHolInfo selectByPrimaryKey(Integer perId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(NtHolInfo record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(NtHolInfo record) {
        return 0;
    }
}
