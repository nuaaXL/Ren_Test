<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <br /><br /><br /><br /><br /><br /><br /><br />
  
  <script type="text/javascript">
    function loginAction(){   
        document.form0.action="/Ren_Test/login";
        document.form0.submit();
    }

  </script>
  
  <body>
    <p align = "center">
        <img src="NuaaXL.png" alt="NuaaXL" style="height: 79px; width: 84px; "><br />
    </p>
    <form name="form0" >
      <p align ="center">
	    ”√ªß√˚<br />
	    <input type="text" name="userId" size="20" />
	  </p>
	  <p align = "center">
		√‹¬Î<br />
		<input type="password" name="passwd" size="21" />
	  </p>  
      <p align = "center">
        <a href="/Ren_Test/Register.jsp">Register</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type = "button" value = "Log In"  onclick="loginAction()"/>
        
      </p>
	  </form>
	    
  </body>
  
</html>
