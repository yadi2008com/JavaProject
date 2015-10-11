<%@page import="com.etc.bean.PageBean"%>
<%@page import="com.etc.bean.TeacherInfoBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
List<TeacherInfoBean> teacherInfoBeans=(List<TeacherInfoBean>)request.getAttribute("teacherInfoBeans");
List<TeacherInfoBean> teachersNotAssign=(List<TeacherInfoBean>)request.getAttribute("teachersNotAssign");
PageBean pageBean=(PageBean)request.getAttribute("pageBean");
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
              <td width="80%" height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">楼宇管理员管理</td>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;"><a href="./BuildingShowServlet">返回</a></td>
            </tr>
            <tr>
              <td colspan="2" height="470" align="center" valign="top" bgcolor="#F6F9FE">
              <form name="form1" method="post" action="./BuildingTeacherAddServlet">
                <table width="100%%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="28%" height="30" style="padding-left:20px;"> 功能导航：&nbsp;&nbsp;添加楼宇管理</td>
                    <td width="72%">可添加的管理员：
                      <input type="hidden" name="buildingId" value="<%=request.getAttribute("buildingId")%>"/>
                      <select name="teachersNotAssignId" id="teachersNotAssign">
                      <%
                      for(TeacherInfoBean teacherBean:teachersNotAssign){
                    	  %>
                    	  <option value="<%=teacherBean.getId() %>"><%=teacherBean.getName() %></option>
                    	  <%
                      }
                      %>
                      </select>
                      <input type="submit" name="button" id="button" value="添加">&nbsp;&nbsp;&nbsp;<%=request.getAttribute("message") %></td>
                  </tr>
                </table>
              </form>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4"><strong>姓名</strong></td>
                    <td bgcolor="#D5E4F4"><strong>电话</strong></td>
                    <td bgcolor="#D5E4F4"><strong>用户名</strong></td>
                    <td bgcolor="#D5E4F4"><strong>操作</strong></td>
                  </tr>
                  <%
                  for(TeacherInfoBean teacherInfoBean:teacherInfoBeans){
                	  %>
                	  <tr align="center">
                      <td height="25" align="center"><%=teacherInfoBean.getName() %></td>
                      <td><%=teacherInfoBean.getTelephone() %></td>
                      <td><%=teacherInfoBean.getUsername() %></td>
                      <td align="center">
                      <a href="BuildingTeacherDeleteServlet?id=<%=teacherInfoBean.getId() %>&buildingId=<%=request.getAttribute("buildingId") %>" onClick="return confirm('确定要删除该楼宇管理员吗？')">删除</a></td>
                    </tr>
                	  <%
                  }
                  %>
                   <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4"><strong></strong></td>
                    <td bgcolor="#D5E4F4"><strong></strong></td>
                    <td bgcolor="#D5E4F4"><strong></strong></td>
                    <td colspan="2" bgcolor="#D5E4F4">
                    <strong>
                    <a href="./BuildingTeacherinfoFetchServlet?pageno=1&id=<%=request.getAttribute("buildingId") %>">首页</a>&nbsp;&nbsp;
                    <a href="./BuildingTeacherinfoFetchServlet?pageno=<%=(pageBean.getPageno()-1)%>&id=<%=request.getAttribute("buildingId") %>">上一页</a>&nbsp;&nbsp;
                    <a href="./BuildingTeacherinfoFetchServlet?pageno=<%=(pageBean.getPageno()+1)%>&id=<%=request.getAttribute("buildingId") %>">下一页</a>&nbsp;&nbsp;
                    <a href="./BuildingTeacherinfoFetchServlet?pageno=<%=pageBean.getMaxpage() %>&id=<%=request.getAttribute("buildingId") %>">尾页</a>&nbsp;&nbsp;共<%=pageBean.getMaxpage() %>页
                    </strong></td>
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
