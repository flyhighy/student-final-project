package com.project.DaoImpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.project.Dao.shortdecDao;
import com.project.bean.Shortdec;

public class shortdecDaoImpl extends HibernateDaoSupport implements shortdecDao {

	public shortdecDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public Shortdec getShortdec(){
		String hql="from Shortdec shortdec";
		List list = (List<Shortdec>)this.getHibernateTemplate().find(hql);
		if(list.size() == 0){
			return null;
		}else{
			return (Shortdec) list.get(0);
		}
	}

	@Override
	public void save(Shortdec shortdec) {
		// TODO Auto-generated method stub
		String hql="from Shortdec shortdec";
		List list = (List<Shortdec>)this.getHibernateTemplate().find(hql);
		if(list.size() == 0){
			this.getHibernateTemplate().save(shortdec);
		}else{
			this.getHibernateTemplate().update(shortdec);
		}
	}

}
