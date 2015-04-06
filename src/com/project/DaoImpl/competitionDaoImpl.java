package com.project.DaoImpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.project.Dao.competitionDao;
import com.project.bean.Competition;

public class competitionDaoImpl extends HibernateDaoSupport implements
		competitionDao {

	public competitionDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Competition> findAll() {
		// TODO Auto-generated method stub
		
		String hql = "from Competition competition";
		List<Competition> list = this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Competition findById(int id) {
		// TODO Auto-generated method stub
		String hql = "from Competition competition where competition.id=?";
		List<Competition> list = this.getHibernateTemplate().find(hql,id);
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public void delCompetition(int id) {
		// TODO Auto-generated method stub
		Competition competition = this.findById(id);
		this.getHibernateTemplate().delete(competition);
	}

	@Override
	public void saveCompetition(Competition competition) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(competition);
	}

	@Override
	public void updateCompetition(Competition competition) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(competition);
	}

}
