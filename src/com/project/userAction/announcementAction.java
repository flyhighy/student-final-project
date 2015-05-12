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
import com.project.Dao.announcementDao;
import com.project.bean.Announcement;
import com.project.bean.Headnews;
import com.project.bean.News;

public class announcementAction extends ActionSupport {
	
	private announcementDao announcementDao;
	private Announcement announcement;
	



	public Announcement getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}

	public announcementDao getAnnouncementDao() {
		return announcementDao;
	}

	public void setAnnouncementDao(announcementDao announcementDao) {
		this.announcementDao = announcementDao;
	}
	
	
	public void userAnnouncementDetail() throws Exception{
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
		Announcement announcement1 = this.announcementDao.findMessage(announcement.getId());
		
		JSONObject jsonitem = JSONObject.fromObject(announcement1);
		json1.add(jsonitem);
		out.print(json1);
	}
	

	

	public void getAnnouncements() throws Exception{
		List<Announcement> list = this.announcementDao.fildAll();
		json(list);
	}
	
	
	
	
	//list转化为json对象
		public void json(List<Announcement> list) throws Exception{
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
