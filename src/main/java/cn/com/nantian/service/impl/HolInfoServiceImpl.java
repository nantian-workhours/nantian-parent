/**
 * @Description: 年假信息管理
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
public class HolInfoServiceImpl implements HolInfoService {

    @Resource
    private NtHolInfoMapper holInfoMapper;


    /**
     * @Description: 查询年假信息列表
     * @Auther: Mr.Kong
     * @Date: 2019/3/29 16:40
     * @Param: [ntHolInfo]
     * @Return: java.util.List<cn.com.nantian.pojo.NtHolInfo>
     **/
    @Override
    public List<NtHolInfo> selectHolInfoList(NtHolInfo ntHolInfo) {
        return holInfoMapper.selectHolInfoList(ntHolInfo);
    }

    @Override
    public int deleteByPrimaryKey(Integer perId) {
        return holInfoMapper.deleteByPrimaryKey(perId);
    }

    @Override
    public int insert(NtHolInfo record) {
        return holInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(NtHolInfo record) {
        return holInfoMapper.insertSelective(record);
    }

    @Override
    public NtHolInfo selectByPrimaryKey(Integer perId) {
        return holInfoMapper.selectByPrimaryKey(perId);
    }

    @Override
    public int updateByPrimaryKeySelective(NtHolInfo record) {
        return holInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(NtHolInfo record) {
        return holInfoMapper.updateByPrimaryKey(record);
    }
}
