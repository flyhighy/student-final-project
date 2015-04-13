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
import com.project.Dao.newsDao;
import com.project.bean.News;
import com.project.bean.User;

public class news extends ActionSupport {
	
	private News news;
	private newsDao newsDao;
	private List<Integer> checkOption;
	private String searchOption;
	
	
	
	
	
	




	public String getSearchOption() {
		return searchOption;
	}


	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}


	public List<Integer> getCheckOption() {
		return checkOption;
	}


	public void setCheckOption(List<Integer> checkOption) {
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
	


	//展示资讯
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String adminNews() throws Exception{
		Map session=ActionContext.getContext().getSession();
		session.put("nowNav", "2");
		User user=(User)session.get("user");
		if(user != null){
			return SUCCESS;
		}
		return "login";
	}
	
	//发布资讯
	public String createNews() throws Exception{
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		if(user != null){
			return SUCCESS;
		}
		return "login";
	}
	
	//保存资讯
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
	
	//删除资讯
	public String delNews() throws Exception{
		this.newsDao.delNews(news.getId());
		return SUCCESS;
	}
	
	//编辑资讯
	@SuppressWarnings("unchecked")
	public String editNews() throws Exception{
		News news1 = this.newsDao.findNews(news.getId());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("news", news1);
		return SUCCESS;
	}
	//更新资讯
	public String updateNews() throws Exception{
		news.setTime(new Date());
		this.newsDao.updateNews(news);
		return SUCCESS;
	}
	
	//查看资讯
	@SuppressWarnings("unchecked")
	public String newsDetail() throws Exception{
		News news1 = this.newsDao.findNews(news.getId());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("news", news1);
		return SUCCESS;
	}
		
	//批量删除资讯
	public String delMany() throws Exception{
		if (checkOption != null) {
			for (int i = 0; i < checkOption.size(); i++) {
				this.newsDao.delNews(checkOption.get(i));
			}}
		
		return SUCCESS;
	}	
	
	
	//查询资讯
	public void searchNews() throws Exception{
	
		
		String hql = "from News news where news.title like"+
				"'%"
				+ searchOption
				+ "%'";
		List<News> list = this.newsDao.searchByHql(hql);
		json(list);
	}
	
	//资讯分页功能
	public void newsPages() throws Exception{
		
		List<News> list = this.newsDao.findAll();
		
		JSONArray json = new JSONArray();   
		
		json(list);
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
