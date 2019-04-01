package com.bbu.test;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.catalina.User;

import com.bbu.dao.impl.UserDaoImpl;
import com.bbu.daof.UserDao;
import com.bbu.model.*;
import com.bbu.util.SQLHelper;
import com.bbu.service.impl.*;
public class Test {
	@org.junit.Test
	public void test() {
		UserDao userdao = new UserDaoImpl();
		ArrayList<User> arraylist = (ArrayList)userdao.getAllUsers();
		for(int i = 0; i < arraylist.size();i++) {
			com.bbu.model.User user = (com.bbu.model.User) arraylist.get(i);
			System.out.println(user);
		}
	}
	@org.junit.Test
	public void test2() {
		com.bbu.model.User user = (com.bbu.model.User) new com.bbu.model.User();
		user.setUsername("admin");
		user.setPassword("123456");
		boolean flag = new UserDaoImpl().checkUserLogin(user);
		System.out.println(flag);
	}
	@org.junit.Test
	public void getCount() {
		System.out.println(new UserServiceImpl().getUserCount());
	}
}
