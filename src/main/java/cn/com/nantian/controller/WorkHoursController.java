package cn.com.nantian.controller;

/**
 * Created by ydz on 2019/3/20
 */


import cn.com.nantian.common.ObjectUtils;
import cn.com.nantian.common.ParamUntil;
import cn.com.nantian.pojo.NtDictionariesKey;
import cn.com.nantian.pojo.NtPerAlias;
import cn.com.nantian.pojo.NtPersonnel;
import cn.com.nantian.pojo.NtWorkingHours;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.pojo.entity.ResultData;
import cn.com.nantian.service.UserService;
import cn.com.nantian.service.WorkHoursService;
import com.alibaba.druid.util.StringUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 工时管理
 */
@Controller
@RequestMapping("workhours")
public class WorkHoursController {


    @Resource
    private WorkHoursService workHoursService;
    @Resource
    private UserService userService;


    /**
     * 导入工时
     * @param myfile
     * @return
     */
    @RequestMapping("/importExcel")
    @ResponseBody
    public ResponseData importProcess(HttpServletRequest request, @RequestParam("myFile") MultipartFile myfile ,String custType,String jurisdiction) {
        //获取登录人的姓名
//        String loginName = SecurityContextHolder.getContext().getAuthentication().getName();
        //判断权限是否许可
        if(Integer.valueOf(jurisdiction) <= 1){

            File tempFile =new File( ParamUntil.excelPath1+"\\"+myfile.getOriginalFilename());
            if (myfile != null){
                    String filename=myfile.getOriginalFilename();
                    String a=request.getRealPath("D:/item");//这个没用 ,直接修改配置文件中的路径就可以了
                    try {
                        //将数据查入到库中
                        Map<String ,Object> resultMap = workHoursService.importExcel(myfile,custType);
                        if (!resultMap.isEmpty()) {
                            if(tempFile.exists()){
                                return ResponseData.ok().putDataValue("code",resultMap);
                            }else{
                                //保存到服务器的路径
                                SaveFileFromInputStream(myfile.getInputStream(),a,filename);
                                return ResponseData.ok().putDataValue("code",resultMap);
                            }
                        } else {
                            return ResponseData.isfailed().putDataValue("data","Upload data is empty");
                        }
                    } catch (IOException e) {
                        return ResponseData.isfailed().putDataValue("data",e.toString());
                    }
                }else{
                    return ResponseData.isfailed().putDataValue("data","Upload data is empty");
                }


        }else{
            return ResponseData.forbidden();
        }


   }




    @RequestMapping("/select")
    @ResponseBody
    public ResponseData iocess(String custType,String name) {
//       NtPerAlias perAlias =  workHoursService.getAliasByCustType(custType,name);

        return ResponseData.ok().putDataValue("",null);
    }


    /**

     * 将MultipartFile转化为file并保存到服务器上的某地

     */

    public void SaveFileFromInputStream(InputStream stream, String path, String savefile)  {

        try {
            FileOutputStream fs=new FileOutputStream( ParamUntil.excelPath + "/"+ savefile);
            byte[] buffer =new byte[1024*1024];
            int bytesum = 0;
            int byteread = 0;
            while ((byteread=stream.read(buffer))!=-1)
            {
                bytesum+=byteread;
                fs.write(buffer,0,byteread);
                fs.flush();
            }
            fs.close();

            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 查询工时
     * @param perId 员工id
     * @param custType 客户类别
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @param jurisdiction 当前查询员工的权限
     * @return
     */
    @RequestMapping("/selectworkhours")
    @ResponseBody
    public ResponseData selectWorkHours(int perId, String custType, Date startDate,Date endDate,String jurisdiction) {
        //获取登录人的姓名
        String loginName = SecurityContextHolder.getContext().getAuthentication().getName();

        //判断员工权限
        if(Integer.valueOf(jurisdiction) ==1 || Integer.valueOf(jurisdiction) ==0){//管理员权限,查询所有
            List<NtWorkingHours> workingHoursList = workHoursService.findAllWorkHours(perId,custType,startDate,endDate);


        }else{//普通员工权限,查询自己
//            workHoursService.selectWorkHoursByPerId(perId,custType,startDate,endDate);

        }

        return ResponseData.ok().putDataValue("",null);
    }


    }



