<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Article</title>
</head>
<body>
<div align="center">
    <h1>Web patterns</h1>

    <h2>
        <a href="${pageContext.request.contextPath}/pages/add-article.jsp">Add New Article</a>

        <a href="${pageContext.request.contextPath}/">Get Article List</a>
    </h2>
</div>

<div align="center" itemscope itemtype="http://schema.org/Article">

    <c:if test="${articleDto == null}">

    <form action="${pageContext.request.contextPath}/add-article" method="post">

    </c:if>

    <c:if test="${articleDto != null}">

    <form action="${pageContext.request.contextPath}/update-article" method="post">
        <input type="hidden" name="updatableName" value="${articleDto.headerDto.patternName}">
        <input type="hidden" name="updatableEmail" value="${articleDto.headerDto.authorEmail}">
    </c:if>

        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:choose>
                        <c:when test="${articleDto != null}">Edit Article</c:when>
                        <c:when test="${articleDto == null}">Add Article</c:when>
                    </c:choose>
                </h2>
            </caption>
            <tr>
                <th>Pattern Name:</th>
                <c:choose>
                    <c:when test="${articleDto == null}">
                        <td><input type="text" name="patternName" placeholder="Pattern Name" size="50"/></td>
                    </c:when>
                    <c:when test="${articleDto != null}">
                        <td>
                            <span itemprop="name">
                                <input type="text" name="patternName" placeholder="Pattern Name" size="50" value="${articleDto.headerDto.patternName}"/>
                            </span>
                        </td>
                    </c:when>
                </c:choose>
            </tr>
            <tr>
                <th>Author Email:</th>
                <c:choose>
                    <c:when test="${articleDto == null}">
                        <td><input type="text" name="authorEmail" placeholder="Author Email" size="50"/></td>
                    </c:when>
                    <c:when test="${articleDto != null}">
                        <td>
                            <span itemprop="creator">
                                <input type="text" name="authorEmail" placeholder="Author Email" size="50" value="${articleDto.headerDto.authorEmail}"/>
                            </span>
                        </td>
                    </c:when>
                </c:choose>
            </tr>
            <tr>
                <th>Content:</th>
                <c:choose>
                    <c:when test="${articleDto == null}">
                        <td><textarea name="content" rows="35" cols="50" ></textarea></td>
                    </c:when>
                    <c:when test="${articleDto != null}">
                        <td>
                            <span itemprop="text">
                                <textarea name="content" rows="35" cols="50">${articleDto.contentDto.body}</textarea>
                            </span>
                        </td>
                    </c:when>
                </c:choose>
            </tr>
            <tr>
                <th>Description:</th>
                <c:choose>
                    <c:when test="${articleDto == null}">
                        <td><textarea name="description" rows="10" cols="50" ></textarea></td>
                    </c:when>
                    <c:when test="${articleDto != null}">
                        <td>
                            <span itemprop="description">
                                <textarea name="description" rows="10" cols="50">${articleDto.contentDto.description}</textarea>
                            </span>
                        </td>
                    </c:when>
                </c:choose>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <c:choose>
                        <c:when test="${articleDto == null}">
                            <input type="submit" value="Add Article">
                        </c:when>
                        <c:when test="${articleDto != null}">
                            <input type="submit" value="Update Article">
                        </c:when>
                    </c:choose>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
