package cn.com.nantian.service.impl;

import cn.com.nantian.common.ObjectUtils;
import cn.com.nantian.common.ParamUntil;
import cn.com.nantian.common.StringUtils;
import cn.com.nantian.mapper.NtCustTypeMapper;
import cn.com.nantian.pojo.NtCustType;
import cn.com.nantian.pojo.NtDictionariesKey;
import cn.com.nantian.service.CustTypeService;
import cn.com.nantian.service.DictionariesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @Author：Mr.Wind
 * @date: 2019/3/20 15:06
 * @Version：1.0
 */
@Service
public class CustTypeServiceImpl implements CustTypeService {

    @Resource
    private NtCustTypeMapper custTypeMapper;
    @Resource
    private DictionariesService dictionariesService;

    /**
     * @description: 查询客户类型集合
     * @Param: [custType]
     * @return: List<NtCustType>
     * @auther: Mr.Wind
     * @date: 2019/3/20 15:04
     **/
    @Override
    public List<NtCustType> selectCustTypeList(NtCustType custType) {
        return custTypeMapper.selectCustTypeList(custType);
    }

    /**
     * @description: 设置客户类别、工作类别、技术等级 名称
     * @Param: [custTypeList]
     * @return: void
     * @auther: Mr.Wind
     * @date: 2019/3/20 15:17
     **/
    @Override
    public void setCustTypeName(List<NtCustType> custTypeList) {
        if (ObjectUtils.isNotNull(custTypeList)) {
            for (NtCustType custType : custTypeList) {
                //客户类别
                NtDictionariesKey dictionariesKey1 = dictionariesService.selectDictionaries(ParamUntil.cust, custType.getCustType());
                if (ObjectUtils.isNotNull(dictionariesKey1)) {
                    custType.setCustTypeName(dictionariesKey1.getDicValue());
                }
                //工作类别
                String workTypes = custType.getWorkType();
                String[] workTypesArray = workTypes.split(",");
                List<String> workTypesList = Arrays.asList(workTypesArray);
                List<String> workTypeNameList = new ArrayList<>();
                for (String str : workTypesList) {
                    NtDictionariesKey dictionariesKey2 = dictionariesService.selectDictionaries(ParamUntil.wt, str);
                    if (ObjectUtils.isNotNull(dictionariesKey2)) {
                        workTypeNameList.add(dictionariesKey2.getDicValue());
                    }
                }
                custType.setWorkTypeNameList(workTypeNameList);
                //技术等级
                String workLevels = custType.getWorkLevel();
                String[] workLevelsArray = workLevels.split(",");
                List<String> workLevelsList = Arrays.asList(workLevelsArray);
                List<String> workLevelNameList = new ArrayList<>();
                for (String str : workLevelsList) {
                    NtDictionariesKey dictionariesKey3 = dictionariesService.selectDictionaries(ParamUntil.dc, str);
                    if (ObjectUtils.isNotNull(dictionariesKey3)) {
                        workLevelNameList.add(dictionariesKey3.getDicValue());
                    }
                }
                custType.setWorkLevelNameList(workLevelNameList);
            }
        }
    }


    /**
     * @description: 设置客户类别、工作类别、技术等级 名称
     * @Param: [custType]
     * @return: void
     * @auther: Mr.Wind
     * @date: 2019/3/20 17:17
     **/
    @Override
    public void setCustTypeName(NtCustType custType) {
        if (custType != null) {
            //工作类别
            String workTypes = custType.getWorkType();
            String[] workTypesArray = workTypes.split(",");
            List<String> workTypesList = Arrays.asList(workTypesArray);
            List<String> workTypeNameList = new ArrayList<>();
            for (String str : workTypesList) {
                NtDictionariesKey dictionariesKey2 = dictionariesService.selectDictionaries(ParamUntil.wt, str);
                if (ObjectUtils.isNotNull(dictionariesKey2)) {
                    workTypeNameList.add(dictionariesKey2.getDicValue());
                }
            }
            custType.setWorkTypeNameList(workTypeNameList);
            //技术等级
            String workLevels = custType.getWorkLevel();
            String[] workLevelsArray = workLevels.split(",");
            List<String> workLevelsList = Arrays.asList(workLevelsArray);
            List<String> workLevelNameList = new ArrayList<>();
            for (String str : workLevelsList) {
                NtDictionariesKey dictionariesKey3 = dictionariesService.selectDictionaries(ParamUntil.dc, str);
                if (ObjectUtils.isNotNull(dictionariesKey3)) {
                    workLevelNameList.add(dictionariesKey3.getDicValue());
                }
            }
            custType.setWorkLevelNameList(workLevelNameList);
            //客户类别
            NtDictionariesKey dictionariesKey1 = dictionariesService.selectDictionaries(ParamUntil.cust, custType.getCustType());
            if (ObjectUtils.isNotNull(dictionariesKey1)) {
                custType.setCustTypeName(dictionariesKey1.getDicValue());
            }
        }
    }

