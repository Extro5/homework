<%@tag description="Default Layout Tag" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@attribute name="title" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>
        <c:if test="${not empty title}"> ${title}</c:if>
    </title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/business-casual.css"/>">


    <!-- Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
          rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic"
          rel="stylesheet" type="text/css">


</head>
<body>
<div class="page-wrapper">

    <div class="text-right">
        <a href='${s:mvcUrl("TC#change").arg(0, "ru_RU").build()}'>Рус</a>
        <a href='${s:mvcUrl("TC#change").arg(0, "en_US").build()}'>Eng</a>
    </div>


    <div class="brand"> The new idea is already close</div>
    <div class="address-bar">Semester work | On Spring | KPFU 2016</div>
    <!-- Navigation -->
    <nav class="navbar navbar-default" role="navigation">
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="<c:url value="/pagination"/>"><spring:message code="pagination"/></a>
                </li>

                <li>
                    <a href="<c:url value="/idea"/>"><spring:message code="home"/></a>
                </li>

                <li>
                    <a href="<c:url value="/post"/>"><spring:message code="New.post"/></a>
                </li>

                <li>
                    <a href="<c:url value="/about"/>"><spring:message code="About"/></a>
                </li>

                <li class="lol">
                    <a href="<c:url value="/login"/>"><spring:message code="Log.in"/></a>
                </li>

                <li class="lol">
                    <a href="<c:url value="/signup"/>"><spring:message code="Sign.up"/></a>
                </li>

                <li class="lol">
                    <a href="<c:url value="/logout"/>"><spring:message code="Log.out"/></a>
                </li>

            </ul>
        </div>
    </nav>

    <div class="container">
        <jsp:doBody/>
    </div>
</div>


<div class="page-footer">
    <footer>
        <div class=footerbottom>
            <div class="text-center">
                <p>Copyright &copy; Goodnewidea.com 2016</p>
            </div>
        </div>
    </footer>
</div>
</body>
</html>