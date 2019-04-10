package cn.com.nantian.service.impl;

import cn.com.nantian.common.ParamUntil;

import cn.com.nantian.mapper.*;
import cn.com.nantian.pojo.*;
import cn.com.nantian.service.InProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by ydz on 2019/3/18
 */


@Service
public class InprojectImpl implements InProjectService{


    @Resource
    private NtPerInProjectMapper perInProjectMapper;

    @Resource
    private NtProjectInfoMapper projectInfoMapper;

    @Resource
    private NtPersonnelMapper personnelMapper;
    @Resource
    private NtDictionariesMapper dictionariesMapper;

    /**
     * 添加员工所在项目信息
     * @param perInProject
     * @return
     */
    @Override
    public int addPerInProject(NtPerInProject perInProject) {
        //查询该员工所在的项目信息
        NtPerInProjectExample example = new NtPerInProjectExample();
        NtPerInProjectExample.Criteria criteria = example.createCriteria();
        criteria.andIdNoEqualTo(perInProject.getIdNo());
        List<NtPerInProject> perInProjectList = perInProjectMapper.selectByExample(example);
        for (int i=0;i<perInProjectList.size();i++){
            //判断该员工在这个项目组中新建的时间是否比结束时间早
           if( perInProjectList.get(i).getProjectEnddate().after(perInProject.getProjectBegdate()) ){
               return -1;
           }
        }
        //判断开始时间是否比接受时间早
        if(perInProject.getProjectEnddate().before(perInProject.getProjectBegdate())){
           return -2;
        }
        //插入员工
        return perInProjectMapper.insert(perInProject);
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

    @Override
    public List<NtPersonnel> select2(String name) {
        List<NtPersonnel> personnelList = personnelMapper.selectByName(name);
        return personnelList ;
    }

    /**
     * 根据客户类别,项目名称,员工姓名查询员工所在项目信息
     * @param custType
     * @param projectName
     * @param name
     * @return
     */
//    @Override
//    public List<InProjectItem> selectPerInProject(String custType, String projectName, String name) {
//        InProjectItem inProjectItem = new InProjectItem();
//        List<InProjectItem> inProjectItemList =new ArrayList<InProjectItem>();
//
//        //根据客户类别和项目名称查询部门编号
//        NtProjectInfoExample example = new NtProjectInfoExample();
//        NtProjectInfoExample.Criteria criteria = example.createCriteria();
//        //添加条件
//        if(custType!=null || custType!=""){
//            criteria.andCustTypeEqualTo(custType);
//        }
//        if(projectName!=null || projectName!=""){
//            criteria.andProjectNameEqualTo(projectName);
//        }
//        //返回项目信息列表
//        List<NtProjectInfo> projectInfoList = projectInfoMapper.selectByExample(example);
//
//        //根据姓名查询出身份证列表集合
//        NtPersonnelExample example1 = new NtPersonnelExample();
//        NtPersonnelExample.Criteria criteria1 = example1.createCriteria();
//        criteria1.andNameEqualTo(name);
//        List<NtPersonnel> personnelList = personnelMapper.selectByExample(example1);
//        System.out.println("projectInfoList "+projectInfoList.size());
//        System.out.println("personnelList "+personnelList.size());
//        //根据项目编号和姓名查询
//        if(projectInfoList.size()>0 && personnelList.size()>0){
//            //循环获取list中的项目编号信息,项目编号
//            for (NtProjectInfo projectInfo: projectInfoList) {
//                //循环personnellist集合获取身份证集合
//                for (NtPersonnel personnel:personnelList) {
//                    //根据部门和姓名去查询所在项目信息
//                    NtPerInProjectExample example2 = new NtPerInProjectExample();
//                    NtPerInProjectExample.Criteria criteria2 = example2.createCriteria();
//                    //添加身份证集合信息
//                    criteria2.andIdNoEqualTo(personnel.getName());
//                    //添加部门信息
//                    criteria2.andProjectNumberEqualTo(projectInfo.getProjectNumber());
//                    List<NtPerInProject> perInProjectList = perInProjectMapper.selectByExample(example2);
//                    //查询NtPerInProject列表
//                    seletePerInpro(perInProjectList);
//                }
//            }
//            //根据项目编号查询
//        }else if(projectInfoList.size()>0 && personnelList.size()<0){
//            //循环获取list中的项目编号信息,项目编号
//            for (NtProjectInfo projectInfo: projectInfoList) {
//
//                    //根据部门和姓名去查询所在项目信息
//                    NtPerInProjectExample example2 = new NtPerInProjectExample();
//                    NtPerInProjectExample.Criteria criteria2 = example2.createCriteria();
//                    //添加部门信息
//                    criteria2.andProjectNumberEqualTo(projectInfo.getProjectNumber());
//                    List<NtPerInProject> perInProjectList = perInProjectMapper.selectByExample(example2);
//
//                    //查询NtPerInProject列表
//                    seletePerInpro(perInProjectList);
//                }
//                //根据姓名查询
//        }else if(projectInfoList.size()<0 && personnelList.size()>0){
//                //循环personnellist集合获取身份证集合
//                for (NtPersonnel personnel:personnelList) {
//                    //根据部门和姓名去查询所在项目信息
//                    NtPerInProjectExample example2 = new NtPerInProjectExample();
//                    NtPerInProjectExample.Criteria criteria2 = example2.createCriteria();
//                    //添加身份证集合信息
//                    criteria2.andIdNoEqualTo(personnel.getName());
//                    List<NtPerInProject> perInProjectList = perInProjectMapper.selectByExample(example2);
//                    //查询NtPerInProject列表
//                    seletePerInpro(perInProjectList);
//                }
//            //查询所有
//        }else{
//            List<NtPerInProject> perInProjectList = perInProjectMapper.selectByExample(null);
//            //查询NtPerInProject列表
//            seletePerInpro(perInProjectList);
//        }
//
//        return inProjectItemList;
//    }

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

    //查询NtPerInProject列表
    private  List<InProjectItem> seletePerInpro( List<NtPerInProject> perInProjectList) {
        List<InProjectItem> inProjectItemList = new ArrayList<InProjectItem>();
        InProjectItem inProjectItem = new InProjectItem();
        for (NtPerInProject perInProject : perInProjectList) {
            //获取员工的部门名称,项目名称,项目等级,工作类型.客户类型
            Map<String, String> perMap = getDictionaries(perInProject.getIdNo(), perInProject.getProjectNumber(), perInProject.getInProjectLeave(), perInProject.getWorkType(), perInProject.getProjectEnddate());
            //设置身份证
            inProjectItem.setIdNo(perInProject.getIdNo());
            //设置开始日期和结束日期
            inProjectItem.setProjectBegdate(perInProject.getProjectBegdate());
            inProjectItem.setProjectEnddate(perInProject.getProjectEnddate());
            //设置部门名称
            inProjectItem.setDeptName(perMap.get("deptName"));
            //设置客户类别
            inProjectItem.setCustType(perMap.get("custType"));
            //设置项目名称
            inProjectItem.setProjectName(perMap.get("projectName"));
            //设置工作类别
            inProjectItem.setWorkType(perMap.get("workType"));
            //设置技术等级
            inProjectItem.setInProjectLeave(perMap.get("inProjectLeave"));
            //设置在场状态
            inProjectItem.setStatus(perMap.get("status"));
            //添加姓名
            inProjectItem.setName(perMap.get("name"));
            inProjectItemList.add(inProjectItem);
        }
        return inProjectItemList;
    }



    /**
     * 根据客户类别,项目名称,员工姓名查询员工所在项目信息
     * @param custType
     * @param projectName
     * @param perId
     * @return
     */
    @Override
    public List<InProjectItem> selectPerInProject2(String custType, String projectName, int perId) {

        List<InProjectItem> inProjectItemList = new ArrayList<>();
        List<InProjectItem> inProjectItemList1 =null;
        List<NtProjectInfo> projectInfoList=null;

        List<NtPerInProject> perInProjectList=new ArrayList<>();

        if (custType!=null||"".equals(custType) ){//客户类别不为空
                //根据项目名称和客户类别查询项目编号
                projectInfoList = projectInfoMapper.selectBycustAndProjectName(custType, projectName);
                for (NtProjectInfo projectInfo:projectInfoList) {
//                    System.out.println(projectInfo.getProjectNumber());
//                    System.out.println(perId);
                    //查询员工所在项目列表
                    perInProjectList = perInProjectMapper.selectByPerIdAndProjectNum(perId,projectInfo.getProjectNumber());
                    //InProjectItem赋值
                    if( perInProjectList.size()>0 ){
                        inProjectItemList1 = seletePerInpro(perInProjectList);
                        if( inProjectItemList1.size()>0){
                            inProjectItemList.addAll(inProjectItemList1);
                        }else{
                            continue;
                        }
                    }else{
                        continue;
                    }
            }
            return inProjectItemList;
        }else{
            //查询所有
            perInProjectList = perInProjectMapper.selectByExample(null);
            inProjectItemList = seletePerInpro(perInProjectList);
        }
        return inProjectItemList;
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
