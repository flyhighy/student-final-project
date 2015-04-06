package com.project.DaoImpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.project.Dao.newsDao;
import com.project.bean.News;

public class newsDaoImpl extends HibernateDaoSupport implements newsDao {

	public newsDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createNews(News news) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(news);
	}
	
	public List<News> findAll(){
		String hql = "from News news";
		@SuppressWarnings("unchecked")
		List<News> list = this.getHibernateTemplate().find(hql);
		if(list.size()<20){
			return list;
		}else{
			return list.subList(0, 20);
		}
				
	}
	
	public News findNews(int id){
		String hql = "from News news where news.id=?";
		return (News) this.getHibernateTemplate().find(hql,id).get(0);
	}
	
	public void delNews(int id){
		News news=this.findNews(id);
		this.getHibernateTemplate().delete(news);
	}
	
	public void updateNews(News news){
		this.getHibernateTemplate().update(news);
	}

}
