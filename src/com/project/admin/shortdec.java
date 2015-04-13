package com.project.admin;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.project.Dao.shortdecDao;
import com.project.bean.Shortdec;
import com.project.bean.User;

public class shortdec extends ActionSupport {
	
	private shortdecDao shortdecDao;
	private Shortdec shortdec;
	
	public Shortdec getShortdec() {
		return shortdec;
	}

	public void setShortdec(Shortdec shortdec) {
		this.shortdec = shortdec;
	}

	public shortdecDao getShortdecDao() {
		return shortdecDao;
	}

	public void setShortdecDao(shortdecDao shortdecDao) {
		this.shortdecDao = shortdecDao;
	}


	
	@SuppressWarnings("unchecked")
	public String adminShortdec() throws Exception{
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		session.put("nowNav", "1");
		if(user != null){
			Shortdec shortdec = this.shortdecDao.getShortdec();
			Map request = (Map) ActionContext.getContext().get("request");
			request.put("shortdec", shortdec);
			return SUCCESS;
		}
		return "login";
	}
	
	//±à¼­¼ò½é
	public String editShortdec() throws Exception{
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		if(user != null){
			return SUCCESS;
		}
		return "login";
	}
	
	//±£´æ¼ò½é
	public String saveShortdec() throws Exception{
		// TODO Auto-generated constructor stub
		shortdec.setId(0);
		this.shortdecDao.save(shortdec);
		
		return SUCCESS;
	}
}
