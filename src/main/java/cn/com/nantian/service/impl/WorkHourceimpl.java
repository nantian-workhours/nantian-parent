package cn.com.nantian.service.impl;


import cn.com.nantian.mapper.NtPerAliasMapper;

import cn.com.nantian.mapper.NtProjectInfoMapper;
import cn.com.nantian.mapper.NtWorkingHoursMapper;
import cn.com.nantian.pojo.NtPerAlias;
import cn.com.nantian.pojo.NtProjectInfo;
import cn.com.nantian.pojo.NtWorkingHours;
import cn.com.nantian.pojo.entity.ProList;
import cn.com.nantian.service.WorkHoursService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
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
import java.io.IOException;
import java.text.DecimalFormat;
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


    @Override
    public String getWorkerHours(String userName , String projectName ,Date start, Date end) {


        return null;
    }


    /**
     * 中行导入工时
     * @param myfile
     * @return
     */
    @Override
    public Map<String ,Object> importImportExcel(MultipartFile myfile , String custType)  {
        Map<String, Object> map =new HashMap<>();
        Map<Integer, Object> map1 =new HashMap<>();

        String msg = "";
        int suct =0;
        int dift =0;
        // datalist拼装List<String[]> datalist,
        HSSFWorkbook wookbook = null;
        XSSFWorkbook wookbook1=null;
        try {
//            wookbook = new HSSFWorkbook(myfile.getInputStream());
            wookbook1 = new XSSFWorkbook(myfile.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        HSSFSheet sheet = wookbook.getSheetAt(0);
        XSSFSheet sheet = wookbook1.getSheetAt(0);
        int rows = sheet.getLastRowNum();// 指的行数，一共有多少行+

        for (int i = 1; i <= rows + 1; i++) {
            List<Object> listwh =null;
            // 读取左上端单元格
//            HSSFRow row = sheet.getRow(i);
            XSSFRow row = sheet.getRow(i);
            // 行不为空
            if (row != null) {
                // **读取cell**

                String inProjectName = getCellValue(row.getCell((short) 11)).toString();// 用户在项目中的名字
                Date workDay = (Date)getCellValue(row.getCell((short) 13));// 工作日期
                String normalHours= getCellValue(row.getCell((short) 14)).toString();// 正常工时
                String overtimeHours= getCellValue(row.getCell((short) 15)).toString();// 加班工时

                if (StringUtils.isEmpty(inProjectName)) {
                    msg += "第" + i + "行员工为空";
                    dift++;
                    continue;
                }
                if (StringUtils.isEmpty(workDay)) {
                    msg += "第" + i + "行工作日期为空";
                    dift++;
                    continue;
                }

                //根据项目中的名字和客户类别查询用户perId
                NtPerAlias perAlias = getAliasByCustType(custType,inProjectName);
                if (ObjectUtils.isEmpty(perAlias)) {
                    msg += "第" + i + "行用户不存在";
                    dift++;
                    continue;
                }

                Date date=new Date();
                //格式转化
                try {
                    //时间格式转化
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String date1 = sdf.format(workDay);
                    date = sdf.parse(date1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //string 转float
                Float normalHoursF =Float.parseFloat(normalHours);
                Float overtimeHoursF= Float.parseFloat(overtimeHours);
//                将数据插入表中
                workingHoursMapper.insertOne(perAlias.getPerId(),date,normalHoursF,overtimeHoursF);
                suct++;
            }
        }
        map.put("rows ",rows);//总行数
        map.put("success num ",suct);//成功条数
        map.put("failed num ",dift);//失败条数

        return map  ;
    }



    /**
     * 获得Hsscell内容
     *
     * @param cell
     * @return
     */
//    public String getCellValue(HSSFCell cell) {
    public Object getCellValue(XSSFCell cell) {
        Object value = "";

        DecimalFormat df = new DecimalFormat("0");//格式化number String字符串
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//日期格式化
        if (cell != null) {
            switch (cell.getCellType()) {
                case XSSFCell.CELL_TYPE_FORMULA:
                    break;
                case XSSFCell.CELL_TYPE_NUMERIC:
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
                case XSSFCell.CELL_TYPE_STRING:
                    value = cell.getStringCellValue().trim();
                    break;
                default:
                    value = "";
                    break;
            }
        }
        return value;
    }

    /**
     * 获取每个单元格的内容
     */
    private static  Object getCellValue1(Cell cell) {
        Object value = null;

        DecimalFormat df = new DecimalFormat("0");//格式化number String字符串
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//日期格式化

        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                value = cell.getRichStringCellValue().getString();
                break;

//这个地方区别
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    value = cell.getDateCellValue();
                }else if ("General".equals(cell.getCellStyle().getDataFormatString())) {
                    value = df.format(cell.getNumericCellValue());
                } else {
                    value = cell.getRichStringCellValue().getString();
                }
                break;
            case Cell.CELL_TYPE_BLANK:
                value = "";
                break;
            default:
                break;
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





}