    /**
     * @description: 删除客户类别
     * @Param: [custType] 删除条件
     * @return: int
     * @auther: Mr.Wind
     * @date: 2019/3/20 15:55
     **/
    @Override
    public int deleteCustType(int custId) {
        return custTypeMapper.deleteByPrimaryKey(custId);
    }

    /**
     * @description: 新增客户类别
     * @Param: [custType]
     * @return: int
     * @auther: Mr.Wind
     * @date: 2019/3/20 16:48
     **/
    @Override
    public int addCustType(NtCustType custType) {
        return custTypeMapper.insert(custType);
    }

    /**
     * @description: 更新客户类别
     * @Param: [custType]
     * @return: int
     * @auther: Mr.Wind
     * @date: 2019/3/20 17:03
     **/
    @Override
    public int updateCustType(NtCustType custType) {
        return custTypeMapper.updateCustType(custType);
    }

    /**
     * @description: 查询客户类型
     * @Param: [custType]
     * @return: NtCustType
     * @auther: Mr.Wind
     * @date: 2019/3/20 17:12
     **/
    @Override
    public NtCustType selectCustType(int custId) {
        return custTypeMapper.selectCustType(custId);
    }

    /**
     * @description: 检查传入的对象所有属性值，在表中是否已存在
     * @auther: Mr.Wind
     * @date: 2019/3/26 14:25
     * @Param: [NtCustType]
     * @return: boolean
     **/
    @Override
    public boolean checkWhetherRepeat(NtCustType ntCustType) {
        List<NtCustType> NtCustTypeList = this.selectCustTypeList(null);
        boolean repeat = false;
        if (ObjectUtils.isNotNull(NtCustTypeList) && ObjectUtils.isNotNull(ntCustType)) {
            for (NtCustType ntCustType2 : NtCustTypeList) {
                if (ntCustType2.equals(ntCustType)) {
                    repeat = true;
                    break;
                }
            }
        }
        return repeat;
    }

    /**
     * @description: 更新 检查传入的对象所有属性值，在表中是否已存在
     * @auther: Mr.Wind
     * @date: 2019/5/7 11:28
     * @Param: [ntCustType]
     * @return: boolean
     **/
    @Override
    public boolean checkUpdateWhetherRepeat(NtCustType ntCustType) {
        List<NtCustType> NtCustTypeList = this.selectCustTypeList(null);
        boolean repeat = false;
        if (ObjectUtils.isNotNull(NtCustTypeList) && ObjectUtils.isNotNull(ntCustType)) {
            for (NtCustType ntCustType2 : NtCustTypeList) {
                if (ntCustType2.getCustId() != ntCustType.getCustId() && ntCustType2.equals(ntCustType)) {
                    repeat = true;
                    break;
                }
            }
        }
        return repeat;
    }

    /**
     * @description: 检查属性值是否为空
     * @auther: Mr.Wind
     * @date: 2019/3/26 14:23
     * @Param: [ntCustType]
     * @return: java.lang.String
     **/
    @Override
    public String checkAttribute(NtCustType ntCustType) {
        if (ObjectUtils.isNotNull(ntCustType)) {
            if (StringUtils.isEmpty(ntCustType.getCustType())) {
                return "客户类别 不能为空！";
            }
            if (StringUtils.isEmpty(ntCustType.getWorkType())) {
                return "工作类别 不能为空！";
            }
            if (StringUtils.isEmpty(ntCustType.getWorkLevel())) {
                return "技术等级 不能为空！";
            }
        }
        return "";
    }
}
