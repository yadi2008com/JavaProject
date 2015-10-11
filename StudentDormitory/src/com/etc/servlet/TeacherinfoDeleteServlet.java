package com.etc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.server.TeacherServer;
import com.etc.server.TeacherServerImpl;

@WebServlet("/TeacherinfoDeleteServlet")
public class TeacherinfoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		String url = "./TeacherinfoListServlet";
		try {
			String idString = request.getParameter("id");
			int id = Integer.parseInt(idString);
			TeacherServer teacherServer = new TeacherServerImpl();
			int result = teacherServer.TeacherinfoDeleteById(id);
			if (result == 1) {
				message = "删除成功！";
			} else {
				message = "删除失败！";
			}
		} catch (Exception e) {
			message = "管理员id不合法！ ";
		}

		request.setAttribute("message", message);
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
