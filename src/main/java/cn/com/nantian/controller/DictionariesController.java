package cn.com.nantian.controller;

import cn.com.nantian.pojo.NtDictionariesKey;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.service.DictionariesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by ydz on 2019/4/9
 */

@Controller
@RequestMapping("/dictionaries")
public class DictionariesController {
    private static final Logger logger = LoggerFactory.getLogger(DictionariesController.class);
    @InitBinder("dictionaries")
    public void initBindDictionaries(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.setFieldDefaultPrefix("dictionaries.");
    }
    @Resource
    private DictionariesService dictionariesService;


    /**
      * @description: 查询字典列表数据
      * @auther: Mr.Wind
      * @date: 2019/5/6 10:40
      * @Param:  [dictionaries]
      * @return: ResponseData
      **/
    @RequestMapping(value = "/list" )
    @ResponseBody
    public ResponseData queryDictionariesList(@ModelAttribute("dictionaries")NtDictionariesKey dictionaries){
        try{
            List<NtDictionariesKey> dictionariesList = dictionariesService.selectDictionariesList(dictionaries);
            return ResponseData.ok().putDataValue("data",dictionariesList);
        } catch (Exception e) {
            logger.error("DictionariesController.queryDictionariesList",e);
            return ResponseData.serverInternalError().putDataValue("",e.toString() );
        }
    }


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
