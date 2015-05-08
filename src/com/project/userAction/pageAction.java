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
import com.project.Dao.downloadDao;
import com.project.bean.Download;
import com.project.bean.News;

public class pageAction extends ActionSupport {
	
	private downloadDao downloadDao;
	

	public downloadDao getDownloadDao() {
		return downloadDao;
	}

	public void setDownloadDao(downloadDao downloadDao) {
		this.downloadDao = downloadDao;
	}

	public pageAction() {
		// TODO Auto-generated constructor stub
	}
	
	public String getPage(){
		return SUCCESS;
	}
	
	public void getDownload() throws Exception{
		List<Download> list = this.downloadDao.findAll();
		json(list);
	}
	
	//list转化为json对象
		public void json(List<Download> list) throws Exception{
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
