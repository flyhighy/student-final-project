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
import com.project.Dao.formDao;
import com.project.bean.Form;
import com.project.bean.Headnews;

public class form  extends ActionSupport{
	
	private Form form;
	private formDao formDao;
	
	

	public Form getForm() {
		return form;
	}



	public void setForm(Form form) {
		this.form = form;
	}



	public formDao getFormDao() {
		return formDao;
	}



	public void setFormDao(formDao formDao) {
		this.formDao = formDao;
	}



	public form() {
		// TODO Auto-generated constructor stub
	}
	
	public String delForm() throws Exception{
		this.formDao.delForm(form.getId());
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String viewForm() throws Exception{
		Form form1 = this.formDao.findById(form.getId());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("form", form1);
		return SUCCESS;
	}

}
