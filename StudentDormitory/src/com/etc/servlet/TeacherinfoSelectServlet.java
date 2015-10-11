package com.etc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.bean.TeacherInfoBean;
import com.etc.server.TeacherServer;
import com.etc.server.TeacherServerImpl;

@WebServlet("/TeacherinfoSelectServlet")
public class TeacherinfoSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("SearchKey");// 查询字段
		String sort = request.getParameter("SearchRow");// 查询类型
		String message = "";
		String url = "teacherinfo_list.jsp";
		if (name != null) {
			TeacherServer teacherServer = new TeacherServerImpl();
			List<TeacherInfoBean> teacherInfoBeanListSelect = null;
			if (sort.equals("name"))// 按姓名查询
			{
				teacherInfoBeanListSelect = teacherServer
						.TeacherinfoFetchIdByName(name);
				request.setAttribute("teacherInfoBeanListSelect", teacherInfoBeanListSelect);
			} else if (sort.equals("telephone")) { // 按电话查询
				teacherInfoBeanListSelect = teacherServer
						.TeacherinfoFetchIdByTelephone(name);
				request.setAttribute("teacherInfoBeanListSelect", teacherInfoBeanListSelect);
			} else if (sort.equals("username")) { // 按用户名查询
				TeacherInfoBean teacherInfoBeanSelect = teacherServer
						.TeacherinfoFetchIdByUsername(name);
				request.setAttribute("teacherInfoBeanSelect", teacherInfoBeanSelect);
			} else {
				message = "查询类型不能为空！";
			}
		} else {
			message = "查询的字段不能为空！";
		}
		request.setAttribute("meesage", message);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
