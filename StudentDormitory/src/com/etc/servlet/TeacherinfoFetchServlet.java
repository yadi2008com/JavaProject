package com.etc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.bean.TeacherInfoBean;
import com.etc.server.TeacherServer;
import com.etc.server.TeacherServerImpl;

@WebServlet("/TeacherinfoFetchServlet")
public class TeacherinfoFetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String sort = request.getParameter("sort");
		String idString = request.getParameter("id");
		String message = "";
		String url = "./TeacherinfoListServlet";
		TeacherInfoBean teacherInfoBean = null;
		try {
			int id = Integer.parseInt(idString);
			TeacherServer teacherServer = new TeacherServerImpl();
			teacherInfoBean = new TeacherInfoBean();
			teacherInfoBean = teacherServer.TeacherinfoFetchById(id);
			if (teacherInfoBean != null) {
				if (sort!=null && sort.equals("view")) {
					url = "teacherinfo_view.jsp";
				} else if (sort!=null && sort.equals("update")) {
					url = "teacherinfo_update.jsp";
				} else {
					message = "操作不明确！";	
				}
			} else {
				message = "暂无此管理员信息";
			}

		} catch (Exception e) {
			message = "管理员id不合法！";
			url="teacherinfo_list.jsp";
		}
		request.setAttribute("teacherInfoBean", teacherInfoBean);
		request.setAttribute("message", message);
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
