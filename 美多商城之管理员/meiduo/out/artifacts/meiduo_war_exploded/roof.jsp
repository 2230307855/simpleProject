<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/11/24
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%--就是一个顶部导航栏页面--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>roof</title>
</head>
<link rel="stylesheet" href="css_style/roof.css">
<body>
<!--顶部栏设计-->
<div id="roof">
  <!--    之后div里要加上<span> 对跳转链接进行文本圆角框美化-->
  <div id="d1"></div>
  <div id="d2">
        <span id="bt1">
            <a href="http://localhost:8080/meiduo/visgoods">浏览商品</a>
            </span>
  </div>
  <div id="d3">
        <span id="bt2">
            <a href="addgoods.jsp">添加商品</a>
        </span>
  </div>
  <div id="d4">
        <span id="bt3">
           <a href="deletegoods.jsp">删除商品</a>
        </span>
  </div>
  <div id="d5">
        <span id="bt4">
            <a href="updategoods.jsp">更新商品</a>
        </span>
  </div>
  <div id="d6">
        <span id="bt5">
            <a href="http://localhost:8080/meiduo/login.jsp">退出</a>
        </span>
  </div>
  <div id="d7"></div>
</div>
<!------------------------------------------------------------------------------------------------>
</body>
</html>
