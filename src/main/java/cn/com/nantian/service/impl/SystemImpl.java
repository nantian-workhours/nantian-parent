package cn.com.nantian.service.impl;

import cn.com.nantian.mapper.NtDictionariesMapper;
import cn.com.nantian.mapper.NtTypeDictionariesMapper;
import cn.com.nantian.pojo.NtDictionariesKey;
import cn.com.nantian.pojo.NtTypeDictionaries;
import cn.com.nantian.service.SystemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SystemImpl implements SystemService {


    @Resource
    private NtTypeDictionariesMapper typeDictionariesMapper;
    @Resource
    private NtDictionariesMapper dictionariesMapper;

    @Override
    public List<NtTypeDictionaries> selectTypedict() {
        return typeDictionariesMapper.selectByExample(null);
    }

    /**
     * 添加参数类别
     * @param typeDictionaries
     * @return
     */
    @Override
    public int addParamCate(NtTypeDictionaries typeDictionaries) {
        return typeDictionariesMapper.insert(typeDictionaries);
    }

    /**
     * 根据参数类型,查询参数值
     * @param dicType
     * @return
     */
    @Override
    public List<NtDictionariesKey> selectValue(String dicType) {
        List<NtDictionariesKey> dictionariesKey = dictionariesMapper.selectByExample(dicType);
        return dictionariesKey ;
    }
}
