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

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		if("delete".equals(type)) {
			String id = request.getParameter("id");
			User user = new User();
			user.setId(Integer.parseInt(id));
			UserService service = new UserServiceImpl();
			if(service.deleteUser(user)) {
				ArrayList<User> arraylist = new UserServiceImpl().getAllUsers();
				request.setAttribute("arraylist", arraylist);
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}else if("add".equals(type)) {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding( "utf-8" );
			User user = new User();
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			user.setGrade(Integer.valueOf(request.getParameter("grade")));
			user.setEmail(request.getParameter("email"));
			if(new UserServiceImpl().addUser(user)) {
				ArrayList<User> arraylist = new UserServiceImpl().getAllUsers();
				request.setAttribute("arraylist", arraylist);
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}else if("modify".equals(type)) {
			String id = request.getParameter("id");
			User user = new User();
			user = new UserServiceImpl().findUserById(Integer.parseInt(id));
			ArrayList<User> modify = new ArrayList();
			modify.add(user);
			request.setAttribute("modify", modify);
			request.getRequestDispatcher("modify.jsp").forward(request, response);
		}else if("modifyjsp".equals(type)) {
			String id = request.getParameter("id");
			User user = new User();
			user.setId(Integer.parseInt(id));
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			user.setGrade(Integer.parseInt(request.getParameter("grade")));
			user.setEmail(request.getParameter("email"));
			boolean flag = false;
			flag = new UserServiceImpl().modifyUser(user);
			if(flag) {
				ArrayList<User> arraylist = new UserServiceImpl().getAllUsers();
				request.setAttribute("arraylist", arraylist);
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}
	}
}
