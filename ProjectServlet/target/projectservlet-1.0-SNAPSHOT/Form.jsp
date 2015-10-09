<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title> Welcome </title>
</head>


<body>
<fmt:requestEncoding value="windows-1251"></fmt:requestEncoding>
<c:if test="${not empty message}">
    <h3>${message}</h3>
</c:if>
<form method="POST" action="/serv">
  <p>
    Введите своё ФИО: &nbsp; <input type="text" name="username" size="40">

  </p>
    <div id="errors">
        <c:if test="${not empty UsernameError}">
            ${UsernameError}
        </c:if>
    </div>
  <p>
    Введите свой email:   <input type="email" name="email"  size="40"> пароль:  <input type="password" name="password" size="20">
  </p>

    <div id="errors1">
        <c:if test="${not empty EmailError}">
            ${EmailError}
        </c:if>
    </div>
    <div id="errors3">
        <c:if test="${not empty PasswordError}">
            ${PasswordError}
        </c:if>
    </div>
  <p>
    Укажите свой пол: &nbsp;
    Мужской <input type="radio" name="sex" value="male">
    Женский <input type="radio" name="sex" value="female">
  </p>
  <p>
    Соглашение на подписку: &nbsp;
    <input type="checkbox" name="lan" value="agree" checked>
  </p>
  <p>
    <input type="submit" value="Клик" name="B1">
  </p>
</form>
</body>
</html>