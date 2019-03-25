package cn.com.nantian.controller;

/**
 * Created by ydz on 2019/3/20
 */


import cn.com.nantian.common.ParamUntil;
import cn.com.nantian.pojo.NtDictionariesKey;
import cn.com.nantian.pojo.NtPerAlias;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.pojo.entity.ResultData;
import cn.com.nantian.service.WorkHoursService;
import com.alibaba.druid.util.StringUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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
    /**
     * 导入工时
     * @param myfile
     * @return
     */
    @RequestMapping("/importExcel")
    @ResponseBody
    public ResponseData importProcess(HttpServletRequest request, @RequestParam("myFile") MultipartFile myfile ,String custType) {
        File tempFile =new File( ParamUntil.excelPath1+"\\"+myfile.getOriginalFilename());
        //判断文件是否已经存在
        if( tempFile.exists() ){
             return ResponseData.isfailed().putDataValue("data","The file has been imported");
        }else{

        if (myfile != null){
            String filename=myfile.getOriginalFilename();
            String a=request.getRealPath("D:/item");
            try {
                //将数据查入到库中
                Map<String ,Object> resultMap = workHoursService.importImportExcel(myfile,custType);
                //保存到服务器的路径
                SaveFileFromInputStream(myfile.getInputStream(),a,filename);
                if (!resultMap.isEmpty()) {
                    return ResponseData.ok().putDataValue("code",resultMap);
                } else {
                    return ResponseData.isfailed().putDataValue("data","Upload data is empty");
                }
            } catch (IOException e) {
                return ResponseData.isfailed().putDataValue("data","Upload data is empty");
            }
        }else{
          return ResponseData.isfailed().putDataValue("data","Upload data is empty");
        }

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

    }



