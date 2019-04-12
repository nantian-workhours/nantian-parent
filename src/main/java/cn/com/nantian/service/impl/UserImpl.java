package cn.com.nantian.service.impl;
import cn.com.nantian.common.RegExpressionUtil;
import cn.com.nantian.mapper.NtPerAliasMapper;
import cn.com.nantian.mapper.NtPersonnelMapper;
import cn.com.nantian.mapper.PersonnelItemMapper;
import cn.com.nantian.pojo.NtPersonnel;
import cn.com.nantian.pojo.PersonnelItem;
import cn.com.nantian.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserImpl implements UserService{

    @Resource
    private NtPersonnelMapper personnelMapper;

    @Resource
    private PersonnelItemMapper personnelItemMapper;

    @Resource
    private NtPerAliasMapper perAliasMapper;
    /**根据id查询员工姓名NT_PERSONNEL
     */
    @Override
    public String  selectByUserId(int perId) {
        return personnelMapper.selectByUserId(perId);
    }

    /**
     *根据员工编号获取员工信息
     * @param perId
     * @return
     */
    @Override
    public NtPersonnel findPersonnlByPerId(int perId) {
        return personnelMapper.selectByPrimaryKey(perId);
    }

    /**
     * 添加员工信息
     * @param personnel
     */
    @Override
    public int addUser(NtPersonnel personnel) {

        //根据身份证号判断该员工是否已经添加
        NtPersonnel oldPersonnel = personnelMapper.selectByPrimaryIdNo(personnel.getIdNo());
        if(!StringUtils.isEmpty(oldPersonnel) ) {
            if (oldPersonnel.getIdNo().equals(personnel.getIdNo())) {
                return 5;
            }
        }
        //设置员工的初始化密码
        personnel.setPassword(DigestUtils.md5DigestAsHex("nt0000".getBytes()));
        //设置用户的权限,超级管理员->0,管理员->1,普通用户->2

//        if("超级管理员".equals(personnel.getJurisdiction())){
//            personnel.setJurisdiction("1");
//        }else if ("管理员".equals(personnel.getJurisdiction())){
//            personnel.setJurisdiction("2");
//        }else if("员工".equals(personnel.getJurisdiction())){
//            personnel.setJurisdiction("3");
//        }else {
//            personnel.setJurisdiction("4");
//        }
        //修改状态和职位
//        updateFrag(personnel);
        return personnelMapper.insert(personnel);
    }

    /**
     * 根据部门deptId和员工name查询员工信息
     * @param deptId
     * @param name
     * @return
     */
    public List<PersonnelItem> findPersonnelBydeptIdAndName(int deptId , String name){
        List<PersonnelItem>  personnelList = personnelItemMapper.selectPersonnel(deptId,name);

        return personnelList;
    }
    /**
      * @Description: 根据部门deptId和员工name查询员工信息
      * @Auther: Mr.Kong
      * @Date: 2019/4/3 14:55
      * @Param: [deptId, name]
      * @Return: java.util.List<cn.com.nantian.pojo.NtPersonnel>
      **/
    public List<NtPersonnel> findPerByDeptIdAndName(int deptId , String name){
        List<NtPersonnel>  personnelList = personnelMapper.findPersonnelBydeptIdAndName(deptId,name);
        return personnelList;
    }
    /**
     *根据身份证号查询员工信息
     * @return
     */
    public NtPersonnel findPersonnlByIdno(String idNo){
       return  personnelMapper.selectByPrimaryIdNo(idNo);
    }
    /**
     * 用于员工登录
     * @param username
     * @return
     */
    @Override
    public NtPersonnel findOne(String username) {

        NtPersonnel personnel=null;
        //判断这个字符串是手机号,身份证号,还是公司邮箱号
        if(username.endsWith("@nantian.com.cn")){//根据邮箱查询用户
            personnel = personnelMapper.selectByEmial(username);
         }else if(username.length()==11){//根据手机号获取
            personnel = personnelMapper.selectByPrimaryMobileNo(username);
        }else if(username.length()==18){//根据身份证号查询
            personnel = personnelMapper.selectByPrimaryIdNo(username);
        }
        return personnel;
    }

    /**
     * 验证登录用户名
     * @param name 登录用户名
     * @return
     */
    @Override
    public String checkLoginName(String name){
        String msg="";
        if (StringUtils.isEmpty(name)){
            msg="登录用户名不能为空！";
        }else if (!RegExpressionUtil.isMobile(name)){
            msg="手机号码填写不正确！";
        }else if (!RegExpressionUtil.isEmail(name)){
            msg="邮箱填写不正确！";
        }else if (!RegExpressionUtil.isIDNumber(name)){
            msg="身份证号码填写不正确！";
        }else {
            msg="登录用户名错误！只能是手机号或邮箱或身份证号码！";
        }
        return msg;
    }

    /**
     * 根据身份证号和别名删除员工信息
     * @param idNo,inProjectName
     * @return
     */
    @Override
    public String deleteByIdNo(String idNo,String inProjectName) {
        //判断别名是否为空
        int a=0;
        if(!inProjectName.isEmpty() && !inProjectName.isEmpty()){
            //如果不为空直接删除别名表的用户信息
              a = perAliasMapper.deleteByIdNoAndOtherName(idNo,inProjectName);
            return "delete otherName "+a;
        }else if(!idNo.isEmpty()) {
                //如果为空直接删除这个用户的信息
                a = personnelMapper.deleteByIdNo(idNo);
            if(a>=0){
                return  " delete personnel "+a;
            }
            return "not delete ";
        }else{
            return "not delete ";
        }
    }

    /**
     * 根据身份证号修改员工信息
     * @param personnel
     * @return
     */
    @Override
    public String updateByIdNo(NtPersonnel personnel) {
        int a=0;
        //查询数据库中是否有该员工信息
      NtPersonnel ntPersonnel =   personnelMapper.selectByPrimaryIdNo(personnel.getIdNo());

      //修改员工信息
      if(ntPersonnel != null){
          //修改状态和职位
            //  updateFrag(personnel);
            a = personnelMapper.updateByPrimaryKey(personnel);
            return "update success "+ a;
      }
      return  "No such employee";
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
     * @param idNo
     * @param password
     * @return
     */
    @Override
    public int byIdNoUpdatePW(String idNo,String oldPassword, String password) {
        int a=0;
        //查询员工信息
        NtPersonnel personnel = personnelMapper.selectByPrimaryIdNo(idNo);
        //判断旧密码是否正确
       String oldPW =  DigestUtils.md5DigestAsHex(oldPassword.getBytes());

        if (personnel != null) {
            if(oldPW.equals(personnel.getPassword())){
                //将密码加密
                personnel.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
                //将修改密码后的信息更改到表中
                a = personnelMapper.updateByPrimaryKey(personnel);
            }
        }else{
            return 0;
        }
        return a;
    }


    /**
     * 根据员工姓名 员工信息
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
     * @param idNo
     * @return
     */
    @Override
    public int resetPassWord(String idNo) {
        int t =0;
      NtPersonnel personnel =  personnelMapper.selectByPrimaryIdNo(idNo);
        //将密码加密
        personnel.setPassword(DigestUtils.md5DigestAsHex( "nt0000".getBytes()));
        //修改表中
        int a = personnelMapper.updateByPrimaryKey(personnel);
        t +=a;
        return t ;
    }



}
