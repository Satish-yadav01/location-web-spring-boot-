<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored ="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Display Location</title>
</head>
<body>
    <h2>Locations:</h2>
    <table>
    <tr>
        <th>id</th>
        <th>code</th>
        <th>name</th>
        <th>type</th>
    </tr>
    <c:forEach items="{location}" var="location">
    <tr>
    <td>${location.id}</td>
    <td>${location.code}</td>
    <td>${location.name}</td>
    <td>${location.type}</td>
    </tr>
    </c:forEach>
    </table>
</body>
</html>