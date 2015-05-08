package com.project.DaoImpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.project.Dao.announcementDao;
import com.project.bean.Announcement;

public class announcementDaoImpl extends HibernateDaoSupport implements announcementDao {

	public announcementDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveMessage(Announcement announcement) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(announcement);
	}
	
	@SuppressWarnings("unchecked")
	public List<Announcement> fildAll(){
		String hql = "from Announcement announcement order by announcement.time desc";
		List<Announcement> list = (List<Announcement>)this.getHibernateTemplate().find(hql);
		return list;
	}
	
	
	public Announcement findMessage(int id){
		String hql = "from Announcement announcement where announcement.id=?";
		List<Announcement> list = this.getHibernateTemplate().find(hql,id);
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	public void delMessage(int id){
		Announcement announcement=this.findMessage(id);
		this.getHibernateTemplate().delete(announcement);
	}
	
	public void updateAnnouncement(Announcement announcement){
		this.getHibernateTemplate().update(announcement);
	}
	
	public List<Announcement> searchByHql(String hql){
		List<Announcement> list = this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list;
		}else{
			return null;
		}
	}

}
