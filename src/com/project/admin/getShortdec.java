package com.project.admin;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.project.Dao.shortdecDao;
import com.project.bean.Shortdec;

public class getShortdec extends ActionSupport {
	

	private shortdecDao shortdecDao;
	
	public shortdecDao getShortdecDao() {
		return shortdecDao;
	}

	public void setShortdecDao(shortdecDao shortdecDao) {
		this.shortdecDao = shortdecDao;
	}


	public void getShortdec() throws Exception{
		
		
		// TODO Auto-generated constructor stub
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8"); 
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Shortdec shortdec = this.shortdecDao.getShortdec();
		
		PrintWriter out = response.getWriter();
		System.out.println();
		out.println(shortdec.getShortdec());
	}

}
