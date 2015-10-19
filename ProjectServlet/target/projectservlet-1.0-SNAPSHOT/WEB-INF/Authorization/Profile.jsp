<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Profile</title>
</head>
<body>
<fmt:requestEncoding value="windows-1251"></fmt:requestEncoding>
<h2>Welcome <span style="font-size: x-large; ">Приветствую &nbsp; ${User} </span></h2>
<%=session.getAttribute("Username")%>
<%=request.getParameter("User")%>
<%=request.getParameter("Password")%>
<%=request.getParameter("Email")%>




<form action="/logout" method="get">
  <input type="submit" value="quit"/>
</form>
</body>
</html>
