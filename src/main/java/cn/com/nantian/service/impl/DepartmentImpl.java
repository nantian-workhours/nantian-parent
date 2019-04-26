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
      * @Description:  添加部门信息
      * @Auther: Mr.Kong
      * @Date: 2019/4/26 9:54
      * @Param:  [department]
      * @Return: int
      **/
    @Override
    public int  addDepartment(NtDepartment department) {
        int id = departmentMapper.insert(department);
        return id;
    }

    /**
      * @Description: 检查传入放入参数是否为空
      * @Auther: Mr.Kong
      * @Date: 2019/4/26 10:01
      * @Param:  [department]
      * @Return: java.lang.String
      **/
    @Override
    public String checkParameter(NtDepartment department){
        String msg="";
        if (StringUtils.isEmpty(department.getDeptName())){
            msg="部门名称 不能为空！";
        }else if (StringUtils.isEmpty(department.getDeptAbbreviation())){
            msg="部门简称 不能为空！";
        }else if (ObjectUtils.isNull(department.getManagerId())){
            msg="门负责人 不能为空！";
        }else if (ObjectUtils.isNull(department.getAssistantId())){
            msg="部门助理 不能为空！";
        }else if (StringUtils.isEmpty(department.getServiceType())){
            msg="服务类别 不能为空！";
        }
        return msg;
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

