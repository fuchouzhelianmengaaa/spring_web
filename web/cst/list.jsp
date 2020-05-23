
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>顾客列表</h2>
<c:if test="${not empty cstList}">
    <table>
        <thead>
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>出生日期</th>
            <th>电话号码</th>
        </tr>
        </thead>
        <tbody>
           <c:forEach items="${cstList}" var="cst">
              <tr>
                  <td>${cst.customerId}</td>
                  <td>${cst.firstName} ${cst.lastName}</td>
                  <td>${cst.dob}</td>
                  <td>${cst.phone}</td>
              </tr>
           </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>
