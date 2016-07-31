<%@page import="com.nuaa.pop.entity.*"  %>
<html>
  <head>
  </head>
  <body>
    <%
	User user =(User) request.getAttribute("user");

	%>
    Success
    <form name = "form0" action = "/Ren_Test/modifyServlet">
      <!-- 
      <a href="/Ren_Test/modifyServlet?actionCode=modify&userId=<%=user.getUserId()%>">Modify</a>
      <a href="/Ren_Test/modifyServlet?actionCode=delete&userId=<%=user.getUserId()%>">Delete</a>
       -->
       <input type = "submit"  value = Modify>
       <input type = "hidden" name = actionCode value = "modify">
       <input type = "hidden" name = userId value = <%=user.getUserId()%>>
    </form>
    <form name = "form0" action = "/Ren_Test/modifyServlet">
    <input type = "submit"  value = Delete>
       <input type = "hidden" name = actionCode value = "delete">
       <input type = "hidden" name = userId value = <%=user.getUserId()%>>
    </form>
  </body>
</html>