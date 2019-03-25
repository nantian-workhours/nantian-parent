package cn.com.nantian.service;


import cn.com.nantian.pojo.NtDictionariesKey;
import cn.com.nantian.pojo.NtTypeDictionaries;

import java.util.List;

/**
 * 系统参数
 */
public interface SystemService {

    /**
     * 添加参数类别
     * @param typeDictionaries
     * @return
     */
    int addParamCate(NtTypeDictionaries typeDictionaries);

    /**
     * 查询类别信息
     * @return
     */
    List<NtTypeDictionaries> selectTypedict();

    /**
     * 根据参数类型,和参数code查询参数值
     * @param dicType
     * @return
     */
    List<NtDictionariesKey> selectValue(String dicType);
}
