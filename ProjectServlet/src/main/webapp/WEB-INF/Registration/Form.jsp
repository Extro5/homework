<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Форма Регистрации </title>
    <meta http-equip="Content-Type" content="text/html; charset= UTF-8">
    <link rel='stylesheet' href='<c:url value="/css/bootstrap.min.css"/>' type='text/css' media='all'>
    <style type="text/css">
        body {
            background-color: #c9d2d0;
        }

        #Form {
            margin: 5%;
            text-align: center;

        }

        #lol1 {
            margin-bottom: 20pt;
        }

        #lol2 {
            text-align: right;
            margin-top: 12px;
            margin-right: 15pt;
        }

        .errors {
            color: #7c0002;
            text-align: center;
            font-size: 20pt;

        }

        #lol3 {
        margin-top: 10pt;
        }

        .form-group {
            text-align: center;
        }
    </style>
    <script language=JavaScript type="text/javascript" src="count.js">

    </script>
</head>


<body>
<fmt:requestEncoding value="UTF-8"/>


<form action="<c:url value="/login"/>" method="get">

    <div id="lol2">
        <button type="submit" class="btn btn-success">Залогиниться</button>
    </div>

</form>

<div class="col-md-offset-4 col-md-4">
    <div class="errors">
        <%--@elvariable id="UsernameError" type="servlets"--%>
        <c:if test="${not empty UsernameError}">
            ${UsernameError}
        </c:if>
    </div>
    <div class="errors">
        <%--@elvariable id="EmailError" type="servlets"--%>
        <c:if test="${not empty EmailError}">
            ${EmailError}
        </c:if>
    </div>
    <div class="errors">
        <%--@elvariable id="PasswordError" type="servlets"--%>
        <c:if test="${not empty PasswordError}">
            ${PasswordError}
        </c:if>
    </div>
    <%--@elvariable id="RepeatError" type="servlets"--%>
    <c:if test="${not empty RepeatError}">
        ${RepeatError}
    </c:if>

</div>
<form id="form" role="form" action="<c:url value="/serv"/>" method="post">


    <div class="col-md-offset-4 col-md-4">
        <h2 id="lol1">Регистрация</h2>
    </div>

    <div class="form-group">
        <div class="col-md-offset-4 col-md-4">
            <label for="text">Введите свое имя:</label>
            <input type="text" class="form-control" id="text" name="username" placeholder="Введите Имя">

            <p class="help-block">Имя по паспорту</p>
        </div>
    </div>


    <div class="form-group">
        <div class="col-md-offset-4 col-md-4">
            <label for="email">Введите свой email: </label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Введите email">

            <p class="help-block"> Корректный email</p>
        </div>
    </div>

    <div class="form-group">
        <div class="col-md-offset-4 col-md-4">
            <label for="pass"> Пароль:</label>
            <input type="password" class="form-control" id="pass" name="password" placeholder="Пароль">

            <p class="help-block">Введите ваш пароль</p>
        </div>
    </div>
    <div class="col-md-offset-4 col-md-4">
        <b>Укажите свой пол: &nbsp; </b>
        <label class="radio-inline"><input type="radio" name="sex" value="male"><b>Мужской</b></label>
        <label class="radio-inline"><input type="radio" name="sex" value="female"><b>Женский</b></label>
    </div>

    <div class="col-md-offset-4 col-md-4">
        Соглашение на подписку: <input type="checkbox" name="lan" value="agree" checked title=""><label
            class="checkbox-inline"></label>
    </div>

    <div class="col-md-offset-4 col-md-4">
        <div class="form-group">
            <%--@declare id="comment"--%><label for="comment">Comment:</label>
        <textarea class="form-control" name="comment" id="textarea" placeholder="Напишите что-нибудь о себе"
                  onclick="length_check(50, 'textarea', 'counter')"
                  onkeyup="length_check(50, 'textarea', 'counter')" rows="3" cols="40"></textarea>

        </div>
    </div>


    <div class="col-md-offset-4 col-md-4">
        Max symbols: <span id="counter">50 / 50</span>
    </div>


    <div id="lol3" class="col-md-offset-4 col-md-4">
        <button type="submit" class="btn btn-success">Зарегистрироваться</button>
    </div>

</form>


</body>
</html>