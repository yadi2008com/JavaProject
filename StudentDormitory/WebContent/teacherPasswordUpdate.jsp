<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">修改宿舍管理员密码
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <%=request.getAttribute("message") != null ? request
					.getAttribute("message") : ""%></td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE">
              <form name="form" method="post" action="./TeacherPasswordUpdateServlet">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%">&nbsp;
                 
                    </td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>请输入原密码：</td>
                    <td><input name="password" type="text" class="text2"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>请输入新密码：</td>
                    <td><input name="password2" type="password" class="text2"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>请重复新密码：</td>
                    <td><input name="password3" type="password" class="text2"></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="修改密码">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" name="button" id="button" value="清空"></td>
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
