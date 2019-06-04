/**
 * @description: 员工考勤异常处理申请管理
 * @ClassName: NtPersonnelApplyController
 * @author： Mr.Wind
 * @date: 2019/5/13 16:48
 * @Version： 1.0
 */
package cn.com.nantian.controller;

import cn.com.nantian.common.DateUtils;
import cn.com.nantian.common.StringUtils;
import cn.com.nantian.pojo.NtPersonnelApply;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.service.NtPersonnelApplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/person/apply")
public class NtPersonnelApplyController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(NtPersonnelApplyController.class);

    @InitBinder("ntPersonnelApply")
    public void initBindNtPersonnelApply(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.setFieldDefaultPrefix("ntPersonnelApply.");
    }

    @Resource
    private NtPersonnelApplyService personnelApplyService;

    /**
     * @description: 创建员工异议申请
     * @auther: Mr.Wind
     * @date: 2019/5/14 15:14
     * @param: [personnelApply]
     * @return: ResponseData
     **/
    @RequestMapping("/add")
    @ResponseBody
    public ResponseData addApply(@ModelAttribute("ntPersonnelApply") NtPersonnelApply personnelApply) {
        try {
            //效验传入的参数值
            String result = personnelApplyService.checkAttribute(personnelApply);
            if (StringUtils.isNotEmpty(result)) {
                return ResponseData.isfailed().putDataValue("error", result);
            }
            int a = personnelApplyService.insertSelective(personnelApply);
            return ResponseData.ok().putDataValue("添加成功", a);
        } catch (Exception e) {
            logger.error("NtPersonnelApplyController.addApply", e);
            return ResponseData.serverInternalError();
        }
    }

    /**
     * @description: 查询员工异议申请信息列表
     * @auther: Mr.Wind
     * @date: 2019/5/14 15:15
     * @param: [ntPersonnelApply]
     * @return: ResponseData
     **/
    @RequestMapping("/findAll")
    @ResponseBody
    public ResponseData findAll(@ModelAttribute("ntPersonnelApply") NtPersonnelApply ntPersonnelApply) {
        try {
            if (StringUtils.isNotEmpty(ntPersonnelApply.getApplyDateStr()) && DateUtils.checkDateReg(ntPersonnelApply.getApplyDateStr())) {
                ntPersonnelApply.setApplyDate(DateUtils.parseToDate(ntPersonnelApply.getApplyDateStr(), "yyyy-MM-dd"));
            }
            List<NtPersonnelApply> ntPersonnelApplies = personnelApplyService.queryPersonApplyList(ntPersonnelApply);
            return ResponseData.ok().putDataValue("data", ntPersonnelApplies);
        } catch (Exception e) {
            logger.error("NtPersonnelApplyController.findAll", e);
            return ResponseData.serverInternalError();
        }
    }

    /**
     * @description: 查询员工异议申请信息详情
     * @auther: Mr.Wind
     * @date: 2019/5/14 15:47
     * @param: [applySeq]
     * @return: ResponseData
     **/
    @RequestMapping("/findDetail")
    @ResponseBody
    public ResponseData findDetail(@RequestParam("applySeq") int applySeq) {
        try {
            NtPersonnelApply ntPersonnelApply = personnelApplyService.selectByPrimaryKey(applySeq);
            return ResponseData.ok().putDataValue("data", ntPersonnelApply);
        } catch (Exception e) {
            logger.error("NtPersonnelApplyController.findDetail", e);
            return ResponseData.serverInternalError();
        }
    }

    /**
     * @description: 更新处理状态
     * @auther: Mr.Wind
     * @date: 2019/5/14 15:46
     * @param: [ntPersonnelApply]
     * @return: ResponseData
     **/
    @RequestMapping("/update")
    @ResponseBody
    public ResponseData update(@ModelAttribute("ntPersonnelApply") NtPersonnelApply ntPersonnelApply) {
        try {
            int a = personnelApplyService.updateApplyStatus(ntPersonnelApply);
            return ResponseData.ok().putDataValue("修改成功", a);
        } catch (Exception e) {
            logger.error("NtPersonnelApplyController.update", e);
            return ResponseData.serverInternalError().putDataValue("", e.toString());
        }
    }
}
