package cn.com.nantian.service.impl;

import cn.com.nantian.mapper.NtCustTypeMapper;
import cn.com.nantian.mapper.NtDepartmentMapper;
import cn.com.nantian.mapper.NtProjectInfoMapper;
import cn.com.nantian.pojo.NtCustTypeKey;
import cn.com.nantian.pojo.NtProjectInfo;
import cn.com.nantian.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerImpl implements CustomerService {


    @Resource
    private NtCustTypeMapper custTypeMapper;
    @Resource
    private  NtProjectInfoMapper projectInfoMapper;

    //添加客户信息
    @Override
    public void addCustomer(String deptName,String customerName,String projectName,String jobAdress,String projectCharge) {
//

//        NtProjectInfo projectInfo = new NtProjectInfo();
//
//        //根据部门名称查询部门编号NT_DEPARTMENT
//        NtDepartment departments = departmentMapper.selectByDeptname(deptName);
//        projectInfo.setDeptId(departments.getDeptId());
//
//        //设置项目名称
//        projectInfo.setProjectName(projectName);
//
//        //设置客户类别
//        if (customerName.equals("中国银行")){
//            projectInfo.setCustType("1");
//        }else if(customerName.equals("中国人寿")){
//            projectInfo.setCustType("2");
//        }
//      //设置办公地址
//        //projectInfo.setAddress()
//
//        projectInfoMapper.insert(projectInfo);

    }

    //添加项目类别信息
    @Override
    public void addCustType(String projectName, Map<String ,String> type, String leave) {

        NtCustTypeKey custTypeKey = new NtCustTypeKey();
        //遍历map中的工作类别

        for (String workType : type.values()) {
            try {
                //设置客户类别名称
                 custTypeKey.setWorkType(projectName);
                //设置工作类型
                custTypeKey.setWorkType(workType);
                //设置技术等级
                custTypeKey.setWorkLeave(leave);

                custTypeMapper.insert(custTypeKey);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 根据项目编号查询项目信息
     * @param projectNumber
     * @return
     */
    @Override
    public NtProjectInfo selectByNumber(int projectNumber) {
        return  projectInfoMapper.selectByPrimaryKey(projectNumber);
    }
}
