package cn.com.nantian.service.impl;

import cn.com.nantian.common.*;
import cn.com.nantian.mapper.NtDictionariesMapper;
import cn.com.nantian.mapper.NtPerInProjectMapper;
import cn.com.nantian.mapper.NtPersonnelMapper;
import cn.com.nantian.mapper.NtProjectInfoMapper;
import cn.com.nantian.pojo.*;
import cn.com.nantian.service.InProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 员工所在项目管理
 * @auther: Mr.Wind
 * @date: 2019/5/9 10:46
 **/
@Service
public class InProjectServiceImpl implements InProjectService {
    @Resource
    private NtPerInProjectMapper perInProjectMapper;
    @Resource
    private NtProjectInfoMapper projectInfoMapper;
    @Resource
    private NtPersonnelMapper personnelMapper;
    @Resource
    private NtDictionariesMapper dictionariesMapper;

    public Map<String,Object> getStatisticsUserNum(NtPerInProject perInProject){
        Map<String, Object> map = new HashMap<>();
        List<NtDictionariesKey> dictionariesList = dictionariesMapper.selectByType(ParamUntil.dc);
        List<NtPerInProject> ntPerInProjectList = perInProjectMapper.queryStatisticsUserNum(perInProject);
        if (ObjectUtils.isNotNull(dictionariesList) && ObjectUtils.isNotNull(ntPerInProjectList)){
            for (NtDictionariesKey dictionaries:dictionariesList){
                String dicCode=dictionaries.getDicCode();
                int totalNum=0;
                for (NtPerInProject ntPerInProject:ntPerInProjectList){
                    if (dicCode.equals(ntPerInProject.getWorkLevel())){
                        totalNum=ntPerInProject.getTotalNum();
                        break;
                    }
                }
                map.put(ParamUntil.dc+"_"+dicCode,totalNum);
            }
        }
        return map;
    }


    @Override
    public List<NtPerInProject> queryStatisticsUserNum(NtPerInProject perInProject) {
        return perInProjectMapper.queryStatisticsUserNum(perInProject);
    }

    /**
      * @description: 根据客户分类 统计员人数
      * @auther: Mr.Wind
      * @date: 2019/6/8 15:31
      * @param:  [perInProject]
      * @return: java.util.Map<java.lang.String,java.lang.Object>
      **/
    public Map<String,Object> getStatisticsNumByCustType(NtPerInProject perInProject) {
        perInProject.setProjectBegdate(new Date());
        Map<String,Object> map=new HashMap<>();
        List<NtPerInProject> ntPerInProjectList = perInProjectMapper.queryStatisticsNumByCustType(perInProject);
        List<NtDictionariesKey> dictionariesKeyList = dictionariesMapper.selectByType(ParamUntil.cust);
        if (ObjectUtils.isNotNull(dictionariesKeyList)){
            for (NtDictionariesKey dictionaries:dictionariesKeyList){
                int totalNum=0;
                String dicCode=dictionaries.getDicCode();
                for (NtPerInProject perInProject2:ntPerInProjectList){
                    if (dicCode.equals(perInProject2.getCustType())){
                        totalNum=perInProject2.getTotalNum();
                        break;
                    }
                }
                map.put(ParamUntil.cust+"_"+dicCode,totalNum);
            }
        }
        return map;
    }



    @Override
    public List<NtPerInProject> queryStatisticsNumByCustType(NtPerInProject perInProject) {
        return perInProjectMapper.queryStatisticsNumByCustType(perInProject);
    }

