package cn.com.nantian.service.impl;


import cn.com.nantian.common.ParamUntil;
import cn.com.nantian.mapper.*;
import cn.com.nantian.pojo.*;
import cn.com.nantian.pojo.entity.ProList;
import cn.com.nantian.service.WorkHoursService;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.sql.Time;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


//工时管理类
@Service
@Transactional
public class WorkHourceImpl implements WorkHoursService{

    @Resource
    private NtWorkingHoursMapper workingHoursMapper;

    @Resource
    private NtPerAliasMapper perAliasMapper;
    @Resource
    private  NtProjectInfoMapper projectInfoMapper;
    @Resource
    private NtWorkingHoursTmpMapper workingHoursTmpMapper;
    @Resource
    private NtHolidayMapper holidayMapper;
    @Resource
    private  NtPersonnelMapper personnelMapper;
    @Resource
    private NtPerInProjectMapper perInProjectMapper;




    @Override
    public  Map<Object,Object> statisticsWorkHours( String custType,Date startDate, Date endDate) {
        //初始化map
        Map<Object, Object> map = new HashMap<>();
        if (custType.equals(ParamUntil._3)) {//如果客户类型是中国人寿
            double days = 0.0;//初始化当月天数
            double daysHours = 0.0;//初始化当月工时数
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
                String startDateStr = sdf.format(startDate);
                String endDateStr = sdf.format(endDate);
                //获取两个时间之间的月份
                List<String> daysList = getMonthBetween(startDateStr, endDateStr);
                for (String strDate : daysList) {
                    float workTime = 0; //当月正常出勤工时
                    float addedHours = 0; //当月加班工时
                    int count = 0;

                    Map<Object, Object> workMap = new HashMap<>();
                    //将时间转化为每个月的1号
                    String strDateDay = strDate + "-01";
                    if (strDateDay != null) {
                        //获取这个月的开始时间和结束时间,返回一个数组
                        String[] strArrDate = getMonthStartAndEndDate(strDateDay);
                        //将字符串格式转化为date
                        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
                        Date mStartDate = simple.parse(strArrDate[0]);
                        Date mEndDate = simple.parse(strArrDate[1]);
                        //获取这个月的正常工作日天数
                        days = calLeaveDays(simple.parse(strArrDate[0]), simple.parse(strArrDate[1]));
                        List<NtWorkingHours> workingHoursList = null;
                        //获取当月工时数
                        daysHours = days * 8;
//                        if (perId == 0) {
                            workingHoursList = workingHoursMapper.selectByDate(mStartDate, mEndDate);
//                        } else {
//                            //查询每个月的工时信息列表
//                            workingHoursList = workingHoursMapper.selectByPerId(perId, mStartDate, mEndDate);
//                        }
                        Calendar cale = null;
                        cale = Calendar.getInstance();
                        Date datAll = sdf.parse(strDateDay);
                        cale.setTime(datAll);
                        int year = cale.get(Calendar.YEAR);
                        int month = cale.get(Calendar.MONTH) + 1;
                        String dateYear  = year+"-"+ month;
                        //循环工时
                        List<Float> list = new ArrayList<>();
                        List<Float> list1 = new ArrayList<>();

                        for (NtWorkingHours workingHours : workingHoursList) {
                            //签到时间迟到次数初始化
                            float workTimeOne = 0; //当月正常出勤工时
                            float addedHoursOne = 0; //当月加班工时

                            SimpleDateFormat simDf = new SimpleDateFormat("HH:mm");
                            //判断这一天是不是非工作日加班(例如:五一,周六,周天),如果是节假日加班就直接判断为节假日加班
                            int t = holidayMapper.countByDay(workingHours.getWorkDate());//判断这一天那是不是节假日
                            boolean flag = isWeekend(workingHours.getWorkDate());
                            if (t > 0 || flag) {//这一整天是节假日加班,
                                String strStartTime = null;
                                Date dateStartTime = null;
                                String strEndTime = null;
                                Date dateEndTime = null;

                                Date startTime = workingHours.getSigninTime();//签到时间
                                Date endTime = workingHours.getSignbackTime();//签退时间
                                if (startTime != null && endTime != null) {//处理签到时间
                                    strStartTime = simDf.format(startTime);
                                    dateStartTime = simDf.parse(strStartTime);//将时间格式转化
                                    strEndTime = simDf.format(endTime);
                                    dateEndTime = simDf.parse(strEndTime);//将时间格式转化
                                    long time = getDatePoor(dateStartTime, dateEndTime);
                                    //签到签退两个小时时间相减,不足一小时,舍去
                                    addedHoursOne += time;
                                    addedHours += time;
                                } else {
                                    addedHoursOne += 0;
                                }

                            } else {//否则就是工作日工时,正常处理
                                Date startTime = workingHours.getSigninTime();//签到时间
                                if (startTime != null) {//处理签到时间
                                    String strStartTime = simDf.format(startTime);
                                    Date dateStartTime = simDf.parse(strStartTime);//将时间格式转化
                                    if (dateStartTime.before(simDf.parse("09:00")) && dateStartTime.after(simDf.parse("05:00"))) {
                                        workTimeOne += 4;//如果签到时间在九点之前,五点之后,正常工时加4
                                        workTime += 4;
                                    } else if (dateStartTime.after(simDf.parse("09:00")) && dateStartTime.after(simDf.parse("10:00"))) {
                                        count++;//如果签到时间在九点之后,十点之前,次数加1
                                        if (count <= 3) {//如果九点之后签到的次数在九点之后超过三次就不算半天的工时
                                            workTimeOne += 4;
                                            workTime += 4;
                                        }
                                    } else {
                                        workTimeOne += 0;
                                        workTime += 0;
                                    }
                                }
                                Date endTime = workingHours.getSignbackTime();//签退时间
                                if (endTime != null) {//处理签退时间
                                    String strEndTime = simDf.format(endTime);
                                    Date dateEndTime = simDf.parse(strEndTime);//将时间格式转化
                                    if (dateEndTime.after(simDf.parse("17:00"))) {
                                        workTimeOne += 4;//签退时间在五点之后,正常工时加4
                                        workTime += 4;
                                    } else if (dateEndTime.after(simDf.parse("19:00"))) {
                                        long time = getDatePoor(simDf.parse("19:00"), dateEndTime);
                                        //签退时间在19:00之后,就是加班工时,不足一小时,舍去
                                        addedHoursOne += time;
                                        addedHours += time;
                                    } else {
                                        workTimeOne += 0;
                                        workTime += 0;
                                    }
                                }
                            }
                            list.add( workTimeOne );//添加每日正常工时
                            list1.add( addedHoursOne );//添加每日加班工时

                            //获取的日期中的日
                            Date date = workingHours.getWorkDate();
                            Calendar cal = Calendar.getInstance();
                            cal.clear();
                            cal.setTime(simple.parse(simple.format(date)));
//                            workMap.put(cal.get(Calendar.DAY_OF_MONTH),list);//添加平时工作日
//                            workMap.put(date,list);//添加平时工作日

                        }
                        float allH=0;//正常
                        float allA=0;//加班

                        //统计工时
                        for(int i=0;i<list.size();i++){
                            allH+=list.get(i);
                            allA+=list1.get(i);
                        }
                        workMap.put("allH", allH);
                        workMap.put("allA", allA);

                        if (workMap == null) {
                            workMap.put("workingHours", Math.floor(daysHours));//向下取整  当月工时数
                            workMap.put("custType", "中国人寿");
                            workMap.put("allHours", workTime);
                            workMap.put("addedHours", addedHours);
                        }
                        map.put(dateYear, workMap);

                    }
                }
                return map;
            } catch (ParseException e) {
                e.printStackTrace();
                return new HashMap<>();
            }

        } else if (custType.equals(ParamUntil._1)) {
            //如果客户类型是中国银行
            double days = 0.0;//初始化当月天数
            double daysHours = 0.0;//初始化当月工时数
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
                String startDateStr = sdf.format(startDate);
                String endDateStr = sdf.format(endDate);

                List<String> daysList = getMonthBetween(startDateStr, endDateStr);
                for (String strDate : daysList) {
                    float workTime = 0; //当月正常出勤工时
                    float addedHours = 0; //当月加班工时

                    Map<Object, Object> workMap = new HashMap<>();
                    //将时间转化为每个月的1号
                    String strDateDay = strDate + "-01";
                    if (strDateDay != null) {
                        //获取这个月的开始时间和结束时间,返回一个数组
                        String[] strArrDate = getMonthStartAndEndDate(strDateDay);
                        //将字符串格式转化为date
                        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
                        Date mStartDate = simple.parse(strArrDate[0]);
                        Date mEndDate = simple.parse(strArrDate[1]);
                        //获取这个月的正常工作日天数
                        days = calLeaveDays(simple.parse(strArrDate[0]), simple.parse(strArrDate[1]));
                        //获取当月工时数
                        daysHours = days * 8;
                        List<NtWorkingHours> workingHoursList = null;
//                        if (perId == 0) {
                            workingHoursList = workingHoursMapper.selectByDate(mStartDate, mEndDate);
//                        } else {
//                            workingHoursList = workingHoursMapper.selectByPerId(perId, mStartDate, mEndDate);
//                            //查询每个月的工时信息列表
//                        }
                        Calendar cale = null;
                        cale = Calendar.getInstance();
                        Date datAll = sdf.parse(strDateDay);
                        cale.setTime(datAll);
                        int year = cale.get(Calendar.YEAR);
                        int month = cale.get(Calendar.MONTH) + 1;
                        String dateYear  = year+"-"+ month;
                        //循环工时
                        List<Float> list = new ArrayList<>();
                        List<Float> list1 = new ArrayList<>();
                        for (NtWorkingHours workingHours : workingHoursList) {
                            list.add(workingHours.getNormalHours());//添加正常工时
                            list1.add(workingHours.getOvertimeHours());//添加加班工时
                            workTime += workingHours.getNormalHours();//正常工时累加

                            addedHours += workingHours.getOvertimeHours();//加班工时累加
//                            workMap.put(workingHours.getWorkDate(), list);//添加平时工作日

                        }
//                        float allH=0;//正常
//                        float allA=0;//加班

                        //统计工时
//                        for(int i=0;i<list.size();i++){
//                            allH+=list.get(i);
//                            allA+=list1.get(i);
//                        }
                        workMap.put("allH", workTime);
                        workMap.put("allA", addedHours);


                        if (workMap == null) {
//                            workMap.put("workingDays", Math.floor(days));//向下取整 当月天数
                            workMap.put("workingHours", Math.floor(daysHours));//向下取整  当月工时数
                            workMap.put("custType", "中国银行");
                            workMap.put("allHours", workTime);
                            workMap.put("addedHours", addedHours);
                        }

                        map.put(dateYear, workMap);

                    }
                }
                return map;
            } catch (ParseException e) {
                e.printStackTrace();
                return new HashMap<>();
            }
        }else {
            return new HashMap<>();
        }
    }













    /**
     * 根据主键(perId和日期)修改工时
     * @param
     * @return
     */
    @Override
    public int updateWorkHours(NtWorkingHours workingHours){
        int t =  workingHoursMapper.updateByPrimaryKey(workingHours);
        return t;
    }



    /**
     *
     * 查询工时
     * @param perId 查询的员工id
     * @param custType 客户类别
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return
     */
    public  Map<Object,Object> findAllWorkHours(Integer perId, String custType,Date startDate, Date endDate){
        //初始化map
        Map<Object, Object> map = new HashMap<>();
        if(custType.equals(ParamUntil._3)){//如果客户类型是中国人寿
            double days=0.0;//初始化当月天数
            double daysHours=0.0;//初始化当月工时数
            try {
                SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM");
                String startDateStr  = sdf.format(startDate);
                String endDateStr = sdf.format(endDate);
                //获取两个时间之间的月份
                List<String>  daysList =getMonthBetween(startDateStr,endDateStr);
                for (String strDate:daysList) {
                    float workTime =0; //当月正常出勤工时
                    float addedHours =0; //当月加班工时
                    int count =0;

                    Map<Object, Object> workMap = new HashMap<>();
                    //将时间转化为每个月的1号
                    String strDateDay =strDate+"-01";
                    if (strDateDay!=null) {
                        //获取这个月的开始时间和结束时间,返回一个数组
                        String[] strArrDate = getMonthStartAndEndDate(strDateDay);
                        //将字符串格式转化为date
                        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
                        Date mStartDate =simple.parse(strArrDate[0]);
                        Date mEndDate =simple.parse(strArrDate[1]);
                        //获取这个月的正常工作日天数
                        days = calLeaveDays(simple.parse(strArrDate[0]),simple.parse(strArrDate[1]));
                        List<NtWorkingHours> workingHoursList=null;
                                //获取当月工时数
                        daysHours = days * 8;
                        if(StringUtils.isEmpty(perId) ){
                            workingHoursList = workingHoursMapper.selectByDate(mStartDate,mEndDate);
                        }else{
                            //查询每个月的工时信息列表
                            workingHoursList = workingHoursMapper.selectByPerId(perId,mStartDate,mEndDate);
                        }

                        //循环工时
                        for (NtWorkingHours workingHours:workingHoursList) {
                            List<Float> list=new ArrayList<>();
                            //签到时间迟到次数初始化
                            float workTimeOne =0; //当月正常出勤工时
                            float addedHoursOne =0; //当月加班工时

                            SimpleDateFormat simDf = new SimpleDateFormat("HH:mm");
                            //判断这一天是不是非工作日加班(例如:五一,周六,周天),如果是节假日加班就直接判断为节假日加班
                           int t = holidayMapper.countByDay(workingHours.getWorkDate());//判断这一天那是不是节假日
                            boolean flag = isWeekend(workingHours.getWorkDate());
                            if(t>0 || flag){//这一整天是节假日加班,
                                String strStartTime = null;
                                Date dateStartTime = null;
                                String strEndTime = null;
                                Date dateEndTime =null;

                                Date startTime =workingHours.getSigninTime() ;//签到时间
                                Date endTime =workingHours.getSignbackTime() ;//签退时间
                                if (startTime!=null && endTime!=null) {//处理签到时间
                                      strStartTime = simDf.format(startTime);
                                      dateStartTime = simDf.parse(strStartTime);//将时间格式转化
                                      strEndTime = simDf.format(endTime);
                                      dateEndTime = simDf.parse(strEndTime);//将时间格式转化
                                    long time = getDatePoor(dateStartTime,dateEndTime);
                                    //签到签退两个小时时间相减,不足一小时,舍去
                                    addedHoursOne += time;
                                    addedHours += time;
                                }else{
                                    addedHoursOne += 0;
                                }

                            }else{//否则就是工作日工时,正常处理
                                Date startTime =workingHours.getSigninTime() ;//签到时间
                                if (startTime!=null) {//处理签到时间
                                    String strStartTime = simDf.format(startTime);
                                    Date dateStartTime = simDf.parse(strStartTime);//将时间格式转化
                                    if(dateStartTime.before(simDf.parse("09:00")) && dateStartTime.after(simDf.parse("05:00")) ){
                                        workTimeOne += 4;//如果签到时间在九点之前,五点之后,正常工时加4
                                        workTime += 4;
                                    }else if(dateStartTime.after(simDf.parse("09:00")) && dateStartTime.after(simDf.parse("10:00"))){
                                        count++;//如果签到时间在九点之后,十点之前,次数加1
                                        if(count<=3){//如果九点之后签到的次数在九点之后超过三次就不算半天的工时
                                            workTimeOne += 4;
                                            workTime += 4;
                                        }
                                    }else{
                                        workTimeOne += 0;
                                        workTime += 0;
                                    }
                                }
                                Date endTime =workingHours.getSignbackTime() ;//签退时间
                                if (endTime!=null) {//处理签退时间
                                    String strEndTime = simDf.format(endTime);
                                    Date dateEndTime = simDf.parse(strEndTime);//将时间格式转化
                                    if(dateEndTime.after(simDf.parse("17:00")) ){
                                        workTimeOne += 4;//签退时间在五点之后,正常工时加4
                                        workTime += 4;
                                    }else if(dateEndTime.after(simDf.parse("19:00")) ){
                                        long time = getDatePoor(simDf.parse("19:00"),dateEndTime);
                                        //签退时间在19:00之后,就是加班工时,不足一小时,舍去
                                        addedHoursOne += time;
                                        addedHours += time;
                                    }else{
                                        workTimeOne +=0;
                                        workTime +=0;
                                    }
                                }
                            }
                            list.add(0,workTimeOne);//添加每日正常工时
                            list.add(1,addedHoursOne);//添加每日加班工时
                            //获取的日期中的日
                            Date date = workingHours.getWorkDate();
                            Calendar cal = Calendar.getInstance();
                            cal.clear();
                            cal.setTime(simple.parse(simple.format(date)));
//                            workMap.put(cal.get(Calendar.DAY_OF_MONTH),list);//添加平时工作日
                            workMap.put(date,list);//添加平时工作日
                        }
//                        if(workMap==null){
                            workMap.put("workingDays",Math.floor(days));//向下取整 当月天数
                            workMap.put("workingHours",Math.floor(daysHours));//向下取整  当月工时数
                            workMap.put("custType","中国人寿");
                            workMap.put("allHours",workTime);
                            workMap.put("addedHours",addedHours);
//                        }

                            map.put(strDate, workMap);

                    }
                }
                return map;
            } catch (ParseException e) {
                e.printStackTrace();
                return  new HashMap<>();
            }

        }else if(custType.equals(ParamUntil._1)){
            //如果客户类型是中国银行
            double days=0.0;//初始化当月天数
            double daysHours=0.0;//初始化当月工时数
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
                String startDateStr = sdf.format(startDate);
                String endDateStr = sdf.format(endDate);

                List<String>  daysList =getMonthBetween(startDateStr,endDateStr);
                for (String strDate:daysList) {
                    float workTime =0; //当月正常出勤工时
                    float addedHours =0; //当月加班工时

                    Map<Object, Object> workMap = new HashMap<>();
                    //将时间转化为每个月的1号
                    String strDateDay =strDate+"-01";
                    if (strDateDay!=null) {
                        //获取这个月的开始时间和结束时间,返回一个数组
                        String[] strArrDate = getMonthStartAndEndDate(strDateDay);
                        //将字符串格式转化为date
                        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
                        Date mStartDate =simple.parse(strArrDate[0]);
                        Date mEndDate =simple.parse(strArrDate[1]);
                        //获取这个月的正常工作日天数
                        days = calLeaveDays(simple.parse(strArrDate[0]),simple.parse(strArrDate[1]));
                        //获取当月工时数
                        daysHours = days * 8;
                        List<NtWorkingHours> workingHoursList =null;
                        if(  StringUtils.isEmpty(perId) ){
                            workingHoursList = workingHoursMapper.selectByDate(mStartDate,mEndDate);
                        }else {
                            workingHoursList = workingHoursMapper.selectByPerId(perId, mStartDate, mEndDate);
                            //查询每个月的工时信息列表
                        }
                        //循环工时

                            for (NtWorkingHours workingHours:workingHoursList) {
                                List<Float> list=new ArrayList<>();
                                if(workingHours.getNormalHours()==null || workingHours.getOvertimeHours()==null){
                                    continue;
                                }else{
                                    list.add(0,workingHours.getNormalHours());//添加正常工时
                                    list.add(1,workingHours.getOvertimeHours());//添加加班工时
                                workTime += workingHours.getNormalHours();//正常工时累加

                                addedHours += workingHours.getOvertimeHours();//加班工时累加
                                }
                                workMap.put(workingHours.getWorkDate(),list);//添加平时工作日


                        }

//                        if(workMap==null) {
                            workMap.put("workingDays", Math.floor(days));//向下取整 当月天数
                            workMap.put("workingHours", Math.floor(daysHours));//向下取整  当月工时数
                            workMap.put("custType", "中国银行");
                            workMap.put("allHours", workTime);
                            workMap.put("addedHours", addedHours);
//                        }

                            map.put(strDate, workMap);

                    }
                }
                return map;
            } catch (ParseException e) {
                e.printStackTrace();
                return  new HashMap<>();
            }
        }else if( StringUtils.isEmpty(custType)){//如果客户类型为空

            double days=0.0;//初始化当月天数
            double daysHours=0.0;//初始化当月工时数
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
                String startDateStr = sdf.format(startDate);
                String endDateStr = sdf.format(endDate);
                //获取这个开始时间和结束时间的所有月
                List<String>  daysList =getMonthBetween(startDateStr,endDateStr);
                for (String strDate:daysList) {
                    float workTime =0; //当月正常出勤工时
                    float addedHours =0; //当月加班工时
                    int count =0;

                    Map<Object, Object> workMap = new HashMap<>();
                    //将时间转化为每个月的1号
                    String strDateDay =strDate+"-01";
                    if (strDateDay!=null) {
                        //获取这个月的开始时间和结束时间,返回一个数组
                        String[] strArrDate = getMonthStartAndEndDate(strDateDay);
                        //将字符串格式转化为date
                        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
                        Date mStartDate =simple.parse(strArrDate[0]);
                        Date mEndDate =simple.parse(strArrDate[1]);
                        //获取这个月的正常工作日天数
                        days = calLeaveDays(simple.parse(strArrDate[0]),simple.parse(strArrDate[1]));
                        //获取当月工时数
                        daysHours = days * 8;
                        List<NtWorkingHours> workingHoursList =null;
                        if( perId==0 ){
                            workingHoursList = workingHoursMapper.selectByDate(mStartDate,mEndDate);
                        }else {
                            //查询这个月的工时信息列表
                         workingHoursList = workingHoursMapper.selectByPerId(perId, mStartDate, mEndDate);
                        }
                        //循环工时
                        for (NtWorkingHours workingHours:workingHoursList) {
                            List<Float> list=new ArrayList<>();
                            Float a = workingHours.getNormalHours();// 正常工时
                            Float b = workingHours.getOvertimeHours();// 加班工时
                            if(a!= null || b!=null ){//有直接的加班类型的情况
                                list.add(0,a);//添加正常工时
                                list.add(1,b);//添加加班工时
                                workTime += a;//正常工时累加
                                addedHours += b;//加班工时累加
                                workMap.put(workingHours.getWorkDate(),list);//添加平时工作日
                            }else  {//没有加班数据的情况(可以根据签到签退计算,这个是人寿的模板)
                                float workTimeOne =0; //当月正常出勤工时
                                float addedHoursOne =0; //当月加班工时

                                SimpleDateFormat simDf = new SimpleDateFormat("HH:mm");
                                //判断这一天是不是非工作日加班(例如:五一,周六,周天),如果是节假日加班就直接判断为节假日加班
                                int t = holidayMapper.countByDay(workingHours.getWorkDate());//判断这一天那是不是节假日
                                boolean flag = isWeekend(workingHours.getWorkDate());
                                if(t>0 || flag){//这一整天是节假日加班,
                                    String strStartTime = null;
                                    Date dateStartTime = null;
                                    String strEndTime = null;
                                    Date dateEndTime =null;

                                    Date startTime =workingHours.getSigninTime() ;//签到时间
                                    Date endTime =workingHours.getSignbackTime() ;//签退时间
                                    if (startTime!=null && endTime!=null) {//处理签到时间
                                        strStartTime = simDf.format(startTime);
                                        dateStartTime = simDf.parse(strStartTime);//将时间格式转化
                                        strEndTime = simDf.format(endTime);
                                        dateEndTime = simDf.parse(strEndTime);//将时间格式转化
                                        long time = getDatePoor(dateStartTime,dateEndTime);
                                        //签到签退两个小时时间相减,不足一小时,舍去
                                        addedHoursOne += time;
                                        addedHours += time;
                                    }else{
                                        addedHoursOne += 0;
                                    }

                                }else{//否则就是工作日工时,正常处理
                                    Date startTime =workingHours.getSigninTime() ;//签到时间
                                    if (startTime!=null) {//处理签到时间
                                        String strStartTime = simDf.format(startTime);
                                        Date dateStartTime = simDf.parse(strStartTime);//将时间格式转化
                                        if(dateStartTime.before(simDf.parse("09:00")) && dateStartTime.after(simDf.parse("05:00")) ){
                                            workTimeOne += 4;//如果签到时间在九点之前,五点之后,正常工时加4
                                            workTime += 4;
                                        }else if(dateStartTime.after(simDf.parse("09:00")) && dateStartTime.after(simDf.parse("10:00"))){
                                            count++;//如果签到时间在九点之后,十点之前,次数加1
                                            if(count<=3){//如果九点之后签到的次数在九点之后超过三次就不算半天的工时
                                                workTimeOne += 4;
                                                workTime += 4;
                                            }
                                        }else{
                                            workTimeOne += 0;
                                            workTime += 0;
                                        }
                                    }
                                    Date endTime =workingHours.getSignbackTime() ;//签退时间
                                    if (endTime!=null) {//处理签退时间
                                        String strEndTime = simDf.format(endTime);
                                        Date dateEndTime = simDf.parse(strEndTime);//将时间格式转化
                                        if(dateEndTime.after(simDf.parse("17:00")) ){
                                            workTimeOne += 4;//签退时间在五点之后,正常工时加4
                                            workTime += 4;
                                        }else if(dateEndTime.after(simDf.parse("19:00")) ){
                                            long time = getDatePoor(simDf.parse("19:00"),dateEndTime);
                                            //签退时间在19:00之后,就是加班工时,不足一小时,舍去
                                            addedHoursOne += time;
                                            addedHours += time;
                                        }else{
                                            workTimeOne +=0;
                                            workTime +=0;
                                        }
                                    }
                                }
                                list.add(0,workTimeOne);//添加每日正常工时
                                list.add(1,addedHoursOne);//添加每日加班工时
                                //获取的日期中的日
                                Date date = workingHours.getWorkDate();
                                Calendar cal = Calendar.getInstance();
                                cal.clear();
                                cal.setTime(simple.parse(simple.format(date)));
//                            workMap.put(cal.get(Calendar.DAY_OF_MONTH),list);//添加平时工作日
                                workMap.put(date,list);//添加平时工作日
                              }
                            }

                        }
//                    if(workMap==null) {
                        workMap.put("workingDays", Math.floor(days));//向下取整 当月天数
                        workMap.put("workingHours", Math.floor(daysHours));//向下取整  当月工时数
//                        workMap.put("custType","中国银行");
                        workMap.put("allHours", workTime);
                        workMap.put("addedHours", addedHours);
//                    }

                        map.put(strDate, workMap);

                }

                return map;
            } catch (Exception e) {
                e.printStackTrace();
                return  new HashMap<>();
            }

        }else{//
            return  new HashMap<>();
        }
    }


    /**
     * 获取两个时间段时间分钟数
     * @param nowDate
     * @param endDate
     * @return
     */
    private   long getDatePoor( Date nowDate,Date endDate) {

        long nd = 1000 * 24 * 60 * 60;//每天毫秒数
        long nh = 1000 * 60 * 60;//每小时毫秒数
        long diff = endDate.getTime() - nowDate.getTime(); // 获得两个时间的毫秒时间差异

        long hour = diff % nd / nh; // 计算差多少小时

        return  hour ;

    }

    /**
     * 得到这个月份的开始日期和结束日期
     * @param todayTime
     * @return
     * @throws ParseException
     */
    public static String[] getMonthStartAndEndDate(String todayTime) throws ParseException {
        String[] arr = new String[2];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(todayTime));
        c.set(Calendar.DAY_OF_MONTH, 1);
        arr[0] = sdf.format(c.getTime());
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        arr[1] = sdf.format(c.getTime());
        return arr;
    }


    /**
     * 获取两个月时间的所有月份
     * @param minDate
     * @param maxDate
     * @return
     * @throws ParseException
     */
    public static List<String> getMonthBetween(String minDate, String maxDate) throws ParseException {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月

        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(sdf.parse(minDate));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

        max.setTime(sdf.parse(maxDate));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }

        return result;
    }


    /**
     *获取这两个时间段时间的正常工作日
     * @param startTime
     * @param endTime
     * @return
     */
    public  double calLeaveDays(Date startTime, Date endTime) {
        double leaveDays = 0;
        //从startTime开始循环，若该日期不是节假日或者不是周六日则请假天数+1
        Date flag = startTime;//设置循环开始日期
        Calendar cal = Calendar.getInstance();
            //循环遍历每个日期
        while (flag.compareTo(endTime) != 1) {
            cal.setTime(flag);

            //判断是否为周六日
            int week = cal.get(Calendar.DAY_OF_WEEK) - 1;
            if (week == 0 || week == 6) {//0为周日，6为周六
                //跳出循环进入下一个日期
                cal.add(Calendar.DAY_OF_MONTH, +1);
                flag = cal.getTime();
                //查询数据库中是否有该周六日,若有就是正常工作日(状态为2)
                int t = holidayMapper.selectByDay(flag);
                if(t == 0){
                    continue;
                }
            }
            //判断是否为节假日
            try {
                //从数据库查找该日期是否在节假日中
                /**这里为数据库操作*/

                int count = holidayMapper.countByDay(flag);//查询数据库中的节假日信息(状态为1)
                /**传入该日期flag,使用sql语句判断flag是否between节假日开始日期and节假日结束日期*/
                /**count为从数据库查出的行数*/
                if (count > 0) {
                    //跳出循环进入下一个日期
                    cal.add(Calendar.DAY_OF_MONTH, +1);
                    flag = cal.getTime();
                    continue;
                }
            } catch (Exception e) {
                e.printStackTrace();
             }

            //不是节假日或者周末，天数+1
            leaveDays = leaveDays + 1;
            //日期往后加一天
            cal.add(Calendar.DAY_OF_MONTH, +1);
            flag = cal.getTime();
        }

        return leaveDays;
    }


    /**
     * 判断这一天是不是周六日
     * @param bDate
     * @return
     * @throws ParseException
     */
    public   boolean isWeekend(Date bDate) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(bDate);
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            //根据这个星期天去查询日期,如果类型为2 , 则这个周天就是正常工作日(例如:五一规定国家调休的周天为正常工作日)
            int r = holidayMapper.selectByDay(cal.getTime());
            if(r > 0){
                return false;
            }else{
                return true;
            }
        } else {
            return false;
        }
    }
    /**
     * 中行导入工时
     * @param myfile
     * @return
     */
    @Override
    public Map<String ,Object> importExcel(MultipartFile myfile , String custType)  {
        try {
            if(custType.equals(ParamUntil._1)) {//表示中国银行的模板
                Map<String, Object> map=new HashMap<>();

                String msg = "";
                //初始化成功条数
                int suct = 0;
                //初始化出错条数
                int dift = 0;
                // datalist拼装List<String[]> datalist,
                XSSFWorkbook wookbook1 = null;
//           HSSFWorkbook wookbook= null;
//                if(WDWUtil.isExcel2007(myfile.getOriginalFilename())) {//判断文件是不是以.xlsx结尾
                wookbook1 = new XSSFWorkbook(myfile.getInputStream());
                XSSFSheet sheet = wookbook1.getSheetAt(0);
                int rows = sheet.getLastRowNum();// 指的行数，一共有多少行+
                for (int i = 1; i <= rows + 1; i++) {
                    List<Object> listwh = null;
                    // 读取左上端单元格
//                   HSSFRow row = sheet.getRow(i);
                    XSSFRow row = sheet.getRow(i);
                    // 行不为空
                    if (row != null) {
                        // **读取cell**
                        String inProjectName = getCellValue(row.getCell((short) 11)).toString();// 用户在项目中的名字
                        Date workDay = (Date) getCellValue(row.getCell((short) 13));// 工作日期
                        String normalHours = getCellValue(row.getCell((short) 14)).toString();// 正常工时
                        String overtimeHours = getCellValue(row.getCell((short) 15)).toString();// 加班工时

                        if (StringUtils.isEmpty(inProjectName)) {
                            msg += "第" + i + "行员工为空; ";
                            dift++;
                            continue;
                        }
                        if (StringUtils.isEmpty(workDay)) {
                            msg += "第" + i + "行工作日期为空; ";
                            dift++;
                            continue;
                        }
                        //根据项目中的名字和客户类别查询用户perId
                        NtPerAlias perAlias = getAliasByCustType(custType, inProjectName);
                        if (ObjectUtils.isEmpty(perAlias)) {
                            msg += "第" + i + "行用户不存在; ";
                            dift++;
                            continue;
                        }
                        Date date = new Date();
                        //时间格式转化
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String date1 = sdf.format(workDay);
                        date = sdf.parse(date1);
                        //string 转float
                        Float normalHoursF = Float.parseFloat(normalHours);
                        Float overtimeHoursF = Float.parseFloat(overtimeHours);
                        if (i==1) {
                            //判断库中是否有该员工数据
                            NtWorkingHours workingHours = workingHoursMapper.selectByOne(perAlias.getPerId(), date);
                            //判断是否有该数据
                            if (!ObjectUtils.isEmpty(workingHours)) {
                                if(workingHours.getPerId()==perAlias.getPerId() && workingHours.getWorkDate().equals(date)){
                                    map.put("error","The table has been imported");
                                    return  map;
                                }
                            }
                        }
                        //将数据插入临时表中
                        if(perAlias.getPerId()!=0) {
                            workingHoursTmpMapper.insertOneTmp(perAlias.getPerId(), date, normalHoursF, overtimeHoursF);
                        }else{
                            map.put("error","第"+ i +"行员工不存在");
                            return  map;
                        }
                        suct++;
                    }
                }
                //查询所有的员工编号
               List<Integer> perIdList =  workingHoursTmpMapper.selectPerId();
                //查询所有日期
                List<Date> dateList =  workingHoursTmpMapper.selectWorkDate();

                //将数据统计到目标表
                for (int i =0 ;i<perIdList.size();i++) {
                    for (int j=0;j<dateList.size();j++) {
                       //查询数据
                        NtWorkingHoursTmp workingHoursTmp = workingHoursTmpMapper.selectByUnify(perIdList.get(i),dateList.get(j));
                      try {
                          //插入数据
                          workingHoursMapper.insertOne(workingHoursTmp.getPerId(),workingHoursTmp.getWorkDate(),workingHoursTmp.getNormalHours(),workingHoursTmp.getOvertimeHours());
                      } catch (Exception e) {
                            e.printStackTrace();
                            map.put("error", "The table has been imported");
                            return map;
                        }

                    }
                }
                //清空临时表内容
                workingHoursTmpMapper.truncateTable();

                map.put("rows", rows);//总行数
                map.put("successNum", suct);//成功条数
                map.put("failedNum", dift);//失败条数
                map.put("error", msg);//异常行数

                return map;
            }else if(custType.equals(ParamUntil._3)){//表示中国人寿的模板
                Map<String, Object> map=new HashMap<>();
                String msg = "";
                //初始化成功条数
                int suct = 0;
                //初始化出错条数
                int dift = 0;
//                HSSFWorkbook wookbook1 = null;
                HSSFWorkbook wookbook1 = null;
                wookbook1 = new HSSFWorkbook(myfile.getInputStream());
//                Workbook bookResource = Workbook.getWorkbook(new File(myfile.getOriginalFilename()));
                HSSFSheet sheet = wookbook1.getSheetAt(0);
                int rows = sheet.getLastRowNum();// 指的行数，一共有多少行+
                //获取导入的月份
                Date dateMonth = splitData(myfile.getOriginalFilename(),"出","月");
                Calendar cale = Calendar.getInstance();

                for (int i = 1; i <= rows +1; i++) {//循环每一行
                    // 读取左上端单元格 ,读取的是第一行数据
//                    HSSFRow row = sheet.getRow(i);
                    Row row = sheet.getRow(i);
                    if (row != null) {
                    DateFormat sdf = new SimpleDateFormat("HH:mm");//日期格式化
                    String inProjectName = getCellValue(row.getCell((short) 1)).toString();// 用户在项目中的名字
                    //根据项目中的名字和客户类别查询用户perId
                    NtPerAlias perAlias = getAliasByCustType(custType, inProjectName);
                    if (ObjectUtils.isEmpty(perAlias)) {
                        msg += "第" + i + "行用户不存在; ";
                        dift++;
                        continue;
                    }
                    //获取文件月份
                    cale.clear();
                    cale.setTime(dateMonth);
                    //获取当月总天数
                    int days = cale.getActualMaximum(cale.DAY_OF_MONTH);
//                    判断行数是否为空
                    if (StringUtils.isEmpty(inProjectName)) {
                        msg += "第" + i + "行员工为空; ";
                        dift++;
                        continue;
                    } else {
                        for (int j = 6; j < days + 6; j++) {
                            String[] strArray = null;
                            String signinTime = null;
                            String signbackTime = null;

                            //获取第一天时间字符串
                            String day = getCellValue(row.getCell((short) j)).toString();//签到签退时间
                            //获取日期
                            Date workDate = cale.getTime();
                            cale.set(Calendar.DATE, cale.get(Calendar.DATE) + 1);

                            if (day.equals("W")) {//如果获取的这个单元格是W 则插入为空
//                                workingHoursMapper.insertOneTmpLife(perAlias.getPerId(), workDate, null, null);
                                continue;
                            } else if(day!=null){
                                //判断当前时间是上个月
                                strArray = day.split("-", -1);
                                signinTime = strArray[0];//获取签到时间
                                signbackTime = strArray[1];//获取签退时间

                                Time singninDate;
                                Time signbackDate;
                                if (signinTime == null || "".equals(signinTime)) {
                                    singninDate = null;
                                } else {
                                    singninDate = new Time(sdf.parse(signinTime).getTime());
                                }

                                if (signbackTime == null || "".equals(signbackTime)) {
                                    signbackDate = null;
                                } else {
                                    signbackDate = new Time(sdf.parse(signbackTime).getTime());
                                }
                                if (j == 1) {
                                    //判断库中是否有该员工数据
                                    NtWorkingHours workingHours = workingHoursMapper.selectByOne(perAlias.getPerId(), workDate);
                                    //判断是否有该数据
                                    if (ObjectUtils.isEmpty(workingHours)) {
                                        if (workingHours.getPerId() == perAlias.getPerId() && workingHours.getWorkDate().equals(workDate)) {
                                            map.put("error", "The table has been imported");
                                            return map;
                                        }
                                    }
                                }
                                //将数据插入目标表表中
                                try {
                                    if(perAlias.getPerId()!=0 ){
                                        workingHoursMapper.insertOneTmpLife(perAlias.getPerId(), workDate, singninDate, signbackDate);
                                    }else{
                                        map.put("error","第"+ i +"行员工不存在");
                                        return map;
                                    }
                                } catch (Exception e) {

                                    e.printStackTrace();
                                    map.put("error", "The table has been imported");
                                    return map;
                                }

                            }else{
                                return new HashMap<>();
                            }
                        }
                        suct++;
                    }
                }
                    }
                    map.put("rows", rows);//总行数
                    map.put("successNum", suct);//成功条数
                    map.put("failedNum", dift);//失败条数
                    map.put("error", msg);//异常行数
                    return map;

            }else{
                return new HashMap<>();
            }

            } catch (Exception e) {
                e.printStackTrace();
                return  new HashMap<>();
            }
    }



    /**
     * 获得xsscell内容
     *
     * @param cell
     * @return
     */
