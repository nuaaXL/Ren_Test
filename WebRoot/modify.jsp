<%@ page language="java"  pageEncoding="gbk"%>
<%@page import="com.nuaa.pop.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title></title>
</head>

<body>
<%	
	User user = (User)request.getAttribute("user");
	String school = user.getSchool();
	
%>
<form name="form0" action="/Ren_Test/modifyServlet">
<table width="427"  border="1" align="center">
  <tr>
    <td height="35" colspan="2" align="center">User Info </td>
  </tr>
  <tr>
    <td width="128">用户名</td>
    <td width="283"><%=user.getUserId()%></td>
  </tr>
  <tr>
    <td width="128">姓名</td>
    <td width="283"><input type="text" name="name" value="<%=user.getName()%>"/></td>
  </tr>
  <tr>
    <td>性别</td>
    <td>Male <input name = "gender" type="radio" value="1" <% if(user.getGender()==1) out.println("checked");%>/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Female <input type="radio" name = "gender"  value="2" <% if(user.getGender()!=1) out.println("checked");%> /></td>
  </tr>
  <tr>
    <td>密码</td>
    <td><input name = "passwd" type="password" value="<%=user.getPasswd() %>"/></td>
  </tr>
  <tr>
    <td>手机号码</td>
    <td><input name = "phone" type="text" value="<%=user.getPhone() %>"/></td>
  </tr>
  
  <tr>
    <td>学校</td>
    <td>
      <select name = "school" >
        <option value="nuaa_old" <% if(school.equals("nuaa_old")) out.println("selected");%> >nuaa_old</option>
        <option value="nuaa_new" <% if(school.equals("nuaa_new")) out.println("selected");%> >nuaa_new</option>
      </select>
    </td>
  </tr>
  
  <tr>
    <td>&nbsp;</td>
    <td><input type="submit" value = "修改"/></td>
  </tr>
</table>

<input type="hidden" name="actionCode" value="modifyConfirm"/>

<input type="hidden" name="userId" value="<%=user.getUserId()%>"/>

</form>
</body>
</html>
