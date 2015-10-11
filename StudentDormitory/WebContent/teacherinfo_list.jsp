<%@page import="com.etc.bean.TeacherInfoBean"%>
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
											style="padding-left: 25px;">楼宇管理员管理</td>
									</tr>
									<tr>
										<td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form
												name="form1" method="post"
												action="./TeacherinfoSelectServlet">
												<table width="100%%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td width="28%" height="30" style="padding-left: 20px;">
															功能导航： <a href="teacherinfo_add.jsp">添加楼宇管理员</a>
														</td>
														<td width="72%">查询： <select name="SearchRow"
															id="SearchRow">
																<option value="name">姓名</option>
																<option value="telephone">电话</option>
																<option value="username">用户名</option>
														</select> <input name="SearchKey" type="text" class="text1"
															id="SearchKey"> <input type="submit"
															name="button" id="button" value="点击查询"></td>
													</tr>
												</table>
											</form> <%=request.getAttribute("message") != null ? request
					.getAttribute("message") : ""%> <%
 	List<TeacherInfoBean> teacherInfoBeanList = (List<TeacherInfoBean>) request
 			.getAttribute("teacherInfoBeanList");
 	if (teacherInfoBeanList != null) {
 %>
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr align="center" class="t1">
													<td height="25" bgcolor="#D5E4F4"><strong>姓名</strong></td>
													<td bgcolor="#D5E4F4"><strong>电话</strong></td>
													<td bgcolor="#D5E4F4"><strong>用户名</strong></td>
													<td bgcolor="#D5E4F4"><strong>操作</strong></td>
												</tr>
												<%
													for (TeacherInfoBean teacherInfo : teacherInfoBeanList) {
												%>
												<tr align="center">
													<td height="25" align="center"><%=teacherInfo.getName()%></td>
													<td><%=teacherInfo.getTelephone()%></td>
													<td><%=teacherInfo.getUsername()%></td>
													<td align="center"><a
														href="./TeacherinfoFetchServlet?id=<%=teacherInfo.getId()%>&sort=update">修改</a>
														<a
														href="./TeacherinfoDeleteServlet?id=<%=teacherInfo.getId()%>"
														onClick="return confirm('确定要删除该楼宇管理员吗？')">删除</a></td>
												</tr>
												<%
													}
												%>
											</table> <%
 	}
 %>
  <%
 	List<TeacherInfoBean> teacherInfoBeanListSelect = (List<TeacherInfoBean>) request
 			.getAttribute("teacherInfoBeanListSelect");
 	if (teacherInfoBeanListSelect != null) {
 %>
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr align="center" class="t1">
													<td height="25" bgcolor="#D5E4F4"><strong>姓名</strong></td>
													<td bgcolor="#D5E4F4"><strong>电话</strong></td>
													<td bgcolor="#D5E4F4"><strong>用户名</strong></td>
													<td bgcolor="#D5E4F4"><strong>操作</strong></td>
												</tr>
												<%
													for (TeacherInfoBean teacherInfo : teacherInfoBeanListSelect) {
												%>
												<tr align="center">
													<td height="25" align="center"><%=teacherInfo.getName()%></td>
													<td><%=teacherInfo.getTelephone()%></td>
													<td><%=teacherInfo.getUsername()%></td>
													<td align="center"><a
														href="./TeacherinfoFetchServlet?id=<%=teacherInfo.getId()%>&sort=update">修改</a>
														<a
														href="./TeacherinfoDeleteServlet?id=<%=teacherInfo.getId()%>"
														onClick="return confirm('确定要删除该楼宇管理员吗？')">删除</a></td>
												</tr>
												<%
													}
												%>
											</table> <%
 	}					%> <%
 	TeacherInfoBean teacherInfoBeanSelect = (TeacherInfoBean) request
 			.getAttribute("teacherInfoBeanSelect");
 	if (teacherInfoBeanSelect != null) {
 %>
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr align="center" class="t1">
													<td height="25" bgcolor="#D5E4F4"><strong>姓名</strong></td>
													<td bgcolor="#D5E4F4"><strong>电话</strong></td>
													<td bgcolor="#D5E4F4"><strong>用户名</strong></td>
													<td bgcolor="#D5E4F4"><strong>操作</strong></td>
												</tr>
												<tr align="center">
													<td height="25" align="center"><%=teacherInfoBeanSelect.getName()%></td>
													<td><%=teacherInfoBeanSelect.getTelephone()%></td>
													<td><%=teacherInfoBeanSelect.getUsername()%></td>
													<td align="center"><a
														href="./TeacherinfoFetchServlet?id=<%=teacherInfoBeanSelect.getId()%>&sort=update">修改</a>
														<a
														href="./TeacherinfoDeleteServlet?id=<%=teacherInfoBeanSelect.getId()%>"
														onClick="return confirm('确定要删除该楼宇管理员吗？')">删除</a></td>
												</tr>
											</table> <%
 	}
 %></td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
			<tr>
				<td height="35" background="Images/bootBg.jpg">&nbsp;</td>
			</tr>
		</table>

	</center>
</body>
</html>