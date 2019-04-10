package com.bbu.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.bbu.model.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class SQLHelper {
	private static Connection conn = null;
	private static PreparedStatement pstate = null;
	private static ResultSet rs = null;
	private static String driver = "";
	private static String url = "";
	private static String password = "";
	private static String user = "";
	private static Properties pro = null;
	private static InputStream fio= null;
	static {
		try {
			pro = new Properties();
			fio = SQLHelper.class.getClassLoader().getResourceAsStream("dbinfo.properties");
			pro.load(fio);
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			user = pro.getProperty("user");
			password = pro.getProperty("password");
			Class.forName(driver);
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(null != fio) {
				try {
					fio.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	public static Connection getConnection() {
		try {
			conn = (Connection) DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static Connection getCt() {
		return conn;
	}
	public static ResultSet getRs() {
		return rs;
	}
	public static PreparedStatement getSt() {
		return pstate;
	}
	public static boolean executeUpdate(String sql , String[] parameters) {
		try {
			conn = getConnection();
			pstate = (PreparedStatement) conn.prepareStatement(sql);
			if(null != parameters) {
				for (int i = 0;i < parameters.length;i++) {
					pstate.setString(i+1, parameters[i]);
				}
					pstate.execute();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs,pstate,conn);
		}
		//关于这一点必须要向老师询问情况，到底是因为什么东西才造成这样的一个结果；
		return true;
	}
	public static ResultSet executeQuery(String sql , String[] parameters) {
		try {
			conn = getConnection();
			pstate = (PreparedStatement) conn.prepareStatement(sql);
			if(null != parameters) {
				for (int i = 0;i < parameters.length;i++) {
					pstate.setString(i+1, parameters[i]);
				}
				rs = pstate.executeQuery();	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public static ResultSet executeQuery1(String sql , Integer[] parameters) {
		try {
			conn = getConnection();
			pstate = (PreparedStatement) conn.prepareStatement(sql);
			if(null != parameters) {
				for (int i = 0;i < parameters.length;i++) {
					pstate.setInt(i+1, parameters[i]);
				}
				rs = pstate.executeQuery();	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public static void close(ResultSet rs , PreparedStatement state , Connection conn) {
		if(null != rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(null != state) {
			try {
				state.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(null != conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
