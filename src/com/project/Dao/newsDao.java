package com.project.Dao;

import java.util.List;

import com.project.bean.News;

public interface newsDao {
	public void createNews(News news);
	public List<News> findAll();
}
