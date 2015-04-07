package com.project.DaoImpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.project.Dao.teamDao;
import com.project.bean.Team;

public class teamDaoImpl extends HibernateDaoSupport implements teamDao {

	public teamDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Team> findAll() {
		// TODO Auto-generated method stub
		String hql = "from Team team";
		List<Team> list = this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list;
		}
		return null;
	}

	@Override
	public void saveTeam(Team team) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(team);
	}

	@Override
	public void update(Team team) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(team);
	}

	@Override
	public void delTeam(int id) {
		// TODO Auto-generated method stub
		Team team = this.findTeam(id);
		this.getHibernateTemplate().delete(team);
	}

	@Override
	public Team findTeam(int id) {
		// TODO Auto-generated method stub
		String hql = "from Team team where team.id=?";
		List<Team> list = this.getHibernateTemplate().find(hql,id);
		if(list.size()>0)
			return list.get(0);
		return null;
	}

}
