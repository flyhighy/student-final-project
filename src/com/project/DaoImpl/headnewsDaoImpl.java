package com.project.DaoImpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.project.Dao.headnewsDao;
import com.project.bean.Headnews;

public class headnewsDaoImpl extends HibernateDaoSupport implements headnewsDao {

	public headnewsDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Headnews> findAll() {
		// TODO Auto-generated method stub
		
		String hql = "from Headnews headnews";
		List<Headnews>  list = this.getHibernateTemplate().find(hql);
		
		if(list.size()>5){
			return list.subList(0, 5);
		}
		return list;
	}

	@Override
	public void delHead(int id) {
		// TODO Auto-generated method stub
		
		Headnews news = this.findById(id);
		this.getHibernateTemplate().delete(news);

	}

	@Override
	public Headnews findById(int id) {
		// TODO Auto-generated method stub
		
		String hql = "from Headnews headnews where headnews.id=?";
		List<Headnews>  list = this.getHibernateTemplate().find(hql,id);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void updateHead(Headnews news) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(news);
	}

	@Override
	public void saveHead(Headnews news) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(news);
	}

}
