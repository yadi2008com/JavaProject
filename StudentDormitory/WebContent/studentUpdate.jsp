<%@page import="com.etc.bean.StudentBean"%>
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
		if (isNull(form1.Student_Username.value)) {
			alert("请输入学号！");
			return false;
		}

		if (isNull(form1.Student_Password.value)) {
			alert("请输入密码！");
			return false;
		}
		if (isNull(form1.Student_Password2.value)) {
			alert("请输入重复密码！");
			return false;
		}
		
		if (document.form1.Student_Password.value != document.form1.Student_Password2.value) {
			alert("您两次输入的新密码不一致！请重新输入！");
			return false;
		}
		if (isNull(form1.Student_Name.value)) {
			alert("请选输入姓名！");
			return false;
		}
		if (isNull(form1.Student_Sex.value)) {
			alert("请选择性别！");
			return false;
		}
		if (isNull(form1.Student_Class.value)) {
			alert("请输入班级！");
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
		<%
			StudentBean studentBeen = (StudentBean) session
					.getAttribute("studentBeen");
			if (studentBeen != null) {
		%>
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
											style="padding-left: 25px;">修改学生</td>
									</tr>
									<tr>
										<td height="470" align="center" valign="top" bgcolor="#F6F9FE">
										<form
												name="form1" method="post" action="./StudentUpdateServlet"
												onSubmit="return mycheck()">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td width="33%" height="30" align="right">&nbsp;</td>

													</tr>
													<tr>
														<td height="30" align="right"><span
															style="color: red;">*</span>学号：</td>
														<td><input name="username" type="text" class="text2"
															id="Student_Username"
															value="<%=studentBeen.getUsername()%>" /></td>
													</tr>
													<tr>
														<td height="30" align="right">密码：</td>
														<td><input name="userpwd" type="password"
															class="text2" id="Student_Password"
															value="<%=studentBeen.getUserpwd()%>"> <span
															style="color: #F60">不修改则不填写</span></td>
													</tr>
													<tr>
														<td height="30" align="right">重复密码：</td>
														<td><input name="userpwd2" type="password"
															class="text2" id="Student_Password2"
															value="<%=studentBeen.getUserpwd()%>"> <span
															style="color: #F60">不修改则不填写</span></td>
													</tr>
													<tr>
														<td height="30" align="right"><span
															style="color: red;">*</span>姓名：</td>
														<td><input name="name" type="text" class="text2"
															id="Student_Name" value="<%=studentBeen.getName()%>"></td>
													</tr>
													<input name="id" type="hidden" class="text2"
														id="Student_id" value="<%=studentBeen.getId()%>">
													<tr>
														<td height="30" align="right"><span
															style="color: red;">*</span>性别：</td>
														<td><select name="sex" id="Student_Sex">
																<option value="">请选择</option>
																<%
																	if (studentBeen.getSex().equals("男")) {
																%>
																<option value="男" selected>男</option>
																<option value="女">女</option>

																<%
																	} else {
																%>
																<option value="男" >男</option>
																<option value="女" selected>女</option>
																<%
																	}
																%>
														</select></td>
													</tr>
													<tr>
														<td height="30" align="right"><span
															style="color: red;">*</span>班级：</td>
														<td><input name="classes" type="text" class="text2"
															id="Student_Class" value="<%=studentBeen.getClasses()%>"></td>
													</tr>
													<tr>
														<td height="30">&nbsp;</td>
														<td><input type="submit" name="button" id="button"
															value="修改学生"> &nbsp;&nbsp; <input type="button"
															name="button2" id="button2" value="返回上页"
															onClick="javascript:history.back(-1);"></td>
													</tr>
													<%
														} else {
															out.print("无此用户信息");
														}
													%>
												</table>

											</form></td>
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
