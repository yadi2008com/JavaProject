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

@WebServlet("/TeacherinfoAddServlet")
public class TeacherinfoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		String repassword = request.getParameter("repassword");
		String name = request.getParameter("name");
		String telephone = request.getParameter("telephone");
		String url = "";
		String message = "";
		if (name == null || name.trim().equals("")) {
			message = "姓名不能为空！";
			url = "teacherinfo_add.jsp";
		} else if (username == null || username.trim().equals("")) {
			message = "帐号不能为空！";
			url = "teacherinfo_add.jsp";
		} else if (userpwd == null || userpwd.trim().equals("")) {
			request.setAttribute("temp_name", username);
			message = "密码不能为空！";
			url = "teacherinfo_add.jsp";
		} else if (repassword == null || repassword.trim().equals("")) {
			request.setAttribute("temp_name", username);
			message = "重复密码不能为空！";
			url = "teacherinfo_add.jsp";
		} else if (telephone == null || telephone.trim().equals("")) {
			request.setAttribute("temp_name", username);
			message = "电话不能为空！";
		} else {
			if (!(userpwd.equals(repassword))) {
				request.setAttribute("temp_name", name);
				message = "两次输入密码不相同！";
				url = "teacherinfo_add.jsp";
			} else {
				TeacherInfoBean teacherInfoBean = new TeacherInfoBean();
				teacherInfoBean.setName(name);
				teacherInfoBean.setTelephone(telephone);
				teacherInfoBean.setUsername(username);
				teacherInfoBean.setUserpwd(userpwd);
				TeacherServer teacherServer = new TeacherServerImpl();
				int result = teacherServer.IsTeacherUsernameRepeat(username);
				if (result == 0)// 未重名
				{
					int rows = teacherServer.TeacherinfoAdd(teacherInfoBean);
					if (rows == 1) {
						message = "添加成功！";
						url = "./TeacherinfoListServlet";
					} else {
						message = "添加失败！";
						request.setAttribute("temp_name", name);
						url = "teacherinfo_add.jsp";
					}
				} else {
					request.setAttribute("temp_name", name);
					message = "此帐号已经存在，请重新输入！";
					url = "teacherinfo_add.jsp";
				}
			}
		}

		request.setAttribute("message", message);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
