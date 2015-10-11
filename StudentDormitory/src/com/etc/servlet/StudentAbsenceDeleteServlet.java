package com.etc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.server.StudentAbsenceServe;
import com.etc.server.StudentAbsenceServeImpl;

/**
 * Servlet implementation class DeleteStudentAbsenceServlet
 */
@WebServlet("/StudentAbsenceDeleteServlet")
public class StudentAbsenceDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");
		String message = "";
		try{
			int id = Integer.parseInt(idString);
			StudentAbsenceServe absenceServe = new StudentAbsenceServeImpl();
			int rows = absenceServe.deleteStudentAbsenceinfoById(id);//���� ͨ��idɾ����Ӧ�û���Ϣ�ķ��� ����ֵ��0��1
			if(rows == 1 ){
				message = "删除成功";
			}else{
				message = "删除失败";
			}
		}catch(Exception e){
			message = "出现异常";
			request.getRequestDispatcher("./left.jsp").forward(request,response);
		}
		request.setAttribute("message",message);
		request.getRequestDispatcher("./StudentAbsenceShowServlet").forward(request,response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
