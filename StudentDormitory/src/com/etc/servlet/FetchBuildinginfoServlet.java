package com.etc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.etc.bean.BuildinginfoBean;
import com.etc.server.BuildinginfoServer;
import com.etc.server.BuildinginfoServerImpl;


@WebServlet("/FetchBuildinginfoServlet")
/**
 * 功能：通过id查找楼宇的信息
 * @作者：魏泽锟
 *
 */
public class FetchBuildinginfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FetchBuildinginfoServlet() {
        super();
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
			//通过id查找到楼宇的信息
			BuildinginfoServer buildinginfoServer=new BuildinginfoServerImpl();
			BuildinginfoBean buildinginfoBean=buildinginfoServer.fetchBuildinginfoById(id);
			if(buildinginfoBean!=null){
				//判断type的类型，将楼宇信息传到不同的页面
				 String type=(String) request.getParameter("type");
				 if(type.equals("view")){
					 request.setAttribute("buildinginfoBean", buildinginfoBean);
					 request.getRequestDispatcher("BuildingShow.jsp").forward(request, response);
				 }else if(type.equals("update")){
					 request.setAttribute("buildinginfoBean", buildinginfoBean);
					//设置当前修改的building Session
					 request.getSession().setAttribute("currentUpdateBuildinginfoBean", buildinginfoBean);
					 request.getRequestDispatcher("BuildingUpdate.jsp").forward(request, response);
				 }
				
			}else{
				request.setAttribute("message", "没有这个id");
				request.getRequestDispatcher("./BuildingShowServlet").forward(request, response);
			}
			
			
		} catch (Exception e) {
			request.setAttribute("message","楼宇id语法有误");
			request.getRequestDispatcher("./BuildingShowServlet").forward(request, response);
		}
	
	}

}
