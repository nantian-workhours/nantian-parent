package cn.com.nantian.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import cn.com.nantian.mapper.NtTypeDictionariesMapper;
import cn.com.nantian.pojo.NtDictionariesKey;
import cn.com.nantian.pojo.NtTypeDictionaries;
import cn.com.nantian.service.TypeDicService;

@Service
public class TypeDicImpl implements TypeDicService{
	
	@Resource
	private NtTypeDictionariesMapper typeDicMapper;
	
	//类别-查询所有类别
	@Override
	public List<NtTypeDictionaries> typeQueryAll(){
		List<NtTypeDictionaries> typeList = null;
		try{
			typeList = typeDicMapper.selectByExample(null);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return typeList;
		
	}
	
	
	// 类别-添加类别
	@Override
	public int typeAdd(NtTypeDictionaries type){
		return typeDicMapper.insert(type);
	}
	
	// 类别-删除类别
	@Override
	public int typeDelete(String typeCode){
		return typeDicMapper.deleteByPrimaryKey(typeCode);
	}


	@Override
	public int subTypeAdd(NtDictionariesKey subType) {
		// TODO Auto-generated method stub
		return 0;
	}
}
