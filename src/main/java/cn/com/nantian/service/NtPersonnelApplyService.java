/**
 * @description: 员工考勤异常处理申请管理
 * @ClassName: NtPersonnelApplyService
 * @author： Mr.Kong
 * @date: 2019/5/13 16:48
 * @Version： 1.0
 */
package cn.com.nantian.service;

import cn.com.nantian.pojo.NtPersonnelApply;

import java.util.List;

public interface NtPersonnelApplyService {

    /**
     * @description: 更新处理状态
     * @auther: Mr.Kong
     * @date: 2019/5/14 15:46
     * @param: [personnelApply]
     * @return: int
     **/
    int updateApplyStatus(NtPersonnelApply personnelApply);

    /**
     * @description: 查询员工异议申请信息列表
     * @auther: Mr.Kong
     * @date: 2019/5/14 15:15
     * @param: [personnelApply]
     * @return: List<NtPersonnelApply>
     **/
    List<NtPersonnelApply> queryPersonApplyList(NtPersonnelApply personnelApply);

    /**
     * @description: 创建时 效验传入的参数值
     * @auther: Mr.Kong
     * @date: 2019/5/14 14:08
     * @param: [personnelApply]
     * @return: java.lang.String
     **/
    String checkAttribute(NtPersonnelApply personnelApply) throws Exception;

    int deleteByPrimaryKey(Integer applySeq);

    int insert(NtPersonnelApply record);

    int insertSelective(NtPersonnelApply record);

    /**
     * @description: 查询员工异议申请信息详情
     * @auther: Mr.Kong
     * @date: 2019/5/14 15:48
     * @param: [applySeq]
     * @return: NtPersonnelApply
     **/
    NtPersonnelApply selectByPrimaryKey(Integer applySeq);

    int updateByPrimaryKeySelective(NtPersonnelApply record);

    int updateByPrimaryKey(NtPersonnelApply record);
}
