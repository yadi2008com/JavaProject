package com.etc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.bean.BuildinginfoBean;
import com.etc.bean.PageBean;
import com.etc.server.BuildinginfoServer;
import com.etc.server.BuildinginfoServerImpl;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

@WebServlet("/BuildingShowServlet")
			/**
			 * @功能：得到所有楼宇的信息列表，显示所有的楼宇信息
			 * @作者：魏泽锟
			 *
			 */
public class BuildingShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public BuildingShowServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		int pageno=1;
		if(request.getParameter("pageno")!=null){
		String	pagenoString=request.getParameter("pageno");
		pageno=Integer.parseInt(pagenoString);
		}
		BuildinginfoServer buildinginfoServer=new BuildinginfoServerImpl();
		//得到楼宇信息表的信息行数
		int buildinginfoRows=buildinginfoServer.getBuildinginfoRows();
		int maxpage=buildinginfoRows%PageBean.ROWS_PRE_PAGE==0?buildinginfoRows/PageBean.ROWS_PRE_PAGE:(buildinginfoRows/PageBean.ROWS_PRE_PAGE+1);
		
		if(pageno<1){
			pageno=1;
		}else if(pageno>maxpage){
			pageno=maxpage;
		}
		java.util.List<BuildinginfoBean> buildinginfoBeans = buildinginfoServer.fetchBuildinfoByPageno(pageno);
		String message=(String) request.getAttribute("message");
		PageBean pageBean=new PageBean();
		pageBean.setMaxpage(maxpage);
		pageBean.setPageno(pageno);
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("buildinginfoBeans", buildinginfoBeans);
		request.setAttribute("message", message);
		request.getRequestDispatcher("BuildingManager.jsp").forward(request, response);
	}

}
