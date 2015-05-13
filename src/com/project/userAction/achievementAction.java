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
import com.project.Dao.achievementDao;
import com.project.bean.Achievement;
import com.project.bean.Announcement;
import com.project.bean.News;

public class achievementAction extends ActionSupport {
	
	private Achievement achievement;
	private achievementDao achievementDao;
	

	public Achievement getAchievement() {
		return achievement;
	}


	public void setAchievement(Achievement achievement) {
		this.achievement = achievement;
	}


	public achievementDao getAchievementDao() {
		return achievementDao;
	}


	public void setAchievementDao(achievementDao achievementDao) {
		this.achievementDao = achievementDao;
	}


	public achievementAction() {
		// TODO Auto-generated constructor stub
	}
	
	public void userAchievementDetail() throws Exception{
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
		Achievement achievement1 = this.achievementDao.findById(achievement.getId());
		
		JSONObject jsonitem = JSONObject.fromObject(achievement1);
		json.add(jsonitem);
		out.println(json);
	}
	
	public void getAchievements() throws Exception{
		List<Achievement> list = this.achievementDao.findAll();
		json(list);
	}
	
	//list转化为json对象
		public void json(List<Achievement> list) throws Exception{
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
