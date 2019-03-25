package cn.com.nantian.controller;


import cn.com.nantian.pojo.NtDictionariesKey;
import cn.com.nantian.pojo.NtTypeDictionaries;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.service.SystemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.security.Provider;
import java.util.List;

@Controller
@RequestMapping("/system")
public class SystemController {

    @Resource
    private SystemService systemService;

    /**
     * 添加系统参数类别
     * @param typeDictionaries
     * @return
     */
    @RequestMapping("/addparam")
    @ResponseBody
    public ResponseData addParamCate(@RequestBody NtTypeDictionaries typeDictionaries){
        try {
            int d = systemService.addParamCate(typeDictionaries);
            return ResponseData.ok().putDataValue("add number ",d);
        }catch (NullPointerException e) {
            //系统异常
            return ResponseData.serverInternalError();
        }catch (IllegalArgumentException e) {
            //没有权限
            return ResponseData.unauthorized();
        } catch (Exception e) {
            //被禁止
            return ResponseData.forbidden();
        }
    }

    /**
     * 查询参数列表
     * @return
     */
    @RequestMapping("/seleteparam")
    @ResponseBody
    public ResponseData selectTypeDict(){
        List<NtTypeDictionaries> list =null;
        try {
            list = systemService.selectTypedict();
            return ResponseData.ok().putDataValue("data",list);
        }catch (NullPointerException e) {
            //系统异常
            return ResponseData.serverInternalError();
        }catch (IllegalArgumentException e) {
            //没有权限
            return ResponseData.unauthorized();
        } catch (Exception e) {
            //被禁止
            return ResponseData.forbidden();
        }
    }


    /**
     * 根据参数类型,和参数code查询参数值
     * @param dicType

     * @return
     */
    @RequestMapping("/seletevalues")
    @ResponseBody
    public ResponseData selectSysParam(String dicType){

        try {
            List<NtDictionariesKey> values = systemService.selectValue(dicType);
            return ResponseData.ok().putDataValue("data",values);

        } catch (Exception e) {
            //错误
            return ResponseData.serverInternalError();
        }
    }


}
