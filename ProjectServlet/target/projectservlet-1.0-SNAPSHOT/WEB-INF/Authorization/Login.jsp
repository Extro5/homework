<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Логин</title>
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
            text-align: center;
            margin-bottom: 20pt;

        }

        #lol2 {
            text-align: right;
            margin-top: 12px;
            margin-right: 15pt;
        }
    </style>
</head>


<body>

<form action="<c:url value="/serv"/>" method="get">

    <div id="lol2">
        <button type="submit" class="btn btn-success">Зарегистрироваться</button>
    </div>

</form>


<form id="form" role="form" action="" method="post">
    <div class="col-md-offset-4 col-md-4">
        <h2 id="lol1">Залогиньтесь</h2>
    </div>
    <div class="form-group">
        <div class="col-md-offset-4 col-md-4">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="login" placeholder="Введите email">

            <p class="help-block">Введите email указанный при регистрации</p>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-offset-4 col-md-4">
            <label for="pass"> Пароль</label>
            <input type="password" class="form-control" id="pass" name="password" placeholder="Пароль">

            <p class="help-block">Введите ваш пароль</p>
        </div>
    </div>
    <div class="col-md-offset-4 col-md-4">
        <button type="submit" class="btn btn-success">Войти</button>
    </div>

</form>


</body>

</html>