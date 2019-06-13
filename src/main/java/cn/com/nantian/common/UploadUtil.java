/**
 * @Description:
 * @ClassName: UploadUtil
 * @author： Mr.Kong
 * @date: 2019/6/12 10:36
 * @Version： 1.0
 */
package cn.com.nantian.common;


import cn.com.nantian.pojo.NtPersonnel;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UploadUtil {

    public static Map<String,Object> doFileUpload(MultipartFile srcFile, String path) throws IOException{
        /*
         * 注意:传入参数时，文件的注解@ReuqestParam("variable") -->variable指:前端的h5的控件的name值.
         * 文件处理功能: 1.将获取的字节数组转化为文件对象，并保存在本地目录中;
         * 文件处理思路: 1.将获取的(source)file对象，通过函数获取字节数组；
         * 				2.实例化文件对象和文件输出流；
         * 				3.将字节数组写入文件即可.
         * 功能难度: 简单.
         */
        //1.变量声明
        Map<String,Object> result = null;// 返回结果变量
        FileOutputStream fos = null; 	//写入文件的变量
        File destFile = null;	//写入的目的地文件(distination)
        try {
            result = new HashMap<String,Object>();
            //2.参数验证
            if(srcFile == null){
                result.put( "code", "F");
                result.put( "msg", "上传文件不存在!");
                return result;
                //throw new RuntimeException("上传文件不存在!");
            }
            if(srcFile.getBytes().length == 0){
                result.put( "code", "F");
                result.put( "msg", "上传文件内容不能为空!");
                return result;
                //throw new RuntimeException("上传文件内容为空!");
            }
            boolean isSize = FileUtil.checkFileSize(srcFile.getSize(), 500, "K");
            if (!isSize){
                result.put( "code", "F");
                result.put( "msg", "上传文件不能超过500kb!");
                return result;
                //throw new RuntimeException("上传文件不超过500kb!");
            }
            //3.操作文件对象，写入本地目录的文件中
            //3.1 截取文件后缀
            String fileName = srcFile.getOriginalFilename().substring(srcFile.getContentType().lastIndexOf( ".")+1);
            String imageType = fileName.substring(fileName.indexOf(".")+1).trim();//逗号后面
            if (!imageType.equals("jpg") && !imageType.equals("png")){
                result.put( "code", "F");
                result.put( "msg", "只能上传jpg/png格式文件!");
                return result;
            }
            //3.2 实例化目标文件，根据当前的操作系统，指定目录文件,
            String key = DateUtils.dateToStr(new Date(), "yyyyMMddHHmmss");
            destFile = new File(path+File.separator+ParamUntil.imagePath+File.separator+key+"."+imageType);
            //3.3 实例化流
            fos = new FileOutputStream(destFile);
            //3.4 获取写入的字节数组,并写入文件
            byte[] srcBytes = srcFile.getBytes();
            fos.write(srcBytes);
            fos.flush();
            //4.对输入、输出流进行统一管理
            //已在文件finally代码块处理
            result.put( "code", "S");
            result.put( "msg", "服务调用成功");
            result.put( "path", destFile.getAbsolutePath());
            result.put( "imagePath",File.separator+ParamUntil.imagePath+File.separator+key+"."+imageType);
            String imageName = fileName.substring(0, fileName.lastIndexOf("."));
            result.put( "imageName", imageName);
            return result;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            result = new HashMap<String,Object>();
            result.put( "code", "F");
            result.put( "msg", "服务调用失败");
            result.put( "path", null);
            return result;
        } finally{
            //关闭系统资源,避免占用资源.
            if(fos != null){
                fos.close();
            }
        }
    }

    public static Map<String, String> upload(HttpServletRequest request,
                                             int maxSize, String path) {
        //以map形式保存数据 key对应保存的是获取界面上的name名称 value保存的是获取界面上的name对应的值
        Map<String, String> map = new HashMap<String, String>();
        Part part = null;
        try {
            MultipartParser mrequest = new MultipartParser(request, maxSize);
            mrequest.setEncoding("utf-8");
            //遍历所有的part组
            while ((part = mrequest.readNextPart()) != null) {
                if (part.isFile()) {  //判断是否是文件

                    FilePart filepart = (FilePart) part;//转化成文件组

                    String fileName = filepart.getFileName();//得到文件名

                    if (fileName != null && fileName.length() > 0) {
                        // 取得扩展名
                        String fileExtName = fileName.substring(
                                fileName.lastIndexOf(".") + 1).toLowerCase();
                        // 只上传图片  //判断图片上传的格式是否符合 后缀名是否有效
                        if (fileExtName.equalsIgnoreCase("jpeg")
                                || fileExtName.equalsIgnoreCase("png")||
                                fileExtName.equalsIgnoreCase("jpg")
                                || fileExtName.equalsIgnoreCase("gif")
                                || fileExtName.equalsIgnoreCase("ico")
                                || fileExtName.equalsIgnoreCase("bmp")
                                || fileExtName.equalsIgnoreCase("flv")
                                || fileExtName.equalsIgnoreCase("mp4")
                                || fileExtName.equalsIgnoreCase("mp3")) {


                            /*String newFileName = new Date().getTime() + "."+ fileExtName;//重新改文件名  文件名+扩展名 */

                            String newFileName =new Date().getTime() +fileName;//不改图片名字

                            String newPath = path + "/" + newFileName; //文件处理文件上传的路径
                            File newFile = new File(newPath);

                            filepart.writeTo(newFile);  //将文件真正写入到对应的文件夹中

                            //filepart.getName()  得到 request 要接收的参数的名字

                            map.put(filepart.getName(), newFileName);//把文件信息保存到map中
                            map.put("newFile", newFile.toString());
                        } else {
                            map.put("geshi", "geshi");
                            continue;
                        }// 说明上传的不是图片
                    } else {

                        map.put("yes","yes");

                        continue; // 说明没有选择上传图片
                    }

                } else if (part.isParam()) {  //判断是否是参数
                    ParamPart paramPart = (ParamPart) part;
                    map.put(paramPart.getName(), paramPart.getStringValue());

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
