package com.etc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.bean.AdminBean;
import com.etc.server.AdminServer;
import com.etc.server.AdminServerImpl;

@WebServlet("/AdmininfoUpdateServlet")
public class AdmininfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute(
				"current_name");
		String type = (String) request.getSession().getAttribute(
				"type");
		String olduserpwd = request.getParameter("olduserpwd");
		String userpwd = request.getParameter("userpwd");
		String reuserpwd = request.getParameter("reuserpwd");
		String message = "";
		String url = "admininfo_update.jsp";
		if (olduserpwd == null || olduserpwd.trim().equals("")) {
			message = "原密码不能为空！";
		} else if (userpwd == null || userpwd.trim().equals("")) {
			message = "新密码不能为空！";
		} else if (reuserpwd == null || reuserpwd.trim().equals("")) {
			message = "重复密码不能为空！";
		} else {
			if (reuserpwd.equals(userpwd)) {
				AdminServer adminServer = new AdminServerImpl();
				AdminBean adminBean = adminServer
						.AdmininfoFetchByUsername(username);
				String olduserpwdfromtable = adminBean.getUserpwd();
				if (olduserpwd.equals(olduserpwdfromtable) && type.equals("1") ) {
					  AdminBean adminBean2=new AdminBean();
					  adminBean2.setUsername(username);
					  adminBean2.setUserpwd(userpwd);
                      int result=adminServer.AdmininfoUpdate(adminBean2);
                      if(result==1)
                      {
                    	  message="修改成功！";
                      }else{
                    	  message="修改失败！";
                      }
				} else {
					message = "与原密码不相同！";
				}
			} else {
				message = "两次密码不相同！";
			}

		}
		request.setAttribute("message", message);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
