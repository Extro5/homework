<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery..."></script>
  <script type="text/javascript">
    var msg;

    function ValidFirstName() {
      var re = /^[A-zА-яЁё]{3,32}$/;
      var myName = document.getElementById('firstName').value;
      var valid = re.test(myName);
      if (valid) output = '';
      else output = 'Имя введено неправильно! ';
      msg+=output;
      return valid;
    }

    function ValidLastName() {
      var re = /^[A-zА-яЁё]{3,32}$/;
      var myName = document.getElementById('lastName').value;
      var valid = re.test(myName);
      if (valid) output = '';
      else output = 'Фамилия введена неправильно!';
      msg+=output;
      return valid;
    }

    function ValidAccountNumber() {
      var re = /^[A-Za-z][A-Za-z0-9]{0,31}[0-9]{4}$/;
      var myMail = document.getElementById('accNum').value;
      var valid = re.test(myMail);
      if (valid) output = '';
      else output = 'Номер счёта введен неправильно!';
      msg+=output;
      return valid;
    }

    function WriteJSONObject() {
      if (ValidFirstName()&ValidLastName()&ValidAccountNumber()) {
        var cart = {
          "firstName": document.getElementById('firstName').value,
          "lastName": document.getElementById('lastName').value,
          "accNum": document.getElementById('accNum').value
        };
        var jsonString = JSON.stringify(cart);
        $.ajax({
          type: 'POST',
          dataType: 'json',
          url: 'http://localhost:8080/Servlet/',
          data: jsonString,
        });
        alert('Successfully Sended!');
      } else {
        alert (msg)
        clearMsg();
      }
    }

    function clearMsg() {
      msg="";
    }
  </script>
</head>
<body>

<p id="message" >Пожалуйста, заполните все поля формы!</p>

<form action="javascript:void(null);" method="post" id="mainForm">
  Name: <input id="firstName" name="firstName" type="text" size="20" /><br />
  LastName: <input id="lastName" name="lastName" type="text" size="20" /><br />
  AccountNumber: <input id="accNum" name="accountNumber" type="text" size="20" /><br />
  <input name="button" type="submit" value="Отправить" onClick="WriteJSONObject()" />
</form>

</body>
</html>