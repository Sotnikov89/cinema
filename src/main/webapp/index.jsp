<%@ page contentType="text/html; charset=UTF-8" %>
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
            var boxCount = $("input[type=checkbox]:checked").length
            if (boxCount === 0) {
            alert("Пожалуйста, выберите место прежде чем перейти к оплате");
            return false;
            }
        }
        function getPlaces() {
            $.ajax({
                type: 'GET',
                crossdomain: true,
                url: 'http://localhost:8080/cinema/ticket',
                dataType: 'json',
            }).done(function(data) {
                for (let i=0; i<data.length; i++){
                    var placeNumber = data[i].row + '.' + data[i].cell;
                    var input = document.getElementById(placeNumber);
                    input.disabled = true;

                    var label = input.closest('label');
                    label.className = "btn btn-success disabled";
                    label.title = "Занято";
                }
            }).fail(function(err){
                alert(err);
            });
        }
        $(document).ready(function(){
            getPlaces();
            setInterval('getPlaces()',5000);
        });
    </script>
</head>
<body>
<form action="http://localhost:8080/cinema/payment" method="get">
<div class="container">
    <div class="row pt-3">
        <h4>
            Бронирование места на сеанс
        </h4>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th colspan="6" class="bg-secondary text-center">Экран</th>
            </tr>
            </thead>
            <tbody class="text-center">
            <tr>
                <td><label class="btn btn-success" title="1 ряд, 1 место"><input type="checkbox" name="place" id="1.1" value="1.1"></label></td>
                <td><label class="btn btn-success" title="1 ряд, 2 место"><input type="checkbox" name="place" id="1.2" value="1.2"></label></td>
                <td><label class="btn btn-success" title="1 ряд, 3 место"><input type="checkbox" name="place" id="1.3" value="1.3"></label></td>
                <td><label class="btn btn-success" title="1 ряд, 4 место"><input type="checkbox" name="place" id="1.4" value="1.4"></label></td>
                <td><label class="btn btn-success" title="1 ряд, 5 место"><input type="checkbox" name="place" id="1.5" value="1.5"></label></td>
                <td><label class="btn btn-success" title="1 ряд, 6 место"><input type="checkbox" name="place" id="1.6" value="1.6"></label></td>
            </tr>
            <tr>
                <td><label class="btn btn-success" title="2 ряд, 1 место"><input type="checkbox" name="place" id="2.1" value="2.1"></label></td>
                <td><label class="btn btn-success" title="2 ряд, 2 место"><input type="checkbox" name="place" id="2.2" value="2.2"></label></td>
                <td><label class="btn btn-success" title="2 ряд, 3 место"><input type="checkbox" name="place" id="2.3" value="2.3"></label></td>
                <td><label class="btn btn-success" title="2 ряд, 4 место"><input type="checkbox" name="place" id="2.4" value="2.4"></label></td>
                <td><label class="btn btn-success" title="2 ряд, 5 место"><input type="checkbox" name="place" id="2.5" value="2.5"></label></td>
                <td><label class="btn btn-success" title="2 ряд, 6 место"><input type="checkbox" name="place" id="2.6" value="2.6"></label></td>
            </tr>
            <tr>
                <td><label class="btn btn-success" title="3 ряд, 1 место"><input type="checkbox" name="place" id="3.1" value="3.1"></label></td>
                <td><label class="btn btn-success" title="3 ряд, 2 место"><input type="checkbox" name="place" id="3.2" value="3.2"></label></td>
                <td><label class="btn btn-success" title="3 ряд, 3 место"><input type="checkbox" name="place" id="3.3" value="3.3"></label></td>
                <td><label class="btn btn-success" title="3 ряд, 4 место"><input type="checkbox" name="place" id="3.4" value="3.4"></label></td>
                <td><label class="btn btn-success" title="3 ряд, 5 место"><input type="checkbox" name="place" id="3.5" value="3.5"></label></td>
                <td><label class="btn btn-success" title="3 ряд, 6 место"><input type="checkbox" name="place" id="3.6" value="3.6"></label></td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="row float-right">
        <button type="submit" class="btn btn-primary" onclick="return validate()">Оплатить</button>
    </div>
</div>
</form>
</body>
</html>