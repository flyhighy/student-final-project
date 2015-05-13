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
import com.project.Dao.competitionDao;
import com.project.bean.Achievement;
import com.project.bean.Announcement;
import com.project.bean.Competition;

public class competitionAction extends ActionSupport {
	
	private Competition competition;
	private competitionDao competitionDao;
	
	

	public Competition getCompetition() {
		return competition;
	}



	public void setCompetition(Competition competition) {
		this.competition = competition;
	}



	



	public competitionDao getCompetitionDao() {
		return competitionDao;
	}



	public void setCompetitionDao(competitionDao competitionDao) {
		this.competitionDao = competitionDao;
	}



	public competitionAction() {
		// TODO Auto-generated constructor stub
	}
	
	public void userCompetitionDetail() throws Exception{
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
		Competition competition1 = this.competitionDao.findById(competition.getId());
		
		JSONObject jsonitem = JSONObject.fromObject(competition1);
		json.add(jsonitem);
		out.println(json);
	}
	
	public void getCompetitions() throws Exception{
		List<Competition>  list = this.competitionDao.findAll();
		json(list);
	}
	
	//list转化为json对象
	public void json(List<Competition> list) throws Exception{
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
