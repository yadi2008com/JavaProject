package com.etc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.bean.DormitoryBean;
import com.etc.server.DormitoryServer;
import com.etc.server.DormitoryServerImpl;

/**
 * Servlet implementation class DomitoryServlet
 */
@WebServlet("/DomitoryServlet")
public class DomitoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DomitoryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		DormitoryServer dormitoryServer = new DormitoryServerImpl();
		List<DormitoryBean> dormitoryBeanList = dormitoryServer
				.fetchAllDormitoryList();
		if (dormitoryBeanList != null && !dormitoryBeanList.isEmpty()) {
			request.setAttribute("dormitoryBeanList", dormitoryBeanList);

		} else {
			request.setAttribute("message", "无宿舍信息，请添加！！！");

		}
		request.getRequestDispatcher("dormitoryManager.jsp").forward(request,
				response);

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
