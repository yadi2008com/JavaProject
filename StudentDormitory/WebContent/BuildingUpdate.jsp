<%@page import="com.etc.bean.BuildinginfoBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>校园宿舍管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
	<% 
	BuildinginfoBean buildinginfoBean=(BuildinginfoBean)request.getAttribute("buildinginfoBean");
	%>
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">修改楼宇</td>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;"><%=request.getAttribute("message")==null?"":request.getAttribute("message") %>
</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE">
              <form name="form1" method="post" action="./BuildingUpdateServlet" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%">&nbsp;</td>
                  </tr>
                   <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>楼宇id：</td>
                    <td><input name="id" type="text" class="text2" id="Building_Name" value="<%=buildinginfoBean.getId()%>" readonly="readonly"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>楼宇名称：</td>
                    <td><input name="name" type="text" class="text2" id="Building_Name" value="<%=buildinginfoBean.getName()!=null?buildinginfoBean.getName():"" %>"></td>
                  </tr>
                   <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>楼宇地址：</td>
                    <td><input name="address" type="text" class="text2" id="Building_Name" value="<%=buildinginfoBean.getAddress()!=null?buildinginfoBean.getAddress():"" %>"></td>
                  </tr>
                   <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>楼宇容量：</td>
                    <td><input name="content" type="text" class="text2" id="Building_Name" value="<%=buildinginfoBean.getContent()!=null?buildinginfoBean.getContent():"" %>"></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="修改楼宇">
                      &nbsp;&nbsp;
                      <input type="button" name="button2" id="button2" value="返回上页" onClick="javascript:history.back(-1);"></td>
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
