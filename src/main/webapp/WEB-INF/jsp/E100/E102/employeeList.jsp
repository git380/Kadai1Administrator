<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>従業員一覧</title>
</head>
<body>
<h1>従業員一覧</h1>
<table>
    <tr>
        <th>従業員ID</th>
        <th>姓</th>
        <th>名</th>
        <th></th>
    </tr>
    <c:forEach var="employee" items="${employeeList}">
        <tr>
            <td>${employee.empId}</td>
            <td>${employee.empLname}</td>
            <td>${employee.empFname}</td>
            <td>
                <form action="EmployeeSearchServlet" method="post">
                    <input type="hidden" name="empId" value="${employee.empId}">
                    <input type="submit" value="変更">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
