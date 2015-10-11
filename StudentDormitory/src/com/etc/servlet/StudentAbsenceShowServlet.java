package com.etc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.bean.AbsenceBean;
import com.etc.server.StudentAbsenceServe;
import com.etc.server.StudentAbsenceServeImpl;

/**
 * Servlet implementation class ShowStudentAbsenceServlet
 */
@WebServlet("/StudentAbsenceShowServlet")
public class StudentAbsenceShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentAbsenceServe absenceServe = new StudentAbsenceServeImpl();
		List<AbsenceBean> absenceList = absenceServe.fetchStudentAbsenceInfo();
		if(absenceList != null && !absenceList.isEmpty()){
			request.setAttribute("absenceList",absenceList);
			request.getRequestDispatcher("./studentAbsenceShow.jsp").forward(request,response);
		}else{
			request.getRequestDispatcher("./studentAbsenceShow.jsp").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
