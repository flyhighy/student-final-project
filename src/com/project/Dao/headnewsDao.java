package com.project.Dao;

import java.util.List;

import com.project.bean.Headnews;

public interface headnewsDao {
	public  List<Headnews> findAll();
	public  void delHead(int id);
	public Headnews findById(int id);
	public void updateHead(Headnews news);
	public void saveHead(Headnews news);
}
