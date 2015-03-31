package com.project.DaoImpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.project.Dao.adminDao;
import com.project.bean.User;

public class adminDaoImpl extends HibernateDaoSupport implements adminDao {

	@Override
	public User findUser(String username) {
		// TODO Auto-generated method stub
		String hql="from User user where user.username=?";

		List list=this.getHibernateTemplate().find(hql,username);
		System.out.print(list.size());
		if(list.size()==0){
			return null;
		}else{
			return (User)list.get(0);
		}
	}

}
