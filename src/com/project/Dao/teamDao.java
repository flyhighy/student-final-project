package com.project.Dao;

import java.util.List;

import com.project.bean.Team;

public interface teamDao {
	public List<Team> findAll();
	public void saveTeam(Team team);
	public void update(Team team);
	public void delTeam(int id);
	public Team findTeam(int id);
}
