package cn.com.nantian.service;

import cn.com.nantian.pojo.NtLeave;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface LeaveService {
    /**
     * @Description: 更新时 效验传入的参数值
     * @auther: Mr.Kong
     * @date: 2019/5/13 16:07
     * @param:  [ntLeave]
     * @return: java.lang.String
     **/
    public String checkUpdateAttribute(NtLeave ntLeave) throws Exception;
    /**
     * @Description: 创建时 效验传入的参数值
     * @auther: Mr.Kong
     * @date: 2019/5/13 16:07
     * @param:  [ntLeave]
     * @return: java.lang.String
     **/
    String checkAttribute(NtLeave ntLeave) throws Exception;

    /**
     * @Description: 更新审批状态(R 审核中, Y 通过, N 退回)
     * @Auther: Mr.Kong
     * @Date: 2019/3/29 15:52
     * @Param: [leave]
     * @Return: int
     **/
    int updateLeaveStatus(NtLeave leave);

    /**
     * @Description: 设置请假类别名称、审批状态名称
     * @Auther: Mr.Kong
     * @Date: 2019/3/29 15:32
     * @Param: [leaveList]
     * @Return: void
     **/
    public void setLeaveTypeName(List<NtLeave> leaveList);

    /**
     * @Description: 设置请假类别名称、审批状态名称
     * @Auther: Mr.Kong
     * @Date: 2019/3/29 15:33
     * @Param: [leave]
     * @Return: void
     **/
    public void setLeaveTypeName(NtLeave leave);

    /**
     * @Description: 查询请假信息列表
     * @Auther: Mr.Kong
     * @Date: 2019/3/29 15:25
     * @Param: [leave]
     * @Return: java.util.List<cn.com.nantian.pojo.NtLeave>
     **/
    List<NtLeave> selectLeaveList(NtLeave leave);

    int deleteByPrimaryKey(Integer leaveId);

    int insert(NtLeave record);

    int insertSelective(NtLeave record);

    NtLeave selectByPrimaryKey(Integer leaveId);

    int updateByPrimaryKeySelective(NtLeave record);

    int updateByPrimaryKey(NtLeave record);

    /**
     * @Description: 导入请假信息
     * @Auther: Mr.Kong
     * @Date: 2019/4/1 17:07
     * @Param: [myfile]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     **/
    Map<String ,Object>  importExcel(MultipartFile myfile);
    /**
     * @Description: 获得xsscell内容
     * @Auther: Mr.Kong
     * @Date: 2019/4/1 17:07
     * @Param: [cell]
     * @Return: java.lang.Object
     **/
    Object getCellValue(Cell cell);
}
