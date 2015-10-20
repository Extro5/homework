<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equip="Content-Type" content="text/html; charset= UTF-8">
    <title>Profile</title>


</head>
<body>

<fmt:requestEncoding value="UTF-8"/>
<h2>Welcome <span style="font-size: x-large; "> &nbsp; ${Username}  </span></h2>
Email: ${Email} <br>
Password: ${Password}<br>
Sex: ${Sex}<br>
Subscribe: ${lol1}<br>
Comment: ${Comment}<br>


<form action="/logout" method="get">
    <input type="submit" value="quit"/>
</form>
</body>
</html>
