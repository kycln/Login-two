package com.bbu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bbu.daof.UserDao;
import com.bbu.model.User;
import com.bbu.util.SQLHelper;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "insert into tuserlogin values(?,?,?,?,?)";
		String[] parameters = {"0",user.getUsername(),user.getPassword(),String.valueOf(user.getGrade()),String.valueOf(user.getEmail())};
		flag = SQLHelper.executeUpdate(sql, parameters);
		return flag;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		String sql = "delete from tuserlogin where id = ?";
		String[] parameters = {user.getId().toString()};
		try {
		SQLHelper.executeUpdate(sql, parameters);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean modifyUser(User user) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "update tuserlogin set username=? , password = ? , grade = ? , email = ? where id = ?";
		String[] parameters = {user.getUsername(),new com.bbu.util.MD5().makeMD5(user.getPassword()) , String.valueOf(user.getGrade()), user.getEmail() , String.valueOf(user.getId())};
		flag = SQLHelper.executeUpdate(sql, parameters);
		return flag;
	}
	@Override
	public User findUserById(Integer id) {
		// TODO Auto-generated method stub
		User user = new User();
		String sql = "select * from tuserlogin where id = ?";
		String[] parameters = {String.valueOf(id)};
		ResultSet rs = null;
		rs = SQLHelper.executeQuery(sql, parameters);
		try {
			if(rs.next()) {
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(new com.bbu.util.MD5().makeMD5(rs.getString(3)));
				user.setGrade(rs.getInt(4));
				user.setEmail(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			SQLHelper.close(rs, SQLHelper.getSt(), SQLHelper.getCt());
		}
		return user;
	}

	@Override
	public User findUserByName(String name) {
		User user = new User();
		String sql = "select * from tuserlogin where username = ?";
		String[] parameters = {name};
		ResultSet rs = null;
		rs = SQLHelper.executeQuery(sql, parameters);
		try {
			if(rs.next()) {
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setGrade(rs.getInt(4));
				user.setEmail(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			SQLHelper.close(rs, SQLHelper.getSt(), SQLHelper.getCt());
		}
		return user;
	}

	@Override
	public ArrayList<User> getAllUsers(){
		// TODO Auto-generated method stub
		ArrayList<User> arraylist = new ArrayList<>();
		String sql = "select * from tuserlogin";
		String[] parameter = {};
		ResultSet rs = null;
		try {
			rs = SQLHelper.executeQuery(sql,parameter);
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(new com.bbu.util.MD5().makeMD5(rs.getString(3)));
				user.setGrade(rs.getInt(4));
				user.setEmail(rs.getString(5));
				arraylist.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			SQLHelper.close(rs, SQLHelper.getSt(), SQLHelper.getCt());
		}
		return arraylist;
	}

	@Override
	public ArrayList<User> getAllUsersByPage(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tuserlogin limit ?,?";
		ArrayList<User> arraylist = new ArrayList<User>();
		Integer[] parameters = {(currentPage-1)*10,pageSize};
		ResultSet rs = SQLHelper.executeQuery1(sql, parameters);
		try {
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(new com.bbu.util.MD5().makeMD5(rs.getString(3)));
				user.setGrade(rs.getInt(4));
				user.setEmail(rs.getString(5));
				arraylist.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			SQLHelper.close(rs, SQLHelper.getSt(), SQLHelper.getCt());
		}
		return arraylist;
	}

	@Override
	public Integer getUserCount() {
		// TODO Auto-generated method stub
		Integer count = null;
		String sql = "select count(*) Count from tuserlogin";
		String[] parameters = {};
		ResultSet rs = null;
		rs = SQLHelper.executeQuery(sql, parameters);
		try {
			if(rs.next()) {
				count = rs.getInt("Count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			SQLHelper.close(rs, SQLHelper.getSt(), SQLHelper.getCt());
		}
		return count;
	}

	@Override
	public boolean checkUserLogin(User user) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "select * from tuserlogin where username = ? and password = ?";
		String []parameters =  {user.getUsername() ,new com.bbu.util.MD5().makeMD5(user.getPassword())};
		ResultSet rs =SQLHelper.executeQuery(sql, parameters);
		try {
		if(null != rs) {
			flag = true;
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			SQLHelper.close(rs, SQLHelper.getSt(), SQLHelper.getCt());
		}
		return flag;
	}

}
