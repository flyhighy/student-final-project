package com.project.admin;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.project.Dao.userDao;
import com.project.bean.User;

public class userManage extends ActionSupport {
	private userDao userDao;
	private User user;
	List<Integer> checkOption;
	
	
	
	
	public List<Integer> getCheckOption() {
		return checkOption;
	}


	public void setCheckOption(List<Integer> checkOption) {
		this.checkOption = checkOption;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public userDao getUserDao() {
		return userDao;
	}


	public void setUserDao(userDao userDao) {
		this.userDao = userDao;
	}


	public String adminUser() throws Exception{
		List<User> list = this.userDao.findAll();
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list", list);
		return SUCCESS;
	}
	
	public String saveUser() throws Exception{
		
		Map map=ActionContext.getContext().getSession();
	    User nowUser=(User)map.get("user");

		if(nowUser.getType() >= user.getType()){
			this.addFieldError("error", "对不起，您没有权限对此用户进行操作！");
			return "error";
		}
		
		if(user.getTime() == null){
			user.setTime(new Date());
		}
		this.userDao.saveUser(user);
		return SUCCESS;
	}
	
	public String addUser() throws Exception{
		return SUCCESS;
	}
	
	public String editUser() throws Exception{
		User user1 = this.userDao.findUserById(user.getId());
		
		Map session=ActionContext.getContext().getSession();
		User nowUser=(User) session.get("user");
		
		if(nowUser.getType() >= user1.getType()){
			this.addFieldError("error", "对不起，您没有权限对此用户进行操作！");
			return "error";
		}
		
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("user", user1);
		return SUCCESS;
	}
	
	public String delUser() throws Exception{
		User user1 = this.userDao.findUserById(user.getId());
		Map session=ActionContext.getContext().getSession();
		User nowUser=(User) session.get("user");

		if(nowUser.getType() >= user1.getType()){
			this.addFieldError("error", "对不起，您没有权限对此用户进行操作！");
			return "error";
		}else{	
			this.userDao.delUserById(user.getId());
			return SUCCESS;
		}
		
	}
	
	public String updateUser() throws Exception{
		if(user.getTime() == null){
			user.setTime(new Date());
		}
		
		Map session=ActionContext.getContext().getSession();
		User nowUser=(User) session.get("user");
			
		if(nowUser.getType() >= user.getType()){
			this.addFieldError("error", "对不起，您没有权限对此用户进行操作！");
			return "error";
		}
		this.userDao.updateUser(user);
		return SUCCESS;
	}
	
	public String delManyUser() throws Exception{
			
		for(int i=0;i<checkOption.size();i++){
			User user1 = this.userDao.findUserById(checkOption.get(i));
			
			Map session=ActionContext.getContext().getSession();
			User nowUser=(User) session.get("user");
				
			if(nowUser.getType() >= user1.getType()){
				this.addFieldError("error", "对不起，您没有权限对此用户进行操作！");
				return "error";
			}
			
			this.userDao.delUserById(checkOption.get(i));
		}
		return SUCCESS;
	}
	

}
