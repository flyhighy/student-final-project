package com.project.admin;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.project.Dao.announcementDao;
import com.project.bean.Announcement;
import com.project.bean.User;

public class message extends ActionSupport {
	
	private Announcement announcement;
	private announcementDao announcementDao;
	private List<Integer>  checkOption;
	private String searchOption;
	
	

	public String getSearchOption() {
		return searchOption;
	}

	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}

	public List<Integer> getCheckOption() {
		return checkOption;
	}

	public void setCheckOption(List<Integer> checkOption) {
		this.checkOption = checkOption;
	}

	public Announcement getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}

	public announcementDao getAnnouncementDao() {
		return announcementDao;
	}

	public void setAnnouncementDao(announcementDao announcementDao) {
		this.announcementDao = announcementDao;
	}

	//展示公告
	@SuppressWarnings("unchecked")
	public String adminMessage() throws Exception{
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		session.put("nowNav", "3");
		if(user != null){
			List<Announcement> list=this.announcementDao.fildAll();
			Map request = (Map) ActionContext.getContext().get("request");
			request.put("list", list);
			return SUCCESS;
		}
		return "login";
	}
	
	//发布公告
	public String createMessage() throws Exception{
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		if(user != null){
			return SUCCESS;
		}
		return "login";
	}
	
	//保存公告
	public String saveMessage() throws Exception{
		announcement.setTime(new Date());
		this.announcementDao.saveMessage(announcement);
		return SUCCESS;
	}
	
	//删除公告
	public String delMessage() throws Exception{
		this.announcementDao.delMessage(announcement.getId());
		return SUCCESS;
	}
	
	//编辑公告
	@SuppressWarnings("unchecked")
	public String editMessage() throws Exception{
		Announcement announcement1=this.announcementDao.findMessage(announcement.getId());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("announcement", announcement1);
		return SUCCESS;
	}
	
	//更新公告
	public String updateMessage() throws Exception{
		this.announcementDao.updateAnnouncement(announcement);
		return SUCCESS;
	}
	

	//查看公告
	@SuppressWarnings("unchecked")
	public String messageDetail() throws Exception{
		Announcement announcement1=this.announcementDao.findMessage(announcement.getId());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("announcement", announcement1);
		return SUCCESS;
	}

	//批量删除公告
	public String delManyMsg() throws Exception{
		
		for(int i = 0;i < checkOption.size();i++ ){
			this.announcementDao.delMessage(checkOption.get(i));
		}
		return SUCCESS;
	}
	
	//搜索公告
	public String searchMessage() throws Exception{
		String hql = "from Announcement announcement where announcement.title like"+
				"'%"
				+ searchOption
				+ "%'";
		List<Announcement> list=this.announcementDao.searchByHql(hql);
		if(list != null){
			Map request = (Map) ActionContext.getContext().get("request");
			request.put("list", list);
		}else{
			this.addFieldError("error", "抱歉，没有找到您搜索的相关内容。");
		}

		return SUCCESS;
	}
}
