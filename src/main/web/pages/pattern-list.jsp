<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Pattern list</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/web-patterns-mp" method="get">
    <input type="hidden" name="action" value="logout">
    <input type="submit" value="logout">
</form>

<div align="center">
    Data : ${sessionScope.data}
</div>

<div align="center">
    <h1>Web patterns</h1>
    <h2>
        <a href="${pageContext.request.contextPath}/pages/add-article.jsp">Add New Article</a>

        <a href="${pageContext.request.contextPath}/">Get Article List</a>
    </h2>
</div>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Articles</h2></caption>
        <tr>
            <th>Pattern name</th>
            <th>Author email</th>
            <th>Edit</th>
            <th>Remove</th>
        </tr>
        <jsp:include page="for_each_pattern_list.jsp" />
    </table>
</div>
</body>
</html>
