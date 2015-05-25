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
import com.project.Dao.messageDao;
import com.project.bean.Message;

public class leaveMessageAction extends ActionSupport {
	
	private Message message;
	private messageDao messageDao;
	

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public messageDao getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(messageDao messageDao) {
		this.messageDao = messageDao;
	}

	public leaveMessageAction() {
		// TODO Auto-generated constructor stub
	}
	
	public String saveLeaveMessage() throws Exception{
		message.setTime(new Date());
		this.messageDao.saveMessage(message);
		return SUCCESS;
	}
	
	public String leaveMsgDetail() throws Exception{
		
		Message message1 = this.messageDao.findById(message.getId());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("message", message1);
		return SUCCESS;
	}
	
	public String delLeaveMsg() throws Exception{
		this.messageDao.delLeavemsg(message.getId());
		return SUCCESS;
	}
	
	public void getLeaveMsgs() throws Exception{
		Map session=ActionContext.getContext().getSession();
		session.put("nowNav", "10");
		List<Message> list = this.messageDao.findAll();
		json(list);
	}
	
	//list转化为json对象
	public void json(List<Message> list) throws Exception{
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
