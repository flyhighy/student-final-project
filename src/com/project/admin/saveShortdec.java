package com.project.admin;

import com.opensymphony.xwork2.ActionSupport;
import com.project.Dao.shortdecDao;
import com.project.bean.Shortdec;

public class saveShortdec extends ActionSupport {
	
	private shortdecDao shortdecDao;
	private Shortdec shortdec;
	
	

	public Shortdec getShortdec() {
		return shortdec;
	}

	public void setShortdec(Shortdec shortdec) {
		this.shortdec = shortdec;
	}

	

	public shortdecDao getShortdecDao() {
		return shortdecDao;
	}

	public void setShortdecDao(shortdecDao shortdecDao) {
		this.shortdecDao = shortdecDao;
	}

	public String saveShortdec() throws Exception{
		// TODO Auto-generated constructor stub
		shortdec.setId(0);
		this.shortdecDao.save(shortdec);
		
		return SUCCESS;
	}

}
