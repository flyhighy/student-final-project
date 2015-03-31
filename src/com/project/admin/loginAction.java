package com.project.admin;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.project.bean.User;
import com.project.Dao.adminDao;;

public class loginAction extends ActionSupport {
	
	private User user;
	
	private adminDao adminDao;

	public adminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(adminDao adminDao) {
		this.adminDao = adminDao;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@SuppressWarnings("unchecked")
	public String login() throws Exception{
		
		User user1 = this.adminDao.findUser(user.getUsername());
		if(user1 == null){
			this.addFieldError("login", "用户名或密码错误！");
			return "input";
		}else{
			if(user1.getPassword().equals(user.getPassword())){
				Map session=ActionContext.getContext().getSession();
				session.put("user", user);
				return SUCCESS;
			}
		}
		this.addFieldError("login", "用户名或密码错误！");
		return "input";
	}

}
