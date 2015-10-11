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


@WebServlet("/StudentUpdateServlet")
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");// 设置字符集
		String username = request.getParameter("username");// 获取用户名
		String userpwd = request.getParameter("userpwd");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String classes = request.getParameter("classes");
		String idString = request.getParameter("id");
		int id=Integer.parseInt(idString);
		System.out.println(id);
		StudentBean StudentBean = new StudentBean();
		StudentBean.setId(id);
		StudentBean.setUsername(username);
		StudentBean.setUserpwd(userpwd);
		StudentBean.setName(name);
		StudentBean.setSex(sex);
		StudentBean.setClasses(classes);
		
		StudentServer studentServer = new StudentServerImpl();

		int result = studentServer.updateStudent(StudentBean);
		if(result==1){
			request.removeAttribute("StudentBean");
			request.getRequestDispatcher("./StudentListServlet").forward(request, response);
		}else{
			request.getRequestDispatcher("studentUpdate.jsp").forward(request, response);
		}
	}

}
