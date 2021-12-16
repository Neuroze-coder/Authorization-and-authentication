<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Страница регистрации</title>
</head>
<body>
<div align="center">
    <h1>Страница регистрации</h1>
    <form action="<%= request.getContextPath() %>/registration" method="post">
        <table style="with: 80%">
            <tr>
                <td>Логин</td>
                <td><input type="text" name="login" /></td>
            </tr>
            <tr>
                <td>Имя</td>
                <td><input type="text" name="name" /></td>
            </tr>
            <tr>
                <td>Фамилия</td>
                <td><input type="text" name="surname" /></td>
            </tr>
            <tr>
                <td>Пароль</td>
                <td><input type="password" name="password" /></td>
            </tr>


        </table>
        <input type="submit" value="Зарегистрироваться" />
    </form>
</div>
</body>
</html>
