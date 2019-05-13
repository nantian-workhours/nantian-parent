/**
 * @Description: 员工考勤异常处理申请管理
 * @ClassName: NtPersonnelApplyController
 * @author： Mr.Kong
 * @date: 2019/5/13 16:48
 * @Version： 1.0
 */
package cn.com.nantian.controller;

import cn.com.nantian.pojo.NtPersonnelApply;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.service.NtPersonnelApplyService;
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

@Controller
@RequestMapping("/person/apply")
public class NtPersonnelApplyController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(NtPersonnelApplyController.class);

    @InitBinder("ntPersonnelApply")
    public void initBindNtPersonnelApply(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.setFieldDefaultPrefix("ntPersonnelApply.");
    }

    @Resource
    private NtPersonnelApplyService personnelApplyService;

    @RequestMapping("/add")
    @ResponseBody
    public ResponseData addApply(@ModelAttribute("ntPersonnelApply") NtPersonnelApply ntPersonnelApply){
        try {
            int a=personnelApplyService.insert(ntPersonnelApply);
            return null;
        } catch (Exception e) {
            logger.error("NtPersonnelApplyController.addApply", e);
            return ResponseData.serverInternalError();
        }
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public ResponseData findAll(@ModelAttribute("ntPersonnelApply") NtPersonnelApply ntPersonnelApply){
        try {
            return ResponseData.ok().putDataValue("data",null);
        } catch (Exception e) {
            logger.error("NtPersonnelApplyController.findAll", e);
            return ResponseData.serverInternalError() ;
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResponseData update(@ModelAttribute("ntPersonnelApply") NtPersonnelApply ntPersonnelApply){
        try {
             int a = personnelApplyService.updateByPrimaryKey(ntPersonnelApply);
             return ResponseData.ok().putDataValue("修改成功",a);
        } catch (Exception e) {
            logger.error("NtPersonnelApplyController.update", e);
            return ResponseData.serverInternalError().putDataValue("", e.toString());
        }
    }

}
