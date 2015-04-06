package com.project.Dao;

import java.util.List;

import com.project.bean.Competition;

public interface competitionDao {
	public List<Competition> findAll();
	public Competition findById(int id);
	public void delCompetition(int id);
	public void saveCompetition(Competition competition);
	public void updateCompetition(Competition competition);
}
