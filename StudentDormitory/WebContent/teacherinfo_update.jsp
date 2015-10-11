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
<script language="JavaScript">
	function mycheck() {
		if (isNull(form1.username.value)) {
			alert("请输入用户名！");
			return false;
		}
		if (document.form1.userpwd.value != document.form1.repassword.value) {
			alert("您两次输入的新密码不一致！请重新输入！");
			return false;
		}
		if (isNull(form1.name.value)) {
			alert("请输入姓名！");
			return false;
		}
		if (isNull(form1.telephone.value)) {
			alert("请输入联系电话！");
			return false;
		}
	}

	function isNull(str) {
		if (str == "")
			return true;
		var regu = "^[ ]+$";
		var re = new RegExp(regu);
		return re.test(str);
	}
</script>
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
							<td width="709" align="center" valign="top" bgcolor="#F6F9FE">
						
							
							<table
									width="709" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="30" background="Images/mainMenuBg.jpg"
											style="padding-left: 25px;">修改楼宇管理员</td>
									</tr>
										
									<tr>
										<td height="470" align="center" valign="top" bgcolor="#F6F9FE">
<%=request.getAttribute("message") != null ? request
					.getAttribute("message") : ""%> 
											<%
 	TeacherInfoBean teacherInfoBean = null;
 	teacherInfoBean = (TeacherInfoBean) request
 			.getAttribute("teacherInfoBean");
 	if (teacherInfoBean != null) {
 %>
											<form name="form1" method="post"
												action="./TeacherinfoUpdateServlet"
												onSubmit="return mycheck()">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td width="33%" height="30" align="right">&nbsp;</td>
														<td width="67%"><input name="Teacher_ID" type="text"
															class="noshow" id="Teacher_ID"
															value="<s:property value='cnbean.Teacher_ID'/>"></td>
													</tr>
													<tr>
														<td height="30" align="right"><span
															style="color: red;">*</span>用户名：</td>
														<td><input name="username"
															value="<%=teacherInfoBean.getUsername()%>" type="text"
															class="text2" id="Teacher_Username"></td>
													</tr>
													<tr>
														<td height="30" align="right">密码：</td>
														<td><input name="userpwd" type="password"
															class="text2" id="Teacher_Password"> <span
															style="color: #F60">不修改则不填写</span></td>
													</tr>
													<tr>
														<td height="30" align="right">重复密码：</td>
														<td><input name="repassword" type="password"
															class="text2" id="Teacher_Password2"> <span
															style="color: #F60">不修改则不填写</span></td>
													</tr>
													<tr>
														<td height="30" align="right"><span
															style="color: red;">*</span>姓名：</td>
														<td><input name="name"
															value="<%=teacherInfoBean.getName()%>" type="text"
															class="text2" id="Teacher_Name"></td>
													</tr>
													<tr>
														<td height="30" align="right"><span
															style="color: red;">*</span>联系电话：</td>
														<td><input name="telephone"
															value="<%=teacherInfoBean.getTelephone()%>" type="text"
															class="text2" id="Teacher_Tel"></td>
													</tr>
													<tr>
														<td height="30">&nbsp;</td>
														<td><input type="hidden" name="id"
															value="<%=teacherInfoBean.getId()%>" /> <input
															type="submit" name="button" id="button" value="修改楼宇管理员">
															&nbsp;&nbsp; <input type="button" name="button2"
															id="button2" value="返回上页"
															onClick="javascript:history.back(-1);"></td>
													</tr>
												</table>
											</form> <%
 	}
 %>
										</td>
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