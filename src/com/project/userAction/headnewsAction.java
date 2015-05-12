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
import com.project.Dao.headnewsDao;
import com.project.bean.Announcement;
import com.project.bean.Headnews;

public class headnewsAction extends ActionSupport {
	
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

	public headnewsAction() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void headNewsDetail() throws Exception{
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
		JSONArray json1 = new JSONArray();   
		Headnews headnews1 = this.headnewsDao.findById(headnews.getId());
		
		JSONObject jsonitem = JSONObject.fromObject(headnews1);
		json1.add(jsonitem);
		out.print(json1);
	}
	
	
	
	public void getheadNews() throws Exception{
		
		List<Headnews> list = this.headnewsDao.findAll();
		json(list);
	}
	
	
	//list转化为json对象
	public void json(List<Headnews> list) throws Exception{
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
