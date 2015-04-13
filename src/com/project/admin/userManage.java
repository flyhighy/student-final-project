package com.project.admin;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

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

	public String adminUser() throws Exception {
		Map session=ActionContext.getContext().getSession();
		session.put("nowNav", "7");
		
		List<User> list = this.userDao.findAll();
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list", list);
		return SUCCESS;
	}

	public String saveUser() throws Exception {

		if (user.getTime() == null) {
			user.setTime(new Date());
		}
		this.userDao.saveUser(user);
		return SUCCESS;
	}

	public String addUser() throws Exception {
		return SUCCESS;
	}

	public String editUser() throws Exception {
		User user1 = this.userDao.findUserById(user.getId());

		Map request = (Map) ActionContext.getContext().get("request");
		request.put("user", user1);
		return SUCCESS;
	}

	public String delUser() throws Exception {
		User user1 = this.userDao.findUserById(user.getId());

		this.userDao.delUserById(user.getId());
		return SUCCESS;

	}

	public String updateUser() throws Exception {
		if (user.getTime() == null) {
			user.setTime(new Date());
		}

		this.userDao.updateUser(user);
		return SUCCESS;
	}

	public String delManyUser() throws Exception {

		for (int i = 0; i < checkOption.size(); i++) {
			User user1 = this.userDao.findUserById(checkOption.get(i));

			Map session = ActionContext.getContext().getSession();
			User nowUser = (User) session.get("user");

			if (nowUser.getType() >= user1.getType()) {
				this.addFieldError("error", "对不起，您没有权限对此用户进行操作！");
				return "error";
			}

			this.userDao.delUserById(checkOption.get(i));
		}
		return SUCCESS;
	}
	
	public void getPageMsg() throws Exception {
	
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8"); 
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		PrintWriter out = response.getWriter();
		Map session = ActionContext.getContext().getSession();
		String nowNav = (String) session.get("nowNav");
		User user = (User) session.get("user");
		
		JSONObject item = JSONObject.fromObject(user);
		JSONArray json = new JSONArray();   
		json.add(user);
		json.add(nowNav);
		out.println(json);
	}

}
