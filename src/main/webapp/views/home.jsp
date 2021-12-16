<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Вы успешно вошли</title>
</head>
<body>
<div style="text-align: center">
    <h1>Вы успешно вошли</h1>
    <b>${user.name} ${user.surname} (${user.login})</b>
    <br><br>

    <form action="views/logout.jsp" target="_blank">
        <button>Выйти</button>
    </form>
</div>
</body>
</html>
