<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">


    <script type="text/javascript" src="<c:url value="/scripts/jquery-2.1.4.min.js"/>"></script>


    <script language="JavaScript">

        $(document).ready(function () {
            $('#myButton').click(function (e) {
                e.preventDefault();
                var textForPost = $('textarea').val();
                if (!textForPost) {
                    alert("Write down at least one symbol");
                    return false;
                }
                $.post("<c:url value="/posts"/>", {"post": textForPost}, function (response) {
                           /* $('#myButton').text("send").attr("disabled", false);*/
                            $('textarea#text').val('');
                            $('#Posts').append(
                                    "<div class=Username1>" +
                                    "<p>" + response.userName + "</p>" +
                                    "</div>" +
                                    "<div class='PostText1'>" +
                                    "<p>" + response.postText + "</p>" +
                                    "</div>" +
                                    "<div class='Time1'>" +
                                    "<span class='pull-left'>" +
                                    "Published time : " +
                                    "<p>" + response.pTime + "</p>" +
                                    "</span>" +
                                    "<div id='post_id' hidden>" + response.idq + "</div>" +
                                    "</div>"
                            )
                            ;
                            $("html,body").animate({scrollTop: $(document).height()}, "fast");
                        },
                        'json'
                )
            });
        });
    </script>

    <title>Посты юзеров</title>

    <style>

        #Posts {
            margin-left: 50pt;
            margin-top: 30pt;
            margin-bottom: 30pt;
        }
    </style>
</head>

<body>


<div id="Posts">


    <c:forEach items="${posts}" var="p">


        <h3><c:out value="${p.getUserName()}"/></h3>


        <p><c:out value="${p.getText()}"/></p>


        <span> <p> Published time : <br> <c:out value="${p.getPublishedTime()}"/></p> </span>


        <div id="post_id" hidden><c:out value="${p.getId()}"/></div>
    </c:forEach>
</div>

<br>

<div id="post">

    <form class="send-message" accept-charset="UTF-8" action="<c:url value=""/>" method="POST">

        <div class="form-group">
            <label class="well well-sm" for="text">Напишите что-нибудь</label>
                                <textarea spellcheck="false" style="resize: none" name="post" class="form-control"
                                          rows="5" id="text"></textarea>
        </div>

        <button type="submit" id="myButton" class="btn btn-block btn-success">Send</button>

    </form>

    <br>
    <br>

    <c:if test="${not empty message}">
        <p style="text-align: center; font-size: 14pt;">
            <c:out value="${message}"/>
        </p>
    </c:if>

</div>


</body>
</html>