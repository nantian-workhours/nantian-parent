package cn.com.nantian.service;

import cn.com.nantian.pojo.NtWorkingHours;
import cn.com.nantian.pojo.NtWorkingHoursKey;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Map;

//工时管理类
public interface WorkHoursService {

    public NtWorkingHours queryUserWorkHours(int perId,Date workDate);


    NtWorkingHours queryUserWorkHours(NtWorkingHoursKey key);

    /**
      * @description: 查询本月加班总小时数
      * @auther: Mr.Wind
      * @date: 2019/6/11 10:35
      * @param:  [key]
      * @return: Float
      **/
    Float queryMonthWorkHours(NtWorkingHoursKey key);

    /**
      * @description: 查询本月正常上班总天数
      * @auther: Mr.Wind
      * @date: 2019/6/11 10:36
      * @param:  [key]
      * @return: int
      **/
    int queryMonthWorkDays(NtWorkingHoursKey key);


    /**
     * 工时统计
     * @param custType
     * @param startDate
     * @param endDate
     * @return
     */
      Map<Object,Object> statisticsWorkHours( String custType,Date startDate, Date endDate);
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
    Map<Object,Object>  findAllWorkHours(Integer  perId, String custType, Date startDate,Date endDate);

    /**
     * 修改工时
     * @param workingHours
     * @return
     */
    int  updateWorkHours(NtWorkingHours workingHours);

}
