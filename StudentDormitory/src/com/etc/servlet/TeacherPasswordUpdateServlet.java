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

/**
 * Servlet implementation class StudentPasswordUpdateServlet
 */
@WebServlet("/TeacherPasswordUpdateServlet")
public class TeacherPasswordUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String message = "";
		String current_name = request.getSession().getAttribute("current_name")
				.toString();
		String type = request.getSession().getAttribute("type").toString();
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String password3 = request.getParameter("password3");
		if (password == null || password.trim().equals("")) {
			message = "原密码不能为空！";
		} else if (password2 == null || password2.trim().equals("")) {
			message = "新密码不能为空！！";
		} else if (password3 == null || password3.trim().equals("")) {
			message = "重复密码不能为空！！！";
		} else if (!password2.equals(password3)) {
			message = "2次密码不一致！！！！";
		} else {
			TeacherServer teacherServer = new TeacherServerImpl();
			TeacherInfoBean teacherInfoBean = new TeacherInfoBean();
			teacherInfoBean = teacherServer.fetchTeacherInfoByName(current_name);
			int id = teacherInfoBean.getId();
			String bpwd = teacherInfoBean.getUserpwd();
			if (!bpwd.equals(password)) {
				message = "原密码输入有误！！！！！";
			} else {
				if (current_name != null && type.equals("2")) {
					int update = teacherServer.updateTeacherPassword(id,password2);
					
					if (update == 1) {
						message = "密码修改成功！！";
					} else {
						message = "密码修改失败！！";
					}
				} else {
					message = "非法用户！";
				}
			}
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("./teacherPasswordUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
