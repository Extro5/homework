/*
 $.post({
 url: "/serv",
 type: "POST",
 data: data,
 success: success,
 dataType: dataType
 });
 */


$(document).ready(function () {
    $("#lol3").click(function () {

        $.ajax({
            type: "POST",
            url: "/serv",
            data: data, // указывает свои параметры
            success: success  // ф-ия котора явыполниться получив ответ
            //dataType: dataType
        });

    })

});