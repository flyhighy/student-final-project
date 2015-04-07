package com.project.Dao;

import java.util.List;

import com.project.bean.Download;

public interface downloadDao {
	public List<Download> findAll();
	public Download findById(int id);
	public void delDownload(int id);
	public void saveDownload(Download download);
	public void updateDownload(Download download);
}
