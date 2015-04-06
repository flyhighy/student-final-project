package com.project.admin;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.project.Dao.achievementDao;
import com.project.Dao.competitionDao;
import com.project.bean.Achievement;
import com.project.bean.Competition;

public class achievement extends ActionSupport {
	
	private achievementDao achievementDao;
	private Achievement achievement;
	List<Integer> checkOption;
	


	public List<Integer> getCheckOption() {
		return checkOption;
	}


	public void setCheckOption(List<Integer> checkOption) {
		this.checkOption = checkOption;
	}


	
	public achievementDao getAchievementDao() {
		return achievementDao;
	}


	public void setAchievementDao(achievementDao achievementDao) {
		this.achievementDao = achievementDao;
	}


	public Achievement getAchievement() {
		return achievement;
	}


	public void setAchievement(Achievement achievement) {
		this.achievement = achievement;
	}


	//‰Ø¿¿»Ÿ”˛
	@SuppressWarnings("unchecked")
	public String adminAchievement() throws Exception{
		
		List<Achievement> list = this.achievementDao.findAll();
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list", list);
		return SUCCESS;
	}
	
	
	//‘ˆº”»Ÿ”˛
	public String createAchievement() throws Exception{
		return SUCCESS;
	}
	
	//±£¥Ê»Ÿ”˛
	public String saveAchievement() throws Exception{
		System.out.println();
		this.achievementDao.saveAchievement(achievement);
		return SUCCESS;
	}
	
	//…æ≥˝»Ÿ”˛
	public String delAchievement() throws Exception{
		this.achievementDao.delAchievement(achievement.getId());
		return SUCCESS;
	}
	
	//≈˙¡ø…æ≥˝»Ÿ”˛
	public String delManyAchievement() throws Exception{
		for(int i = 0;i < checkOption.size();i++ ){
			this.achievementDao.delAchievement(checkOption.get(i));
		}
		return SUCCESS;
	}
	//±‡º≠»Ÿ”˛
	@SuppressWarnings("unchecked")
	public String editAchievement() throws Exception{
		Achievement achievement1 = this.achievementDao.findById(achievement.getId());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("achievement", achievement1);
		return SUCCESS;
	}
	//∏¸–¬»Ÿ”˛
	public String updateAchievement() throws Exception{
		this.achievementDao.updateAchievement(achievement);
		return SUCCESS;
	}
}
