package cn.com.nantian.service.impl;

import cn.com.nantian.mapper.NtDictionariesMapper;
import cn.com.nantian.pojo.NtDictionariesKey;
import cn.com.nantian.service.DictionariesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 字典数据管理
 * @Author：Mr.Kong
 * @date: 2019/3/19 16:48
 * @Version：1.0
 */
@Service
public class DictionariesServiceImpl implements DictionariesService {

    @Resource
    private NtDictionariesMapper dictionariesMapper;

    /**
      * @description: 根据字典所属类型、字典值查询数据
      * @auther: Mr.Kong
      * @date: 2019/5/16 11:12
      * @param:  [dicType, dicValue] 字典所属类型、字典值
      * @return: cn.com.nantian.pojo.NtDictionariesKey
      **/
    public NtDictionariesKey queryDictionaries(String dicType, String dicValue){
        NtDictionariesKey dictionariesKey=new NtDictionariesKey();
        dictionariesKey.setDicType(dicType);
        dictionariesKey.setDicValue(dicValue);
        return dictionariesMapper.queryDictionaries(dictionariesKey);
    }

    /**
     * @description: 根据条件查询字典数据
     * @Param: [dictionariesKey]
     * @return: List<NtDictionariesKey>
     * @auther: Mr.Kong
     * @date: 2019/3/19 16:49
     **/
    public List<NtDictionariesKey> selectDictionariesList(NtDictionariesKey dictionariesKey){
        return dictionariesMapper.selectDictionariesList(dictionariesKey);
    }

    /**
     * @description: 根据条件查询字典数据
     * @Param: [dicType, dicCode] 类别、编码
     * @return: NtDictionariesKey
     * @auther: Mr.Kong
     * @date: 2019/3/20 15:27
     **/
    public NtDictionariesKey selectDictionaries(String dicType, String dicCode){
        NtDictionariesKey dictionariesKey=new NtDictionariesKey();
        dictionariesKey.setDicType(dicType);
        dictionariesKey.setDicCode(dicCode);
        return dictionariesMapper.selectDictionaries(dictionariesKey);
    }
    /**
     * 根据类别查询
     * @param dicType
     * @return
     */
    @Override
    public List<NtDictionariesKey> selectDictionariesByType(String dicType) {
        return  dictionariesMapper.selectByType(dicType);
    }
}
