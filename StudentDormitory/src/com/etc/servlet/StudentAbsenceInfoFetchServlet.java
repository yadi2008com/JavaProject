package com.etc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.bean.AbsenceBean;
import com.etc.bean.StudentBean;
import com.etc.server.StudentAbsenceServe;
import com.etc.server.StudentAbsenceServeImpl;

/**
 * Servlet implementation class FetchAbsenceStudentInoServlet
 */
@WebServlet("/StudentAbsenceInfoFetchServlet")
public class StudentAbsenceInfoFetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentAbsenceServe absenceServe = new StudentAbsenceServeImpl();
		AbsenceBean absence = (AbsenceBean)request.getAttribute("absence");
		int stu_id = absence.getStu_id();
		List<StudentBean> studentList = absenceServe.fetchAbsenceStudentInfoByStu_id(stu_id);
		if(studentList != null && !studentList.isEmpty()){
			request.setAttribute("studentList",studentList);
			request.getRequestDispatcher("./studentAbsenceView.jsp").forward(request,response);
		}else{
			request.setAttribute("message","没有该学生数据");
			request.getRequestDispatcher("./StudentAbsenceShowServlet").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
