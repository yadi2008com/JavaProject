package com.etc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.server.DormitoryServer;
import com.etc.server.DormitoryServerImpl;

/**
 * Servlet implementation class DormitoryDeleteServlet
 */
@WebServlet("/DormitoryDeleteServlet")
public class DormitoryDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DormitoryDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String idString=request.getParameter("id");
		String message="";
		DormitoryServer dormitoryServer= new DormitoryServerImpl();
		int rows=0;
		try {
			int id=Integer.parseInt(idString);
			rows=dormitoryServer.deleteDormitoryinfo(id);
			
			if(rows==1){
				 message="删除成功！";
				
				 
			 }else {
				message="删除失败，请重新删除！";
				
			}
			 request.setAttribute("message", message);
			 request.getRequestDispatcher("./DomitoryServlet").forward(request,
						response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
