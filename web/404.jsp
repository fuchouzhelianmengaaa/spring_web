<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/5/6
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>系统故障</title>
</head>
<body>
<h2>系统故障</h2>
系统出问题了：${ex.message}${exception}
<%
    out.print("异常信息："+exception.getMessage());
%>
</body>
</html>
