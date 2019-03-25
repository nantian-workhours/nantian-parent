package cn.com.nantian.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.nantian.mapper.NtDictionariesMapper;
import cn.com.nantian.pojo.NtDictionariesKey;
import cn.com.nantian.service.SubTypeDicService;

@Service
public class SubTypeDicServiceImpl implements SubTypeDicService {
	@Resource
	NtDictionariesMapper subTypeDicMapper;
	
	//子类-添加
	@Override
	public int subTypeAdd(NtDictionariesKey subTypeDic) {
		// 添加
		return subTypeDicMapper.insert(subTypeDic);
	}
	
	//子类-查询
	@Override
	public List<NtDictionariesKey> subTypeQuery(String dicType) {
		List<NtDictionariesKey> list = null;
		try{
			if(dicType!=null){
				list = subTypeDicMapper.selectByExample(dicType);
			}else{
				list = subTypeDicMapper.selectByExample(null);				
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	//子类-删除-单条删除
	@Override
	public int subTypeDelete(String dicCode) {
		return subTypeDicMapper.deleteByPrimaryKey(dicCode);
	}
	
	//子类-删除-根据所属类别批量删除
	@Override
	public int subTypeDeleteByDicType(String dicType) {
		return subTypeDicMapper.deleteByDicType(dicType);
	}

}
