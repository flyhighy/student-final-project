package com.project.admin;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.project.Dao.headnewsDao;
import com.project.bean.Headnews;

public class headNews extends ActionSupport {
	
	private headnewsDao headnewsDao;
	private Headnews headnews;
	
	
	

	public Headnews getHeadnews() {
		return headnews;
	}

	public void setHeadnews(Headnews headnews) {
		this.headnews = headnews;
	}

	public headnewsDao getHeadnewsDao() {
		return headnewsDao;
	}

	public void setHeadnewsDao(headnewsDao headnewsDao) {
		this.headnewsDao = headnewsDao;
	}

	public headNews() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	public String adminHeadnews() throws Exception{
		Map session=ActionContext.getContext().getSession();
		session.put("nowNav", "11");
		
		List<Headnews> list = this.headnewsDao.findAll();
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list", list);
		return SUCCESS;
	}
	
	public String createHeadnews() throws Exception{
		return SUCCESS;
	}
	
	public String saveHeadnews() throws Exception{
		
		this.headnews.setTime(new Date());
		this.headnewsDao.saveHead(headnews);
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String editHeadnews() throws Exception{
		
		Headnews news = this.headnewsDao.findById(headnews.getId());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("headnews", news);
		return SUCCESS;
	}
	
	public String updateHeadnews() throws Exception{
		
		this.headnews.setTime(new Date());
		this.headnewsDao.updateHead(headnews);
		return SUCCESS;
	}
	
	public String delHeadnews() throws Exception{
		this.headnewsDao.delHead(headnews.getId());
		return SUCCESS;
	}
}
