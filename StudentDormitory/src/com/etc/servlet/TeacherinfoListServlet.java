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


@WebServlet("/TeacherinfoListServlet")
public class TeacherinfoListServlet<T> extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String message = (String) request.getAttribute("message");// 获取上一层页面传过来的提示信息
		String url = null;
		TeacherServer teacherServer=new TeacherServerImpl();
		List<TeacherInfoBean> teacherInfoBeanList=teacherServer.fetchAllTeacherinfo();
		if (teacherInfoBeanList != null && !teacherInfoBeanList.isEmpty()) {
			request.setAttribute("teacherInfoBeanList", teacherInfoBeanList);
			request.setAttribute("message", message);
			url = "teacherinfo_list.jsp";
		} else {
			request.setAttribute("message", "无用户信息，请添加！");
			url = "teacherinfo_add.jsp";
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
