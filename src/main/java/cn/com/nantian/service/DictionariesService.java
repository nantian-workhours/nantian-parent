package cn.com.nantian.service;

import cn.com.nantian.pojo.NtDictionariesKey;

import java.util.List;

/**
 * @Description: 字典数据管理
 * @Author：Fly
 * @Date: 2019/3/19 16:48
 * @Version：1.0
 */
public interface DictionariesService {
    /**
      * @Description: 根据条件查询字典数据
      * @Param: [dictionariesKey]
      * @Return: java.util.List<cn.com.nantian.pojo.NtDictionariesKey>
      * @Auther: Fly
      * @Date: 2019/3/19 16:49
      **/
    public List<NtDictionariesKey> selectDictionariesList(NtDictionariesKey dictionariesKey);


    /**
      * @Description: 根据条件查询字典数据
      * @Param: [dicType, dicCode] 类别、编码
      * @Return: cn.com.nantian.pojo.NtDictionariesKey
      * @Auther: Fly
      * @Date: 2019/3/20 15:27
      **/
    public NtDictionariesKey selectDictionaries(String dicType, String dicCode);



}
