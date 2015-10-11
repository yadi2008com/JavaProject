package com.etc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.bean.DormitoryBean;
import com.etc.server.DormitoryServer;
import com.etc.server.DormitoryServerImpl;

/**
 * Servlet implementation class DormitoryAddServlet
 */
@WebServlet("/DormitoryAddServlet")
public class DormitoryAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DormitoryAddServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String dormitoryName=request.getParameter("domitoryName");
		String dormitoryNumberString=request.getParameter("domitoryNumber");
		String dormitoryBuildingIDString=request.getParameter("domitoryBuildingID");
		DormitoryBean dormitoryBean = new DormitoryBean();
		DormitoryServer dormitoryServer= new DormitoryServerImpl();
		String message="";
		try {
		 int dormitoryNumber=Integer.parseInt(dormitoryNumberString);
		 int dormitoryBuildingID=Integer.parseInt(dormitoryBuildingIDString);
		 dormitoryBean.setBuild_id(dormitoryBuildingID);
		 dormitoryBean.setName(dormitoryName);
		 dormitoryBean.setNumber(dormitoryNumber);
		 int rows=dormitoryServer.addDormitoryinfo(dormitoryBean);
		 if(rows==1){
			 message="添加成功！";
			 request.getRequestDispatcher("./DomitoryServlet").forward(request,
						response);
			 
		 }else {
			message="添加失败，请重新添加！";
			request.getRequestDispatcher("domitoryAdd.jsp").forward(request,
					response);
		}
		 request.setAttribute("message", message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
