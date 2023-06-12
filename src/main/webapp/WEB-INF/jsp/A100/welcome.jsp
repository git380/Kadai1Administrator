<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>管理者画面</title>
</head>
<body>
<h1>ようこそ!管理者画面です。</h1>
<ul>
    <c:if test="${empty sessionScope.empId}">
        <li><a href="/Kadai1Administrator/LoginServlet">ログイン</a></li>
    </c:if>
    <c:if test="${not empty sessionScope.empId}">
        <li><a href="/Kadai1Administrator/LogoutServlet">ログアウト</a></li>
        <li><a href="/Kadai1Administrator/PwChangeServlet">パスワードの変更</a></li>
        <li><a href="/Kadai1Administrator/RegisterServlet">従業員登録</a></li>
        <li><a href="/Kadai1Administrator/EmployeeSearchServlet">従業員氏名変更</a></li>
        <li><a href="/Kadai1Administrator/HospitalRegistrationServlet">他病院登録</a></li>
        <li><a href="/Kadai1Administrator/HospitalSearchServlet">他病院住所検索</a></li>
    </c:if>
</ul>
</body>
</html>