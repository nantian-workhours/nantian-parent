package cn.com.nantian.service;

import cn.com.nantian.pojo.NtLeave;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface LeaveService {

    List<NtLeave> getStatisticalLeave(NtLeave ntLeave);

    List<NtLeave> queryStatisticalLeave(NtLeave ntLeave);

    Map<String,Object> getStatisticalLeaveTotal(NtLeave ntLeave) throws Exception;


    NtLeave queryStatisticalLeaveTotal(NtLeave ntLeave);

    /**
     * @description: 效验请假信息是否已存在
     * @auther: Mr.Kong
     * @date: 2019/5/16 13:50
     * @param:  [ntLeave]
     * @return: boolean true 有，false 无
     **/
    public boolean checkWhetherRepeat(NtLeave ntLeave);
    /**
     * @description: 更新时 效验传入的参数值
     * @auther: Mr.Kong
     * @date: 2019/5/13 16:07
     * @param:  [ntLeave]
     * @return: java.lang.String
     **/
    public String checkUpdateAttribute(NtLeave ntLeave) throws Exception;
    /**
     * @description: 创建时 效验传入的参数值
     * @auther: Mr.Kong
     * @date: 2019/5/13 16:07
     * @param:  [ntLeave]
     * @return: java.lang.String
     **/
    String checkAttribute(NtLeave ntLeave) throws Exception;

    /**
     * @description: 更新审批状态(R 审核中, Y 通过, N 退回)
     * @auther: Mr.Kong
     * @date: 2019/3/29 15:52
     * @Param: [leave]
     * @return: int
     **/
    int updateLeaveStatus(NtLeave leave);

    /**
     * @description: 设置请假类别名称、审批状态名称
     * @auther: Mr.Kong
     * @date: 2019/3/29 15:32
     * @Param: [leaveList]
     * @return: void
     **/
    public void setLeaveTypeName(List<NtLeave> leaveList);

    /**
     * @description: 设置请假类别名称、审批状态名称
     * @auther: Mr.Kong
     * @date: 2019/3/29 15:33
     * @Param: [leave]
     * @return: void
     **/
    public void setLeaveTypeName(NtLeave leave);

    /**
     * @description: 查询请假信息列表
     * @auther: Mr.Kong
     * @date: 2019/3/29 15:25
     * @Param: [leave]
     * @return: List<NtLeave>
     **/
    List<NtLeave> selectLeaveList(NtLeave leave);

    int deleteByPrimaryKey(Integer leaveId);

    int insert(NtLeave record);

    int insertSelective(NtLeave record);

    NtLeave selectByPrimaryKey(Integer leaveId);

    int updateByPrimaryKeySelective(NtLeave record);

    int updateByPrimaryKey(NtLeave record);

    /**
     * @description: 导入请假信息
     * @auther: Mr.Kong
     * @date: 2019/4/1 17:07
     * @Param: [myfile]
     * @return: Map<String,Object>
     **/
    Map<String ,Object>  importExcel(MultipartFile myfile) throws Exception;
    /**
     * @description: 获得xsscell内容
     * @auther: Mr.Kong
     * @date: 2019/4/1 17:07
     * @Param: [cell]
     * @return: java.lang.Object
     **/
    Object getCellValue(Cell cell);
}
