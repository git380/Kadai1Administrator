<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>従業員更新</title>
</head>
<body>
<h1>従業員更新</h1>
<form action="EmployeeUpdateServlet" method="post">
  <input type="hidden" name="empId" value="${empId}">
  姓:<input type="text" name="lastName"><br>
  名:<input type="text" name="firstName"><br>
  <input type="submit" value="変更確認">
</form>
</body>
</html>
