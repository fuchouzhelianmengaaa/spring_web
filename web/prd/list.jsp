<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/3/29
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
<H2>商品列表</H2>
<c:if test="${not empty prdList}">
    <table>
       <thead>
        <tr>
            <td>编号</td>
            <td>类别</td>
            <td>名称</td>
            <td>描述</td>
            <td>价格</td>
            <td>操作</td>
        </tr>
       </thead>
        <tbody>
             <c:forEach items="${prdList}" var="p">
                 <tr>
                     <td>${p.prdId}</td>
                     <td>${p.typeId}</td>
                     <td>${p.prdName}</td>
                     <td>${p.desc}</td>
                     <td>${p.price}</td>
                     <td>
                         <a href="${pageContext.request.contextPath}/prd/edit/${p.prdId}">编辑</a>
                     </td>
                 </tr>
             </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>
