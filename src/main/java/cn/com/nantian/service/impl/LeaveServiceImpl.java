/**
 * @description: 请假信息管理
 * @ClassName: LeaveServiceImpl
 * @Author： Mr.Kong
 * @date: 2019/3/29 15:03
 * @Version： 1.0
 */
package cn.com.nantian.service.impl;

import cn.com.nantian.common.DateUtils;
import cn.com.nantian.common.ObjectUtils;
import cn.com.nantian.common.ParamUntil;
import cn.com.nantian.common.StringUtils;
import cn.com.nantian.mapper.NtLeaveMapper;
import cn.com.nantian.pojo.NtDepartment;
import cn.com.nantian.pojo.NtDictionariesKey;
import cn.com.nantian.pojo.NtLeave;
import cn.com.nantian.pojo.NtPersonnel;
import cn.com.nantian.service.DepartmentService;
import cn.com.nantian.service.DictionariesService;
import cn.com.nantian.service.LeaveService;
import cn.com.nantian.service.UserService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Resource
    private NtLeaveMapper leaveMapper;
    @Resource
    private DictionariesService dictionariesService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private UserService userService;

    @Override
    public Map<String, Object> getStatisticalLeaveTotal(NtLeave ntLeave) {
        Map<String, Object> dataMap= new HashMap<>();
        Map<String,Object> totalNumMap=new HashMap<>();//人数
        Map<String,Object> totalHoursMap=new HashMap<>();//时长
        //1	事假
        ntLeave.setLeaveType("1");
        NtLeave ntLeave1=this.queryStatisticalLeaveTotal(ntLeave);
        totalNumMap.put("thingsLeaveNum",ntLeave1.getTotalNum());
        totalHoursMap.put("thingsLeaveHours",ntLeave1.getTotalHours());
        //2	年假
        ntLeave.setLeaveType("2");
        NtLeave ntLeave2=this.queryStatisticalLeaveTotal(ntLeave);
        totalNumMap.put("yearLeaveNum",ntLeave2.getTotalNum());
        totalHoursMap.put("yearLeaveHours",ntLeave2.getTotalHours());
        //3	调休
        ntLeave.setLeaveType("3");
        NtLeave ntLeave3=this.queryStatisticalLeaveTotal(ntLeave);
        totalNumMap.put("paidLeaveNum",ntLeave3.getTotalNum());
        totalHoursMap.put("paidLeaveHours",ntLeave3.getTotalHours());
        //5	婚假
        ntLeave.setLeaveType("5");
        NtLeave ntLeave5=this.queryStatisticalLeaveTotal(ntLeave);
        totalNumMap.put("marriageLeaveNum",ntLeave5.getTotalNum());
        totalHoursMap.put("marriageLeaveHours",ntLeave5.getTotalHours());
        //6	丧假
        ntLeave.setLeaveType("6");
        NtLeave ntLeave6=this.queryStatisticalLeaveTotal(ntLeave);
        totalNumMap.put("funeralLeaveNum",ntLeave6.getTotalNum());
        totalHoursMap.put("funeralLeaveHours",ntLeave6.getTotalHours());
        //7	产假
        ntLeave.setLeaveType("7");
        NtLeave ntLeave7=this.queryStatisticalLeaveTotal(ntLeave);
        totalNumMap.put("maternityLeaveNum",ntLeave7.getTotalNum());
        totalHoursMap.put("maternityLeaveHours",ntLeave7.getTotalHours());
        dataMap.put("totalNumMap",totalNumMap);
        dataMap.put("totalHoursMap",totalHoursMap);
        return dataMap;
    }

    @Override
    public NtLeave queryStatisticalLeaveTotal(NtLeave ntLeave) {
        return leaveMapper.queryStatisticalLeaveTotal(ntLeave);
    }

    /**
     * @description: 创建时 效验传入的参数值
     * @auther: Mr.Kong
     * @date: 2019/5/13 16:07
     * @param: [ntLeave]
     * @return: java.lang.String
     **/
    public String checkAttribute(NtLeave ntLeave) throws Exception {
        if (ObjectUtils.isNull(ntLeave.getDeptId())) {
            return "部门编号 不能为空！";
        }
        if (ObjectUtils.isNull(ntLeave.getPerId())) {
            return "员工编号 不能为空！";
        }
        if (StringUtils.isEmpty(ntLeave.getBegDateStr())) {
            return "开始日期 不能为空！";
        } else if (!DateUtils.checkDateReg(ntLeave.getBegDateStr())) {
            return "开始日期 格式不正确！";
        } else {
            ntLeave.setBegDate(DateUtils.parseToDate(ntLeave.getBegDateStr(), "yyyy-MM-dd"));
        }
        if (StringUtils.isEmpty(ntLeave.getEndDateStr())) {
            return "结束日期 不能为空！";
        } else if (!DateUtils.checkDateReg(ntLeave.getEndDateStr())) {
            return "结束日期 格式不正确！";
        } else {
            ntLeave.setEndDate(DateUtils.parseToDate(ntLeave.getEndDateStr(), "yyyy-MM-dd"));
        }
        if (ObjectUtils.isNull(ntLeave.getLeaveCountStr())) {
            return "请假天数 不能为空！";
        } else if (!StringUtils.isOnePointNumber(ntLeave.getLeaveCountStr())) {
            return "请假天数 格式不正确！";
        } else {
            ntLeave.setLeaveCount(Float.parseFloat(ntLeave.getLeaveCountStr()));
        }
        if (StringUtils.isEmpty(ntLeave.getLeaveType())) {
            return "请假类型 不能为空！";
        }
        if (StringUtils.isEmpty(ntLeave.getLeaveRemark())) {
            return "请假内容 不能为空！";
        }
        return "";
    }

    /**
     * @description: 更新时 效验传入的参数值
     * @auther: Mr.Kong
     * @date: 2019/5/13 16:07
     * @param: [ntLeave]
     * @return: java.lang.String
     **/
    public String checkUpdateAttribute(NtLeave ntLeave) throws Exception {
        if (ObjectUtils.isNull(ntLeave.getLeaveId())) {
            return "主键id 不能为空！";
        }
        if (StringUtils.isEmpty(ntLeave.getApplyStatus())) {
            return "审批状态 不能为空！";
        }
        /*if (StringUtils.isEmpty(ntLeave.getApproveOpn())) {
            return "审批意见 不能为空！";
        }*/
        return "";
    }

    /**
     * @description: 更新审批状态(R 审核中, Y 通过, N 退回)
     * @auther: Mr.Kong
     * @date: 2019/3/29 15:52
     * @Param: [leave]
     * @return: int
     **/
    @Override
    public int updateLeaveStatus(NtLeave leave) {
        leave.setManagerId(1);//审批人id
        leave.setApproveDate(new Date());//审批时间
        return leaveMapper.updateLeaveStatus(leave);
    }

    /**
     * @description: 设置请假类别名称、审批状态名称
     * @auther: Mr.Kong
     * @date: 2019/3/29 15:32
     * @Param: [leaveList]
     * @return: void
     **/
    @Override
    public void setLeaveTypeName(List<NtLeave> leaveList) {
        if (ObjectUtils.isNotNull(leaveList)) {
            for (NtLeave leave : leaveList) {
                //设置请假类别名称
                NtDictionariesKey dictionariesKey = dictionariesService.selectDictionaries(ParamUntil.hol, leave.getLeaveType());
                if (ObjectUtils.isNotNull(dictionariesKey)) {
                    leave.setLeaveTypeName(dictionariesKey.getDicValue());
                }
                //设置审批状态名称 R 审核中，Y 通过，N 退回
                if (StringUtils.isNotEmpty(leave.getApplyStatus()) && ParamUntil.R.equals(leave.getApplyStatus())) {
                    leave.setApplyStatusName("审核中");
                } else if (StringUtils.isNotEmpty(leave.getApplyStatus()) && ParamUntil.Y.equals(leave.getApplyStatus())) {
                    leave.setApplyStatusName("通过");
                } else if (StringUtils.isNotEmpty(leave.getApplyStatus()) && ParamUntil.N.equals(leave.getApplyStatus())) {
                    leave.setApplyStatusName("退回");
                }
            }
        }
    }

    /**
     * @description: 设置请假类别名称、审批状态名称
     * @auther: Mr.Kong
     * @date: 2019/3/29 15:33
     * @Param: [leave]
     * @return: void
     **/
    @Override
    public void setLeaveTypeName(NtLeave leave) {
        if (ObjectUtils.isNotNull(leave)) {
            //设置请假类别名称
            NtDictionariesKey dictionariesKey = dictionariesService.selectDictionaries(ParamUntil.hol, leave.getLeaveType());
            if (ObjectUtils.isNotNull(dictionariesKey)) {
                leave.setLeaveTypeName(dictionariesKey.getDicValue());
            }
            //设置审批状态名称 R 审核中，Y 通过，N 退回
            if (StringUtils.isNotEmpty(leave.getApplyStatus()) && ParamUntil.R.equals(leave.getApplyStatus())) {
                leave.setApplyStatusName("审核中");
            }
            if (StringUtils.isNotEmpty(leave.getApplyStatus()) && ParamUntil.Y.equals(leave.getApplyStatus())) {
                leave.setApplyStatusName("通过");
            } else if (StringUtils.isNotEmpty(leave.getApplyStatus()) && ParamUntil.N.equals(leave.getApplyStatus())) {
                leave.setApplyStatusName("退回");
            }
        }
    }
    /**
     * @description: 查询请假信息列表
     * @auther: Mr.Kong
     * @date: 2019/3/29 15:25
     * @Param: [leave]
     * @return: List<NtLeave>
     **/
    @Override
    public List<NtLeave> selectLeaveList(NtLeave leave) {
        return leaveMapper.selectLeaveList(leave);
    }

    @Override
    public int deleteByPrimaryKey(Integer leaveId) {
        return leaveMapper.deleteByPrimaryKey(leaveId);
    }

    @Override
    public int insert(NtLeave record) {
        return leaveMapper.insert(record);
    }

    @Override
    public int insertSelective(NtLeave record) {
        record.setApplyStatus(ParamUntil.R);
        return leaveMapper.insertSelective(record);
    }
    @Override
    public NtLeave selectByPrimaryKey(Integer leaveId) {
        return leaveMapper.selectByPrimaryKey(leaveId);
    }

    @Override
    public int updateByPrimaryKeySelective(NtLeave record) {
        return leaveMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(NtLeave record) {
        return leaveMapper.updateByPrimaryKey(record);
    }
    /**
     * @description: 导入请假信息
     * @auther: Mr.Kong
     * @date: 2019/4/1 17:07
     * @Param: [myfile]
     * @return: Map<String, Object>
     **/
    @Override
    public Map<String, Object> importExcel(MultipartFile myfile) throws Exception{
        try {
            Map<String, Object> map = new HashMap<>();
            String msg = "";
            int errorRow=2;//定位错误行数
            int successNum = 0;//初始化成功条数
            int failNum = 0;//初始化出错条数
            XSSFWorkbook xssfWorkbook = null;
            xssfWorkbook = new XSSFWorkbook(myfile.getInputStream());
            XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
            //指的行数，一共有多少行
            int rows = sheet.getLastRowNum();
            for (int i = 2; i <= rows+1; i++) {
                ++errorRow;
                System.out.println("..................errorRow="+errorRow);
                //读取左上端单元格
                XSSFRow row = sheet.getRow(i);
                //行不为空 读取cell
                if (row != null) {
                    //部门名称
                    NtDepartment department=null;
                    String deptName = getMergedRegionValue(sheet,i,0);
                    if (StringUtils.isEmpty(deptName)){
                        msg += "第" + errorRow + "行 部门名称不能为空; ";
                        failNum++;
                        continue;
                    }else{
                        department=departmentService.queryDepartmentByName(deptName);
                        if (ObjectUtils.isNull(department)) {
                            msg += "第" + errorRow + "行 部门名称不正确; ";
                            failNum++;
                            continue;
                        }
                    }
                    System.out.println(".............第"+errorRow+"行，第一列，部门名称是："+deptName);
                    //员工姓名
                    String userName = getCellValue(row.getCell((short) 1)).toString();
                    if (StringUtils.isEmpty(userName)) {
                        msg += "第" + errorRow + "行 员工姓名为空; ";
                        failNum++;
                        continue;
                    }
                    List<NtPersonnel> userList = userService.findPerByDeptIdAndName(department.getDeptId(), userName);
                    if (ObjectUtils.isNull(userList)) {
                        msg += "第" + errorRow + "行 员工不存在; ";
                        failNum++;
                        continue;
                    }
                    //请假类型
                    NtDictionariesKey dictionaries=null;
                    String leaveTypeName = getCellValue(row.getCell((short) 2)).toString();
                    if (StringUtils.isEmpty(leaveTypeName)) {
                        msg += "第" + errorRow + "行 请假类型为空; ";
                        failNum++;
                        continue;
                    }else {
                        dictionaries= dictionariesService.queryDictionaries(ParamUntil.hol,leaveTypeName);
                        if (ObjectUtils.isNull(dictionaries)) {
                            msg += "第" + errorRow + "行 请假类型填写错误; ";
                            failNum++;
                            continue;
                        }
                    }
                    //请假天数
                    String leaveDays = getCellValue(row.getCell((short) 3)).toString();
                    if (StringUtils.isEmpty(leaveDays)) {
                        msg += "第" + errorRow + "行 请假天数为空; ";
                        failNum++;
                        continue;
                    }else if (!StringUtils.isOnePointNumber(leaveDays)){
                        msg += "第" + errorRow + "行 请假天数格式不正确; ";
                        failNum++;
                        continue;
                    }
                    //请假开始时间
                    Date begDate =(Date) getCellValue(row.getCell((short) 4));
                    if (ObjectUtils.isNull(begDate)) {
                        msg += "第" + errorRow + "行 请假开始时间为空; ";
                        failNum++;
                        continue;
                    }
                    //请假结时间束
                    Date endDate =(Date) getCellValue(row.getCell((short) 5));
                    if (ObjectUtils.isNull(endDate)) {
                        msg += "第" + errorRow + "行 请假结时间束为空; ";
                        failNum++;
                        continue;
                    }
                    //请假明细
                    String leaveRemark = getCellValue(row.getCell((short) 6)).toString();
                    //新增请假
                    NtLeave ntLeave = new NtLeave();
                    ntLeave.setPerId(userList.get(0).getPerId());
                    ntLeave.setBegDate(begDate);
                    ntLeave.setEndDate(endDate);
                    ntLeave.setLeaveType(dictionaries.getDicCode());
                    ntLeave.setLeaveCount(Float.valueOf(leaveDays));
                    ntLeave.setLeaveRemark(leaveRemark);
                    ntLeave.setApplyStatus(ParamUntil.R);
                    boolean repeat=this.checkWhetherRepeat(ntLeave);
                    System.out.println("第"+errorRow+"行 信息是否存在！repeat="+repeat);
                    if (repeat){
                        msg += "第" + errorRow + "行 该员工请假信息已申请; ";
                        failNum++;
                        continue;
                    }else {
                        this.insertSelective(ntLeave);
                        successNum++;
                    }
                }
            }
            //总记导入数据
            map.put("totalNum", rows-1);
            //成功条数
            map.put("successNum ", successNum);
            //失败条数
            map.put("failNum ", failNum);
            //错误信息
            map.put("error", msg);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    /**
      * @description: 获得xsscell内容
      * @auther: Mr.Kong
      * @date: 2019/5/16 11:29
      * @param:  [cell]
      * @return: java.lang.Object
      **/
    @Override
    public Object getCellValue(Cell cell) {
        Object value = "";
        //格式化number String字符串
        DecimalFormat df = new DecimalFormat("0.0");
        if (cell != null) {
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_FORMULA:
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        value = cell.getDateCellValue();
                    } else if ("General".equals(cell.getCellStyle().getDataFormatString())) {
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

    /**
      * @description: 获取Excel合并单元格的值
      * @auther: Mr.Kong
      * @date: 2019/5/16 11:28
      * @param:  [sheet, row, column]
      * @return: java.lang.String
      **/
    public String getMergedRegionValue(Sheet sheet, int row, int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress ca = sheet.getMergedRegion(i);
            int firstColumn = ca.getFirstColumn();
            int lastColumn = ca.getLastColumn();
            int firstRow = ca.getFirstRow();
            int lastRow = ca.getLastRow();
            if (row >= firstRow && row <= lastRow) {
                if (column >= firstColumn && column <= lastColumn) {
                    Row fRow = sheet.getRow(firstRow);
                    Cell fCell = fRow.getCell(firstColumn);
                    return (String)getCellValue(fCell);
                }
            }
        }
        return null;
    }

    /**
      * @description: 效验员工请假申请时间段信息是否已存在
      * @auther: Mr.Kong
      * @date: 2019/5/16 13:50
      * @param:  [ntLeave]
      * @return: boolean true 有，false 无
      **/
    public boolean checkWhetherRepeat(NtLeave ntLeave){
        boolean repeat=false;
        List<NtLeave> ntLeaveList = this.selectLeaveList(null);
        if (ObjectUtils.isNotNull(ntLeave) && ObjectUtils.isNotNull(ntLeaveList)){
            for (NtLeave leave:ntLeaveList){
                if (leave.getPerId()==ntLeave.getPerId() && leave.getApplyStatus().equals(ParamUntil.R)){
                    if (DateUtils.comparisonDate(ntLeave.getBegDate(),ntLeave.getEndDate(),
                            leave.getBegDate(),leave.getEndDate())){
                        repeat=true;
                    }
                }
            }
        }
        return repeat;
    }
}
