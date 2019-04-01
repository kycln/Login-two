package com.bbu.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbu.model.User;
import com.bbu.service.impl.UserServiceImpl;
import com.bbu.servicef.UserService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		UserService service = new UserServiceImpl();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//将得到的信息放在JavaBean里面
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		//开始进行验证，看是否可以进行页面切换
		if(service.checkUserLogin(user)) {
			ArrayList<User> arraylist = new ArrayList();
			arraylist = service.getAllUsers();
			request.setAttribute("arraylist", arraylist);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
