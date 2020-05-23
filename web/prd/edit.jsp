<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/4/30
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>编辑商品</title>
</head>
<body>
<h2>编辑商品信息</h2>
<form:form method="post" action="${pageContext.request.contextPath}/prd/edit" modelAttribute="productInfo">
     商品编号：<input type="text" name="prdId" value="${productInfo.prdId}" readonly><form:errors path="prdId"></form:errors><br>
     商品名称：<input type="text" name="prdName" value="${productInfo.prdName}"><br>
    类别：<select>
    <option value="0">请选择类别</option>
    <c:if test="${ not empty typeList }">
        <c:forEach items="${typeList}" var="t">
            <option value="${t.typeId}" <c:if test="${t.typeId==productInfo.typeId}">selected</c:if>>${t.typeName}</option>
        </c:forEach>
    </c:if>
</select><br>
    商品描述：<textarea name="desc" id="desc" cols="30" rows="4">${productInfo.desc}</textarea><form:errors path="desc"></form:errors><br>
    价格:<input type="text" name="price" value="${productInfo.price}"><form:errors path="price"></form:errors> <br>
    <button type="submit">提交</button>
</form:form>

</body>
</html>
