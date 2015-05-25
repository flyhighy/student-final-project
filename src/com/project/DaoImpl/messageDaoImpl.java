package com.project.DaoImpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.project.Dao.messageDao;
import com.project.bean.Message;

public class messageDaoImpl extends HibernateDaoSupport implements messageDao {

	public messageDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveMessage(Message message) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(message);
	}

	@Override
	public List<Message> findAll() {
		
		// TODO Auto-generated method stub
		String hql = "from Message message";
		List<Message> list =this.getHibernateTemplate().find(hql);
		
		return list;
	}

	@Override
	public Message findById(int id) {
		// TODO Auto-generated method stub
		String hql = "from Message message where message.id=?";
		List<Message> list =this.getHibernateTemplate().find(hql,id);
				
		return list.get(0);
	}
	
	public void delLeavemsg(int id){
		Message message = this.findById(id);
		this.getHibernateTemplate().delete(message);
	}

}
