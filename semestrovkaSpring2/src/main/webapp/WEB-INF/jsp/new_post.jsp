<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<t:main_layout title="Посты">


    <div class="row">
        <div class="box">
            <div class="col-lg-12">
                <hr>
                <h2 class="intro-text text-center">
                    <strong> <spring:message code="New.post"/> </strong>
                </h2>
                <hr>

                <div class="text-center">
                    <c:if test="${not empty message}">
                        <h3>${message}</h3>
                    </c:if>
                </div>


                <form:form method="POST" commandName="userPost">
                    <br>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-4 text-center">
                            <form:label path="topic"><spring:message code="Enter.your.theme"/></form:label>
                            <form:input path="topic"/>
                            <form:errors path="topic"/><br>
                        </div>
                    </div>
                    <br>

                    <br>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-4 text-center">
                            <form:label path="tag"><spring:message code="Enter.your.tag"/></form:label>
                            <form:input path="tag"/>
                            <form:errors path="tag"/><br>
                        </div>
                    </div>
                    <br>

                    <br>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-4 text-center">
                            <form:label path="description"><spring:message code="Enter.description.idea"/></form:label>
                            <form:textarea path="description" rows="8" cols="40"/>
                            <form:errors path="description"/><br>
                        </div>
                    </div>

                    <div class="col-md-offset-4 col-md-4 text-center">
                        <button type="submit" class="btn btn-success"><spring:message code="Send"/></button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</t:main_layout>


