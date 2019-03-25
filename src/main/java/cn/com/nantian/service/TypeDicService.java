package cn.com.nantian.service;

import java.util.List;

import cn.com.nantian.pojo.NtDictionariesKey;
import cn.com.nantian.pojo.NtTypeDictionaries;

public interface TypeDicService {
	//类别 - 添加参数类别
	int typeAdd(NtTypeDictionaries type);
	
	//类别 - 删除参数类别
	int typeDelete(String typeCode);
	
	//类别 - 查询所有类别
	List<NtTypeDictionaries> typeQueryAll();
	
	// 子类-添加
	int subTypeAdd(NtDictionariesKey subType);
}
