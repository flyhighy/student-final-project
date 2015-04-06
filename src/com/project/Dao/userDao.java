package com.project.Dao;

import java.util.List;

import com.project.bean.User;

public interface userDao {
	public List<User> findAll();
	public void saveUser(User user);
	public User findUserById(int id);
	public void delUserById(int id);
	public void updateUser(User user);
}
