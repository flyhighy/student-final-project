package com.project.admin;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.project.Dao.shortdecDao;
import com.project.bean.Shortdec;
import com.project.bean.User;

public class shortdec extends ActionSupport {
	
	public shortdecDao getShortdecDao() {
		return shortdecDao;
	}

	public void setShortdecDao(shortdecDao shortdecDao) {
		this.shortdecDao = shortdecDao;
	}

	private shortdecDao shortdecDao;
	
	@SuppressWarnings("unchecked")
	public String adminShortdec() throws Exception{
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		if(user != null){
			Shortdec shortdec = this.shortdecDao.getShortdec();
			Map request = (Map) ActionContext.getContext().get("request");
			request.put("shortdec", shortdec);
			return SUCCESS;
		}
		return "login";
	}
}
