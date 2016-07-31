<%@ page language="java"  pageEncoding="gbk"%>
<%@page import="com.nuaa.pop.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title></title>
</head>

<body>

<form name="form0" action="/Ren_Test/modifyServlet">
<table width="427"  border="1" align="center">
  <tr>
    <td height="35" colspan="2" align="center">Register </td>
  </tr>
  <tr>
    <td width="128">用户名</td>
    <td width="283"><input type="text" name="userId"/></td>
  </tr>
  <tr>
    <td width="128">姓名</td>
    <td width="283"><input type="text" name="name"/></td>
  </tr>
  <tr>
    <td>性别</td>
    <td>Male <input name = "gender" type="radio" value="1" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Female <input type="radio" name = "gender"  value="2"  /></td>
  </tr>
  <tr>
    <td>密码</td>
    <td><input name = "passwd" type="password" /></td>
  </tr>
  <tr>
    <td>手机号码</td>
    <td><input name = "phone" type="text" /></td>
  </tr>
  
  <tr>
    <td>学校</td>
    <td>
      <select name = "school" >
        <option value="nuaa_old">南航本部校区</option>
        <option value="nuaa_new">南航江宁校区</option>
      </select>
    </td>
  </tr>
  
  <tr>
    <td>&nbsp;</td>
    <td><input type="submit" value = "Register"/></td>
  </tr>
</table>

<input type="hidden" name="actionCode" value="register"/>

</form>
</body>
</html>
