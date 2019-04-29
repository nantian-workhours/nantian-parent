package cn.com.nantian.service;
import cn.com.nantian.pojo.NtPersonnel;
import cn.com.nantian.pojo.PersonnelItem;
import java.util.List;

public interface UserService {


    /**
      * @Description: 处理用户列表数据
      * @Auther: Mr.Kong
      * @Date: 2019/4/29 14:32
      * @Param:  [personnelList]
      * @Return: java.util.List<cn.com.nantian.pojo.NtPersonnel>
      **/
    public List<NtPersonnel> setPersonnelDate(List<NtPersonnel> personnelList);

    /**
     * @Description:  查询用户列表
     * @Auther: Mr.Kong
     * @Date: 2019/4/29 14:16
     * @Param:  [personnel]
     * @Return: java.util.List<cn.com.nantian.pojo.NtPersonnel>
     **/
    List<NtPersonnel> queryPersonnelListDate(NtPersonnel personnel);


    /**
     * @Description: 查询用户列表
     * @auther: Mr.Kong
     * @date: 2019/4/26 15:59
     * @param:  [personnel] 查询条件
     * @return: java.util.List<cn.com.nantian.pojo.NtPersonnel>
     */
    List<NtPersonnel> queryPersonnelList(NtPersonnel personnel);

    /**
     * 添加员工信息
     * NT_PERSONNEL
     *
     * @param personnel
     */
    public int addUser(NtPersonnel personnel);
    /**
     * @Description: 检查传入的参数是否为空 格式是否正确 是否已存在
     * @Auther: Mr.Kong
     * @Date: 2019/4/26 14:22
     * @Param:  [personnel]
     * @Return: java.lang.String
     **/
    public String checkUserParameter(NtPersonnel personnel);

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
      * @Description: 根据部门deptId和员工name查询员工信息
      * @Auther: Mr.Kong
      * @Date: 2019/4/3 14:56
      * @Param: [deptId, name]
      * @Return: java.util.List<cn.com.nantian.pojo.NtPersonnel>
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
     * 验证登录用户名
     * @param name 登录用户名
     * @return
     */
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
    String updateByIdNo(NtPersonnel personnel);


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
}