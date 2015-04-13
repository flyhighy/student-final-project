package com.project.admin;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.project.Dao.teamDao;
import com.project.bean.Team;

public class team extends ActionSupport {
	
	private teamDao teamDao;
	private Team team;
	List<Integer> checkOption;
	


	public List<Integer> getCheckOption() {
		return checkOption;
	}


	public void setCheckOption(List<Integer> checkOption) {
		this.checkOption = checkOption;
	}


	
	public teamDao getTeamDao() {
		return teamDao;
	}


	public void setTeamDao(teamDao teamDao) {
		this.teamDao = teamDao;
	}


	public Team getTeam() {
		return team;
	}


	public void setTeam(Team team) {
		this.team = team;
	}


	//浏览指导团队
	@SuppressWarnings("unchecked")
	public String adminTeam() throws Exception{
		Map session=ActionContext.getContext().getSession();
		session.put("nowNav", "4");
		
		List<Team> list = this.teamDao.findAll();
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list", list);
		return SUCCESS;
	}
	
	
	//增加指导团队
	public String addTeam() throws Exception{
		return SUCCESS;
	}
	
	//保存指导团队
	public String saveTeam() throws Exception{
		if(team.getTime() == null){
			team.setTime(new Date());
		}
		this.teamDao.saveTeam(team);
		return SUCCESS;
	}
	
	//删除指导团队
	public String delTeam() throws Exception{
		this.teamDao.delTeam(team.getId());
		return SUCCESS;
	}
	
	//批量删除指导团队
	public String delManyTeam() throws Exception{
		for(int i = 0;i < checkOption.size();i++ ){
			this.teamDao.delTeam(checkOption.get(i));
		}
		return SUCCESS;
	}
	//编辑指导团队
	@SuppressWarnings("unchecked")
	public String editTeam() throws Exception{
		Team team1 = this.teamDao.findTeam(team.getId());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("team", team1);
		return SUCCESS;
	}
	//更新指导团队
	public String updateTeam() throws Exception{
		this.teamDao.update(team);
		return SUCCESS;
	}
}
