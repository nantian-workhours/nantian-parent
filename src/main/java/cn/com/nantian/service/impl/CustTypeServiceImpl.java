package cn.com.nantian.service.impl;

import cn.com.nantian.common.ObjectUtils;
import cn.com.nantian.common.ParamUntil;
import cn.com.nantian.common.StringUtils;
import cn.com.nantian.mapper.NtCustTypeMapper;
import cn.com.nantian.pojo.NtCustTypeKey;
import cn.com.nantian.pojo.NtDictionariesKey;
import cn.com.nantian.service.CustTypeService;
import cn.com.nantian.service.DictionariesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
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
    @Override
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
    @Override
    public void setCustTypeName(List<NtCustTypeKey> custTypeKeyList){
        if(ObjectUtils.isNotNull(custTypeKeyList)){
            for(NtCustTypeKey custTypeKey:custTypeKeyList){
                //客户类别
                NtDictionariesKey dictionariesKey1=dictionariesService.selectDictionaries(ParamUntil.cust,custTypeKey.getCustType());
                if (ObjectUtils.isNotNull(dictionariesKey1)){
                    custTypeKey.setCustTypeName(dictionariesKey1.getDicValue());
                }
                //工作类别
                String workTypes=custTypeKey.getWorkType();
                String[] workTypesArray=workTypes.split(",");
                List<String> workTypesList= Arrays.asList(workTypesArray);
                List<String> workTypeNameList=new ArrayList<>();
                for (String str:workTypesList){
                    NtDictionariesKey dictionariesKey2=dictionariesService.selectDictionaries(ParamUntil.wt,str);
                    if (ObjectUtils.isNotNull(dictionariesKey2)){
                        workTypeNameList.add(dictionariesKey2.getDicValue());
                    }
                }
                custTypeKey.setWorkTypeNameList(workTypeNameList);
                //技术等级
                String workLevels=custTypeKey.getWorkLevel();
                String[] workLevelsArray=workLevels.split(",");
                List<String> workLevelsList= Arrays.asList(workLevelsArray);
                List<String> workLevelNameList=new ArrayList<>();
                for (String str:workLevelsList){
                    NtDictionariesKey dictionariesKey3=dictionariesService.selectDictionaries(ParamUntil.dc,str);
                    if (ObjectUtils.isNotNull(dictionariesKey3)){
                        workLevelNameList.add(dictionariesKey3.getDicValue());
                    }
                }
                custTypeKey.setWorkLevelNameList(workLevelNameList);
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
    @Override
    public void setCustTypeName(NtCustTypeKey custTypeKey){
        if(custTypeKey!=null){
            //工作类别
            String workTypes=custTypeKey.getWorkType();
            String[] workTypesArray=workTypes.split(",");
            List<String> workTypesList= Arrays.asList(workTypesArray);
            List<String> workTypeNameList=new ArrayList<>();
            for (String str:workTypesList){
                NtDictionariesKey dictionariesKey2=dictionariesService.selectDictionaries(ParamUntil.wt,str);
                if (ObjectUtils.isNotNull(dictionariesKey2)){
                    workTypeNameList.add(dictionariesKey2.getDicValue());
                }
            }
            custTypeKey.setWorkTypeNameList(workTypeNameList);
            //技术等级
            String workLevels=custTypeKey.getWorkLevel();
            String[] workLevelsArray=workLevels.split(",");
            List<String> workLevelsList= Arrays.asList(workLevelsArray);
            List<String> workLevelNameList=new ArrayList<>();
            for (String str:workLevelsList){
                NtDictionariesKey dictionariesKey3=dictionariesService.selectDictionaries(ParamUntil.dc,str);
                if (ObjectUtils.isNotNull(dictionariesKey3)){
                    workLevelNameList.add(dictionariesKey3.getDicValue());
                }
            }
            custTypeKey.setWorkLevelNameList(workLevelNameList);
            //客户类别
            NtDictionariesKey dictionariesKey1=dictionariesService.selectDictionaries(ParamUntil.cust,custTypeKey.getCustType());
            if (ObjectUtils.isNotNull(dictionariesKey1)){
                custTypeKey.setCustTypeName(dictionariesKey1.getDicValue());
            }
        }
    }

    /**
     * @Description: 删除客户类别
     * @Param: [custTypeKey] 删除条件
     * @Return: int
     * @Auther: Fly
     * @Date: 2019/3/20 15:55
     **/
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
    public String checkAttribute(NtCustTypeKey ntCustType){
        if (ObjectUtils.isNotNull(ntCustType)){
            if(StringUtils.isEmpty(ntCustType.getCustType())){
                return "客户类别名称 不能为空！";
            }
            if(StringUtils.isEmpty(ntCustType.getWorkType())){
                return "工作类别 不能为空！";
            }
            if(StringUtils.isEmpty(ntCustType.getWorkLevel())){
                return "技术等级 不能为空！";
            }
        }
        return "";
    }
}