    /**
     * @description: 创建时 效验传入的参数值
     * @auther: Mr.Wind
     * @date: 2019/5/9 11:07
     * @Param: [ntPerInProject]
     * @return: java.lang.String
     **/
    public String checkAttribute(NtPerInProject ntPerInProject) throws Exception {
        if (ObjectUtils.isNull(ntPerInProject.getPerId())) {
            return "员工编号 不能为空！";
        }
        if (StringUtils.isEmpty(ntPerInProject.getIdNo())) {
            return "身份证号 不能为空！";
        } else if (!RegExpressionUtils.isIDNumber(ntPerInProject.getIdNo())) {
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
        if (ObjectUtils.isNotNull(ntPerInProject.getProjectBegdate()) && ObjectUtils.isNotNull(ntPerInProject.getProjectEnddate())) {
            if (ntPerInProject.getProjectBegdate().getTime() >= ntPerInProject.getProjectEnddate().getTime()) {
                return "结束日期必须大于开始日期！";
            }
        }
        return "";
    }

    /**
     * @description: 创建时 效验数据是否已存在
     * @auther: Mr.Wind
     * @date: 2019/5/9 14:28
     * @Param: [ntPerInProject]
     * @return: boolean
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
     * @description: 更新时 效验数据是否已存在
     * @auther: Mr.Wind
     * @date: 2019/5/9 15:58
     * @Param: [ntPerInProject]
     * @return: boolean
     **/
    public boolean checkUpdateWhetherRepeat(NtPerInProject ntPerInProject) {
        List<NtPerInProject> ntPerInProjectList = this.queryNtPerInProjectList(null);
        boolean repeat = false;
        if (ObjectUtils.isNotNull(ntPerInProjectList) && ObjectUtils.isNotNull(ntPerInProject)) {
            for (NtPerInProject perInProject : ntPerInProjectList) {
                if (perInProject.getPerId() != ntPerInProject.getPerId() && perInProject.equals(ntPerInProject)) {
                    repeat = true;
                    break;
                }
            }
        }
        return repeat;
    }

    /**
     * @description: 添加员工所在项目信息
     * @auther: Mr.Wind
     * @date: 2019/5/9 15:59
     * @Param: [perInProject]
     * @return: int
     **/
    @Override
    public int addPerInProject(NtPerInProject perInProject) {
        perInProject.setCreateTime(new Date());
        perInProject.setStatus(0);
        return perInProjectMapper.insert(perInProject);
    }

    /**
     * @description: 查询员工所在项目列表数据
     * @auther: Mr.Wind
     * @date: 2019/5/9 16:33
     * @Param:  [perInProject]
     * @return: List<NtPerInProject>
     **/
    @Override
    public List<NtPerInProject> queryNtPerInProjectList(NtPerInProject perInProject) {
        return perInProjectMapper.queryNtPerInProjectList(perInProject);
    }

    /**
      * @description: 查询员工所在项目详情信息
      * @auther: Mr.Wind
      * @date: 2019/5/9 16:34
      * @Param:  [id]
      * @return: NtPerInProject
      **/
    @Override
    public NtPerInProject queryPerInProjectInfo(int id) {
        return perInProjectMapper.queryPerInProjectInfo(id);
    }

    /**
     * @description: 更新员工所在项目信息
     * @auther: Mr.Wind
     * @date: 2019/5/9 16:35
     * @Param:  [ntPerInProject]
     * @return: int
     **/
    @Override
    public int updateNtPerInProject(NtPerInProject ntPerInProject) {
        return perInProjectMapper.updateNtPerInProject(ntPerInProject);
    }

    /**
      * @description: 设置在场状态
      * @auther: Mr.Wind
      * @date: 2019/5/9 16:47
      * @Param:  [ntPerInProjectList]
      * @return: void
      **/
    public void setWorkStatus(List<NtPerInProject> ntPerInProjectList){
        if (ObjectUtils.isNotNull(ntPerInProjectList)){
            for (NtPerInProject perInProject:ntPerInProjectList){
                //在职状态
                if (ObjectUtils.isNotNull(perInProject.getProjectBegdate()) && ObjectUtils.isNotNull(perInProject.getProjectEnddate())){
                    if(perInProject.getProjectEnddate().after(new Date())){
                        perInProject.setWorkStatus("在场");
                    }else if(perInProject.getProjectEnddate().before(new Date())){
                        perInProject.setWorkStatus("离场");
                    }else {
                        perInProject.setWorkStatus("至今");
                    }
                }else {
                    perInProject.setWorkStatus("待定");
                }
            }
        }
    }

    /**
     * 获取员工的部门名称,项目名称,项目等级,工作类型.客户类型,在场状态
     *
     * @param idNo
     * @param projectNumber
     * @param inProjectLeave
     * @param workType
     * @return
     */
    private Map<String, String> getDictionaries(String idNo, int projectNumber, String inProjectLeave, String workType, Date projectEndDate) {
        //初始化map
        Map<String, String> map = new HashMap<>();
        //根据身份证号查询姓名和部门

        NtPersonnel personnel = personnelMapper.selectByPrimaryIdNo(idNo);
        NtDictionariesKey deptNameAll = dictionariesMapper.selectByTypeAndCode(ParamUntil.dept, personnel.getDeptId().toString());
        //查询客户类别和项目名称
        NtProjectInfo projectInfo = projectInfoMapper.selectByPrimaryKey(projectNumber);
        //获取客户类别
        NtDictionariesKey custTypeAll = dictionariesMapper.selectByTypeAndCode(ParamUntil.cust, projectInfo.getCustType());
        //获取工作类别
        NtDictionariesKey workTypeAll = dictionariesMapper.selectByTypeAndCode(ParamUntil.wt, workType);
        //获取技术等级
        NtDictionariesKey inProjectLeaveAll = dictionariesMapper.selectByTypeAndCode(ParamUntil.tc, inProjectLeave);
        //将内容添加到map中
        map.put("deptName", deptNameAll.getDicValue());
        map.put("name", personnel.getName());
        map.put("custType", custTypeAll.getDicValue());
        map.put("projectName", projectInfo.getProjectName());
        map.put("workType", workTypeAll.getDicValue());
        map.put("inProjectLeave", inProjectLeaveAll.getDicValue());
        //判断在职状态
        if (projectEndDate.after(new Date())) {
            map.put("status", "在场");
        } else if (projectEndDate == null) {
            map.put("status", "至今");
        } else {
            map.put("status", "离场");
        }
        return map;
    }

}
