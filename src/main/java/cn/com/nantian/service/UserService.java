package cn.com.nantian.service;
import cn.com.nantian.pojo.NtPersonnel;
import cn.com.nantian.pojo.PersonnelItem;
import java.util.List;

public interface UserService {

    /**
     * 添加员工信息
     * NT_PERSONNEL
     *
     * @param personnel
     */
    public int addUser(NtPersonnel personnel);

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