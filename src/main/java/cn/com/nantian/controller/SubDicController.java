package cn.com.nantian.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.nantian.pojo.NtDictionariesKey;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.service.SubTypeDicService;

@Controller
@RequestMapping("/params")
public class SubDicController {
	
	@Resource SubTypeDicService subTypeDicService;
	
	/**
	 * 子类-查询
	 * @return
	 */
	@RequestMapping(value="/subTypeQuery", method={RequestMethod.GET})
	@ResponseBody
	public ResponseData subTypeQuery(String dicType){
		List<NtDictionariesKey> list = null;
		
		if(dicType!=null){
			list = subTypeDicService.subTypeQuery(dicType);
		}else {
			list = subTypeDicService.subTypeQuery(null);
		}
		
		return ResponseData.ok().putDataValue("res", list);
	}
	
	/**
	 * 子类-添加
	 * @param subTypeDic
	 * @return
	 */
	@RequestMapping(value="/subTypeAdd", method={RequestMethod.POST})
	@ResponseBody
	public ResponseData subTypeAdd(@RequestBody NtDictionariesKey subTypeDic){
		try{
			//数据库操作成功数
			int id = subTypeDicService.subTypeAdd(subTypeDic);
			if(id > 0){
				return ResponseData.ok().putDataValue("res", "子类添加成功");
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
	 * 子类-单条删除
	 * @param dicCode
	 * @return
	 */
	@RequestMapping(value="subTypeDelete", method={RequestMethod.POST})
	@ResponseBody
	public ResponseData subTypeDelete(String dicCode){
		try{
			int id = subTypeDicService.subTypeDelete(dicCode);
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
	
	/**
	 * 子类-根据所属类别批量删除
	 * @param dicType
	 * @return
	 */
	@RequestMapping(value="subTypeDeleteByDicType", method={RequestMethod.POST})
	@ResponseBody
	public ResponseData subTypeDeleteByDicType(String dicType){
		try{
			int id = subTypeDicService.subTypeDeleteByDicType(dicType);
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
