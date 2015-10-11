<%@page import="com.etc.bean.AbsenceBean"%>
<%@page import="com.etc.server.StudentAbsenceServe"%>
<%@page import="com.etc.server.StudentAbsenceServeImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>校园宿舍管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<center>
  <table width="900" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="60" bgcolor="#E6F5FF" style="color:#06F; font-size:19px; font-weight:bolder; padding-left:50px;">校园宿舍管理系统</td>
    </tr>
    <tr>
      <td height="30" background="Images/MenuBg.jpg">&nbsp;</td>
    </tr>
    <tr>
      <td height="500" align="center" valign="top"><table width="900" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="191" height="500" align="center" valign="top" background="Images/leftbg.jpg">
          <%@ include file="left.jsp"%>
          </td>
          <td width="709" align="center" valign="top" bgcolor="#F6F9FE"><table width="709" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">学生缺寝记录</td>
            </tr>
            <tr>
          	<%=request.getAttribute("message") != null ? request
					.getAttribute("message") : ""%>
            </tr>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;"></td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4"><strong>缺勤记录id</strong></td>
                    <td bgcolor="#D5E4F4"><strong>学生号</strong></td>
                    <td bgcolor="#D5E4F4"><strong>缺勤原因</strong></td>
                    <td bgcolor="#D5E4F4"><strong>缺勤时间</strong></td>
                    <td bgcolor="#D5E4F4"><strong>操作</strong></td>
                    </tr>
                    <%
                    StudentAbsenceServe absenceServe = new StudentAbsenceServeImpl();
		            List<AbsenceBean> absenceList = (List<AbsenceBean>)request.getAttribute("absenceList");
		            for(AbsenceBean absence : absenceList){
                     %>
                    <tr align="center">
                      <td height="25" align="center"><%=absence.getId() %></td>
                      <td><%=absence.getStu_id() %></td>
                      <td><%=absence.getNote() %></td>
                      <td><%=absence.getTime() %></td>
                      <td>
                      <a href="./StudentAbsenceFetchServlet?id=<%=absence.getId()%>&sort=fetch">查找</a>&nbsp;
                     <a href="./StudentAbsenceFetchServlet?id=<%=absence.getId()%>&sort=update">更改</a>&nbsp;
                     <a href="./StudentAbsenceDeleteServlet?id=<%=absence.getId()%>">删除</a></td>
                      </tr>
                      <%
                      }
                       %>
              </table></td>
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
