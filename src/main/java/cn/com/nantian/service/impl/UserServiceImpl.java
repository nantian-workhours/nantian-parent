package cn.com.nantian.service.impl;

import cn.com.nantian.common.DateUtils;
import cn.com.nantian.common.ObjectUtils;
import cn.com.nantian.common.ParamUntil;
import cn.com.nantian.common.RegExpressionUtils;
import cn.com.nantian.mapper.NtPerAliasMapper;
import cn.com.nantian.mapper.NtPersonnelMapper;
import cn.com.nantian.mapper.PersonnelItemMapper;
import cn.com.nantian.pojo.NtDepartment;
import cn.com.nantian.pojo.NtDictionariesKey;
import cn.com.nantian.pojo.NtPersonnel;
import cn.com.nantian.pojo.PersonnelItem;
import cn.com.nantian.pojo.entity.ResponseData;
import cn.com.nantian.service.DepartmentService;
import cn.com.nantian.service.DictionariesService;
import cn.com.nantian.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
  * @description: 用户管理
  * @auther: Mr.Wind
  * @date: 2019/4/29 14:33
  **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private NtPersonnelMapper personnelMapper;

    @Resource
    private PersonnelItemMapper personnelItemMapper;

    @Resource
    private NtPerAliasMapper perAliasMapper;

    @Resource
    private DictionariesService dictionariesService;


    @Override
    public Map<String,Object> getStatisticsUserNum(NtPersonnel personnel){
        Map<String, Object> map = new HashMap<>();
        List<NtDictionariesKey> dictionariesList = dictionariesService.selectDictionariesByType(ParamUntil.POST);
        List<NtPersonnel> ntPersonnelList = personnelMapper.queryStatisticsUserNumByDept(personnel);
        if (ObjectUtils.isNotNull(dictionariesList) && ObjectUtils.isNotNull(ntPersonnelList)){
            for (NtDictionariesKey dictionaries:dictionariesList){
                String dicCode=dictionaries.getDicCode();
                int totalNum=0;
                for (NtPersonnel ntPersonnel:ntPersonnelList){
                    if (dicCode.equals(ntPersonnel.getPost())){
                        totalNum=ntPersonnel.getTotalNum();
                        break;
                    }
                }
                map.put(ParamUntil.POST+"_"+dicCode,totalNum);
            }
        }
        return map;
    }

    @Override
    public List<NtPersonnel> queryStatisticsUserNumByDept(NtPersonnel personnel) {
        return personnelMapper.queryStatisticsUserNumByDept(personnel);
    }

    /**
      * @description: 按岗位统计员工人数
      * @auther: Mr.Wind
      * @date: 2019/5/22 15:18
      * @param:  [ntPersonnel]
      * @return: java.util.Map<java.lang.String,java.lang.Object>
      **/
    public Map<String,Object> getStatisticalPersonnelNum(NtPersonnel ntPersonnel) {
        Map<String,Object> totalNumMap=new HashMap<>();//总人数
        List<NtDictionariesKey> dictionariesList=dictionariesService.selectDictionariesByType(ParamUntil.POST);
        if (ObjectUtils.isNotNull(dictionariesList)){
            for (int i=0;i<dictionariesList.size();i++){
                ntPersonnel.setPost(dictionariesList.get(i).getDicCode());
                NtPersonnel personnel =personnelMapper.queryStatisticalPersonnelNum(ntPersonnel);
                totalNumMap.put(ParamUntil.POST+"_"+dictionariesList.get(i).getDicCode()+"_"+"NUMS",personnel.getTotalNum());
            }
        }
        return totalNumMap;
    }

    /**
     * @description: 处理用户列表数据
     * @auther: Mr.Wind
     * @date: 2019/4/29 14:32
     * @Param: [personnelList]
     * @return: List<NtPersonnel>
     **/
    @Override
    public List<NtPersonnel> setPersonnelDate(List<NtPersonnel> personnelList) {
        List<NtPersonnel> ntPersonnelList = new ArrayList<>();
        if (ObjectUtils.isNotNull(personnelList)) {
            for (NtPersonnel personnel : personnelList) {
                NtPersonnel personnel1 = new NtPersonnel();
                personnel1.setPerId(personnel.getPerId());
                personnel1.setName(personnel.getName());
                personnel1.setPosition(personnel.getPosition());
                personnel1.setManagerId(personnel.getManagerId());
                personnel1.setAssistantId(personnel.getAssistantId());
                ntPersonnelList.add(personnel1);
            }
        }
        return ntPersonnelList;
    }

    @Override
    public NtPersonnel queryStatisticalPersonnelNum(NtPersonnel personnel) {
        return personnelMapper.queryStatisticalPersonnelNum(personnel);
    }

    /**
     * @description: 查询用户列表
     * @auther: Mr.Wind
     * @date: 2019/4/29 14:16
     * @Param: [personnel]
     * @return: List<NtPersonnel>
     **/
    @Override
    public List<NtPersonnel> queryPersonnelListDate(NtPersonnel personnel) {
        return personnelMapper.queryPersonnelListDate(personnel);
    }

    /**
     * @description: 查询用户列表
     * @auther: Mr.Wind
     * @date: 2019/4/26 15:59
     * @param: [personnel] 查询条件
     * @return: List<NtPersonnel>
     */
    @Override
    public List<NtPersonnel> queryPersonnelList(NtPersonnel personnel) {
        return personnelMapper.queryPersonnelList(personnel);
    }


    /**
     * 根据id查询员工姓名NT_PERSONNEL
     */
    @Override
    public String selectByUserId(int perId) {
        return personnelMapper.selectByUserId(perId);
    }

    /**
     * 根据员工编号获取员工信息
     *
     * @param perId
     * @return
     */
    @Override
    public NtPersonnel findPersonnlByPerId(int perId) {
        return personnelMapper.selectByPrimaryKey(perId);
    }

    /**
     * 添加员工信息
     *
     * @param personnel
     */
    @Override
    public int addUser(NtPersonnel personnel) throws Exception{
        //日期转换
        if (ObjectUtils.isNotNull(personnel.getBirthdayStr())){
            personnel.setBirthday(DateUtils.parseToDate(personnel.getBirthdayStr(),"yyyy-MM-dd"));
        }
        if (ObjectUtils.isNotNull(personnel.getGraduationDateStr())){
            personnel.setGraduationDate(DateUtils.parseToDate(personnel.getGraduationDateStr(),"yyyy-MM-dd"));
        }
        if (ObjectUtils.isNotNull(personnel.getEntryDateStr())){
            personnel.setEntryDate(DateUtils.parseToDate(personnel.getEntryDateStr(),"yyyy-MM-dd"));
        }
        if (ObjectUtils.isNotNull(personnel.getLeaveDateStr())){
            personnel.setLeaveDate(DateUtils.parseToDate(personnel.getLeaveDateStr(),"yyyy-MM-dd"));
        }
        //设置员工的初始化密码
        personnel.setPassword(DigestUtils.md5DigestAsHex("nt0000".getBytes()));
        //设置用户的权限,超级管理员->0,管理员->1,普通用户->2
        return personnelMapper.insert(personnel);
    }

    /**
     * @description: 检查传入的参数是否为空 格式是否正确 是否已存在
     * @auther: Mr.Wind
     * @date: 2019/4/26 14:22
     * @Param: [personnel]
     * @return: java.lang.String
     **/
    @Override
    public String checkAddUserParameter(NtPersonnel personnel) {
        String msg = "";
        if (StringUtils.isEmpty(personnel.getName())) {
            return msg = "姓名 不能为空！";
        }
        //身份证号效验
        if (StringUtils.isEmpty(personnel.getIdNo())) {
            return msg = "身份证号 不能为空！";
        } else if (!RegExpressionUtils.isIDNumber(personnel.getIdNo())) {
            return msg = "身份证号 填写错误！";
        } else {
            NtPersonnel personnlByIdno = this.findPersonnlByIdno(personnel.getIdNo());
            if (!ObjectUtils.isNull(personnlByIdno)) {
                return msg = "身份证号 已存在！";
            }
        }
        if (StringUtils.isEmpty(personnel.getSex())) {
            return msg = "性别 不能为空！";
        }
        //日期效验
        if (!ObjectUtils.isNull(personnel.getBirthdayStr())){
            if (!DateUtils.checkDateReg(personnel.getBirthdayStr())){
                return msg="生日 日期格式不正确！";
            }
        }
        /*if (StringUtils.isEmpty(personnel.getEthnic())){
            msg="民族 不能为空！";
        }else if (StringUtils.isEmpty(personnel.getNativePlace())){
            msg="籍贯 不能为空！";
        }*/
        if (StringUtils.isEmpty(personnel.getCompanyEmail())) {
            msg = "公司邮箱 不能为空！";
        } else if (!RegExpressionUtils.isEmail(personnel.getCompanyEmail())) {
            msg = "公司邮箱 格式填写错误！";
        }else {
            NtPersonnel ntPersonnel = personnelMapper.selectByEmail(personnel.getCompanyEmail());
            if (!ObjectUtils.isNull(ntPersonnel)) {
                return msg = "公司邮箱 已存在！";
            }
        }
        //个人邮箱效验
        /*if (StringUtils.isEmpty(personnel.getPersonEmail())){
            return msg="个人邮箱 不能为空！";
        }*/
        if (!StringUtils.isEmpty(personnel.getPersonEmail()) && !RegExpressionUtils.isEmail(personnel.getPersonEmail())) {
            return msg = "个人邮箱 填写错误！";
        }else {
            NtPersonnel ntPersonnel = personnelMapper.selectByPersonEmail(personnel.getPersonEmail());
            if (!ObjectUtils.isNull(ntPersonnel)) {
                return msg = "个人邮箱 已存在！";
            }
        }
        //手机号效验
        if (StringUtils.isEmpty(personnel.getMobileNo())) {
            return msg = "手机号 不能为空！";
        } else if (!RegExpressionUtils.isMobile(personnel.getMobileNo())) {
            return msg = "手机号 填写错误！";
        } else {
            NtPersonnel ntPersonnel = personnelMapper.selectByPrimaryMobileNo(personnel.getMobileNo());
            if (!ObjectUtils.isNull(ntPersonnel)) {
                return msg = "手机号 已存在！";
            }
        }
        //日期效验
        if (!ObjectUtils.isNull(personnel.getGraduationDateStr())){
            if (!DateUtils.checkDateReg(personnel.getGraduationDateStr())){
                return msg="毕业日期 日期格式不正确！";
            }
        }
        if (!ObjectUtils.isNull(personnel.getEntryDateStr())){
            if (!DateUtils.checkDateReg(personnel.getEntryDateStr())){
                return msg="入司日期 日期格式不正确！";
            }
        }
        if (!ObjectUtils.isNull(personnel.getLeaveDateStr())){
            if (!DateUtils.checkDateReg(personnel.getLeaveDateStr())){
                return msg="离职日期 日期格式不正确！";
            }
        }

        /*if (StringUtils.isEmpty(personnel.getEducation())){
            return msg="学历 不能为空！";
        }else if (StringUtils.isEmpty(personnel.getUniversity())){
            return msg="毕业院校 不能为空！";
        }else if (StringUtils.isEmpty(personnel.getMajor())){
            return msg="专业 不能为空！";
        }if (ObjectUtils.isNull(personnel.getGraduationDate())){
            return msg="毕业日期 不能为空！";
        }else if (StringUtils.isEmpty(personnel.getPosition())){
            return msg="职位 不能为空！";
        }else if (StringUtils.isEmpty(personnel.getPost())){
            return msg="岗位 不能为空！";
        }else if (StringUtils.isEmpty(personnel.getStatus())){
            return msg="在职状态 不能为空！";
        }else if (ObjectUtils.isNull(personnel.getEntryDate())){
            return msg="入司日期 不能为空！";
        }else if (ObjectUtils.isNull(personnel.getLeaveDate())){
            return msg="离职日期 不能为空！";
        }else if (ObjectUtils.isNull(personnel.getDeptId())){
            return msg="所属部门 不能为空！";
        }*/
        if (ObjectUtils.isNull(personnel.getJurisdiction())) {
            return msg = "系统权限 不能为空！";
        }
        return msg;
    }

    /**
     * @description: 更新 检查传入的参数是否为空 格式是否正确 是否已存在
     * @auther: Mr.Wind
     * @date: 2019/5/5 15:23
     * @Param:  [personnel]
     * @return: java.lang.String
     **/
    @Override
    public String checkUpdateUserParameter(NtPersonnel personnel) {
        String msg = "";
        if (ObjectUtils.isNull(personnel.getPerId())){
            return msg = "员工编号 不能为空！";
        }
        NtPersonnel personnel2=this.findPersonnlByPerId(personnel.getPerId());
        if (StringUtils.isEmpty(personnel.getName())) {
            return msg = "姓名 不能为空！";
        }
        //身份证号效验
        if (StringUtils.isEmpty(personnel.getIdNo())) {
            return msg = "身份证号 不能为空！";
        } else if (!RegExpressionUtils.isIDNumber(personnel.getIdNo())) {
            return msg = "身份证号 填写错误！";
        } else {
            NtPersonnel personnlByIdno = this.findPersonnlByIdno(personnel.getIdNo());
            if (ObjectUtils.isNotNull(personnlByIdno)){
                if (!personnlByIdno.getPerId().equals(personnel2.getPerId())){
                    return msg = "身份证号 已存在！";
                }
            }
        }
        if (StringUtils.isEmpty(personnel.getSex())) {
            return msg = "性别 不能为空！";
        }
        //日期效验
        if (!ObjectUtils.isNull(personnel.getBirthdayStr())){
            if (!DateUtils.checkDateReg(personnel.getBirthdayStr())){
                return msg="生日 日期格式不正确！";
            }
        }
        /*if (StringUtils.isEmpty(personnel.getEthnic())){
            msg="民族 不能为空！";
        }else if (StringUtils.isEmpty(personnel.getNativePlace())){
            msg="籍贯 不能为空！";
        }*/
        if (StringUtils.isEmpty(personnel.getCompanyEmail())) {
            msg = "公司邮箱 不能为空！";
        } else if (!RegExpressionUtils.isEmail(personnel.getCompanyEmail())) {
            msg = "公司邮箱 格式填写错误！";
        }else {
            NtPersonnel ntPersonnel = personnelMapper.selectByEmail(personnel.getCompanyEmail());
            if (ObjectUtils.isNotNull(ntPersonnel)){
                if (!ntPersonnel.getPerId().equals(personnel2.getPerId())){
                    return msg = "公司邮箱 已存在！";
                }
            }
        }
        //个人邮箱效验
        /*if (StringUtils.isEmpty(personnel.getPersonEmail())){
            return msg="个人邮箱 不能为空！";
        }*/
        if (!StringUtils.isEmpty(personnel.getPersonEmail()) && !RegExpressionUtils.isEmail(personnel.getPersonEmail())) {
            return msg = "个人邮箱 填写错误！";
        }else {
            NtPersonnel ntPersonnel = personnelMapper.selectByPersonEmail(personnel.getPersonEmail());
            if (ObjectUtils.isNotNull(ntPersonnel)){
                if (!ntPersonnel.getPerId().equals(personnel2.getPerId())){
                    return msg = "个人邮箱 已存在！";
                }
            }
        }
        //手机号效验
        if (StringUtils.isEmpty(personnel.getMobileNo())) {
            return msg = "手机号 不能为空！";
        } else if (!RegExpressionUtils.isMobile(personnel.getMobileNo())) {
            return msg = "手机号 填写错误！";
        } else {
            NtPersonnel ntPersonnel = personnelMapper.selectByPrimaryMobileNo(personnel.getMobileNo());
            if (ObjectUtils.isNotNull(ntPersonnel)){
                if (!ntPersonnel.getPerId().equals(personnel2.getPerId())){
                    return msg = "手机号 已存在！";
                }
            }

        }

        //日期效验
        if (!ObjectUtils.isNull(personnel.getGraduationDateStr())){
            if (!DateUtils.checkDateReg(personnel.getGraduationDateStr())){
                return msg="毕业日期 日期格式不正确！";
            }
        }
        if (!ObjectUtils.isNull(personnel.getEntryDateStr())){
            if (!DateUtils.checkDateReg(personnel.getEntryDateStr())){
                return msg="入司日期 日期格式不正确！";
            }
        }
        if (!ObjectUtils.isNull(personnel.getLeaveDateStr())){
            if (!DateUtils.checkDateReg(personnel.getLeaveDateStr())){
                return msg="离职日期 日期格式不正确！";
            }
        }

        /*if (StringUtils.isEmpty(personnel.getEducation())){
            return msg="学历 不能为空！";
        }else if (StringUtils.isEmpty(personnel.getUniversity())){
            return msg="毕业院校 不能为空！";
        }else if (StringUtils.isEmpty(personnel.getMajor())){
            return msg="专业 不能为空！";
        }else if (ObjectUtils.isNull(personnel.getGraduationDate())){
            return msg="毕业日期 不能为空！";
        }else if (StringUtils.isEmpty(personnel.getPosition())){
            return msg="职位 不能为空！";
        }else if (StringUtils.isEmpty(personnel.getPost())){
            return msg="岗位 不能为空！";
        }else if (StringUtils.isEmpty(personnel.getStatus())){
            return msg="在职状态 不能为空！";
        }else if (ObjectUtils.isNull(personnel.getEntryDate())){
            return msg="入司日期 不能为空！";
        }else if (ObjectUtils.isNull(personnel.getLeaveDate())){
            return msg="离职日期 不能为空！";
        }else if (ObjectUtils.isNull(personnel.getDeptId())){
            return msg="所属部门 不能为空！";
        }*/
        if (ObjectUtils.isNull(personnel.getJurisdiction())) {
            return msg = "系统权限 不能为空！";
        }
        return msg;
    }

    /**
     * 根据部门deptId和员工name查询员工信息
     *
     * @param deptId
     * @param name
     * @return
     */
    @Override
    public List<PersonnelItem> findPersonnelBydeptIdAndName(int deptId, String name) {
        List<PersonnelItem> personnelList = personnelItemMapper.selectPersonnel(deptId, name);

        return personnelList;
    }

    /**
     * @description: 根据部门deptId和员工name查询员工信息
     * @auther: Mr.Wind
     * @date: 2019/4/3 14:55
     * @Param: [deptId, name]
     * @return: List<NtPersonnel>
     **/
    @Override
    public List<NtPersonnel> findPerByDeptIdAndName(int deptId, String name) {
        List<NtPersonnel> personnelList = personnelMapper.findPersonnelBydeptIdAndName(deptId, name);
        return personnelList;
    }

    /**
     * 根据身份证号查询员工信息
     *
     * @return
     */
    @Override
    public NtPersonnel findPersonnlByIdno(String idNo) {
        return personnelMapper.selectByPrimaryIdNo(idNo);
    }

    /**
     * 用于员工登录
     *
     * @param username
     * @return
     */
    @Override
    public NtPersonnel findOne(String username) {
        NtPersonnel personnel = null;
        //根据邮箱查询用户
        if (RegExpressionUtils.isEmail(username)) {
            personnel = personnelMapper.selectByEmail(username);
        } else if (RegExpressionUtils.isMobile(username)) {
            //根据手机号获取
            personnel = personnelMapper.selectByPrimaryMobileNo(username);
        } else if (RegExpressionUtils.isIDNumber(username)) {
            //根据身份证号查询
            personnel = personnelMapper.selectByPrimaryIdNo(username);
        }
        return personnel;
    }

    /**
     * @description: 效验传入的登录用户名、密码
     * @auther: Mr.Wind
     * @date: 2019/5/17 14:37
     * @param:  [name, password]
     * @return: java.lang.String
     **/
    @Override
    public String checkLoginParameter(String name,String password) {
        //查询用户的信息
        NtPersonnel personnel =null;
        //效验登录用户名
        if (StringUtils.isEmpty(name)) {
            return "用户名 不能为空！";
        } if (!(RegExpressionUtils.isMobile(name) || RegExpressionUtils.isEmail(name) || RegExpressionUtils.isIDNumber(name))) {
            return "用户名 格式不正确！";
        } else if (StringUtils.isEmpty(password)) {
            return "登录密码 不能为空！";
        }else {
            personnel = this.findOne(name);
            if (ObjectUtils.isNull(personnel)){
                return "用户名 不存在！";
            }else if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(personnel.getPassword())){
                return "密码不正确！";
            }
        }
        return "";
    }



    /**
      * @description: 验证登录用户名
      * @auther: Mr.Wind
      * @date: 2019/5/17 14:44
      * @param:  [name]
      * @return: java.lang.String
      **/
    @Override
    public String checkLoginName(String name) {
        //查询这个用户的信息
        NtPersonnel personnel =null;
        //效验登录用户名
        if (StringUtils.isEmpty(name)) {
            return "用户名 不能为空！";
        } if (!(RegExpressionUtils.isMobile(name) || RegExpressionUtils.isEmail(name) || RegExpressionUtils.isIDNumber(name))) {
            return "用户名 格式不正确！";
        }else {
            personnel = this.findOne(name);
            if (ObjectUtils.isNull(personnel)){
                return "用户不存在！";
            }
        }
        return "";
    }

    /**
     * 根据身份证号和别名删除员工信息
     *
     * @param idNo,inProjectName
     * @return
     */
    @Override
    public String deleteByIdNo(String idNo, String inProjectName) {
        //判断别名是否为空
        int a = 0;
        if (!inProjectName.isEmpty() && !inProjectName.isEmpty()) {
            //如果不为空直接删除别名表的用户信息
            a = perAliasMapper.deleteByIdNo(idNo);
            return "delete otherName " + a;
        } else if (!idNo.isEmpty()) {
            //如果为空直接删除这个用户的信息
            a = personnelMapper.deleteByIdNo(idNo);
            if (a >= 0) {
                return " delete personnel " + a;
            }
            return "not delete ";
        } else {
            return "not delete ";
        }
    }

    /**
     * 根据身份证号修改员工信息
     *
     * @param personnel
     * @return
     */
    @Override
    public int updateByIdNo (NtPersonnel personnel) throws ParseException {
        //日期转换
        if (ObjectUtils.isNotNull(personnel.getBirthdayStr())){
            personnel.setBirthday(DateUtils.parseToDate(personnel.getBirthdayStr(),"yyyy-MM-dd"));
        }
        if (ObjectUtils.isNotNull(personnel.getGraduationDateStr())){
            personnel.setGraduationDate(DateUtils.parseToDate(personnel.getGraduationDateStr(),"yyyy-MM-dd"));
        }
        if (ObjectUtils.isNotNull(personnel.getEntryDateStr())){
            personnel.setEntryDate(DateUtils.parseToDate(personnel.getEntryDateStr(),"yyyy-MM-dd"));
        }
        if (ObjectUtils.isNotNull(personnel.getLeaveDateStr())){
            personnel.setLeaveDate(DateUtils.parseToDate(personnel.getLeaveDateStr(),"yyyy-MM-dd"));
        }
       return personnelMapper.updateByPrimaryKeySelective(personnel);
    }


    /**
      * @description: 处理员工工作状态数据
      * @auther: Mr.Wind
      * @date: 2019/5/6 14:57
      * @Param:  [personnelList]
      * @return: void
      **/
    public void setWorkStates(List<NtPersonnel> personnelList){
        if (ObjectUtils.isNotNull(personnelList)){
            for (NtPersonnel personnel:personnelList){
                NtDictionariesKey dictionariesKey=dictionariesService.selectDictionaries(ParamUntil.WORK_STATES,personnel.getStatus());
                if (ObjectUtils.isNotNull(dictionariesKey)){
                    personnel.setWorkStatus(dictionariesKey.getDicValue());
                }
            }
        }
    }


    private NtPersonnel updateFrag(NtPersonnel personnel) {

        //设置在职状态
        if ("在职".equals(personnel.getStatus())) {
            personnel.setStatus("1");
        } else if ("离职".equals(personnel.getStatus())) {
            personnel.setStatus("2");
        } else {
            personnel.setStatus("4");
        }

        //设置职位
        if ("员工".equals(personnel.getPosition())) {
            personnel.setPosition("1");
        } else if ("部门经理".equals(personnel.getPosition())) {
            personnel.setPosition("2");
        } else if ("总经理".equals(personnel.getPosition())) {
            personnel.setPosition("3");
        } else {
            personnel.setPosition("4");
        }
        return personnel;
    }

    /**
     * 根据身份证号修改密码
     *
     * @param idNo
     * @param password
     * @return
     */
    @Override
    public int byIdNoUpdatePW(String idNo, String oldPassword, String password) {
        int a = 0;
        //查询员工信息
        NtPersonnel personnel = personnelMapper.selectByPrimaryIdNo(idNo);
        //判断旧密码是否正确
        String oldPW = DigestUtils.md5DigestAsHex(oldPassword.getBytes());

        if (personnel != null) {
            if (oldPW.equals(personnel.getPassword())) {
                //将密码加密
                personnel.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
                //将修改密码后的信息更改到表中
                a = personnelMapper.updateByPrimaryKey(personnel);
            }
        } else {
            return 0;
        }
        return a;
    }


    /**
     * 根据员工姓名 员工信息
     *
     * @param name
     * @return
     */
    @Override
    public List<NtPersonnel> findByName(String name) {
        List<NtPersonnel> personnelList = personnelMapper.selectByName(name);
        return personnelList;
    }


    /**
     * 重置密码
     *
     * @param idNo
     * @return
     */
    @Override
    public int resetPassWord(String idNo) {
        int t = 0;
        NtPersonnel personnel = personnelMapper.selectByPrimaryIdNo(idNo);
        //将密码加密
        personnel.setPassword(DigestUtils.md5DigestAsHex("nt0000".getBytes()));
        //修改表中
        int a = personnelMapper.updateByPrimaryKey(personnel);
        t += a;
        return t;
    }

    /**
      * @description: 重置密码
      * @auther: Mr.Wind
      * @date: 2019/5/13 10:54
      * @param:  [perId]
      * @return: int
      **/
    @Override
    public int resetPassWord(int perId) {
        NtPersonnel personnel=new NtPersonnel();
        personnel.setPerId(perId);
        String password="nt0000";
        personnel.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        return personnelMapper.updatePassWord(personnel);
    }
}
