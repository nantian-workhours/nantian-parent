package cn.com.nantian.service;

import cn.com.nantian.pojo.NtPerAlias;
import cn.com.nantian.pojo.NtWorkingHours;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Map;

//工时管理类
public interface WorkHoursService {



    /**
     * 导入工时
     * @param myfile
     * @return
     */
    Map<String ,Object> importExcel(MultipartFile myfile , String custType);



//    NtPerAlias getAliasByCustType(String custType, String name);


    /**
     * 可以查询所有员工工时信息
     * @param perId
     * @param custType
     * @param startDate
     * @param endDate
     * @return
     */
    Map<Object,Object>  findAllWorkHours(int  perId, String custType, Date startDate,Date endDate);


}
