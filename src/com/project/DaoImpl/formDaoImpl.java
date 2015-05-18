package com.project.DaoImpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.project.Dao.formDao;
import com.project.bean.Form;

public class formDaoImpl extends HibernateDaoSupport implements formDao {

	public formDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveForm(Form form) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(form);
	}
	
	public List<Form> getAll(){
		String hql = "from Form form";
		List<Form> list = this.getHibernateTemplate().find(hql);
		return list;
	}
	
	public Form findById(int id){
		String hql = "from Form form where form.id=?";
		List<Form> list = (List<Form>) this.getHibernateTemplate().find(hql, id);
		return list.get(0);
	}
	
	public void delForm(int id){
		Form form = this.findById(id);
		this.getHibernateTemplate().delete(form);
	}
	
	
	

}
