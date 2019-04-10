package com.bbu.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbu.model.PageBean;
import com.bbu.model.User;
import com.bbu.service.impl.UserServiceImpl;
import com.bbu.servicef.UserService;

/**
 * Servlet implementation class PageServlet
 */
@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pageSize = 10;
        // 获取当前页
        String curpage = request.getParameter("curpage");
        UserService userService = new UserServiceImpl();
        // 获取总数量
        int count = userService.getUserCount();
        //字符串转成整型
        int currentPage = Integer.parseInt(curpage);
        // 创建page对象
        PageBean page = new PageBean(count, currentPage, pageSize);
        // 获取当前页的数据
        ArrayList<User> user = userService.getAllUsersByPage(currentPage, pageSize);
        //将相关数据存储起来
        request.setAttribute("page", page);
        request.setAttribute("arraylist", user);
        //转发
        request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
