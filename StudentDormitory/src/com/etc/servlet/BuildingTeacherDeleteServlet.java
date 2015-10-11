package com.etc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.server.BuildinginfoServer;
import com.etc.server.BuildinginfoServerImpl;

@WebServlet("/BuildingTeacherDeleteServlet")
public class BuildingTeacherDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BuildingTeacherDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String idString=request.getParameter("id");
	try {
		int id=Integer.parseInt(idString);
		BuildinginfoServer buildinginfoServer=new BuildinginfoServerImpl();
		int result=buildinginfoServer.deleteBuildingTeacherById(id);
		if(result==1){
			request.setAttribute("message", "删除成功！");
			//将楼的id传给显示页面
			request.setAttribute("buildingId", request.getParameter("buildingId"));
			request.getRequestDispatcher("./BuildingTeacherinfoFetchServlet").forward(request, response);
		}else{
			//删除失败
			request.setAttribute("message", "删除失败！");
			//将楼的id传给显示页面
			request.setAttribute("buildingId", request.getAttribute("buildingId"));
			request.getRequestDispatcher("./BuildingTeacherinfoFetchServlet").forward(request, response);
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	}

}
