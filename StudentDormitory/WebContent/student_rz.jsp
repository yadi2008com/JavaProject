<%@page import="com.etc.bean.BuildinginfoBean"%>
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
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<script language="JavaScript">
	function mycheck() {

		if (isNull(form1.Building_ID.value)) {
			alert("请选择楼宇！");
			return false;
		}
		if (isNull(form1.Domitory_ID.value)) {
			alert("请选择寝室！");
			return false;
		}
		if (isNull(form1.Student_Username.value)) {
			alert("请输入学生学号！");
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
<script type="text/javascript">
	$(function() {
		$(".select1").change(function() {
			var build_ids = $(".select1").val();
			var dormitory=$(".dormitory");

			$.get("./StudentRZServlet", {
				build_id:build_ids
			}, function(data) {
			
			},"html");
		});
	});
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
							<td width="709" align="center" valign="top" bgcolor="#F6F9FE"><table
									width="709" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="30" background="Images/mainMenuBg.jpg"
											style="padding-left: 25px;">学生入住登记</td>
									</tr>
									<tr>
										<td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form
												name="form1" method="post" action="StudentRZSave.action"
												onSubmit="return mycheck()">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td width="33%" height="30" align="right">&nbsp;</td>
														<td width="67%">&nbsp;</td>
													</tr>
													<tr>
														<td height="30" align="right"><span
															style="color: red;">*</span>楼宇：</td>
														<td><select name="region" class="select1"
															id="BigClass">
																<option value="">请选择</option>
																<%
																	List<BuildinginfoBean> buildinginfoBeanList = (List<BuildinginfoBean>) request
																			.getAttribute("buildinginfoBeanList");
																	if (buildinginfoBeanList != null) {
																		for (BuildinginfoBean buildinginfoBean : buildinginfoBeanList) {
																%>
																<option value="<%=buildinginfoBean.getId()%>"><%=buildinginfoBean.getName()%></option>
																<%
																	}
																	} else {
																%>
																<option value="">暂无楼宇信息！</option>
																<%
																	}
																%>
														</select></td>
													</tr>
													<tr>
														<td height="30" align="right"><span
															style="color: red;">*</span>寝室：</td>
														<td><select name="dormitory" class="dormitory" >
																
																
														</select></td>
													</tr>
													<tr>
														<td height="30" align="right"><span
															style="color: red;">*</span>学生学号：</td>
														<td><label for="Student_ID"></label> <input
															type="text" name="Student_Username" id="Student_Username"></td>
													</tr>
													<tr>
														<td height="30">&nbsp;</td>
														<td><input type="submit" name="button" id="button"
															value="确定入住"></td>
													</tr>
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
