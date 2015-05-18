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
import com.project.Dao.teamDao;
import com.project.bean.Headnews;
import com.project.bean.Team;

public class teamAction extends ActionSupport {
	
	private teamDao teamDao;
	private Team team;
	

	public teamDao getTeamDao() {
		return teamDao;
	}


	public void setTeamDao(teamDao teamDao) {
		this.teamDao = teamDao;
	}


	public Team getTeam() {
		return team;
	}


	public void setTeam(Team team) {
		this.team = team;
	}


	public teamAction() {
		// TODO Auto-generated constructor stub
	}
	
	public void getTeams() throws Exception{
		List<Team> list = this.teamDao.findAll();
		json(list);
	}
	
	//list转化为json对象
		public void json(List<Team> list) throws Exception{
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
