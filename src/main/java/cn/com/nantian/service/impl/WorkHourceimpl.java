package cn.com.nantian.service.impl;


import cn.com.nantian.common.ParamUntil;
import cn.com.nantian.common.WDWUtil;
import cn.com.nantian.mapper.*;

import cn.com.nantian.pojo.*;
import cn.com.nantian.pojo.entity.ProList;
import cn.com.nantian.service.WorkHoursService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


//工时管理类
@Service
@Transactional
public class WorkHourceimpl  implements WorkHoursService{

    @Resource
    private NtWorkingHoursMapper workingHoursMapper;

    @Resource
    private NtPerAliasMapper perAliasMapper;
    @Resource
    private  NtProjectInfoMapper projectInfoMapper;
    @Resource
    private NtWorkingHoursTmpMapper workingHoursTmpMapper;

    @Resource
    private  NtPersonnelMapper personnelMapper;




    /**
     *
     * 查询工时
     * @param perId 员工id
     * @param custType 客户类别
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return
     */
    @Override
    public List<NtWorkingHours> findAllWorkHours(int perId, String custType, Date startDate, Date endDate) {

        if(custType == null || "".equals(custType)){//直接计算所有工时
            List<NtWorkingHours> workingHoursList = workingHoursMapper.selectByPerId(perId);
            for (NtWorkingHours workingHours:workingHoursList) {

            }



        }else{//根据客户类别查询工时
//            workingHoursMapper.selectWorkHoursByNameAndDate();

        }


        return null;
    }

    /**
     * 中行导入工时
     * @param myfile
     * @return
     */
    @Override
    public Map<String ,Object> importImportExcel(MultipartFile myfile , String custType)  {
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
                            if (workingHours!=null ) {
                                if(workingHours.getPerId()==perAlias.getPerId() && workingHours.getWorkDate().equals(date)){
                                    map.put("error","The table has been imported");
                                    return  map;
                                }
                            }
                        }
                        //将数据插入临时表中
                        workingHoursTmpMapper.insertOneTmp(perAlias.getPerId(), date, normalHoursF, overtimeHoursF);
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
                        //插入数据
                        workingHoursMapper.insertOne(workingHoursTmp.getPerId(),workingHoursTmp.getWorkDate(),workingHoursTmp.getNormalHours(),workingHoursTmp.getOvertimeHours());
                    }
                }
                //清空临时表内容
                workingHoursTmpMapper.truncateTable();

                map.put("rows ", rows);//总行数
                map.put("success num ", suct);//成功条数
                map.put("failed num ", dift);//失败条数
                map.put("error ", msg);//异常行数

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
                            System.out.println(workDate);
                            if (day.equals("W")) {
                                workingHoursMapper.insertOneTmpLife(perAlias.getPerId(), workDate, null, null);
                                continue;
                            } else {
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
                                    if (workingHours != null) {
                                        if (workingHours.getPerId() == perAlias.getPerId() && workingHours.getWorkDate().equals(workDate)) {
                                            map.put("error", "The table has been imported");
                                            return map;
                                        }
                                    }
                                }
                                //将数据插入目标表表中
                                workingHoursMapper.insertOneTmpLife(perAlias.getPerId(), workDate, singninDate, signbackDate);
                            }
                        }
                        suct++;
                    }
                }
                    }
                    map.put("rows ", rows);//总行数
                    map.put("success num ", suct);//成功条数
                    map.put("failed num ", dift);//失败条数
                    map.put("error ", msg);//异常行数
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
       NtPerAlias perAlias =null;
       //根据客户类别查询项目编号
      List<NtProjectInfo> projectInfoList = projectInfoMapper.selectByCustType(custType);
       if ( projectInfoList.size()>0) {
           try {
               for (NtProjectInfo projectInfo:projectInfoList ) {
                   //获取项目列表
                    //list.add(projectInfo.getProjectNumber());
                   perAlias = perAliasMapper.selectByInProNameAndPronum(projectInfo.getProjectNumber(),name);
                if(!ObjectUtils.isEmpty(perAlias)){
                    break;
                }
              }
           } catch (Exception e) {
               e.printStackTrace();
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
