package com.project.Dao;

import java.util.List;

import com.project.bean.Announcement;

public interface announcementDao {
	public void saveMessage(Announcement announcement);
	public void delMessage(int id);
	public Announcement findMessage(int id);
	public void updateAnnouncement(Announcement announcement);
	public List<Announcement> fildAll();
	public List<Announcement> searchByHql(String hql);
}
