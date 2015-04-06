package com.project.Dao;

import java.util.List;

import com.project.bean.Achievement;
import com.project.bean.Competition;

public interface achievementDao {
	public List<Achievement> findAll();
	public Achievement findById(int id);
	public void delAchievement(int id);
	public void saveAchievement(Achievement achievement);
	public void updateAchievement(Achievement achievement);
}
