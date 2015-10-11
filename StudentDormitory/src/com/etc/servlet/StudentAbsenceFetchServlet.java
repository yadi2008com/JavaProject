package com.etc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.bean.AbsenceBean;
import com.etc.server.StudentAbsenceServe;
import com.etc.server.StudentAbsenceServeImpl;

/**
 * Servlet implementation class FetchStudentAbsenceServlet
 */
@WebServlet("/StudentAbsenceFetchServlet")
public class StudentAbsenceFetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String ids = request.getParameter("id");
		String urlpath = "./studentAbsenceShow.jsp";
		String message = "";
		try {
			int id = Integer.parseInt(ids);
			StudentAbsenceServe absenceServe = new StudentAbsenceServeImpl();
			AbsenceBean absence = absenceServe.fetchStudentAbsenceInfoById(id);
			if(absence != null){
				String sort = request.getParameter("sort");
				if(sort!=null&&sort.equals("fetch")){
					request.setAttribute("absence",absence);
					urlpath = "./StudentAbsenceInfoFetchServlet";
				}else if(sort != null&&sort.equals("update")){
					request.getSession().setAttribute("absence",absence);
					urlpath = "studentAbsenceUpdate.jsp";
				}else {
					message = "sort无信息！";
				}
			}else {
				message = "无数据信息";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("message", message);//����Ϣ
		request.getRequestDispatcher(urlpath).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
