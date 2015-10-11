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


@WebServlet("/BuildingAddServlet")
public class BuildingAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BuildingAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String content=request.getParameter("content");
		if(name!=null&!name.trim().isEmpty()){
			//判断楼宇名称是否被占用,flag为true时表示被占用
			BuildinginfoServer buildinginfoServer=new BuildinginfoServerImpl();
			boolean flag=buildinginfoServer.isBuildingExits(name);
			if(flag){
				//被占用
				request.setAttribute("message", "楼宇名已被占用，请更换");
				request.getRequestDispatcher("BuildingAdd.jsp").forward(request, response);
			}else{
				BuildinginfoBean buildinginfoBean=new BuildinginfoBean();
				buildinginfoBean.setName(name);
				buildinginfoBean.setAddress(address);
				buildinginfoBean.setContent(content);
				int result=buildinginfoServer.addBuilding(buildinginfoBean);
				if(result==1){
					request.setAttribute("message", "添加楼宇成功！");
					request.getRequestDispatcher("./BuildingShowServlet").forward(request, response);	
				}
			}
		}else{
			request.setAttribute("message", "楼宇名不能为空");
			request.getRequestDispatcher("BuildingAdd.jsp").forward(request, response);
		}
	}

}
