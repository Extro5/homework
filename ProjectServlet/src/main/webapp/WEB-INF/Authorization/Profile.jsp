<%--@elvariable id="Comment" type="servlets"--%>
<%--@elvariable id="Subscribe" type="servlets"--%>
<%--@elvariable id="Sex" type="servlets"--%>
<%--@elvariable id="Password" type="servlets"--%>
<%--@elvariable id="Email" type="servlets"--%>
<%--@elvariable id="Username" type="servlets"--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Профиль </title>
    <meta http-equip="Content-Type" content="text/html; charset= UTF-8">
    <link rel='stylesheet' href='<c:url value="/css/bootstrap.min.css"/>' type='text/css' media='all'>


    <style type="text/css">
        #form {
            text-align: right;
            padding: 10pt;
        }

        body {
            background-color: #c9d2d0;
        }

        .container {
            margin-top: 100pt;

        }

        .table-user-information > tbody > tr {
            border-top: 1px solid rgb(221, 221, 221);
        }

        .table-user-information > tbody > tr:first-child {
            border-top: 0;
        }

        .table-user-information > tbody > tr > td {
            border-top: 0;
        }

        .toppad {
            margin-top: 20px;
        }

    </style>

</head>


<body>

<form id="form" role="form" action="<c:url value="/logout"/>" method="get">
    <button type="submit" class="btn btn-success">Выйти</button>
</form>

<form id="form1" role="form" action="<c:url value="/posts"/>" method="get">
    <button type="submit" class="btn btn-success">Посты</button>
</form>


<div class="container">
    <div class="row">

        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">


            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">Приветствую ${Username} </h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-3 col-lg-3 " align="center"><img alt="User Pic"
                                                                            src="<c:url value="/resources/mem.jpg"/>"
                                                                            class="img-circle img-responsive"></div>


                        <div class=" col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>
                                <tr>
                                    <td>Email:</td>
                                    <td>${Email}</td>
                                </tr>
                                <tr>
                                    <td>Пароль:</td>
                                    <td>${Password}</td>
                                </tr>
                                <tr>
                                    <td>Пол:</td>
                                    <td>${Sex}</td>
                                </tr>

                                <tr>
                                <tr>
                                    <td>Подписка:</td>
                                    <td>${Subscribe}</td>
                                </tr>
                                <tr>
                                    <td>О себе:</td>
                                    <td>${Comment}</td>
                                </tr>


                                </tbody>
                            </table>


                        </div>
                    </div>
                </div>


            </div>
        </div>
    </div>
</div>
</body>
</html>
