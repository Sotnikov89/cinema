<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"
            integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <title>Cinema</title>
    <script>
        function validate() {
            if ($('#name').val() === "" || $('#phone').val() === "" || $('#email').val() === "") {
                alert("Пожалуйста, введите Ваше имя и номер телефона");
                return false;
            }
        }
    </script>
</head>
<body>
<div class="container">
    <div class="row pt-3">
        <h3>
            Вы выбрали:
            <c:forEach items="${places}" var="place">
                <c:out value="${place}"/>
            </c:forEach>
            <br>
            Сумма к оплате:
                <c:out value="${price}"/>
             рублей.
        </h3>
    </div>
    <div class="row">
        <form action="http://localhost:8080/cinema/payment" method="post">
            <div class="form-group">
                <label for="name">Имя</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Имя">
            </div>
            <div class="form-group">
                <label for="email">Почта</label>
                <input type="text" class="form-control" id="email" name="email"placeholder="Почта">
            </div>
            <div class="form-group">
                <label for="phone">Номер телефона</label>
                <input type="text" class="form-control" id="phone" name="phone" placeholder="Без кода и пробелов">
            </div>
            <button type="submit" class="btn btn-primary" onclick="return validate()">Оплатить</button>
        </form>
    </div>
</div>
</body>
</html>
