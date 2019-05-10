/**
 * @Description: 节假日信息管理
 * @ClassName: NtHolidayController
 * @author： Mr.Kong
 * @date: 2019/5/10 14:03
 * @Version： 1.0
 */
package cn.com.nantian.controller;

import cn.com.nantian.common.ObjectUtils;
import cn.com.nantian.common.StringUtils;
import cn.com.nantian.pojo.NtHoliday;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.service.NtHolidayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/holiday")
public class NtHolidayController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(NtHolidayController.class);

    @InitBinder("ntHoliday")
    public void initBindNtHoliday(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.setFieldDefaultPrefix("ntHoliday.");
    }

    @Resource
    private NtHolidayService holidayService;


    @RequestMapping("/add")
    @ResponseBody
    public ResponseData addNtHoliday(@ModelAttribute("ntHoliday") NtHoliday ntHoliday) {
        try {
            String result = holidayService.checkAttribute(ntHoliday);
            if (StringUtils.isNotEmpty(result)) {//判断属性值是否为空
                return ResponseData.isfailed().putDataValue("error", result);
            }
            boolean repeat = holidayService.checkWhetherRepeat(ntHoliday);
            if (repeat) {//判断是否存在重复数据
                return ResponseData.isfailed().putDataValue("error", "数据已存在，请修改！");
            } else {
                int id = holidayService.insert(ntHoliday);
                return ResponseData.ok().putDataValue("success", id);
            }
        } catch (Exception e) {
            logger.error("NtHolidayController.addNtHoliday", e);
            return ResponseData.forbidden();
        }
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public ResponseData findAll(@ModelAttribute("ntHoliday") NtHoliday ntHoliday){
        try {
            List<NtHoliday> holidayList = holidayService.queryHolidayList(ntHoliday);
            return ResponseData.ok().putDataValue("data",holidayList);
        } catch (Exception e) {
            logger.error("NtHolidayController.findAll", e);
            return ResponseData.serverInternalError() ;
        }
    }

    @RequestMapping("/findInfo")
    @ResponseBody
    public ResponseData findInfo(@RequestParam("holidayId") int holidayId){
        try {
            NtHoliday holiday = holidayService.selectByPrimaryKey(holidayId);
            return ResponseData.ok().putDataValue("data",holiday);
        } catch (Exception e) {
            logger.error("NtHolidayController.findInfo", e);
            return ResponseData.serverInternalError() ;
        }
    }


    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(@RequestParam("holidayId") int holidayId) {
        try {
            int num = holidayService.deleteByPrimaryKey(holidayId);
            return ResponseData.ok().putDataValue("delete number", num);
        } catch (Exception e) {
            logger.error("NtHolidayController.delete", e);
            return ResponseData.forbidden();
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResponseData updateNtHoliday(@ModelAttribute("ntHoliday") NtHoliday ntHoliday){
        try {
            //效验传入参数值
            String result=holidayService.checkAttribute(ntHoliday);
            if (ObjectUtils.isNull(ntHoliday.getHolidayId())){
                result="主键id 不能为空！";
            }
            if (StringUtils.isNotEmpty(result)){
                return ResponseData.isfailed().putDataValue("error",result);
            }
            //效验数据是否已存在
            boolean repeat=holidayService.checkUpdateWhetherRepeat(ntHoliday);
            if (repeat){
                return ResponseData.isfailed().putDataValue("error","数据已存在 请修改！");
            }else{
                int a = holidayService.updateByPrimaryKeySelective(ntHoliday);
                return ResponseData.ok().putDataValue("修改成功",a);
            }
        } catch (Exception e) {
            logger.error("NtHolidayController.updateNtHoliday", e);
            return ResponseData.serverInternalError().putDataValue("", e.toString());
        }
    }
}
