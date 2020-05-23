<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/4/27
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>文件列表</title>
</head>
<body>
<h2>文件列表</h2>
<c:if test="${not empty files}">
    <ul>
        <c:forEach items="${files}" var="f">
            <li><a href="${pageContext.request.contextPath}/file/download?fileName=${f.name}">${f.name}</a></li>
        </c:forEach>
    </ul>
</c:if>
</body>
</html>
