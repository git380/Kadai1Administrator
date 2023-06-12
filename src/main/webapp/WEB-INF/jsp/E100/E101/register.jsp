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
    <label for="empPasswd">パスワード:</label>
    <input type="password" id="empPasswd" name="empPasswd"><br>
    <label>ロール:</label>
    <input type="radio" id="receptionist" name="empRole" value="1">
    <label for="receptionist">受付</label>
    <input type="radio" id="doctor" name="empRole" value="2">
    <label for="doctor">医師</label><br>
    <input type="submit" value="登録" disabled>
</form>
<script>
    const inputs = document.querySelectorAll('input[type=text], input[type=password], input[type=radio]');
    const submitButton = document.querySelector('input[type=submit]');
    Array.from(inputs).forEach(input => {
        input.addEventListener('change', () => {
            submitButton.disabled = Array.from(inputs).some(input => !input.value) || !Array.from(document.querySelectorAll('input[type=radio]:checked')).length;
        });
    });
</script>
</body>
</html>
