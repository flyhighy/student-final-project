package com.project.userAction;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.project.Dao.newsDao;
import com.project.bean.Headnews;
import com.project.bean.News;

public class newsAction extends ActionSupport {
	
	private newsDao newsDao;
	private News news;
	
	

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public newsDao getNewsDao() {
		return newsDao;
	}

	public void setNewsDao(newsDao newsDao) {
		this.newsDao = newsDao;
	}

	public newsAction() {
		// TODO Auto-generated constructor stub
	}
	
	public void gethotNews() throws Exception{
		
		List<News> list = this.newsDao.getAll();
		json(list);
	}
	
	public void userNewsDetail() throws Exception{		
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
		JSONArray json = new JSONArray();   
		News news1 = this.newsDao.findNews(news.getId());
		news1.setNumber(news1.getNumber()+1);
		this.newsDao.updateNews(news1);
		JSONObject jsonitem = JSONObject.fromObject(news1);
		json.add(jsonitem);
		out.println(json);
	}
	
	//list转化为json对象
		public void json(List<News> list) throws Exception{
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
			
			if(list == null){
				out.println("[]");
			}
			JSONArray json = new JSONArray();   
			for(int i = 0;i<list.size();i++){
				JSONObject jsonitem = JSONObject.fromObject(list.get(i));
				json.add(jsonitem);
			}			
			out.println(json);
		}

}
