package com.etc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etc.bean.AbsenceBean;
import com.etc.bean.StudentBean;
import com.etc.server.StudentAbsenceServe;
import com.etc.server.StudentAbsenceServeImpl;
import com.etc.server.StudentServer;
import com.etc.server.StudentServerImpl;

@WebServlet("/MyAbsenceServlet")
public class MyAbsenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session =request.getSession();
		String username=(String)session.getAttribute("current_name");
		//验证是否正常登录
		if(username==null){
			out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
			out.flush();out.close();

		}else{
			StudentAbsenceServe absenceServe=new StudentAbsenceServeImpl();
			StudentServer studentServer=new StudentServerImpl();
			List<AbsenceBean> absenceBeanList=absenceServe.fetchAbsenceStudentInfoByUsername(username);
			StudentBean studentBean=studentServer.fetchStudentInfoByUsername(username);
			if(absenceBeanList!=null&&studentBean!=null){
				request.setAttribute("studentBean", studentBean);
				request.setAttribute("absenceBeanList", absenceBeanList);
				request.getRequestDispatcher("myAbsence.jsp").forward(request,response);
				
				
			}else{
				
				request.getRequestDispatcher("login.jsp").forward(request,response);
			}
			
		}
	}

}
