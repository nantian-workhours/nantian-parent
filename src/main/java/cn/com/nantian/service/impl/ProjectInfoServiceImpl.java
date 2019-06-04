package cn.com.nantian.service.impl;

import cn.com.nantian.common.ObjectUtils;
import cn.com.nantian.common.ParamUntil;
import cn.com.nantian.mapper.NtCustTypeMapper;
import cn.com.nantian.mapper.NtDictionariesMapper;
import cn.com.nantian.mapper.NtPerInProjectMapper;
import cn.com.nantian.mapper.NtProjectInfoMapper;
import cn.com.nantian.pojo.NtCustType;
import cn.com.nantian.pojo.NtDictionariesKey;
import cn.com.nantian.pojo.NtPerInProject;
import cn.com.nantian.pojo.NtProjectInfo;
import cn.com.nantian.service.ProjectInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ProjectInfoServiceImpl implements ProjectInfoService {



    @Resource
    private NtCustTypeMapper custTypeMapper;
    @Resource
    private NtProjectInfoMapper projectInfoMapper;
    @Resource
    private NtDictionariesMapper dictionariesMapper;
    @Resource
    private NtPerInProjectMapper perInProjectMapper;


    /**
     * @description: 查询客户信息列表
     * @Param: [example]
     * @return: List<NtProjectInfo>
     * @auther: Mr.Wind
     * @date: 2019/3/19 10:37
     **/
    public List<NtProjectInfo> selectNtProjectInfoList(NtProjectInfo ntProjectInfo){
        return projectInfoMapper.selectNtProjectInfoList(ntProjectInfo);
    }

    /**
     * @description: 根据项目编号查询详情
     * @auther: Mr.Wind
     * @date: 2019/3/27 14:25
     * @Param: [projectNumber]
     * @return: NtProjectInfo
     **/
    public NtProjectInfo selectByPrimaryKey(Integer projectNumber){
        return projectInfoMapper.selectByPrimaryKey(projectNumber);
    }

    /**
     * @description: 设置客户类型名称 项目人数
     * @Param: [NtProjectInfoList]
     * @return: void
     * @auther: Mr.Wind
     * @date: 2019/3/19 16:55
     **/
    public void setNtProjectInfoTypeName(List<NtProjectInfo> NtProjectInfoList){
        String custType="cust";
        if(NtProjectInfoList!=null && NtProjectInfoList.size()>0){
            for(NtProjectInfo ntProjectInfo:NtProjectInfoList){
                //设置项目人数
                NtPerInProject perInProject=new NtPerInProject();
                perInProject.setProjectNumber(ntProjectInfo.getProjectNumber());
                List<NtPerInProject> perInProjectList=perInProjectMapper.selectPerInProjectList(perInProject);
                ntProjectInfo.setPeopleNumber(perInProjectList.size());
                //设置客户类型
                NtDictionariesKey dictionariesKey=new NtDictionariesKey();
                dictionariesKey.setDicType(custType);
                dictionariesKey.setDicCode(ntProjectInfo.getCustType());
                List<NtDictionariesKey> dictionariesKeyList=dictionariesMapper.selectDictionariesList(dictionariesKey);
                if(dictionariesKeyList!=null && dictionariesKeyList.size()>0){
                    ntProjectInfo.setCustTypeName(dictionariesKeyList.get(0).getDicValue());
                }
            }
        }
    }
    /**
      * @description: 设置客户类型名称 项目人数
      * @auther: Mr.Wind
      * @date: 2019/3/27 14:38
      * @Param: [ntProjectInfo]
      * @return: void
      **/
    public void setNtProjectInfoTypeName(NtProjectInfo ntProjectInfo){
        if(ObjectUtils.isNotNull(ntProjectInfo)){
            //设置项目人数
            NtPerInProject perInProject=new NtPerInProject();
            perInProject.setProjectNumber(ntProjectInfo.getProjectNumber());
            List<NtPerInProject> perInProjectList=perInProjectMapper.selectPerInProjectList(perInProject);
            ntProjectInfo.setPeopleNumber(perInProjectList.size());
            //设置客户类型
            NtDictionariesKey dictionariesKey=new NtDictionariesKey();
            dictionariesKey.setDicType(ParamUntil.cust);
            dictionariesKey.setDicCode(ntProjectInfo.getCustType());
            List<NtDictionariesKey> dictionariesKeyList=dictionariesMapper.selectDictionariesList(dictionariesKey);
            if(ObjectUtils.isNotNull(dictionariesKeyList)){
                ntProjectInfo.setCustTypeName(dictionariesKeyList.get(0).getDicValue());
            }
        }
    }

    /**
     * @description: 根据项目编号删除一条数据
     * @Param: [projectNumber]
     * @return: int
     * @auther: Mr.Wind
     * @date: 2019/3/20 10:38
     **/
    public int deleteNtProjectInfo(int projectNumber){
        return projectInfoMapper.deleteByPrimaryKey(projectNumber);
    }
    /**
     * @description: 新增客户信息
     * @Param: [NtProjectInfo]
     * @return: int
     * @auther: Mr.Wind
     * @date: 2019/3/20 13:51
     **/
    public int addNtProjectInfo(NtProjectInfo NtProjectInfo) {
        return projectInfoMapper.insert(NtProjectInfo);
    }

    /**
     * @description: 更新客户信息
     * @Param: [NtProjectInfo]
     * @return: int
     * @auther: Mr.Wind
     * @date: 2019/3/20 14:29
     **/
    public int updateNtProjectInfo(NtProjectInfo NtProjectInfo){
        return projectInfoMapper.updateByPrimaryKeySelective(NtProjectInfo);
    }

    /**
      * @description: 新增时 检查传入的对象所有属性值，在表中是否已存在
      * @auther: Mr.Wind
      * @date: 2019/3/26 10:51
      * @Param: [ntProjectInfoList, ntProjectInfo]
      * @return: boolean false 不存在，true 存在
      **/
    public boolean checkWhetherRepeat(NtProjectInfo ntProjectInfo){
        List<NtProjectInfo> ntProjectInfoList=this.selectNtProjectInfoList(null);
        boolean repeat=false;
        if(ObjectUtils.isNotNull(ntProjectInfoList) && ObjectUtils.isNotNull(ntProjectInfo)){
            for (NtProjectInfo projectInfo:ntProjectInfoList) {
                if(projectInfo.equals(ntProjectInfo)){
                    repeat=true;
                    break;
                }
            }
        }
        return repeat;
    }

    /**
      * @description: 更新时 检查传入的对象所有属性值，在表中是否已存在
      * @auther: Mr.Wind
      * @date: 2019/5/8 10:18
      * @Param:  [ntProjectInfo]
      * @return: boolean
      **/
    @Override
    public boolean checkUpdateWhetherRepeat(NtProjectInfo ntProjectInfo){
        List<NtProjectInfo> ntProjectInfoList=this.selectNtProjectInfoList(null);
        boolean repeat=false;
        if(ObjectUtils.isNotNull(ntProjectInfoList) && ObjectUtils.isNotNull(ntProjectInfo)){
            for (NtProjectInfo projectInfo:ntProjectInfoList) {
                if(projectInfo.getProjectNumber()!=ntProjectInfo.getProjectNumber() && projectInfo.equals(ntProjectInfo)){
                    repeat=true;
                    break;
                }
            }
        }
        return repeat;
    }
    /**
      * @description: 检查客户信息属性值是否为空
      * @auther: Mr.Wind
      * @date: 2019/3/26 11:08
      * @Param: [ntProjectInfo] 客户信息实体
      * @return: java.lang.String
      **/
    public String checkAttribute(NtProjectInfo ntProjectInfo){
        if (ObjectUtils.isNotNull(ntProjectInfo)){
            if(ObjectUtils.isNull(ntProjectInfo.getProjectName())){
                return "项目名称 不能为空！";
            }
            if(ObjectUtils.isNull(ntProjectInfo.getAddress())){
                return "办公地址 不能为空！";
            }
            if(ObjectUtils.isNull(ntProjectInfo.getChargeId())){
                return "在场负责人 不能为空！";
            }
            if(ObjectUtils.isNull(ntProjectInfo.getCustType())){
                return "客户类别 不能为空！";
            }
            if(ObjectUtils.isNull(ntProjectInfo.getDeptId())){
                return "部门 不能为空！";
            }
        }
        return "";
    }

    //添加项目类别信息
    @Override
    public void addCustType(String projectName, Map<String ,String> type, String leave) {
        NtCustType custType = new NtCustType();
        //遍历map中的工作类别
        for (String workType : type.values()) {
            try {
                //设置客户类别名称
                custType.setWorkType(projectName);
                //设置工作类型
                custType.setWorkType(workType);
                //设置技术等级
                custType.setWorkLevel(leave);
                custTypeMapper.insert(custType);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
