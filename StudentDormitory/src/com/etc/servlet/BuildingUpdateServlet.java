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

/**
 * Servlet implementation class BuildingUpdateServlet
 */
@WebServlet("/BuildingUpdateServlet")
public class BuildingUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BuildingUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		//得到修改后的楼宇信息
	String idString=request.getParameter("id");
	String name=request.getParameter("name");
	String address=request.getParameter("address");
	String content=request.getParameter("content");
	int id=Integer.parseInt(idString);
	
	BuildinginfoBean buildinginfoBean=new BuildinginfoBean();
	buildinginfoBean.setId(id);
	buildinginfoBean.setName(name);
	buildinginfoBean.setAddress(address);
	buildinginfoBean.setContent(content);
	
	BuildinginfoBean currentUpdateBuildinginfoBean=(BuildinginfoBean)request.getSession().getAttribute("currentUpdateBuildinginfoBean");
	
	
	//判断楼宇名是否为空
	if(name==null||name.trim().equals("")){
		request.setAttribute("message", "楼宇名不能为空");
		request.setAttribute("buildinginfoBean", buildinginfoBean);
		request.getRequestDispatcher("BuildingUpdate.jsp").forward(request, response);
	}
	
	
	//判断楼宇名字是否被占用
	BuildinginfoServer buildinginfoServer=new BuildinginfoServerImpl();
	boolean flag=buildinginfoServer.isBuildingExits(name);
	if(flag&&!name.equals(currentUpdateBuildinginfoBean.getName())){
		//名字被占用，且名字不是修改前的名字
		request.setAttribute("message", "楼宇名被占用");
		request.setAttribute("buildinginfoBean", buildinginfoBean);
		request.getRequestDispatcher("BuildingUpdate.jsp").forward(request, response);
	}else{
		//进行修改操作
	int result=buildinginfoServer.updateBuilding(buildinginfoBean);	
	if(result==1){
		//"修改成功"
		request.setAttribute("message", "修改成功");
		request.getRequestDispatcher("./BuildingShowServlet").forward(request, response);
	}else{
		//"修改失败"
		request.setAttribute("message", "修改失败");
		request.setAttribute("buildinginfoBean", buildinginfoBean);
		request.getRequestDispatcher("BuildingUpdate.jsp").forward(request, response);
		
	}
	}
	}	

}
