package cn.com.nantian.service.impl;

import cn.com.nantian.common.ObjectUtils;
import cn.com.nantian.common.ParamUntil;
import cn.com.nantian.common.StringUtils;
import cn.com.nantian.mapper.NtDepartmentMapper;
import cn.com.nantian.mapper.NtPersonnelMapper;
import cn.com.nantian.pojo.NtDepartment;
import cn.com.nantian.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DepartmentImpl implements DepartmentService {


    @Resource
    private NtDepartmentMapper departmentMapper;


    /**
     * 修改部门信息
     * @param department
     * @return
     */
    @Override
    public int updateDepartment(NtDepartment department) {

        int  d = departmentMapper.updateByPrimaryKey(department);
        return d;
    }

    /**
     * 查询部门所有信息
     * @return
     */
    @Override
    public List<NtDepartment> findAll() {

        List<NtDepartment> departmentList = departmentMapper.selectByExample(null);
        return departmentList;
    }


    /**根据id删除一条部门信息
     * @param deptId :员工id
     * @return
     */
    @Override
    public int  deleteone(int deptId) {
        return departmentMapper.deleteByPrimaryKey(deptId);
    }
    /**
     * 添加部门信息
     * @param deptName
     * @param deptAbbreviation
     * @param managerId
     * @param assistantId
     * @param serviceType
     * @return
     */
    public int  addDepartment(String deptName, String deptAbbreviation, int managerId,int assistantId,String serviceType) {
        //查询数据库中最大的id
       int key =  departmentMapper.seletByMaxKey();
        key++;

        NtDepartment department = new NtDepartment();
        //根据id查询部门负责人
        department.setDeptId(key);
        department.setDeptName(deptName);
        department.setDeptAbbreviation(deptAbbreviation);
        department.setAssistantId(assistantId);
        department.setManagerId(managerId);
        department.setServiceType(serviceType);
        department.setPrioDeptId(0);
        int id = departmentMapper.insert(department);
        return id;
    }

    /**
     * 根据部门deptId查询部门名称
     * @param deptId
     * @return
     */
    @Override
    public String selectDepart(int deptId) {
        NtDepartment department = departmentMapper.selectByPrimaryKey(deptId);
        return department.getDeptName();
    }

    /**
     * @Description: 设置服务类别名称
     * @Auther: Mr.Kong
     * @Date: 2019/4/23 16:42
     * @Param:
     * @Return: java.util.List<java.lang.String>
     **/
    @Override
    public void setServiceTypeName(List<NtDepartment> departmentList){
        if(ObjectUtils.isNotNull(departmentList)){
            for(NtDepartment ntDepartment:departmentList){
                if(StringUtils.isNotEmpty(ntDepartment.getServiceType())){
                    String[] strings=ntDepartment.getServiceType().split(",");
                    List<String> stringList= Arrays.asList(strings);
                    if (ObjectUtils.isNotNull(stringList)){
                        List<String> serTypeNameList=new ArrayList<>();
                        for (String name:stringList){
                            if(name.equals("C")){
                                serTypeNameList.add(ParamUntil.C);
                            }
                            if(name.equals("H")){
                                serTypeNameList.add(ParamUntil.H);
                            }
                            if(name.equals("P")){
                                serTypeNameList.add(ParamUntil.P);
                            }
                        }
                        ntDepartment.setSerTypeNameList(serTypeNameList);
                    }
                }
            }
        }
    }
}

