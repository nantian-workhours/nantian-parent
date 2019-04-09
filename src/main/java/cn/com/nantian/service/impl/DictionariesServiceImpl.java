package cn.com.nantian.service.impl;

import cn.com.nantian.mapper.NtDictionariesMapper;
import cn.com.nantian.pojo.NtDictionariesKey;
import cn.com.nantian.service.DictionariesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 字典数据管理
 * @Author：Fly
 * @Date: 2019/3/19 16:48
 * @Version：1.0
 */
@Service
public class DictionariesServiceImpl implements DictionariesService {

    @Resource
    private NtDictionariesMapper dictionariesMapper;


    /**
     * @Description: 根据条件查询字典数据
     * @Param: [dictionariesKey]
     * @Return: java.util.List<cn.com.nantian.pojo.NtDictionariesKey>
     * @Auther: Fly
     * @Date: 2019/3/19 16:49
     **/
    public List<NtDictionariesKey> selectDictionariesList(NtDictionariesKey dictionariesKey){
        return dictionariesMapper.selectDictionariesList(dictionariesKey);
    }

    /**
     * @Description: 根据条件查询字典数据
     * @Param: [dicType, dicCode] 类别、编码
     * @Return: cn.com.nantian.pojo.NtDictionariesKey
     * @Auther: Fly
     * @Date: 2019/3/20 15:27
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
