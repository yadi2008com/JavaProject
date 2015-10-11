package com.etc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.bean.DormitoryBean;
import com.etc.dao.DormitoryDao;
import com.etc.dao.DormitoryDaoImpl;
import com.etc.server.DormitoryServer;
import com.etc.server.DormitoryServerImpl;

/**
 * Servlet implementation class DomitoryFetchServlet
 */
@WebServlet("/DomitoryFetchServlet")
public class DomitoryFetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DomitoryFetchServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String Dormitory_BuildingID=request.getParameter("Dormitory_BuildingID");
	    String roomName=request.getParameter("SearchKey");
	   
		List<DormitoryBean> dormitoryBeanList=(List<DormitoryBean>) new ArrayList<DormitoryBean>();
		DormitoryServer dormitoryServer = new DormitoryServerImpl();
		try {
			int build_id= Integer.parseInt(Dormitory_BuildingID);
			if(build_id!=0&&roomName!=null&&!roomName.trim().isEmpty()){
				dormitoryBeanList=dormitoryServer.fetchAllDormitoryListByNameId(build_id,roomName);
				if(dormitoryBeanList!=null&& !dormitoryBeanList.isEmpty()){
					
						request.setAttribute("dormitoryBeanList", dormitoryBeanList);

					} else {
						request.setAttribute("message", "该楼无该宿舍，请确认后查询！！！");

					}
				
			}else if(build_id==0&&roomName!=null&&!roomName.trim().isEmpty()){
				dormitoryBeanList=dormitoryServer.fetchAllDormitoryListByName(roomName);
				if(dormitoryBeanList!=null&& !dormitoryBeanList.isEmpty()){
					
						request.setAttribute("dormitoryBeanList", dormitoryBeanList);

					} else {
						request.setAttribute("message", "宿舍名不存在，请确认后查询！！！");

					}
				
			}else if(build_id!=0&&roomName.trim().isEmpty()){
				dormitoryBeanList=dormitoryServer.fetchAllDormitoryListById(build_id);
				if(dormitoryBeanList!=null&& !dormitoryBeanList.isEmpty()){
					
						request.setAttribute("dormitoryBeanList", dormitoryBeanList);

					} else {
						request.setAttribute("message", "该楼宇未添加宿舍，请确认后查询！！！");

					}
			}else{
				request.setAttribute("message", "请输入查询条件！");
			}
			request.getRequestDispatcher("dormitoryManager.jsp").forward(request,
					response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
