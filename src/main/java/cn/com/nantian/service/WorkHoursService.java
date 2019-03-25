package cn.com.nantian.service;

import cn.com.nantian.pojo.NtPerAlias;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Map;

//工时管理类
public interface WorkHoursService {

    String getWorkerHours(String userName ,String projectName , Date start,Date end);

    /**
     * 导入工时
     * @param myfile
     * @return
     */
    Map<String ,Object> importImportExcel(MultipartFile myfile , String custType);



//    NtPerAlias getAliasByCustType(String custType, String name);
}
