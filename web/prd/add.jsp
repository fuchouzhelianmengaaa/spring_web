<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/4/12
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>追加商品</title>
</head>
<body>
    <h2>追加商品</h2>
    <form:form action="${pageContext.request.contextPath}/prd/add" method="post" modelAttribute="productInfo">
        商品名称 ：<input type="text" name="prdName"/><br>
        类别：<select name="typeId" id="typeId">
            <option value="0">请选择类别</option>
        <c:if test="${ not empty typeList }">
            <c:forEach items="${typeList}" var="t">
                <option value="${t.typeId}">${t.typeName}</option>
            </c:forEach>
        </c:if>
        </select><br>
        描述：<textarea name="desc" id="desc" cols="30" rows="5"></textarea>
        <br>
        价格：<input type="text" name="price"/> <br>
        <button type="submit">提交</button>

        <br>
        <form:errors path="*"></form:errors>

    </form:form>

    ${param.msg}
<%--<c:if test="${not empty msgs}">
    <ul>
    <c:forEach items="${msgs}" var="m">
        <li>${m}</li>
    </c:forEach>
    </ul>
</c:if>--%>
</body>
</html>
