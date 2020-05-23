<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/3/29
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index</title>
    <link rel="stylesheet" href="css/main.css">
    <script src="js/main.js" type="text/javascript"></script>
  </head>
  <body>
  <div>
       <a href="${pageContext.request.contextPath}/prd/list">获取商品信息</a>
       <br>
       <a href="${pageContext.request.contextPath}/cst/list">查看顾客列表</a>
       <br>
       <a href="${pageContext.request.contextPath}/prd/add">添加商品信息</a>
       <br>
       <a href="${pageContext.request.contextPath}/cst/add">添加顾客信息</a>
       <br>
      <a href="${pageContext.request.contextPath}/prd/test">测试</a>
      <br>
      <a href="${pageContext.request.contextPath}/prd/add_ajax.jsp">AJAX录入新商品</a>
      <br>
      <a href="${pageContext.request.contextPath}/file/upload.jsp">文件上传</a>
      <br>
      <a href="${pageContext.request.contextPath}/file/list">文件列表</a>
      <br>
       </div>
       <button onclick="show()">test</button>
       <img src="${pageContext.request.contextPath}/img/kebiao.png" alt="课表"/>
  </body>
</html>
