<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>他病院登録</title>
</head>
<body>
<h1>他病院登録</h1>
<form action="HospitalRegistrationServlet" method="post">
    <label for="tabyouinid">他病院ID:</label>
    <input type="text" id="tabyouinid" name="tabyouinid"><br>
    <label for="tabyouinmei">他病院名:</label>
    <input type="text" id="tabyouinmei" name="tabyouinmei"><br>
    <label for="tabyouinaddres">他病院住所:</label>
    <input type="text" id="tabyouinaddres" name="tabyouinaddres"><br>
    <label for="tabyouintel">他病院電話番号:</label>
    <input type="text" id="tabyouintel" name="tabyouintel"><br>
    <label for="tabyouinshihonkin">資本金:</label>
    <input type="number" id="tabyouinshihonkin" name="tabyouinshihonkin"><br>
    <label for="kyukyu">救急対応:</label>
    <select id="kyukyu" name="kyukyu">
        <option value="0">なし</option>
        <option value="1">あり</option>
    </select><br>
    <input type="submit" value="登録">
</form>
</body>
</html>
