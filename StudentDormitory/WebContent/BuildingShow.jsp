
<%@page import="com.etc.bean.BuildinginfoBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%

BuildinginfoBean buildinginfoBean=(BuildinginfoBean)request.getAttribute("buildinginfoBean");
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">楼宇管理</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="BuildingManager.action">
                <table width="100%%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="28%" height="30" style="padding-left:20px;"> 功能导航： <a href="BuildingAdd.jsp">添加楼宇</a></td>
                    <td width="72%">名称：
                      
                      
                      <%=request.getAttribute("message")==null?"":request.getAttribute("message") %>
                      </td>
                     
                  </tr>
                </table>
              </form>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4" width="20%"><strong>楼宇编号</strong></td>
                    <td><%=buildinginfoBean.getId() %></td>
                   </tr>
                    <tr align="center"  class="t1" width="20%">
                    <td height="25" bgcolor="#D5E4F4"><strong>楼宇名称</strong></td>
                    <td><%=buildinginfoBean.getName() %></td>
                    </tr>
                     <tr align="center"  class="t1" width="20%">
                    <td height="25" bgcolor="#D5E4F4"><strong>楼宇地址</strong></td>
                     <td><%=buildinginfoBean.getAddress() %></td>
                    </tr>
                     <tr align="center"  class="t1" width="20%">
                    <td height="25" bgcolor="#D5E4F4"><strong>楼宇容量</strong></td>
                    <td><%=buildinginfoBean.getContent() %></td>
                    </tr>
                    <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4"></td>
                    <td height="25" bgcolor="#afa" align="right">
                    <strong>
                    <a href="./BuildingTeacherinfoFetchServlet?id=<%=buildinginfoBean.getId() %>&url=/BuildingShowServlet">管理员</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="./BuildingShowServlet">返回</a>
                    </strong>
                    </td>
                    </tr>
                   
                  
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
