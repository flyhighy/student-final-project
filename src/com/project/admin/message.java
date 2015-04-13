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

	//չʾ����
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
	
	//��������
	public String createMessage() throws Exception{
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		if(user != null){
			return SUCCESS;
		}
		return "login";
	}
	
	//���湫��
	public String saveMessage() throws Exception{
		announcement.setTime(new Date());
		this.announcementDao.saveMessage(announcement);
		return SUCCESS;
	}
	
	//ɾ������
	public String delMessage() throws Exception{
		this.announcementDao.delMessage(announcement.getId());
		return SUCCESS;
	}
	
	//�༭����
	@SuppressWarnings("unchecked")
	public String editMessage() throws Exception{
		Announcement announcement1=this.announcementDao.findMessage(announcement.getId());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("announcement", announcement1);
		return SUCCESS;
	}
	
	//���¹���
	public String updateMessage() throws Exception{
		this.announcementDao.updateAnnouncement(announcement);
		return SUCCESS;
	}
	

	//�鿴����
	@SuppressWarnings("unchecked")
	public String messageDetail() throws Exception{
		Announcement announcement1=this.announcementDao.findMessage(announcement.getId());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("announcement", announcement1);
		return SUCCESS;
	}

	//����ɾ������
	public String delManyMsg() throws Exception{
		
		for(int i = 0;i < checkOption.size();i++ ){
			this.announcementDao.delMessage(checkOption.get(i));
		}
		return SUCCESS;
	}
	
	//��������
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
			this.addFieldError("error", "��Ǹ��û���ҵ���������������ݡ�");
		}

		return SUCCESS;
	}
}
