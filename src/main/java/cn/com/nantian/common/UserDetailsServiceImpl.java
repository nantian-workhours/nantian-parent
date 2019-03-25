package cn.com.nantian.common;

import java.util.ArrayList;

import java.util.List;

import cn.com.nantian.pojo.LoginItem;
import cn.com.nantian.pojo.NtPersonnel;
import cn.com.nantian.service.UserService;
import com.alibaba.druid.sql.visitor.functions.If;
import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



public class UserDetailsServiceImpl implements UserDetailsService {

	
	
	private UserService userService;
	
	//添加set方法发
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 自定义的认证方法
	 */

	@Override
	public UserDetails loadUserByUsername(String jsonname) throws UsernameNotFoundException {



		//提供数据库的信息,前台登录页面,用户名和密码
		
		NtPersonnel personnel = userService.findOne(jsonname);
		if(personnel!=null) {
			//获取认证权限集合
			List<GrantedAuthority> authorities  =new ArrayList<>();
			//获取认证权限字符串
			SimpleGrantedAuthority simpleGrantedAuthority=null;
			if("0".equals(personnel.getJurisdiction())){//超级管理员
				 simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_SUPERADMIN");
			}else if("1".equals(personnel.getJurisdiction())){//管理员
				 simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
			}else if("2".equals(personnel.getJurisdiction())){//不同用户
				 simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
			}else {//没有权限
				simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_FORBIDDEN");
			}

			authorities.add(simpleGrantedAuthority);
			//返回认证信息
			return new User(jsonname, personnel.getPassword(), authorities);
		}else {
			return null;
			
		}
		
		
	}

}
