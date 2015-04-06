package com.project.DaoImpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.project.Dao.achievementDao;
import com.project.bean.Achievement;
import com.project.bean.Competition;

public class achievementDaoImpl extends HibernateDaoSupport implements
	achievementDao {

	public achievementDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Achievement> findAll() {
		// TODO Auto-generated method stub
		
		String hql = "from Achievement achievement";
		List<Achievement> list = this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Achievement findById(int id) {
		// TODO Auto-generated method stub
		String hql = "from Achievement achievement where achievement.id=?";
		List<Achievement> list = this.getHibernateTemplate().find(hql,id);
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public void delAchievement(int id) {
		// TODO Auto-generated method stub
		Achievement achievement = this.findById(id);
		this.getHibernateTemplate().delete(achievement);
	}

	@Override
	public void saveAchievement(Achievement achievement) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(achievement);
	}

	@Override
	public void updateAchievement(Achievement achievement) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(achievement);
	}

}
