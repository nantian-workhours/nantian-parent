package cn.com.nantian.controller;


import cn.com.nantian.pojo.NtCustTypeKey;

import cn.com.nantian.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

//客户管理
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;


    //新增客户信息内容NT_PROJECT_INFO
    @RequestMapping("/add")
    @ResponseBody
    public  void addCustomer(String projectName, String jobAdress,String jobLeadMan,String custType,String deptName){

        //customerService.addCustomer(deptName,customerName,projectName, jobAdress, projectCharge);

    }

    //新增客户类别管理
//    @RequestMapping("addtype")
//    @ResponseBody
//    public Result addType(String projectName,Map<String ,String> type,String leave){
//        try {
//            customerService.addCustType(projectName,type,leave);
//            return new Result(true, "添加成功");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new Result(false, "添加失败");
//        }
//

//    }





}
