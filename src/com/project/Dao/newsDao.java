package com.project.Dao;

import java.util.List;

import com.project.bean.News;

public interface newsDao {
	public void createNews(News news);
	public List<News> findAll();
	public void delNews(int id);
	public void updateNews(News news);
	public News findNews(int id);
}
