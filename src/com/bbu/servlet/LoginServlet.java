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
		response.setContentType("text/html;charse=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		UserService service = new UserServiceImpl();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//验证码的使用
		String vcode = request.getParameter("vcode");
		//获取图片上验证码的值
		String cscode = (String) request.getSession().getAttribute("vscode");
		//将得到的信息放在JavaBean里面
		User user = new User();
		user.setUsername(username);
		password = new com.bbu.util.MD5().makeMD5(password);
		user.setPassword(password);
		//开始进行验证，看是否可以进行页面切换
		if(service.checkUserLogin(user)&&vcode.equalsIgnoreCase(cscode)) {
			ArrayList<User> arraylist = new ArrayList();
			arraylist = service.getAllUsersByPage(1, 10);
			request.setAttribute("arraylist", arraylist);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
