package com.bbu.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.bbu.dao.impl.UserDaoImpl;
import com.bbu.daof.UserDao;
import com.bbu.model.User;

public class UserDaoImplTest {

	@Test
	public ArrayList<User> testGetAllUsers() {
			ArrayList<User> arraylist = new ArrayList<User>();
			UserDaoImpl dao = new UserDaoImpl();
			arraylist = dao.getAllUsers();
			return arraylist;
	}

}
