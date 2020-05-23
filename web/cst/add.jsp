<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/4/12
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>追加客户</title>
    <form action="${pageContext.request.contextPath}/cst/add" method="post">
        Frist Name:<input type="text" name="firstName"/> Last Name:<input type="text" name="lastName"/><br>
        出生日期：<input type="text" name="dob"><br>
        电话：<input type="text" name="phone"/><br>
        <button type="submit">提交</button>
    </form>
    ${msg}
</head>
<body>

</body>
</html>
