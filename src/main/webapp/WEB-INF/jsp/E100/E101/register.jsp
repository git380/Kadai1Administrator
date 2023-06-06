<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ユーザ登録</title>
</head>
<body>
<h1>ユーザ登録</h1>
<form action="RegisterServlet" method="post">
    <label for="empId">ユーザID:</label>
    <input type="text" id="empId" name="empId"><br>
    <label for="fName">名:</label>
    <input type="text" id="fName" name="fName"><br>
    <label for="lName">姓:</label>
    <input type="text" id="lName" name="lName"><br>
    <label for="emppasswd">パスワード:</label>
    <input type="password" id="emppasswd" name="emppasswd"><br>
    <label for="empRole">役割:</label>
    <input type="text" id="empRole" name="empRole"><br>
    <input type="submit" value="登録">
</form>
</body>
</html>
