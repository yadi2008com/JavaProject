package com.etc.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.bean.AbsenceBean;
import com.etc.server.StudentAbsenceServe;
import com.etc.server.StudentAbsenceServeImpl;

/**
 * Servlet implementation class UpdateStudentAbsenceServlet
 */
@WebServlet("/StudentAbsenceUpdateServlet")
public class StudentAbsenceUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			String idS = request.getParameter("id");
			int id = Integer.parseInt(idS);
			String idstring = request.getParameter("stu_id");
			int stu_id = Integer.parseInt(idstring);
			String note = request.getParameter("note");
			String timeS = request.getParameter("date");
			Timestamp time = Timestamp.valueOf(timeS); 
			StudentAbsenceServe absenceServe = new StudentAbsenceServeImpl();
			AbsenceBean absence = new AbsenceBean();
			absence.setId(id);
			absence.setStu_id(stu_id);
			absence.setNote(note);
			absence.setTime(time);
			int i = absenceServe.updateStudentAbsenceInfo(absence);
			if(i == 1){
				request.setAttribute("message","更新成成功！！");
				request.setAttribute("absence",absence);
				request.getRequestDispatcher("./StudentAbsenceShowServlet").forward(request, response);
			}else{
				System.out.println("失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
