<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Form Registration </title>
    <meta http-equip="Content-Type" content="text/html; charset= UTF-8">
    <style type="text/css">
        body {
            background-color: gray;
        }

        #Form {
            margin: 15%;
            text-align: center;

        }

        .errors {
            color: #7c0002;

        }
    </style>
    <script language=JavaScript type="text/javascript" src="count.js">

    </script>
</head>

<c:if test="${not empty RepeatError}">
    ${RepeatError}
</c:if>
<body>
<fmt:requestEncoding value="windows-1251"></fmt:requestEncoding>


<form method="POST" action="/serv">

    <div id="Form">

        <h2> Регистрация </h2>

        <div class="block1">
            <p> Введите своё Имя: &nbsp; <input type="text" name="username" size="40" placeholder="Username"></p>
        </div>

        <div class="errors">
            <c:if test="${not empty UsernameError}">
                ${UsernameError}
            </c:if>
        </div>

        <p> Введите свой email: <input type="email" name="email" size="40" placeholder="Email"></p>

        <div class="errors">
            <c:if test="${not empty EmailError}">
                ${EmailError}
            </c:if>
        </div>

        <p> Введите свой пароль: <input type="password" name="password" size="20" placeholder="Password"></p>


        <div class="errors">
            <c:if test="${not empty PasswordError}">
                ${PasswordError}
            </c:if>
        </div>

        <p>
            Укажите свой пол: &nbsp;
            Мужской <input type="radio" name="sex" value="male" title="">
            Женский <input type="radio" name="sex" value="female" title="">
        </p>

        <p>

            Соглашение на подписку: &nbsp;
            <input type="checkbox" name="lan" value="agree" checked title="">
        </p>

        <p>Comment<br>
            <textarea name="comment" id="textarea" onclick="length_check(50, 'textarea', 'counter')"
                      onkeyup="length_check(50, 'textarea', 'counter')" cols="40" rows="3" title=""></textarea>
        </p>
        Max symbols: <span id="counter">50 / 50</span>

        <p>
            <input type="submit" value="Зарегистрироваться" name="B1">
        </p>
    </div>
</form>

<form method="GET" action="/login">
    <p>
        <input type="submit" value="Log in" name="B1">
    </p>
</form>
</body>
</html>