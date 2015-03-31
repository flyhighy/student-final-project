package com.project.admin;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.project.Dao.newsDao;
import com.project.bean.News;
import com.project.bean.User;

public class createNews extends ActionSupport {
	

	public String createNews() throws Exception{
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		if(user != null){
			return SUCCESS;
		}
		return "login";
	}
}
