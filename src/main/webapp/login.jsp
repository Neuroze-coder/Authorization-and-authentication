<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Страница входа</title>
</head>
<script
        src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
<script type="text/javascript"
        src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>

<body>
<div style="text-align: center">
    <h1>Войти</h1>
    <form action="login" method="post">
        <label for="login">Login:</label>
        <input name="login" size="30"/>
        <br><br>
        <label for="password">Password:</label>
        <input type="password" name="password" size="30"/>
        <br>${message}
        <br><br>
            <button type="submit">Войти</button>
    </form>
    <form action="registration.jsp" target="_blank">
        <button>Регистрация</button>
    </form>
</div>
</body>
<script type="text/javascript">

    $(document).ready(function () {
        $("#loginForm").validate({
            rules: {
                username: {
                    required: true,
                    username: true
                },

                password: "required",
            },

            messages: {
                username: {
                    required: "Please enter email",
                    username: "Please enter a valid email address"
                },

                password: "Please enter password"
            }
        });

    });
</script>
</html>
