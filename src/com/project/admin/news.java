package com.project.admin;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.project.Dao.newsDao;
import com.project.bean.News;
import com.project.bean.User;

public class news extends ActionSupport {
	
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


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String adminNews() throws Exception{
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		if(user != null){
			
			List<News> list = this.newsDao.findAll();
			Map request = (Map) ActionContext.getContext().get("request");
			request.put("list", list);
			
			return SUCCESS;
		}
		return "login";
	}
}
