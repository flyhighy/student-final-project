package com.project.admin;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.project.Dao.competitionDao;
import com.project.bean.Competition;

public class competition extends ActionSupport {
	
	private competitionDao competitionDao;
	private Competition competition;
	List<Integer> checkOption;
	


	public List<Integer> getCheckOption() {
		return checkOption;
	}


	public void setCheckOption(List<Integer> checkOption) {
		this.checkOption = checkOption;
	}


	public competitionDao getCompetitionDao() {
		return competitionDao;
	}


	public void setCompetitionDao(competitionDao competitionDao) {
		this.competitionDao = competitionDao;
	}


	public Competition getCompetition() {
		return competition;
	}


	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	//浏览参赛经历
	@SuppressWarnings("unchecked")
	public String adminCompetition() throws Exception{
		Map session=ActionContext.getContext().getSession();
		session.put("nowNav", "5");
		List<Competition> list = this.competitionDao.findAll();
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list", list);
		return SUCCESS;
	}
	
	
	//增加参赛经历
	public String createCompetition() throws Exception{
		return SUCCESS;
	}
	
	//保存参赛经历
	public String saveCompetition() throws Exception{
		System.out.println();
		this.competitionDao.saveCompetition(competition);
		return SUCCESS;
	}
	
	//删除参赛经历
	public String delCompetition() throws Exception{
		this.competitionDao.delCompetition(competition.getId());
		return SUCCESS;
	}
	
	//批量删除参赛经历
	public String delManyCompetition() throws Exception{
		for(int i = 0;i < checkOption.size();i++ ){
			this.competitionDao.delCompetition(checkOption.get(i));
		}
		return SUCCESS;
	}
	//编辑参赛经历
	@SuppressWarnings("unchecked")
	public String editCompetition() throws Exception{
		Competition competition1 = this.competitionDao.findById(competition.getId());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("competition", competition1);
		return SUCCESS;
	}
	//更新参赛经历
	public String updateCompetition() throws Exception{
		this.competitionDao.updateCompetition(competition);
		return SUCCESS;
	}
}
