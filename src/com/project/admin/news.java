package com.project.admin;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.project.Dao.newsDao;
import com.project.bean.News;
import com.project.bean.Shortdec;
import com.project.bean.User;

public class news extends ActionSupport {
	
	private News news;
	private String checkOption;
	private newsDao newsDao;
	
	
	public String getCheckOption() {
		return checkOption;
	}


	public void setCheckOption(String checkOption) {
		this.checkOption = checkOption;
	}


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


	//չʾ��Ѷ
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
	
	//������Ѷ
	public String createNews() throws Exception{
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		if(user != null){
			return SUCCESS;
		}
		return "login";
	}
	
	//������Ѷ
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
	
	//ɾ����Ѷ
	public String delNews() throws Exception{
		this.newsDao.delNews(news.getId());
		return SUCCESS;
	}
	
	//�༭��Ѷ
	@SuppressWarnings("unchecked")
	public String editNews() throws Exception{
		News news1 = this.newsDao.findNews(news.getId());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("news", news1);
		return SUCCESS;
	}
	//������Ѷ
	public String updateNews() throws Exception{
		news.setTime(new Date());
		this.newsDao.updateNews(news);
		return SUCCESS;
	}
	
	//�鿴��Ѷ
	@SuppressWarnings("unchecked")
	public String newsDetail() throws Exception{
		News news1 = this.newsDao.findNews(news.getId());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("news", news1);
		return SUCCESS;
	}
		
	//����ɾ����Ѷ
	public String delMany() throws Exception{
		if (checkOption != null) {
			String[] listId = checkOption.split(",");
			for (int i = 0; i < listId.length; i++) {
				this.newsDao.delNews(Integer.parseInt(listId[i]));
			}}
		
		return SUCCESS;
	}	
	
}
