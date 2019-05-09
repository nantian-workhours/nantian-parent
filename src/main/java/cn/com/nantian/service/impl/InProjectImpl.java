package cn.com.nantian.service.impl;
import cn.com.nantian.common.*;

import cn.com.nantian.mapper.*;
import cn.com.nantian.pojo.*;
import cn.com.nantian.service.InProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.*;
import java.util.*;
import java.util.List;
/**
  * @Description: 员工所在项目管理
  * @Auther: Mr.Kong
  * @Date: 2019/5/9 10:46
  **/
@Service
public class InProjectImpl implements InProjectService{
    @Resource
    private NtPerInProjectMapper perInProjectMapper;
    @Resource
    private NtProjectInfoMapper projectInfoMapper;
    @Resource
    private NtPersonnelMapper personnelMapper;
    @Resource
    private NtDictionariesMapper dictionariesMapper;

    /**
      * @Description: 创建时 效验传入的参数值
      * @Auther: Mr.Kong
      * @Date: 2019/5/9 11:07
      * @Param:  [ntPerInProject]
      * @Return: java.lang.String
      **/
    public String checkAttribute(NtPerInProject ntPerInProject) throws Exception{
        if (ObjectUtils.isNull(ntPerInProject.getPerId())) {
            return "员工编号 不能为空！";
        }
        if (StringUtils.isEmpty(ntPerInProject.getIdNo())) {
            return "身份证号 不能为空！";
        }else if (!RegExpressionUtils.isIDNumber(ntPerInProject.getIdNo())){
            return "身份证号 格式不正确！";
        }
        if (StringUtils.isEmpty(ntPerInProject.getCustType())) {
            return "客户类别 不能为空！";
        }
        if (ObjectUtils.isNull(ntPerInProject.getProjectNumber())) {
            return "项目名称 不能为空！";
        }
        if (StringUtils.isEmpty(ntPerInProject.getWorkType())) {
            return "工作类别 不能为空！";
        }
        if (StringUtils.isEmpty(ntPerInProject.getWorkLevel())) {
            return "技术等级 不能为空！";
        }
        if (ObjectUtils.isNotNull(ntPerInProject.getProjectBegdateStr())) {
            if (!DateUtils.checkDateReg(ntPerInProject.getProjectBegdateStr())) {
                return "开始日期 格式不正确！";
            } else {
                ntPerInProject.setProjectBegdate(DateUtils.parseToDate(ntPerInProject.getProjectBegdateStr(), "yyyy-MM-dd"));
            }
        }
        if (ObjectUtils.isNotNull(ntPerInProject.getProjectEnddateStr())) {
            if (!DateUtils.checkDateReg(ntPerInProject.getProjectEnddateStr())) {
                return "结束日期 格式不正确！";
            } else {
                ntPerInProject.setProjectEnddate(DateUtils.parseToDate(ntPerInProject.getProjectEnddateStr(), "yyyy-MM-dd"));
            }
        }
        if (ObjectUtils.isNotNull(ntPerInProject.getProjectBegdate()) && ObjectUtils.isNotNull(ntPerInProject.getProjectEnddate())){
            if (ntPerInProject.getProjectBegdate().getTime()>=ntPerInProject.getProjectEnddate().getTime()){
                return "结束日期必须大于开始日期！";
            }
        }
        return "";
    }

    /**
     * @Description: 创建时 效验数据是否已存在
     * @Auther: Mr.Kong
     * @Date: 2019/5/9 14:28
     * @Param:  [ntPerInProject]
     * @Return: boolean
     **/
    public boolean checkWhetherRepeat(NtPerInProject ntPerInProject) {
        List<NtPerInProject> ntPerInProjectList = this.queryNtPerInProjectList(null);
        boolean repeat = false;
        if (ObjectUtils.isNotNull(ntPerInProjectList) && ObjectUtils.isNotNull(ntPerInProject)) {
            for (NtPerInProject perInProject : ntPerInProjectList) {
                if (perInProject.equals(ntPerInProject)) {
                    repeat = true;
                    break;
                }
            }
        }
        return repeat;
    }






    /**
     * 添加员工所在项目信息
     * @param perInProject
     * @return
     */
    @Override
    public int addPerInProject(NtPerInProject perInProject) {
        perInProject.setCreateTime(new Date());
        perInProject.setStatus(0);
        return perInProjectMapper.insert(perInProject);
    }

    @Override
    public List<NtPerInProject> queryNtPerInProjectList(NtPerInProject perInProject){
        return perInProjectMapper.queryNtPerInProjectList(perInProject);
    }

    @Override
    public NtPerInProject queryPerInProjectInfo(int id) {
        return perInProjectMapper.queryPerInProjectInfo(id);
    }

    /**
     * 查询所有的客户信息
     * @return
     */
    @Override
    public List<NtProjectInfo> selectAllProject() {
        List<NtProjectInfo> projectInfoList = projectInfoMapper.selectByExample(null);
        return projectInfoList ;
    }

    /**
     * 获取员工的部门名称,项目名称,项目等级,工作类型.客户类型,在场状态
     * @param idNo
     * @param projectNumber
     * @param inProjectLeave
     * @param workType
     * @return
     */
    private Map<String ,String> getDictionaries(String idNo, int projectNumber, String inProjectLeave, String workType, Date projectEndDate){
        //初始化map
        Map<String,String > map =new HashMap<>();
        //根据身份证号查询姓名和部门

       NtPersonnel personnel =  personnelMapper.selectByPrimaryIdNo(idNo);
        NtDictionariesKey deptNameAll = dictionariesMapper.selectByTypeAndCode(ParamUntil.dept,personnel.getDeptId().toString());
       //查询客户类别和项目名称
        NtProjectInfo projectInfo = projectInfoMapper.selectByPrimaryKey(projectNumber);
        //获取客户类别
        NtDictionariesKey custTypeAll = dictionariesMapper.selectByTypeAndCode(ParamUntil.cust,projectInfo.getCustType());
        //获取工作类别
        NtDictionariesKey workTypeAll = dictionariesMapper.selectByTypeAndCode(ParamUntil.wt,workType);
        //获取技术等级
        NtDictionariesKey inProjectLeaveAll = dictionariesMapper.selectByTypeAndCode(ParamUntil.tc,inProjectLeave);
        //将内容添加到map中
        map.put("deptName",deptNameAll.getDicValue());
        map.put("name",personnel.getName());
        map.put("custType",custTypeAll.getDicValue());
        map.put("projectName",projectInfo.getProjectName());
        map.put("workType",workTypeAll.getDicValue());
        map.put("inProjectLeave",inProjectLeaveAll.getDicValue());
        //判断在职状态
        if(projectEndDate.after(new Date())){
             map.put("status","在场");
        } else if (projectEndDate == null) {
            map.put("status", "至今");
        } else {
            map.put("status", "离场");
        }
        return  map;
    }

    /**
     * 修改员工所在项目
     * @param perInProject
     * @return
     */
    @Override
    public int updatePerInpro(NtPerInProject perInProject) {

        NtPerInProjectExample example = new NtPerInProjectExample();
        NtPerInProjectExample.Criteria criteria = example.createCriteria();
        criteria.andProjectNumberEqualTo(perInProject.getProjectNumber());
        criteria.andIdNoEqualTo(perInProject.getIdNo());
        //根据项目编号和身份证号修改
        return perInProjectMapper.updateByExampleSelective(perInProject,example);
    }
}
