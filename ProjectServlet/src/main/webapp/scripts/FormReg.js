$(function () {
    $("#form").submit(function (event) {
        /* отключение стандартной отправки формы */

        event.preventDefault();

        var username = $("#username").val();
        var email = $("#email").val();
        var password = $("#password").val();
        var sex = $("#sex").val();
        var subscription = $("#subscription").val();
        var comment = $("#comment").val();
        $.ajax({
            type: "POST",
            url: "/serv",
            data: {
                "username": username,
                "email": email,
                "password": password,
                "sex": sex,
                "subscription": subscription,
                "comment": comment
            }
            // cache: false
            //success: function (response) {
            //    var messageResp = new Array('Ваше сообщение отправлено', 'Сообщение не отправлено Ошибка базы данных', 'Нельзя отправлять пустые сообщения');
            //    var resultStat = messageResp[Number(response)];
            //    if (response == 0) {
            //        $("#author").val("");
            //        $("#message").val("");
            //    }
            //    $("#resp").text(resultStat).show().delay(1500).fadeOut(800);
            //
            //}
        });
        //return false;

    });
});
