package cn.com.nantian.service.impl;

import cn.com.nantian.common.ObjectUtils;
import cn.com.nantian.mapper.NtCustTypeMapper;
import cn.com.nantian.pojo.NtCustTypeKey;
import cn.com.nantian.pojo.NtDictionariesKey;
import cn.com.nantian.service.CustTypeService;
import cn.com.nantian.service.DictionariesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author：Fly
 * @Date: 2019/3/20 15:06
 * @Version：1.0
 */
@Service
public class CustTypeServiceImpl implements CustTypeService {

    @Resource
    private NtCustTypeMapper custTypeMapper;
    @Resource
    private DictionariesService dictionariesService;

    /**
     * @Description: 查询客户类型集合
     * @Param: [custTypeKey]
     * @Return: java.util.List<cn.com.nantian.pojo.NtCustTypeKey>
     * @Auther: Fly
     * @Date: 2019/3/20 15:04
     **/
    public List<NtCustTypeKey> selectCustTypeList(NtCustTypeKey custTypeKey){
        return custTypeMapper.selectCustTypeList(custTypeKey);
    }

    /**
     * @Description: 设置客户类别、工作类别、技术等级 名称
     * @Param: [custTypeKeyList]
     * @Return: void
     * @Auther: Fly
     * @Date: 2019/3/20 15:17
     **/
    public void setCustTypeName(List<NtCustTypeKey> custTypeKeyList){
        if(custTypeKeyList!=null && custTypeKeyList.size()>0){
            for(NtCustTypeKey custTypeKey:custTypeKeyList){
                //客户类别
                String custType="cust";
                NtDictionariesKey dictionariesKey1=dictionariesService.selectDictionaries(custType,custTypeKey.getCustType());
                custTypeKey.setCustTypeName(dictionariesKey1.getDicValue());
                //工作类别
                String workType="wt";
                NtDictionariesKey dictionariesKey2=dictionariesService.selectDictionaries(workType,custTypeKey.getWorkType());
                custTypeKey.setWorkTypeName(dictionariesKey2.getDicValue());
                //技术等级
                String workLeave="dc";
                NtDictionariesKey dictionariesKey3=dictionariesService.selectDictionaries(workLeave,custTypeKey.getWorkLeave());
                custTypeKey.setWorkLeaveName(dictionariesKey3.getDicValue());
            }
        }
    }
    /**
      * @Description: 设置客户类别、工作类别、技术等级 名称
      * @Param: [custTypeKey]
      * @Return: void
      * @Auther: Fly
      * @Date: 2019/3/20 17:17
      **/
    public void setCustTypeName(NtCustTypeKey custTypeKey){
        if(custTypeKey!=null){
            //工作类别
            String workType="wt";
            NtDictionariesKey dictionariesKey2=dictionariesService.selectDictionaries(workType,custTypeKey.getWorkType());
            custTypeKey.setWorkTypeName(dictionariesKey2.getDicValue());
            //技术等级
            String workLeave="dc";
            NtDictionariesKey dictionariesKey3=dictionariesService.selectDictionaries(workLeave,custTypeKey.getWorkLeave());
            custTypeKey.setWorkLeaveName(dictionariesKey3.getDicValue());
            //客户类别
            String custType="cust";
            NtDictionariesKey dictionariesKey1=dictionariesService.selectDictionaries(custType,custTypeKey.getCustType());
            custTypeKey.setCustTypeName(dictionariesKey1.getDicValue());
        }
    }

    /**
     * @Description: 删除客户类别
     * @Param: [custTypeKey] 删除条件
     * @Return: int
     * @Auther: Fly
     * @Date: 2019/3/20 15:55
     **/
    public int deleteCustType(NtCustTypeKey custTypeKey){
        return custTypeMapper.deleteByPrimaryKey(custTypeKey);
    }

    /**
     * @Description: 新增客户类别
     * @Param: [custTypeKey]
     * @Return: int
     * @Auther: Fly
     * @Date: 2019/3/20 16:48
     **/
    public int addCustType(NtCustTypeKey custTypeKey){
        return custTypeMapper.insert(custTypeKey);
    }

    /**
     * @Description: 更新客户类别
     * @Param: [custTypeKey]
     * @Return: int
     * @Auther: Fly
     * @Date: 2019/3/20 17:03
     **/
    public int updateCustType(NtCustTypeKey custTypeKey){
        return custTypeMapper.updateCustType(custTypeKey);
    }

    /**
     * @Description: 查询客户类型
     * @Param: [custTypeKey]
     * @Return: cn.com.nantian.pojo.NtCustTypeKey
     * @Auther: Fly
     * @Date: 2019/3/20 17:12
     **/
    public NtCustTypeKey selectCustType(NtCustTypeKey custTypeKey){
        return custTypeMapper.selectCustType(custTypeKey);
    }

    /**
      * @Description: 检查传入的对象所有属性值，在表中是否已存在
      * @Auther: Mr.Kong
      * @Date: 2019/3/26 14:25
      * @Param: [ntCustTypeKey]
      * @Return: boolean
      **/
    public boolean checkWhetherRepeat(NtCustTypeKey ntCustTypeKey){
        List<NtCustTypeKey> ntCustTypeKeyList=this.selectCustTypeList(null);
        boolean repeat=false;
        if(ObjectUtils.isNotNull(ntCustTypeKeyList) && ObjectUtils.isNotNull(ntCustTypeKey)){
            for (NtCustTypeKey ntCustTypeKey1:ntCustTypeKeyList) {
                if(ntCustTypeKey1.equals(ntCustTypeKey)){
                    repeat=true;
                    break;
                }
            }
        }
        return repeat;
    }

    /**
      * @Description: 检查属性值是否为空
      * @Auther: Mr.Kong
      * @Date: 2019/3/26 14:23
      * @Param: [ntCustType]
      * @Return: java.lang.String
      **/
    public String checkAttribute(NtCustTypeKey ntCustType){
        if (ObjectUtils.isNotNull(ntCustType)){
            if(ObjectUtils.isNull(ntCustType.getCustType())){
                return "ntProjectInfo.custType 属性值不能为空！";
            }
            if(ObjectUtils.isNull(ntCustType.getWorkType())){
                return "ntProjectInfo.workType 属性值不能为空！";
            }
            if(ObjectUtils.isNull(ntCustType.getWorkLeave())){
                return "ntProjectInfo.workLeave 属性值不能为空！";
            }
        }
        return "";
    }
}
