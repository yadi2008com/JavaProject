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
 * Servlet implementation class AddStudentAbsenceServlet
 */
@WebServlet("/StudentAbsenceAddServlet")
public class StudentAbsenceAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAbsenceAddServlet() {
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
		String urlpath = "";
		String message = "";
		try {
			request.setCharacterEncoding("utf-8");
			String stu_idS = request.getParameter("stu_id");
			String note = request.getParameter("note");
			String timeS = request.getParameter("date");
			if(stu_idS == null || stu_idS.trim().equals("")){
				message = "学号不能为空";
				urlpath = "./studentAbsenceAdd.jsp";
			}else if(note == null || note.trim().equals("")){
				message = "缺寝理由不能为空";
				urlpath = "./studentAbsenceAdd.jsp";
			}else if(timeS == null || timeS.trim().equals("")){
				message = "缺寝时间不能为空";
				urlpath = "./studentAbsenceAdd.jsp";
			}else{	
			StudentAbsenceServe absenceServe = new StudentAbsenceServeImpl();
			int stu_id = Integer.parseInt(stu_idS);
			Timestamp time = Timestamp.valueOf(timeS);
			AbsenceBean absence = new AbsenceBean();
			absence.setStu_id(stu_id);
			absence.setNote(note);
			absence.setTime(time);
			int result = absenceServe.addAbsenceInfo(absence);
			if(result == 1){
				urlpath = "./StudentAbsenceShowServlet";
			}else{
				message = "添加失败";
			}
			}
		} catch (Exception e) {
			urlpath = "./StudentAbsenceShowServlet";
		}
		request.setAttribute("message",message);
		request.getRequestDispatcher(urlpath).forward(request, response);
	}

}
