package com.project.userAction;

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

public class formAction  extends ActionSupport{
	
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



	public formAction() {
		// TODO Auto-generated constructor stub
	}
	
	public String saveForm() throws Exception{
		this.form.setTime(new Date());
		this.formDao.saveForm(form);
		return SUCCESS;
	}
	
	public void getApplys() throws Exception{
		Map session=ActionContext.getContext().getSession();
		session.put("nowNav", "9");
		List<Form> list = this.formDao.getAll();
		json(list);
	}
	
	//list转化为json对象
	public void json(List<Form> list) throws Exception{
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
