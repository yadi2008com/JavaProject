package com.etc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.bean.BuildinginfoBean;
import com.etc.server.BuildinginfoServer;
import com.etc.server.BuildinginfoServerImpl;


@WebServlet("/BuildinginfoFetchByNameServlet")
public class BuildinginfoFetchByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BuildinginfoFetchByNameServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String SearchKey= request.getParameter("SearchKey");
		
		BuildinginfoServer buildinginfoServer=new BuildinginfoServerImpl();
		BuildinginfoBean buildinginfoBean= buildinginfoServer.fetchBuildinginfoByName(SearchKey);
		if(buildinginfoBean!=null){
			//查到了楼宇信息
			request.setAttribute("message", "恭喜，查询成功！");
			request.setAttribute("buildinginfoBean", buildinginfoBean);
			request.getRequestDispatcher("BuildingShow.jsp").forward(request, response);
		}else{
			//查不到信息
			request.setAttribute("message", "查不到该楼宇的信息!");
			request.getRequestDispatcher("./BuildingShowServlet").forward(request, response);
		}
	
	}

}
