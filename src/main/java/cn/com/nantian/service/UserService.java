package cn.com.nantian.service;
import cn.com.nantian.pojo.NtPersonnel;
import cn.com.nantian.pojo.PersonnelItem;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface UserService {

    public Map<String,Object> getStatisticsUserNum(NtPersonnel personnel);

    List<NtPersonnel> queryStatisticsUserNumByDept(NtPersonnel personnel);

    Map<String,Object> getStatisticalPersonnelNum(NtPersonnel ntPersonnel);

    NtPersonnel queryStatisticalPersonnelNum(NtPersonnel personnel);

    /**
     * @description: 处理员工工作状态数据
     * @auther: Mr.Wind
     * @date: 2019/5/6 14:57
     * @Param:  [personnelList]
     * @return: void
     **/
    public void setWorkStates(List<NtPersonnel> personnelList);
    /**
      * @description: 处理用户列表数据
      * @auther: Mr.Wind
      * @date: 2019/4/29 14:32
      * @Param:  [personnelList]
      * @return: List<NtPersonnel>
      **/
    public List<NtPersonnel> setPersonnelDate(List<NtPersonnel> personnelList);

    /**
     * @description:  查询用户列表
     * @auther: Mr.Wind
     * @date: 2019/4/29 14:16
     * @Param:  [personnel]
     * @return: List<NtPersonnel>
     **/
    List<NtPersonnel> queryPersonnelListDate(NtPersonnel personnel);


    /**
     * @description: 查询用户列表
     * @auther: Mr.Wind
     * @date: 2019/4/26 15:59
     * @param:  [personnel] 查询条件
     * @return: List<NtPersonnel>
     */
    List<NtPersonnel> queryPersonnelList(NtPersonnel personnel);

    /**
     * 添加员工信息
     * NT_PERSONNEL
     *
     * @param personnel
     */
    public int addUser(NtPersonnel personnel) throws Exception;
    /**
     * @description: 新建 检查传入的参数是否为空 格式是否正确 是否已存在
     * @auther: Mr.Wind
     * @date: 2019/4/26 14:22
     * @Param:  [personnel]
     * @return: java.lang.String
     **/
    public String checkAddUserParameter(NtPersonnel personnel);
    /**
      * @description: 更新 检查传入的参数是否为空 格式是否正确 是否已存在
      * @auther: Mr.Wind
      * @date: 2019/5/5 15:23
      * @Param:  [personnel]
      * @return: java.lang.String
      **/
    public String checkUpdateUserParameter(NtPersonnel personnel);



    /**根据id查询员工姓名
     */
    String  selectByUserId(int perId);

    /**
     * 根据部门deptId和员工name查询员工信息
     * @param deptId
     * @param name
     * @return
     */
    List<PersonnelItem> findPersonnelBydeptIdAndName(int deptId , String name);

    /**
      * @description: 根据部门deptId和员工name查询员工信息
      * @auther: Mr.Wind
      * @date: 2019/4/3 14:56
      * @Param: [deptId, name]
      * @return: List<NtPersonnel>
      **/
    public List<NtPersonnel> findPerByDeptIdAndName(int deptId , String name);


    /**
     * 根据身份证号查询员工信息
     * @return
     */
    NtPersonnel findPersonnlByIdno(String idNo);


    /**
     * 用于员工的登录
     * @param username
     * @return
     */
    NtPersonnel findOne(String username);

    /**
      * @description: 效验传入的登录用户名、密码
      * @auther: Mr.Wind
      * @date: 2019/5/17 14:37
      * @param:  [name, password]
      * @return: java.lang.String
      **/
    public String checkLoginParameter(String name,String password);

    /**
     * @description: 验证登录用户名
     * @auther: Mr.Wind
     * @date: 2019/5/17 14:44
     * @param:  [name]
     * @return: java.lang.String
     **/
    public String checkLoginName(String name);

    /**
     *根据员工编号获取员工信息
     * @param perId
     * @return
     */
   NtPersonnel findPersonnlByPerId(int perId);


    /**
     * 根据身份证号和别名删除员工信息
     * @param idNo,inProjectName
     * @return
     */
    String deleteByIdNo(String idNo,String inProjectName);

    /**
     *  修改员工信息
     * @param personnel
     * @return
     */
    int updateByIdNo(NtPersonnel personnel) throws ParseException;


    /**
     * 根据身份证号修改密码
     * @param idNo
     * @param password
     * @return
     */
    int byIdNoUpdatePW(String idNo,String oldPassword,String password);

    /**
     * 根据员工姓名 员工信息
     * @param name
     * @return
     */
    List<NtPersonnel> findByName(String name);

    /**
     * 重置密码
     * @param idNo
     * @return
     */
    int resetPassWord(String idNo);

    /**
      * @description: 重置密码
      * @auther: Mr.Wind
      * @date: 2019/5/13 10:54
      * @param:  [perId]
      * @return: int
      **/
    int resetPassWord(int perId);
}