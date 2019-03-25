package cn.com.nantian.pojo;

/**
 * 定义用户登录方式的实体
 */
public class LoginItem {

    //手机号
    private String mobileNo;

    //身份证号
    private String idNo;
    //公司邮箱
    private String companyEmail;

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }
}
