<%--
  Created by IntelliJ IDEA.
  User: shund
  Date: 10.04.2018
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${requestScope.articleList}" var="articleHeader">
    <tr>
        <td><c:out value="${articleHeader.patternName}"/></td>
        <td><c:out value="${articleHeader.authorEmail}"/></td>
        <td>
            <form action=${pageContext.request.contextPath}/get-article>
                <input type="hidden" name="authorEmail" value="${articleHeader.authorEmail}"/>
                <input type="hidden" name="patternName" value="${articleHeader.patternName}"/>
                <input type="submit" value="Edit">
            </form>
        </td>
        <td>
            <form action=${pageContext.request.contextPath}/remove-article method="post">
                <input type="hidden" name="authorEmail" value="${articleHeader.authorEmail}"/>
                <input type="hidden" name="patternName" value="${articleHeader.patternName}"/>
                <input type="submit" value="Remove">
            </form>
        </td>
    </tr>
</c:forEach>
</body>
</html>
