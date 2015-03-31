package com.project.admin;

import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.project.Dao.newsDao;
import com.project.bean.News;
import com.project.bean.User;

public class saveNews extends ActionSupport {
	
	private News news;
	private newsDao newsDao;
	
	
	
	
	public newsDao getNewsDao() {
		return newsDao;
	}


	public void setNewsDao(newsDao newsDao) {
		this.newsDao = newsDao;
	}


	public News getNews() {
		return news;
	}


	public void setNews(News news) {
		this.news = news;
	}


	public String saveNews() throws Exception{
		
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		news.setTime(new Date());
		news.setNumber(0);
		
		if(user != null){
			this.newsDao.createNews(news);
			return SUCCESS;
		}
		return "login";
	}
}
