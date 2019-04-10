package com.bbu.service.impl;

import java.util.ArrayList;

import com.bbu.dao.impl.UserDaoImpl;
import com.bbu.daof.UserDao;
import com.bbu.model.User;
import com.bbu.servicef.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().addUser(user);
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().deleteUser(user);
	}

	@Override
	public boolean modifyUser(User user) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().modifyUser(user);
	}

	@Override
	public User findUserById(Integer id) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().findUserById(id);
	}

	@Override
	public User findUserByName(String name) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().findUserByName(name);
	}

	@Override
	public ArrayList<User> getAllUsers() {
		// TODO Auto-generated method stub
		
		return new UserDaoImpl().getAllUsers();
	}

	@Override
	public ArrayList<User> getAllUsersByPage(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().getAllUsersByPage(currentPage, pageSize);
	}

	@Override
	public Integer getUserCount() {
		// TODO Auto-generated method stub
		return new UserDaoImpl().getUserCount();
	}

	@Override
	public boolean checkUserLogin(User user) {
		// TODO Auto-generated method stub
		boolean flag = false;
		UserDao userDao = new UserDaoImpl();
		if(userDao.checkUserLogin(user)) {
			flag = true;
		}
		return flag;
	}

}
