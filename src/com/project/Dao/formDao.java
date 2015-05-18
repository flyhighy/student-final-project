package com.project.Dao;

import java.util.List;

import com.project.bean.Form;


public interface formDao {
	public void saveForm(Form form);
	public List<Form> getAll();
	public void delForm(int id);
	public Form findById(int id);
}
