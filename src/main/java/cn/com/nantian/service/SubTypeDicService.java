package cn.com.nantian.service;

import java.util.List;

import cn.com.nantian.pojo.NtDictionariesKey;

public interface SubTypeDicService {
	
	//子类-查询
	List<NtDictionariesKey> subTypeQuery(String dicType);
	
	//子类-添加
	int subTypeAdd(NtDictionariesKey subTypeDic);
	
	//子类-删除
	int subTypeDelete(String dicCode);
	
	//子类-删除-根据所属类别批量删除
	int subTypeDeleteByDicType(String dicType);
}
