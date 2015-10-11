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

@WebServlet("/TeacherinfoUpdateServlet")
public class TeacherinfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String idString = request.getParameter("id");
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		String repassword = request.getParameter("repassword");
		String name = request.getParameter("name");
		String telephone = request.getParameter("telephone");
		String url = " ";
		String message = " ";
		int id = Integer.parseInt(idString);
		if (username == null || username.trim().equals("")) {
			message = "用户名不能为空！";
			url = "teacherinfo_update.jsp";
		} else if (!(username != null && !(username.trim().equals(" "))
				&& userpwd != null && !(userpwd.trim().equals(" ")) && userpwd
					.equals(repassword))) {
			request.setAttribute("temp_name", username);
			message = "两次输入密码不相同！";
			url = "teacherinfo_update.jsp";
		} else {
			TeacherInfoBean teacherInfoBean = new TeacherInfoBean();
			teacherInfoBean.setId(id);
			teacherInfoBean.setName(name);
			teacherInfoBean.setTelephone(telephone);
			teacherInfoBean.setUsername(username);

			TeacherServer teacherServer = new TeacherServerImpl();
			TeacherInfoBean temp_teacherInfoBean = teacherServer
					.TeacherinfoFetchById(id);
			String temp_userpwd = temp_teacherInfoBean.getUserpwd();
			if (userpwd == null || userpwd.trim().equals("")) { // 密码为空则没有修改密码
				teacherInfoBean.setUserpwd(temp_userpwd);
			} else {
				teacherInfoBean.setUserpwd(userpwd);
			}
			TeacherInfoBean temp_teacherInfoBean_id= teacherServer.TeacherinfoFetchIdByUsername(username);
			int temp_id =temp_teacherInfoBean_id.getId();
			if (temp_id == 0 || temp_id == id) { // 判断是否出现重名
				int rows = teacherServer.TeacherinfoUpdate(teacherInfoBean);
				if (rows == 1) {
					message = "管理员ID为" + id + "信息修改成功！！";
					url = "./TeacherinfoListServlet";
				} else {
					message = "修改失败！";
					url = "teacherinfo_update.jsp";
				}
			} else {
				request.setAttribute("temp_telephone", telephone);
				message = "此帐号已经存在，请重新输入！";
				url = "teacherinfo_update.jsp";
			}
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
