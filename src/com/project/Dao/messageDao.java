package com.project.Dao;

import java.util.List;

import com.project.bean.Message;

public interface messageDao {
	public void saveMessage(Message message);
	public List<Message> findAll();
	public Message findById(int id);
	public void delLeavemsg(int id);
}