//    public String getCellValue(HSSFCell cell) {
    public Object getCellValue(Cell cell) {
        Object value = "";

        DecimalFormat df = new DecimalFormat("0");//格式化number String字符串
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//日期格式化
        if (cell != null) {
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_FORMULA:
                    break;
                case Cell.CELL_TYPE_NUMERIC:
//                    value = df.format(cell.getNumericCellValue());
//                    break;

                if (DateUtil.isCellDateFormatted(cell)) {
                    value = cell.getDateCellValue();
                }else if ("General".equals(cell.getCellStyle().getDataFormatString())) {
                    value = df.format(cell.getNumericCellValue());
                } else {
                    value = df.format(cell.getNumericCellValue());
                }
                break;
                case Cell.CELL_TYPE_STRING:
                    value = cell.getStringCellValue().trim();
                    break;
                default:
                    value = "";
                    break;
            }
        }
        return value;
    }




    /** 根据获取员工编号**/
   public NtPerAlias getAliasByCustType(String custType,String name){
       ProList proList = new ProList();
       List<Integer> list = null;
       NtPerAlias perAlias =new NtPerAlias();
       NtPerAlias perAlias1 =new NtPerAlias();
        NtPersonnel personnel =null;
       //根据客户类别查询项目编号
      List<NtProjectInfo> projectInfoList = projectInfoMapper.selectByCustType(custType);
       if ( projectInfoList.size()>0) {
           try {
               for (NtProjectInfo projectInfo:projectInfoList ) {
                   //获取项目列表
                    //list.add(projectInfo.getProjectNumber());
                     perAlias1 = perAliasMapper.selectByInProNameAndPronum(projectInfo.getProjectNumber(),name);
                   //查询出数据结束
                if(!ObjectUtils.isEmpty(perAlias1)){
                    perAlias.setPerId(perAlias1.getPerId());

                }
              }
           } catch (Exception e) {
               e.printStackTrace();
           }
           //如果查询别名表perAlias还是为空,查询员工表信息
           if(ObjectUtils.isEmpty(perAlias1)){

              List<NtPerInProject>  perInProjectList =  perInProjectMapper.selectByCustType(custType);
               for (NtPerInProject perInProject:perInProjectList) {
                    personnel = personnelMapper.selectByPrimaryKey(perInProject.getPerId());
                   if(!ObjectUtils.isEmpty(personnel)){
                       if(name.equals(personnel.getName())==true ){
                           perAlias.setPerId(personnel.getPerId());

                       }
                   }else{
                       perAlias.setPerId(0);
                   }
               }

           }
           if(perAlias.getPerId()==null){
               perAlias.setPerId(0);
           }
           return perAlias;
       }else{
           return  null;
       }

   }





    /**   截取2个指定字符之间的字符串
     *
     * @param str
     * @param strStart
     * @param strEnd
     * @return
     */
    public static Date splitData(String str, String strStart, String strEnd) {
        String tempStr;
        Date date = null;
        tempStr = str.substring(str.indexOf(strStart) + 1, str.lastIndexOf(strEnd));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        try {
            // 注意格式需要与上面一致，不然会出现异常
            date = sdf.parse(tempStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }




}
