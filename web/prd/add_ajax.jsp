<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/4/27
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add_ajax录入新商品</title>
    <script type="text/javascript" src="../jq/jquery-1.11.2.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#btnSubmit").click(function () {
                console.info("hello");
                var prdName=$("#prdName").val();
                var typeId=$("#typeId").val();
                var price=$("#privce").val();
                var desc=$("#desc").val();

                var data={};
                data.prdName=prdName;
                if(typeId && typeId>0){
                    data.typeId=typeId;
                }
                data.desc=desc;
                data.price=price;


                $.ajax({
                    url:'${pageContext.request.contextPath}/prd/ajax/add',
                    data:JSON.stringify(data),
                    contentType:'application/json',
                    dataType:'json',
                    success:function (resp) {
                        console.info(resp);
                    },
                    method:'POST'
                });
            })
        })
    </script>
</head>
<body>
      <h2>录入新商品</h2>
      <div>
          商品名：<input type="text" name="prdName" id="prdName"><br>
          类型：<select id="typeId" name="typeId">
          <option value="0">请选择类别</option>
          <option value="1">Book</option>
          <option value="2">Video</option>
          <option value="3">DVD</option>
          <option value="4">CD</option>
          <option value="5">Magazine</option>
                </select><br>
          价格：<input type="text" name="price" id="price"><br>
          描述：<textarea name="desc" id="desc" cols="30" rows="5"></textarea><br>
          <button id="btnSubmit" type="button">提交</button>
      </div>
</body>
</html>
