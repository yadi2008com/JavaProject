
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link href="Style/Style.css" rel="stylesheet" type="text/css" />
<%
String current_name=(String)session.getAttribute("current_name");
if(session.getAttribute("type")!=null && current_name!=null)
{
%>
<table width="155" border="0" cellspacing="0" cellpadding="0">
             <tr>
                   <td height="31" align="center" background="Images/left1.jpg"><strong>当前用户：<%=current_name %></strong></td>
             </tr>
            <tr>
              <td height="31" align="center" background="Images/left1.jpg"><strong>系统选项</strong></td>
            </tr>
            <tr>
              <td height="50" align="center" valign="top"><table width="150" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="index.jsp">后台首页</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <%if(session.getAttribute("type").toString().equals("1")){%>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="./TeacherinfoListServlet">楼宇管理员管理</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="./StudentListServlet">学生管理</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="./BuildingShowServlet">楼宇管理</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="./DomitoryServlet">宿舍管理</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="./StudentRZServlet">学生入住登记</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="StudentTH.jsp">学生寝室调换</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="StudentQC.jsp">学生迁出登记</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="AdminLog.action">学生缺寝记录</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="OutList.action">迁出记录</a></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="admininfo_update.jsp">修改密码</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <%}%>
                <%if(session.getAttribute("type").toString().equals("2")){%>
                <tr>
                   
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="./studentAbsenceAdd.jsp">添加学生缺寝记录</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="./StudentAbsenceShowServlet">管理学生缺寝记录</a></td>
                </tr>
                 <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                 <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="./teacherPasswordUpdate.jsp">修改密码</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <%}%>
                <%if(session.getAttribute("type").toString().equals("3")){%>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="./MyAbsenceServlet">我的缺寝记录</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <%}%>
             
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="./LogoutServlet" onclick="return confirm('确定要退出系统吗？')">退出系统</a></td>
                </tr>
              </table>
              </td>
            </tr>
          </table>
 <%} else{
	 request.setAttribute("message", "请您先登录！");
	 request.getRequestDispatcher("login.jsp").forward(request, response);
 }%>