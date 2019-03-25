package cn.com.nantian.service.impl;

import cn.com.nantian.mapper.NtLeaveInfoMapper;
import cn.com.nantian.pojo.NtDictionariesKey;
import cn.com.nantian.pojo.NtLeaveInfo;
import cn.com.nantian.service.DictionariesService;
import cn.com.nantian.service.PriceLeaveService;
import cn.com.nantian.util.ClassCompareUtil;
import cn.com.nantian.util.ObjectUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 单价级别信息管理
 * @Author：Fly
 * @Date: 2019/3/21 11:15
 * @Version：1.0
 */
@Service
public class PriceLeaveServiceImpl implements PriceLeaveService {
    @Resource
    private NtLeaveInfoMapper ntLeaveInfoMapper;
    @Resource
    private DictionariesService dictionariesService;
    /**
      * @Description: 查询单价级别列表
      * @Param: [ntLeaveInfo] 查询条件
      * @Return: java.util.List<cn.com.nantian.pojo.NtLeaveInfo>
      * @Auther: Fly
      * @Date: 2019/3/21 14:57
      **/
    @Override
    public List<NtLeaveInfo> selectLeaveInfoList(NtLeaveInfo ntLeaveInfo) {
        return ntLeaveInfoMapper.selectLeaveInfoList(ntLeaveInfo);
    }
    /**
      * @Description: 设置客户类别、工作类别、技术等级名称
      * @Param: [ntLeaveInfoList]
      * @Return: void
      * @Auther: Fly
      * @Date: 2019/3/21 15:32
      **/
    @Override
    public void setLeaveInfoName(List<NtLeaveInfo> ntLeaveInfoList) {
        if(ntLeaveInfoList!=null && ntLeaveInfoList.size()>0){
            for(NtLeaveInfo ntLeaveInfo:ntLeaveInfoList){
                //设置客户类别
                NtDictionariesKey dictionariesKey1= dictionariesService.selectDictionaries("cust",ntLeaveInfo.getCustType());
                ntLeaveInfo.setCustTypeName(dictionariesKey1.getDicValue());
                // 工作类别
                NtDictionariesKey dictionariesKey2= dictionariesService.selectDictionaries("wt",ntLeaveInfo.getWorkType());
                ntLeaveInfo.setWorkTypeName(dictionariesKey2.getDicValue());
                // 技术等级名称
                NtDictionariesKey dictionariesKey3= dictionariesService.selectDictionaries("dc",ntLeaveInfo.getWorkLeave());
                ntLeaveInfo.setWorkLeaveName(dictionariesKey3.getDicValue());
            }
        }

    }
    /**
      * @Description: 设置客户类别、工作类别、技术等级名称
      * @Param: [ntLeaveInfo]
      * @Return: void
      * @Auther: Fly
      * @Date: 2019/3/21 16:07
      **/
    @Override
    public void setLeaveInfoName(NtLeaveInfo ntLeaveInfo) {
        if(ntLeaveInfo!=null){
            // 技术等级名称
            NtDictionariesKey dictionariesKey3= dictionariesService.selectDictionaries("dc",ntLeaveInfo.getWorkLeave());
            ntLeaveInfo.setWorkLeaveName(dictionariesKey3.getDicValue());
            //设置客户类别
            NtDictionariesKey dictionariesKey1= dictionariesService.selectDictionaries("cust",ntLeaveInfo.getCustType());
            ntLeaveInfo.setCustTypeName(dictionariesKey1.getDicValue());
            // 工作类别
            NtDictionariesKey dictionariesKey2= dictionariesService.selectDictionaries("wt",ntLeaveInfo.getWorkType());
            ntLeaveInfo.setWorkTypeName(dictionariesKey2.getDicValue());
        }
    }
    /**
      * @Description: 删除单价级别信息
      * @Param: [ntLeaveInfo] 条件
      * @Return: int
      * @Auther: Fly
      * @Date: 2019/3/21 16:51
      **/
    @Override
    public int deleteLeaveInfo(int priceId) {
        return ntLeaveInfoMapper.deleteByPrimaryKey(priceId);
    }
    /**
      * @Description: 新增单价级别信息
      * @Param: [ntLeaveInfo]
      * @Return: int
      * @Auther: Fly
      * @Date: 2019/3/21 16:55
      **/
    @Override
    public int addLeaveInfo(NtLeaveInfo ntLeaveInfo) {
        return ntLeaveInfoMapper.insertSelective(ntLeaveInfo);
    }
    /**
      * @Description: 更新单价级别信息
      * @Param: [ntLeaveInfo]
      * @Return: int
      * @Auther: Fly
      * @Date: 2019/3/21 17:03
      **/
    @Override
    public int updateLeaveInfo(NtLeaveInfo ntLeaveInfo) {
        return ntLeaveInfoMapper.updateByExampleSelective(ntLeaveInfo);
    }
    /**
      * @Description: 查询 单价级别信息
      * @Param: [ntLeaveInfo]
      * @Return: cn.com.nantian.pojo.NtLeaveInfo
      * @Auther: Fly
      * @Date: 2019/3/21 17:10
      **/
    @Override
    public NtLeaveInfo selectLeaveInfo(int priceId) {
        return ntLeaveInfoMapper.selectLeaveInfo(priceId);
    }

    /**
     * @Description: 检查是否有重复数据
     * @Param: [ntLeaveInfo]
     * @Return: boolean true 有 , false 无
     * @Auther: Fly
     * @Date: 2019/3/22 9:52
     **/
    public boolean checkWhetherRepeat(NtLeaveInfo ntLeaveInfo){
        boolean whether=false;
        if(ObjectUtils.isNotNull(ntLeaveInfo)){
            List<NtLeaveInfo> leaveInfoList=ntLeaveInfoMapper.selectLeaveInfoList(null);
            if(ObjectUtils.isNotNull(leaveInfoList)){
                for (NtLeaveInfo ntLeaveInfo1:leaveInfoList){
                    boolean isok= ClassCompareUtil.compareObject(ntLeaveInfo,ntLeaveInfo1);
                    if(isok==true){
                        whether=true;
                        break;
                    }
                }
            }
        }
        return whether;
    }
}
