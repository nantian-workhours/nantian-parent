/**
 * @Description: 请假信息管理
 * @ClassName: LeaveServiceImpl
 * @Author： Mr.Kong
 * @Date: 2019/3/29 15:03
 * @Version： 1.0
 */
package cn.com.nantian.service.impl;

import cn.com.nantian.common.ObjectUtils;
import cn.com.nantian.common.ParamUntil;
import cn.com.nantian.common.StringUtils;
import cn.com.nantian.mapper.NtLeaveMapper;
import cn.com.nantian.pojo.*;
import cn.com.nantian.service.DepartmentService;
import cn.com.nantian.service.DictionariesService;
import cn.com.nantian.service.LeaveService;
import cn.com.nantian.service.UserService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * @Description: 更新审批状态(R 审核中, Y 通过, N 退回)
     * @Auther: Mr.Kong
     * @Date: 2019/3/29 15:52
     * @Param: [leave]
     * @Return: int
     **/
    @Override
    public int updateLeaveStatus(NtLeave leave) {
        return leaveMapper.updateLeaveStatus(leave);
    }

    /**
     * @Description: 设置请假类别名称、审批状态名称
     * @Auther: Mr.Kong
     * @Date: 2019/3/29 15:32
     * @Param: [leaveList]
     * @Return: void
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
                if (StringUtils.isNotEmpty(leave.getApplyStatus()) && leave.getApplyStatus().equals("R")) {
                    leave.setApplyStatusName("审核中");
                } else if (StringUtils.isNotEmpty(leave.getApplyStatus()) && leave.getApplyStatus().equals("Y")) {
                    leave.setApplyStatusName("通过");
                } else if (StringUtils.isNotEmpty(leave.getApplyStatus()) && leave.getApplyStatus().equals("N")) {
                    leave.setApplyStatusName("退回");
                }
            }
        }
    }

    /**
     * @Description: 设置请假类别名称、审批状态名称
     * @Auther: Mr.Kong
     * @Date: 2019/3/29 15:33
     * @Param: [leave]
     * @Return: void
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
            if (StringUtils.isNotEmpty(leave.getApplyStatus()) && leave.getApplyStatus().equals("R")) {
                leave.setApplyStatusName("审核中");
            }
            if (StringUtils.isNotEmpty(leave.getApplyStatus()) && leave.getApplyStatus().equals("Y")) {
                leave.setApplyStatusName("通过");
            } else if (StringUtils.isNotEmpty(leave.getApplyStatus()) && leave.getApplyStatus().equals("N")) {
                leave.setApplyStatusName("退回");
            }
        }
    }

    /**
     * @Description: 查询请假信息列表
     * @Auther: Mr.Kong
     * @Date: 2019/3/29 15:25
     * @Param: [leave]
     * @Return: java.util.List<cn.com.nantian.pojo.NtLeave>
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
     * @Description: 导入请假信息
     * @Auther: Mr.Kong
     * @Date: 2019/4/1 17:07
     * @Param: [myfile]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     **/
    @Override
    public Map<String, Object> importExcel(MultipartFile myfile) {
        try {
            Map<String, Object> map = new HashMap<>();
            String msg = "";
            //初始化成功条数
            int suct = 0;
            //初始化出错条数
            int dift = 0;
            XSSFWorkbook xssfWorkbook = null;
            xssfWorkbook = new XSSFWorkbook(myfile.getInputStream());
            XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
            //指的行数，一共有多少行
            int rows = sheet.getLastRowNum();
            for (int i = 2; i <= rows + 1; i++) {
                //读取左上端单元格
                XSSFRow row = sheet.getRow(i);
                //行不为空 读取cell
                if (row != null) {
                    //部门名称
                    String deptName = getCellValue(row.getCell((short) 0)).toString();
                    Integer deptId=selectDeptId(deptName);
                    if(ObjectUtils.isNull(deptId)){
                        msg += "第" + i + "行 部门名称为空或不正确; ";
                        dift++;
                        continue;
                    }
                    //员工姓名
                    String userName = getCellValue(row.getCell((short) 1)).toString();
                    if (StringUtils.isEmpty(userName)) {
                        msg += "第" + i + "行 员工姓名为空; ";
                        dift++;
                        continue;
                    }
                    List<NtPersonnel> userList = userService.findPerByDeptIdAndName(deptId, userName);
                    if(ObjectUtils.isNull(userList)){
                        msg += "第" + i + "行 员工不存在; ";
                        dift++;
                        continue;
                    }
                    //请假类型
                    String leaveTypeName = getCellValue(row.getCell((short) 2)).toString();
                    if (StringUtils.isEmpty(leaveTypeName)) {
                        msg += "第" + i + "行 请假类型为空; ";
                        dift++;
                        continue;
                    }
                    //请假天数
                    Float leaveDays = Float.valueOf(getCellValue(row.getCell((short) 3)).toString());
                    if (ObjectUtils.isNull(leaveDays)) {
                        msg += "第" + i + "行 请假天数为空; ";
                        dift++;
                        continue;
                    }
                    //请假开始时间
                    Date begDate = (Date) getCellValue(row.getCell((short) 4));
                    if (ObjectUtils.isNull(begDate)) {
                        msg += "第" + i + "行 请假开始时间为空; ";
                        dift++;
                        continue;
                    }
                    //请假结时间束
                    Date endDate = (Date) getCellValue(row.getCell((short) 5));
                    if (ObjectUtils.isNull(endDate)) {
                        msg += "第" + i + "行 请假结时间束为空; ";
                        dift++;
                        continue;
                    }
                    //请假明细
                    String leaveRemark = getCellValue(row.getCell((short) 6)).toString();
                    //时间格式转化
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String begin = sdf.format(begDate);
                    begDate = sdf.parse(begin);
                    String end = sdf.format(endDate);
                    endDate = sdf.parse(end);
                    //新增请假信息
                    NtLeave ntLeave = new NtLeave();
                    NtDictionariesKey dic = new NtDictionariesKey();
                    dic.setDicType(ParamUntil.hol);
                    List<NtDictionariesKey> dicList = dictionariesService.selectDictionariesList(dic);
                    if (ObjectUtils.isNotNull(dicList)) {
                        for (NtDictionariesKey dick : dicList) {
                            if (dick.getDicValue().equals(leaveTypeName)) {
                                //设置请假类型
                                ntLeave.setLeaveType(dick.getDicCode());
                            }
                        }
                    }
                    if (StringUtils.isEmpty(ntLeave.getLeaveType())) {
                        msg += "第" + i + "行 请假类型填写错误; ";
                        dift++;
                        continue;
                    }
                    ntLeave.setPerId(userList.get(0).getPerId());
                    ntLeave.setBegDate(begDate);
                    ntLeave.setEndDate(endDate);
                    ntLeave.setLeaveCount(leaveDays);
                    ntLeave.setLeaveRemark(leaveRemark);
                    ntLeave.setApplyStatus("R");
                    this.insertSelective(ntLeave);
                    suct++;
                }
            }
            //总行数
            map.put("rows ", rows);
            //成功条数
            map.put("success num ", suct);
            //失败条数
            map.put("failed num ", dift);
            //异常行数
            map.put("error ", msg);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    /**
     * @Description: 获得xsscell内容
     * @Auther: Mr.Kong
     * @Date: 2019/4/1 17:07
     * @Param: [cell]
     * @Return: java.lang.Object
     **/
    @Override
    public Object getCellValue(Cell cell) {
        Object value = "";
        //格式化number String字符串
        DecimalFormat df = new DecimalFormat("0");
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
      * @Description: 查询部门id
      * @Auther: Mr.Kong
      * @Date: 2019/4/3 14:31
      * @Param: [deptName] 部门名称
      * @Return: int  部门id
      **/
    public Integer selectDeptId(String deptName){
        Integer deptId=null;
        List<NtDepartment> departmentList = departmentService.findAll();
        if(ObjectUtils.isNotNull(departmentList) && StringUtils.isNotEmpty(deptName)){
            for (NtDepartment department:departmentList){
                if(department.getDeptName().equals(deptName)){
                    deptId=department.getDeptId();
                    break;
                }
            }
        }
        return deptId;
    }
}
