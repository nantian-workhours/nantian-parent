package cn.com.nantian.service.impl;

import cn.com.nantian.mapper.NtPerAliasMapper;
import cn.com.nantian.mapper.NtPersonnelMapper;
import cn.com.nantian.mapper.NtProjectInfoMapper;
import cn.com.nantian.pojo.NtPerAlias;

import cn.com.nantian.pojo.NtPerAliasExample;
import cn.com.nantian.pojo.NtPersonnel;
import cn.com.nantian.pojo.NtProjectInfo;
import cn.com.nantian.pojo.entity.ProList;
import cn.com.nantian.service.ProjectNameService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


import java.util.ArrayList;
import java.util.List;


@Service
public class ProjectNameImpl implements ProjectNameService {


    @Resource
    private NtPerAliasMapper perAliasMapper;
    @Resource
    private NtPersonnelMapper personnelMapper;
    @Resource
    private NtProjectInfoMapper projectInfoMapper;

    /**
     * 添加别名内容
     * @param perAlias
     * @return
     */
    @Override
    public int addProjectName(NtPerAlias perAlias) {

        //判断员工表中是否有该员工,根据身份证号
       NtPersonnel personnel =  personnelMapper.selectByPrimaryIdNo(perAlias.getIdNo());
        if(personnel != null ){
            int a=0;
            //判断是否已经添加这个别名
            int t = perAliasMapper.selectByPerIdAndName(personnel.getPerId(),perAlias.getInProjectName());
            if(t==0){
                //设置员工编号
                perAlias.setPerId(personnel.getPerId());
                //将信息插入到别名表中
                a = perAliasMapper.insert(perAlias);
                }
            return  a;
        }else{
                return 0;
            }

    }

    /**
     * 查询别名信息
     * @param inCompanyName
     * @param idNo
     * @param custType
     * @return
     */
    @Override
    public List<NtPerAlias> selectAllName(String inCompanyName, String idNo, String custType) {
        //根据客户类别查询出项目编号
        List<NtProjectInfo> projectInfoList = projectInfoMapper.selectByCustType(custType);
        List<Integer> list =new ArrayList<Integer>();
        if(projectInfoList==null || inCompanyName!= null || idNo != null){
            //根据身份证号/姓名查询查询用户别名信息
            List<NtPerAlias> perAliases = perAliasMapper.selectByNameOrIdNo(inCompanyName, idNo);
            return  perAliases;
        }else if(projectInfoList !=null ){
          //根据项目编号列表查询
           for (NtProjectInfo projectInfo: projectInfoList) {
               list.add(projectInfo.getProjectNumber());
           }
           //判断查询的客户列表是否为空 ,为空返回null
           if(list.size() > 0){
            ProList aliasList =new ProList();
           aliasList.setProjectNumberArr(list);
           //根据客户类别查询
            List<NtPerAlias> perAliases = perAliasMapper.selectByAliasList(aliasList);
            return perAliases;
           }else{
               return  null;
           }
        }else {
            return null;
        }
    }

    /**
     * 根据员工身份证号,别名,客户名称删除员工别名信息
     * @param idNo
     * @param inProjectName
     *
     * @return
     */
    @Override
    public int deleteOtherName(String idNo, String inProjectName) {
        return perAliasMapper.deleteByIdNoAndOtherName(idNo,inProjectName);
    }

    /**
     * 修改别名信息
     * @param perAlias
     * @return
     */
    @Override
    public int updateOtherName(NtPerAlias perAlias) {
        int t = 0;
        //查询客户类别名称
        NtProjectInfo projectInfo = projectInfoMapper.selectByPrimaryKey(perAlias.getProjectNumber());

        //根据客户类别和身份证号修改
        NtPerAliasExample example = new NtPerAliasExample();
        NtPerAliasExample.Criteria criteria = example.createCriteria();
        //创建条件身份证号,姓名,项目编号
        criteria.andIdNoEqualTo(perAlias.getIdNo());
        criteria.andProjectNumberEqualTo(projectInfo.getProjectNumber());
        criteria.andInCompanyNameEqualTo(perAlias.getInCompanyName());
        criteria.andPerIdEqualTo(perAlias.getPerId());
        t = perAliasMapper.updateByExample(perAlias,example);
        return  t;
    }
}

