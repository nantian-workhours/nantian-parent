package cn.com.nantian.controller;

import cn.com.nantian.common.StringUtils;
import cn.com.nantian.pojo.NtPerAlias;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.service.ProjectNameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 别名管理(项目组中的名字)
 */
@Controller
@RequestMapping("/other/name")
public class ProjectNameController {
    private static final Logger logger = LoggerFactory.getLogger(ProjectNameController.class);

    @InitBinder("ntPerAlias")
    public void initBindNtPerAlias(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.setFieldDefaultPrefix("ntPerAlias.");
    }

    @Resource
    private ProjectNameService projectNameService;

    /**
     * @description: 添加项目别名
     * @auther: Mr.Wind
     * @date: 2019/5/8 11:01
     * @Param: [ntPerAlias]
     * @return: ResponseData
     **/
    @RequestMapping("/add")
    @ResponseBody
    public ResponseData addProjectName(@ModelAttribute("ntPerAlias") NtPerAlias ntPerAlias) {
        try {
            //效验传入的参数是否为空
            String result = projectNameService.checkAttribute(ntPerAlias);
            if (StringUtils.isNotEmpty(result)) {
                return ResponseData.isfailed().putDataValue("error", result);
            }
            //效验是否已存在
            boolean repeat = projectNameService.checkWhetherRepeat(ntPerAlias);
            if (repeat) {
                return ResponseData.isfailed().putDataValue("error", "数据已存在 请修改！");
            } else {
                int a = projectNameService.addProjectName(ntPerAlias);
                return ResponseData.ok().putDataValue("success", a);
            }
        } catch (Exception e) {
            logger.error("ProjectNameController.addProjectName", e);
            return ResponseData.serverInternalError();
        }
    }

    /**
     * @description: 查询员工别名列表
     * @auther: Mr.Wind
     * @date: 2019/5/8 16:20
     * @Param: [ntPerAlias]
     * @return: ResponseData
     **/
    @RequestMapping("/findAll")
    @ResponseBody
    public ResponseData queryNtPerAliasList(@ModelAttribute("ntPerAlias") NtPerAlias ntPerAlias) {
        try {
            //根据姓名,身份证号  或者客户类型查询信息
            List<NtPerAlias> perAliasList = projectNameService.queryNtPerAliasList(ntPerAlias);
            return ResponseData.ok().putDataValue("data", perAliasList);
        } catch (Exception e) {
            logger.error("ProjectNameController.queryNtPerAliasList", e);
            return ResponseData.serverInternalError();
        }
    }

    /**
     * @description: 根据员工身份证号, 别名删除员工别名信息
     * @auther: Mr.Wind
     * @date: 2019/5/8 16:20
     * @Param: [idNo]
     * @return: ResponseData
     **/
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData deleteOtherName(@RequestParam("idNo") String idNo) {
        try {
            int a = projectNameService.deleteByIdNo(idNo);
            return ResponseData.ok().putDataValue("success", a);
        } catch (Exception e) {
            logger.error("ProjectNameController.deleteOtherName", e);
            return ResponseData.serverInternalError();
        }
    }

    /**
     * @description: 修改别名信息
     * @auther: Mr.Wind
     * @date: 2019/5/8 16:20
     * @Param: [ntPerAlias]
     * @return: ResponseData
     **/
    @RequestMapping("/update")
    @ResponseBody
    public ResponseData updateOtherName(@ModelAttribute("ntPerAlias") NtPerAlias ntPerAlias) {
        try {
            //效验传入的参数是否为空
            String result = projectNameService.checkAttribute(ntPerAlias);
            if (StringUtils.isNotEmpty(result)) {
                return ResponseData.isfailed().putDataValue("error", result);
            }
            //效验是否已存在
            boolean repeat = projectNameService.checkUpdateWhetherRepeat(ntPerAlias);
            if (repeat) {
                return ResponseData.isfailed().putDataValue("error", "数据已存在 请修改！");
            } else {
                int a = projectNameService.updateNtPerAlias(ntPerAlias);
                return ResponseData.ok().putDataValue("success", a);
            }
        } catch (Exception e) {
            logger.error("ProjectNameController.updateOtherName", e);
            return ResponseData.serverInternalError();
        }
    }
}
