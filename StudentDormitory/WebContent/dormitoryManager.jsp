<%@page import="com.etc.server.DormitoryServerImpl"%>
<%@page import="com.etc.server.DormitoryServer"%>
<%@page import="com.etc.bean.BuildinginfoBean"%>
<%@page import="com.etc.server.BuildinginfoServerImpl"%>
<%@page import="com.etc.server.BuildinginfoServer"%>
<%@page import="com.etc.bean.DormitoryBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>校园宿舍管理系统</title>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<center>
		<table width="900" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="60" bgcolor="#E6F5FF"
					style="color: #06F; font-size: 19px; font-weight: bolder; padding-left: 50px;">校园宿舍管理系统</td>
			</tr>
			<tr>
				<td height="30" background="Images/MenuBg.jpg">&nbsp;</td>
			</tr>
			<tr>
				<td height="500" align="center" valign="top"><table width="900"
						border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="191" height="500" align="center" valign="top"
								background="Images/leftbg.jpg"><%@ include file="left.jsp"%>
							</td>
							<td width="709" align="center" valign="top" bgcolor="#F6F9FE"><table
									width="709" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="30" background="Images/mainMenuBg.jpg"
											style="padding-left: 25px;">宿舍管理</td>
									</tr>
									<tr>
										<td height="470" align="center" valign="top" bgcolor="#F6F9FE">
										<form name="form1" method="post" action="./DomitoryFetchServlet">
												<table width="100%%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td width="22%" height="30" style="padding-left: 20px;">
															功能导航： <a href="dormitoryAdd.jsp">添加宿舍</a>
														</td>
														<td width="78%">查询： <select
															name="Dormitory_BuildingID" id="Domitory_BuildingID">
																<option value="0">全部楼宇</option>
																<%
																	BuildinginfoServer buildinginfoServer = new BuildinginfoServerImpl();
																	List<BuildinginfoBean> buildinginfoBeans = buildinginfoServer
																			.fetchAllBuildinfo();
																	for (BuildinginfoBean buildinginfoBean : buildinginfoBeans) {
																%>
																<option value="<%=buildinginfoBean.getId()%>"><%=buildinginfoBean.getName()%></option>
																<%
																	}
																%>
														
														</select> <input name="SearchKey" type="text" class="text1"
															id="SearchKey"/> <input type="submit"
															name="button" id="button" value="点击查询"/></td>
													</tr>
												</table>
											</form>
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr align="center" class="t1">
													<td bgcolor="#D5E4F4" height="25"><strong>宿舍ID</strong></td>
													<td bgcolor="#D5E4F4"><strong>楼宇名</strong></td>
													<td bgcolor="#D5E4F4"><strong>寝室号</strong></td>
													<td bgcolor="#D5E4F4"><strong>宿舍人数</strong></td>
													<td bgcolor="#D5E4F4"><strong>操作</strong></td>
												</tr>
												<%
													List<DormitoryBean> dormitoryBeanList = (List<DormitoryBean>) request
															.getAttribute("dormitoryBeanList");
												if(dormitoryBeanList != null && !dormitoryBeanList.isEmpty()){
													for (int i=0; i<dormitoryBeanList.size();i++) {
														DormitoryBean dormitoryBean = new DormitoryBean();
														dormitoryBean=dormitoryBeanList.get(i);
												%>
												<tr align="center">
													<td height="25" align="center"><%=dormitoryBean.getId()%></td>
													<td align="center"><%=dormitoryBean.getBuild_name()%></td>
													<td align="center"><%=dormitoryBean.getName()%></td>
													<td align="center"><%=dormitoryBean.getNumber()%></td>
													<td align="center"><a href="./DormitoryDeleteServlet?id=<%=dormitoryBean.getId() %>" onClick="return confirm('确定要删除该宿舍吗？')">删除</a></td>
												</tr>

												<%
													}
												}else{
												%>
											</table>
											 <strong><%=request.getAttribute("message") !=null?request.getAttribute("message"):"无宿舍信息！"%></strong></td>
											
											<%
											
												
											}%>
											
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
			<%=request.getAttribute("massage") != null ? request
					.getAttribute("message") : ""%>
			<%
				request.setAttribute("dormitoryBeanList", dormitoryBeanList);
			%>
			<tr>
				<td height="35" background="Images/bootBg.jpg">&nbsp;</td>
			</tr>
		</table>

	</center>
</body>
</html>
