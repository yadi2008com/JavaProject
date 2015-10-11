package com.etc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.server.BuildinginfoServer;
import com.etc.server.BuildinginfoServerImpl;


@WebServlet("/BuildingDeleteServlet")
public class BuildingDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BuildingDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			String idString=request.getParameter("id");
			int id=Integer.parseInt(idString);
			
			BuildinginfoServer buildinginfoServer=new BuildinginfoServerImpl();
			int result=buildinginfoServer.deleteBuildingById(id);
			if(result==1){
			request.getRequestDispatcher("./BuildingShowServlet").forward(request, response);
			}else{
				request.setAttribute("message", "删除楼宇失败");
				request.getRequestDispatcher("./BuildingShowServlet").forward(request, response);	
			}
			} catch (Exception e) {
			
			request.setAttribute("message", "楼宇id语法有误");
			request.getRequestDispatcher("./BuildingShowServlet").forward(request, response);
		}
		
		
	}

}
