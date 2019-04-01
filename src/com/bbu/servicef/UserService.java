package com.bbu.servicef;

import java.util.ArrayList;
import com.bbu.model.User;

public interface UserService {
	//增加用户
	public boolean addUser(User user);
	//删除用户
	public boolean deleteUser(User user);
	//修改用户
	public boolean modifyUser(User user);
	//按照id查询用户
	public User findUserById(Integer id);
	//按照name查询用户
	public User findUserByName(String name);
	//返回全体用户
	public ArrayList<User> getAllUsers();
	//返回分页后用户
	public ArrayList<User> getAllUsersByPage(int currentPage, int
	pageSize);
	//查询计算数据库总记录数
	public Integer getUserCount();
	//验证用户登录
	public boolean checkUserLogin(User user);
	}