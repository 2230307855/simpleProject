<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/12/1
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>visgoodserror</title>
</head>
<body>
<%
    HttpSession p=request.getSession();
    p.setAttribute("nobook",true);
    response.sendRedirect("addgoodsexception.jsp");
%>
</body>
</html>
