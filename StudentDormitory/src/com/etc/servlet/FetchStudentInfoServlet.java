package com.etc.servlet;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.etc.bean.StudentBean;
import com.etc.server.StudentServer;
import com.etc.server.StudentServerImpl;


@WebServlet("/FetchStudentInfoServlet")
public class FetchStudentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//设置字符集
		String idString=request.getParameter("id");//通过连接参数，获取用户id信息
		String urlPath="./FetchStudentInfoServlet";//声明一个string的urlPath变量，用于存储路径信息
		String message="";

		try{
			int id=Integer.parseInt(idString);//将字符串转换为int
			StudentServer studentServer=new StudentServerImpl();
			StudentBean studentBeen=studentServer.fetchStudentInfoById(id);
			//用户实例对象非空时，根据所选操作转到相应页面
			if(studentBeen!=null){
				String sort=request.getParameter("sort");
				
				 if(sort!=null&&sort.equals("update")){
					
					request.getSession().setAttribute("studentBeen", studentBeen);
					urlPath="studentUpdate.jsp";//设置修改页面路径
				}
				else if(sort!=null&&sort.equals("delete")){
					request.getSession().setAttribute("studentBeen",studentBeen);
					urlPath="userinfo_delete.jsp";
				}
				else{
					message="操作不明确，请重新操作";
				}
				
			}else{
				message="该用户信息不存在，请确认后重新查看";
			}
			
			
		}catch(Exception e){
			message="该用户ID不存在，请确认后重新查看";
		}



		request.setAttribute("message",message);
		request.getRequestDispatcher(urlPath).forward(request,response);
	}
	}


