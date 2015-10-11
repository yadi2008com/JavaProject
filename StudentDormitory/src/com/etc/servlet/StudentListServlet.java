package com.etc.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.etc.bean.StudentBean;
import com.etc.server.StudentServer;
import com.etc.server.StudentServerImpl;


@WebServlet("/StudentListServlet")
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		StudentServer studentServer=new StudentServerImpl();
		List<StudentBean> studentBeanList=studentServer.fetchAllUserinfoList();
		if(studentBeanList!=null&&!studentBeanList.isEmpty()){
			
			request.setAttribute("studentBeanList", studentBeanList);
			request.getRequestDispatcher("studentManager.jsp").forward(request,response);
			
			
		}else{
			
			request.getRequestDispatcher("studentAdd.jsp").forward(request,response);
		}
			
		
	
	}
}