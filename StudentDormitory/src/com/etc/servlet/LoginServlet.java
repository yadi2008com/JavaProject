package com.etc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.bean.AdminBean;
import com.etc.bean.StudentBean;
import com.etc.bean.TeacherInfoBean;
import com.etc.server.LoginServer;
import com.etc.server.LoginServerImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");// 确定交互的编码方式为UTF-8
		String username = request.getParameter("username");// 获取传入的用户名
		String userpwd = request.getParameter("userpwd");
		String type = request.getParameter("type");
		LoginServer loginServer = new LoginServerImpl();

		if (type.equals("系统管理员")) {
			AdminBean adminBean = new AdminBean();
			adminBean.setUsername(username);
			adminBean.setUserpwd(userpwd);

			int result = loginServer.adminLogin(adminBean);// 调用登录方法
			if (result == 1) {// 登录成功
				request.getSession().setAttribute("type", "1");//用户类型
				request.getSession().setAttribute("current_name", username);// 封装session信息
				request.getRequestDispatcher("index.jsp").forward(request,
						response);// 指定跳转页面
				
			} else {// 登录失败
				request.setAttribute("message", "用户名或密码错误！！！");// 封装失败信息
				request.getRequestDispatcher("login.jsp").forward(request,
						response);// 指定跳转信息
			}
		} else if (type.equals("宿舍管理员")) {
			TeacherInfoBean teacherInfoBean = new TeacherInfoBean();
			teacherInfoBean.setUsername(username);
			teacherInfoBean.setUserpwd(userpwd);
			
			int result = loginServer.teacherLogin(teacherInfoBean);// 调用登录方法
			if (result == 1) {// 登录成功
				request.getSession().setAttribute("type", "2");//用户类型
				request.getSession().setAttribute("current_name", username);// 封装session信息
				request.getRequestDispatcher("index.jsp").forward(request,
						response);// 指定跳转页面
			
			} else {// 登录失败
				request.setAttribute("message", "用户名或密码错误！！！");// 封装失败信息
				request.getRequestDispatcher("login.jsp").forward(request,
						response);// 指定跳转信息
				
			}
		} else if (type.equals("学生")) {
			StudentBean studentBeen = new StudentBean();
			studentBeen.setUsername(username);
			studentBeen.setUserpwd(userpwd);
			
			int result = loginServer.studentLogin(studentBeen);// 调用登录方法
			if (result == 1) {// 登录成功
				request.getSession().setAttribute("type", "3");//用户类型
				request.getSession().setAttribute("current_name", username);// 封装session信息
				request.getRequestDispatcher("index.jsp").forward(request,
						response);// 指定跳转页面
				
			} else {// 登录失败
				request.setAttribute("message", "用户名或密码错误！！！");// 封装失败信息
				request.getRequestDispatcher("login.jsp").forward(request,
						response);// 指定跳转信息
			}

		} else {
			request.setAttribute("message", "非法输入，请重新选择登录类型！！！");
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
