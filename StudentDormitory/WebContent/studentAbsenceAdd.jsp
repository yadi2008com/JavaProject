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
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script> 
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">添加缺寝记录</td>
            </tr>
           
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE">
              <form action="./StudentAbsenceAddServlet" method="post">  
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
                   <tr>
                    <td width="100%" height="30" align="center">学生号:
                    <input type="text" name="stu_id"/></td>
                  </tr> <tr>
                    <td width="100%" height="30" align="center">缺寝原因:
                    <textarea name="note" ></textarea></td>
                  </tr> <tr>
                    <td width="100%" height="30" align="center">缺寝时间:
                   <input class="Wdate" type="text" name="date" style="width: 150px;"
                                              onFocus="WdatePicker({isShowClear:true,readOnly:false,dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
                  </tr>
                   <tr>
                    <td width="100%" height="30" align="center">
                    <input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="reset" value="清空"/></td>
                  </tr>
                   <tr>
          	<%=request.getAttribute("message") != null ? request
					.getAttribute("message") : ""%>
            </tr>
                </table></form>
              
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
