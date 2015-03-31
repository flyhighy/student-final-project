package com.project.admin;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.project.bean.User;

public class editShortdec extends ActionSupport {
	
	public String editShortdec() throws Exception{
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		if(user != null){
			return SUCCESS;
		}
		return "login";
	}
}
