package com.etc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.bean.PageBean;
import com.etc.bean.TeacherInfoBean;
import com.etc.server.BuildinginfoServer;
import com.etc.server.BuildinginfoServerImpl;


@WebServlet("/BuildingTeacherinfoFetchServlet")
public class BuildingTeacherinfoFetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public BuildingTeacherinfoFetchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String url= request.getParameter("url");
		String idString= request.getParameter("id");
		
		try {
			int id=0;
			if(idString!=null){
			 id=Integer.parseInt(idString);
			}
			if(request.getAttribute("buildingId")!=null){
				idString=(String) request.getAttribute("buildingId");
				id=Integer.parseInt(idString) ;
			}
			//得到所要的信息页数（pageno）
			int pageno=1;
			if(request.getParameter("pageno")!=null){
				String pagenoString=request.getParameter("pageno");
				pageno=Integer.parseInt(pagenoString);
			}
			//通过的到信息的行数来得到maxpage
			BuildinginfoServer buildinginfoServer=new BuildinginfoServerImpl();
			//得到信息行数
			int buildingTeacherinfoRows=buildinginfoServer.getBuildingTeacherinfoRowsByBuildingId(id);
			//得到maxpage
			int maxpage=buildingTeacherinfoRows%PageBean.ROWS_PRE_PAGE==0?buildingTeacherinfoRows/PageBean.ROWS_PRE_PAGE:(buildingTeacherinfoRows/PageBean.ROWS_PRE_PAGE+1);
			
			if(pageno<1){
				pageno=1;
			}else if(pageno>maxpage){
				pageno=maxpage;
			}
			List<TeacherInfoBean> teacherInfoBeans=buildinginfoServer.fetchTeacherinfoByBuildingIdPageno(id,pageno);
			List<TeacherInfoBean> teachersNotAssign=buildinginfoServer.fetchNotAssignTeachers();
			PageBean pageBean=new PageBean();
			pageBean.setMaxpage(maxpage);
			pageBean.setPageno(pageno);
			if(!teacherInfoBeans.isEmpty()){
				//查到了宿舍管理员信息
				
				request.setAttribute("pageBean", pageBean);
				request.setAttribute("message", "查询管理员信息成功！");
				request.setAttribute("teacherInfoBeans", teacherInfoBeans);
				request.setAttribute("teachersNotAssign", teachersNotAssign);
				request.setAttribute("buildingId", id);
				request.getRequestDispatcher("BuildingTeacherinfoShow.jsp").forward(request, response);
			}else{
				//没查到宿舍管理员信息
				request.setAttribute("pageBean", pageBean);
				request.setAttribute("message", "该楼还没有宿舍管理员，请添加！");
				request.setAttribute("teacherInfoBeans", teacherInfoBeans);
				request.setAttribute("teachersNotAssign", teachersNotAssign);
				request.setAttribute("buildingId", id);
				request.getRequestDispatcher("BuildingTeacherinfoShow.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("message", "楼宇id语法错误");
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

}
