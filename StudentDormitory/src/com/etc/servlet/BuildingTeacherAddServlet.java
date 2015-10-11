package com.etc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.server.BuildinginfoServer;
import com.etc.server.BuildinginfoServerImpl;


@WebServlet("/BuildingTeacherAddServlet")
public class BuildingTeacherAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BuildingTeacherAddServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	//为楼宇添加管理员
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//得到楼宇的id
		String buildingIdString=request.getParameter("buildingId");
		//得到要分配的管理员的id
		String teacherIdString=request.getParameter("teachersNotAssignId");
		try {
			int buildingId=Integer.parseInt(buildingIdString);
			int teacherId=Integer.parseInt(teacherIdString);
			BuildinginfoServer buildinginfoServer=new BuildinginfoServerImpl();
			int result= buildinginfoServer.addBuildingTeacher(buildingId,teacherId);
			if(result==1){
				//添加成功
				request.setAttribute("message", "添加成功！");
				request.setAttribute("buildingId", request.getParameter("buildingId"));
				request.getRequestDispatcher("./BuildingTeacherinfoFetchServlet").forward(request, response);
				
			}else{
				//添加失败
				request.setAttribute("message", "添加失败！");
				request.setAttribute("buildingId", request.getParameter("buildingId"));
				request.getRequestDispatcher("./BuildingTeacherinfoFetchServlet").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("message", "没有管理员了，请先添加管理员");
			request.setAttribute("buildingId", request.getParameter("buildingId"));
			request.getRequestDispatcher("./BuildingTeacherinfoFetchServlet").forward(request, response);
		}
		
		
		
		
	}

}
