<%@page import="com.etc.bean.PageBean"%>
<%@page import="com.etc.bean.BuildinginfoBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
List<BuildinginfoBean> buildinginfoBeans=(List<BuildinginfoBean>)request.getAttribute("buildinginfoBeans");
PageBean pageBean=(PageBean)request.getAttribute("pageBean");
%>
<%--@ taglib prefix="s" uri="/struts-tags"--%>
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
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE">
              <form name="form1" method="post" action="./BuildinginfoFetchByNameServlet">
                <table width="100%%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="28%" height="30" style="padding-left:20px;"> 功能导航： <a href="BuildingAdd.jsp">添加楼宇</a></td>
                    <td width="72%">名称：
                      
                      <input name="SearchKey" type="text" class="text1" id="SearchKey">
                      <input type="submit" name="button" id="button" value="点击查询">
                      <%=request.getAttribute("message")==null?"":request.getAttribute("message") %>
                      </td>
                     
                  </tr>
                </table>
              </form>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4"><strong>楼宇编号</strong></td>
                    <td bgcolor="#D5E4F4"><strong>楼宇名称</strong></td>
                    <td bgcolor="#D5E4F4"><strong>楼宇地址</strong></td>
                    <td bgcolor="#D5E4F4"><strong>楼宇容量</strong></td>
                    <td bgcolor="#D5E4F4"><strong>操作</strong></td>
                  </tr>
                  
                  <%
                  for(BuildinginfoBean buildinginfoBean:buildinginfoBeans){
                	%>
                	  <tr align="center">
                	  <td><%=buildinginfoBean.getId() %></td>
                	  <td><%=buildinginfoBean.getName() %></td>
                	  <td><%=buildinginfoBean.getAddress() %></td>
                	  <td><%=buildinginfoBean.getContent() %></td>
                	  <td align="center">
                        <a href="./BuildingTeacherinfoFetchServlet?id=<%=buildinginfoBean.getId() %>&url=/BuildingShowServlet">管理员</a>
                        <a href="./FetchBuildinginfoServlet?id=<%=buildinginfoBean.getId() %>&type=view">查看</a>  
                        <a href="./FetchBuildinginfoServlet?id=<%=buildinginfoBean.getId() %>&type=update">修改</a> 
                        <a href="./BuildingDeleteServlet?id=<%=buildinginfoBean.getId() %>" onClick="return confirm('确定要删除该楼宇吗？')">删除</a>
                      </td>
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
                    <a href="./BuildingShowServlet?pageno=1">首页</a>&nbsp;&nbsp;
                    <a href="./BuildingShowServlet?pageno=<%=(pageBean.getPageno()-1)%>">上一页</a>&nbsp;&nbsp;
                    <a href="./BuildingShowServlet?pageno=<%=(pageBean.getPageno()+1)%>">下一页</a>&nbsp;&nbsp;
                    <a href="./BuildingShowServlet?pageno=<%=pageBean.getMaxpage() %>">尾页</a>&nbsp;&nbsp;共<%=pageBean.getMaxpage() %>页
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
