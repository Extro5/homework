<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="util" tagdir="/WEB-INF/tags/util" %>

<t:main_layout title="Pagination">

    <div class="text-center">
        <form action="<c:url value="/pagination"/>" method="get">
            <div id="inquiry">
                <input type="text" class="form-control" name="searchTerm" id="searchTerm"
                       placeholder="Укажите тему">
                <button type="submit" class="btn btn-success">Поиск</button>
            </div>
        </form>
    </div>

    <div class="text-center">
        <jsp:useBean id="page" scope="request" type="org.springframework.data.domain.Page"/>
        <c:forEach items="${page.getContent()}" var="pageList">
            <div class="row">
                <div class="box">
                    <div class="col-lg-12">
                        <hr>
                        <h4 class="text-center">
                            <strong> <c:out value="${pageList.topic}"></c:out> </strong>
                        </h4>
                        <hr>

                        <h6 class="text-left">
                            Опубликовал пользователь "<c:out value="${pageList.login}"></c:out>"
                        </h6>

                        <h6 class="text-center">
                            <c:out value="${pageList.tag}"></c:out>
                        </h6>
                        <br>
                        <div class="text-center">
                            <c:out value="${pageList.description}"></c:out>
                        </div>

                    </div>
                </div>
            </div>

        </c:forEach>

        <div class="row-fluid">
            <util:pagination thispage="${page}"></util:pagination>
        </div>


    </div>

</t:main_layout>