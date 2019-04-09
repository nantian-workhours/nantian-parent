package cn.com.nantian.controller;

import cn.com.nantian.pojo.NtDictionariesKey;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.service.DictionariesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ydz on 2019/4/9
 */

@Controller
@RequestMapping("/dictionaries")
public class DictionariesController {


    @Resource
    private DictionariesService dictionariesService;


    /**
     * 根据类别,编码 查询字典数据
     * @param dicType
     * @param dicCode
     * @return
     */
    @RequestMapping(value = "/select" )
    @ResponseBody
    public ResponseData selectDictionaries(String dicType, String dicCode){
       try{
        //查询类别值
            NtDictionariesKey dictionariesKey = dictionariesService.selectDictionaries(dicType,dicCode);
            return ResponseData.ok().putDataValue("data",dictionariesKey);
        } catch (Exception e) {
            //被禁止
            return ResponseData.serverInternalError().putDataValue("",e.toString() );
        }
    }

    /**
     *根据类别查询
     * @param dicType
     * @return
     */
    @RequestMapping(value = "/selectbytype" )
    @ResponseBody
    public ResponseData selectDictionaries(String dicType ){
        try{
            //查询类别值
            List<NtDictionariesKey> dictionariesKeyList = dictionariesService.selectDictionariesByType(dicType);
            return ResponseData.ok().putDataValue("data",dictionariesKeyList);
        } catch (Exception e) {
            //被禁止
            return ResponseData.serverInternalError().putDataValue("",e.toString() );
        }
       }
    }
