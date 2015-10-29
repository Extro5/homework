// тест ajax, button onclick setText..

$(document).ready(function () {
    $("#btn1").click(function () {
        $.getJSON('ajax/testjson.json', {}, function (json) {
            $("#txt1").html('');
            // заполняем DOM элемент данными из JSON объекта
            $("#txt1").append(""+json.One + '<br/>')
                .append("" +json.Two + '<br/>')

        })
    })

});