package com.bill99.ian.controller.local;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bill99.ian.entity.SysAuthorities;
import com.bill99.ian.entity.SysRoles;
import com.bill99.ian.entity.SysRolesAuthorities;
import com.bill99.ian.entity.SysUsers;
import com.bill99.ian.entity.SysUsersRoles;
import com.bill99.ian.service.SysUsersService;
import com.bill99.ian.util.MD5;

/**
 * 系统对象用户请求处理-注册
 * @author haipeng.cheng
 * @since 2016-04-13
 * @version jdk1.6
 */
@Controller
public class UserMgrController {
	
	@Autowired
	private BCryptPasswordEncoder myPwdEncoder;
	
	@Autowired
	private SysUsersService sysUsersService;

	@RequestMapping(value="/toRegister", method=RequestMethod.GET)
	public ModelAndView toRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView view = new ModelAndView("/register");
		return view;
	}
	
	/**
	 * 注册：用户对象设置、权限资源设置-入库
	 * @param request
	 * @param response
	 * @param username
	 * @param password
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("username")String username, @RequestParam("password")String password) throws IOException {
		System.out.println("username:" + username);
		System.out.println("password:" + password);
		SysUsers user = new SysUsers();
		user.setUserName(username);
		user.setUserPassword(MD5.GetMD5Code(password));
		user.setUserAccount("test_account");
		user.setIssys(0);
		user.setEnabled(1);
		Map<String, String> seqMap = new HashMap<String, String>();
		seqMap.put("name", "user_id");
		seqMap.put("userId", "");
		sysUsersService.getUserId(seqMap);
		user.setUserId(seqMap.get("userId"));
		SysUsersRoles usersRoles = new SysUsersRoles();
		usersRoles.setEnabled(1);
		usersRoles.setId(Long.parseLong(seqMap.get("userId")));
		SysRoles role = new SysRoles();
		role.setRoleId("002");
		role.setEnabled(1);
		role.setIssys(0);
		role.setRoleDesc("普通用户");
		role.setRoleName("ROLE_USER");
		usersRoles.setSysUsers(user);
		usersRoles.setSysRoles(role);
		SysRolesAuthorities rolesAuthorities = new SysRolesAuthorities();
		SysAuthorities authority = new SysAuthorities();
		authority.setAuthorityId("002");
		authority.setAuthorityName("ROLE_USER");
		authority.setEnabled(1);
		authority.setIssys(0);
		rolesAuthorities.setId(2l);
		rolesAuthorities.setSysAuthorities(authority);
		rolesAuthorities.setSysRoles(role);
		ModelAndView view = new ModelAndView("/login");
		try {
			sysUsersService.registerUser(user, usersRoles);
		} catch (Exception e) {
			e.printStackTrace();
			view = new ModelAndView("/register");
		}
		return view;
	}
}
