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
import com.project.bean.Headnews;

public class headnewsAction extends ActionSupport {
	
	private headnewsDao headnewsDao;
	

	public headnewsDao getHeadnewsDao() {
		return headnewsDao;
	}

	public void setHeadnewsDao(headnewsDao headnewsDao) {
		this.headnewsDao = headnewsDao;
	}

	public headnewsAction() {
		// TODO Auto-generated constructor stub
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
