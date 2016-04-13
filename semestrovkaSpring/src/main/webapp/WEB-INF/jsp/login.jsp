<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<t:mainLayout title="Вход">


    <c:if test="${not empty message}">
        <h1>${message}</h1>
    </c:if>

    <div class="row">
        <div class="box">
            <div class="col-lg-12">
                <hr>
                <h2 class="intro-text text-center">
                    <strong> <spring:message code="Log.in"/> </strong>
                </h2>
                <hr>
                <br>

                <form:form method="POST" commandName="userLogin">
                    <br>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-4 text-center">
                            <form:label path="email"><spring:message code="Enter.email.you"/></form:label>
                            <form:input path="email"/>
                            <form:errors path="email"/><br>
                        </div>
                    </div>
                    <br>

                    <br>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-4 text-center">
                            <form:label path="password"><spring:message code="Enter.your.password"/></form:label>
                            <form:input path="password"/>
                            <form:errors path="password"/><br>
                        </div>
                    </div>
                    <br>
                    <br>
                    <br>
                    <div class="col-md-offset-4 col-md-4 text-center">
                        <button type="submit" class="btn btn-success"> <spring:message code="Send"/></button>
                    </div>
                    <br><br><br><br>
                </form:form>
            </div>
        </div>
    </div>
</t:mainLayout>