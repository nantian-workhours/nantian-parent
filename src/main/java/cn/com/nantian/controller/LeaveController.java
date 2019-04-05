/**
 * @Description: 请假信息管理
 * @ClassName: LeaveController
 * @Author： Mr.Kong
 * @Date: 2019/3/29 15:02
 * @Version： 1.0
 */
package cn.com.nantian.controller;

import cn.com.nantian.common.ParamUntil;
import cn.com.nantian.pojo.NtLeave;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.service.LeaveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Controller
public class LeaveController {

    private static final Logger logger = LoggerFactory.getLogger(LeaveController.class);

    @Resource
    private LeaveService leaveService;

    @InitBinder("ntLeave")
    public void initBindNtLeave(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.setFieldDefaultPrefix("ntLeave.");
    }

    /**
     * @Description: 查询请假信息列表 1
     * @Auther: Mr.Kong
     * @Date: 2019/3/29 15:55s
     * @Param: [leave]
     * @Return: cn.com.nantian.pojo.entity.ResponseData
     **/
    @RequestMapping("/ntLeave/findAll")
    @ResponseBody
    public ResponseData findAll(@ModelAttribute("ntLeave") NtLeave leave) {
        try {
            List<NtLeave> leaveList = leaveService.selectLeaveList(leave);
            leaveService.setLeaveTypeName(leaveList);
            return ResponseData.ok().putDataValue("data", leaveList);
        } catch (Exception e) {
            logger.error("LeaveController.findAll", e);
            return ResponseData.forbidden();
        }
    }

    /**
     * @Description: 请假申请录入
     * @Auther: Mr.Kong
     * @Date: 2019/3/29 15:45
     * @Param: [leave]
     * @Return: cn.com.nantian.pojo.entity.ResponseData
     **/
    @RequestMapping("/ntLeave/add")
    @ResponseBody
    public ResponseData insert(@ModelAttribute("ntLeave") NtLeave leave) {
        try {
            int id = leaveService.insertSelective(leave);
            return ResponseData.ok().putDataValue(" Add success num ", id);
        } catch (Exception e) {
            logger.error("LeaveController.insert", e);
            return ResponseData.forbidden();
        }
    }

    /**
     * @Description: 更新审批状态(R 审核中, Y 通过, N 退回)
     * @Auther: Mr.Kong
     * @Date: 2019/3/29 15:50
     * @Param: [leave]
     * @Return: cn.com.nantian.pojo.entity.ResponseData
     **/
    @RequestMapping("/ntLeave/update")
    @ResponseBody
    public ResponseData update(@ModelAttribute("ntLeave") NtLeave leave) {
        try {
            int d = leaveService.updateLeaveStatus(leave);
            return ResponseData.ok().putDataValue("update number", d);
        } catch (Exception e) {
            logger.error("LeaveController.update", e);
            return ResponseData.forbidden();
        }
    }

    /**
     * @Description: 导入请假信息
     * @Auther: Mr.Kong
     * @Date: 2019/4/1 17:08
     * @Param: [request, myfile]
     * @Return: cn.com.nantian.pojo.entity.ResponseData
     **/
    @RequestMapping("/ntLeave/importExcel")
    @ResponseBody
    public ResponseData importProcess(HttpServletRequest request, @RequestParam("myFile") MultipartFile myfile) {
        //判断权限是否许可
        File tempFile = new File(ParamUntil.excelPath1 + "\\" + myfile.getOriginalFilename());
        if (myfile != null) {
            String filename = myfile.getOriginalFilename();
            String a = request.getRealPath("D:/item");//这个没用 ,直接修改配置文件中的路径就可以了
            try {
                //将数据查入到库中
                Map<String, Object> resultMap = leaveService.importExcel(myfile);
                if (!resultMap.isEmpty()) {
                    if (tempFile.exists()) {
                        return ResponseData.ok().putDataValue("code", resultMap);
                    } else {
                        //保存到服务器的路径
                        SaveFileFromInputStream(myfile.getInputStream(), a, filename);
                        return ResponseData.ok().putDataValue("code", resultMap);
                    }
                } else {
                    return ResponseData.isfailed().putDataValue("data", "Upload data is empty");
                }
            } catch (IOException e) {
                return ResponseData.isfailed().putDataValue("data", e.toString());
            }
        } else {
            return ResponseData.isfailed().putDataValue("data", "Upload data is empty");
        }
    }

    /**
     * @Description: 将MultipartFile转化为file并保存到服务器上的某地
     * @Auther: Mr.Kong
     * @Date: 2019/4/1 17:09
     * @Param: [stream, path, savefile]
     * @Return: void
     **/
    public void SaveFileFromInputStream(InputStream stream, String path, String savefile) {

        try {
            FileOutputStream fs = new FileOutputStream(ParamUntil.excelPath + "/" + savefile);
            byte[] buffer = new byte[1024 * 1024];
            int bytesum = 0;
            int byteread = 0;
            while ((byteread = stream.read(buffer)) != -1) {
                bytesum += byteread;
                fs.write(buffer, 0, byteread);
                fs.flush();
            }
            fs.close();

            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
