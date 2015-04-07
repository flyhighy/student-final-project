package com.project.DaoImpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.project.Dao.downloadDao;
import com.project.bean.Download;

public class downloadDaoImpl extends HibernateDaoSupport implements downloadDao {

	public downloadDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Download> findAll() {
		// TODO Auto-generated method stub
		String hql = "from Download download";
		List<Download> list = this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list;
		}
		return null;
	}

	@Override
	public Download findById(int id) {
		// TODO Auto-generated method stub
		String hql = "from Download download where download.id=?";
		List<Download> list = this.getHibernateTemplate().find(hql,id);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void delDownload(int id) {
		// TODO Auto-generated method stub
		Download download = this.findById(id);
		this.getHibernateTemplate().delete(download);
	}

	@Override
	public void saveDownload(Download download) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(download);
	}

	@Override
	public void updateDownload(Download download) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(download);

	}

}
