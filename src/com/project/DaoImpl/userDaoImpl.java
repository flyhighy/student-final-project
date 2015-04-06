package com.project.DaoImpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.project.Dao.userDao;
import com.project.bean.User;

public class userDaoImpl extends HibernateDaoSupport implements userDao {

	public userDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public List<User> findAll(){
		String hql = "from User user";
		List<User> list = this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list;
		}else{
			return null;
		}
	}
	
	public void saveUser(User user){
		this.getHibernateTemplate().save(user);
	}
	
	public User findUserById(int id){
		String hql = "from User user where user.id=?";
		List<User> list = this.getHibernateTemplate().find(hql,id);
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	public void delUserById(int id){
		User user = this.findUserById(id);
		if(user != null){
			this.getHibernateTemplate().delete(user);
		}
	}
	
	public void updateUser(User user){
		this.getHibernateTemplate().update(user);
	}

}
