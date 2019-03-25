package cn.com.nantian.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.nantian.pojo.NtDictionariesKey;
import cn.com.nantian.pojo.NtTypeDictionaries;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.service.TypeDicService;

/**
 * 参数管理
 * @author wangshuai
 */

@Controller
@RequestMapping("/params")
public class TypeDicController {
	@Resource
	private TypeDicService typeDicService;
	
	/**
	 * 类别-查询所有
	 * @return
	 */
	@RequestMapping(value="/typeQuery", method={RequestMethod.GET})
	@ResponseBody
	public ResponseData queryAllType(){
		List<NtTypeDictionaries> typeList = typeDicService.typeQueryAll();
		return ResponseData.ok().putDataValue("res", typeList);
	}
	
	/**
	 * 类别-添加
	 * @param type
	 * @return
	 */
	@RequestMapping(value="/typeAdd", method={RequestMethod.POST})
	@ResponseBody
	public ResponseData addType(@RequestBody NtTypeDictionaries type){
		try{
			//数据库操作成功数
			int id = typeDicService.typeAdd(type);
			if(id > 0){
				return ResponseData.ok().putDataValue("res", "类别添加成功");
			}else{
				//失败
				return ResponseData.isfailed();
			}
		}catch(Exception e){
			//服务器端异常
			return ResponseData.serverInternalError();
		}
	}
	
	/**
	 * 类别-删除
	 * @param typeCode
	 * @return
	 */
	@RequestMapping(value="/typeDelete", method={RequestMethod.POST})
	@ResponseBody
	public ResponseData deleteType(String typeCode){
		try{
			int id = typeDicService.typeDelete(typeCode);
			if(id > 0){
				return ResponseData.ok().putDataValue("res", "删除成功"+id+"条");
			}else{
				//失败
				return ResponseData.isfailed();
			}
		}catch(Exception e){
			//服务器端异常
			return ResponseData.serverInternalError();
		}		
	}
}
