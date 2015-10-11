package com.etc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.bean.StudentBean;
import com.etc.server.StudentServer;
import com.etc.server.StudentServerImpl;


@WebServlet("/StudentAddServlet")
public class StudentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");// 设置字符集
		String username = request.getParameter("username");// 获取用户名
		String userpwd = request.getParameter("userpwd");
		String userpwd2 = request.getParameter("userpwd2");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String classes = request.getParameter("classes");
		
			StudentBean StudentBean = new StudentBean();
			
			StudentBean.setUsername(username);
			StudentBean.setUserpwd(userpwd);
			StudentBean.setName(name);
			StudentBean.setSex(sex);
			StudentBean.setClasses(classes);

			StudentServer studentServer = new StudentServerImpl();

			boolean result = studentServer.addStudent(StudentBean);
			if(result){
				request.getRequestDispatcher("./StudentListServlet").forward(request, response);
			}else{
				request.getRequestDispatcher("StudentAdd.jsp").forward(request, response);
			}
	}

}
