<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/11/30
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.mysql.cj.Session" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>login</title>
</head>
<link rel="stylesheet" href="css_style/login.css">
<body background="source/gouwu.png">
<%--判断是否需要弹出登录错误提示框--%>
<%
    String iserror= (String) request.getAttribute("error");
    if(iserror!=null&&!iserror.equals("")){
        if(iserror.equals("loginerror"))
            out.println("<script> alert(\"信息错误，请重新登录！\"); </script>");
    }
    request.removeAttribute("error");
%>

<div class="move">
    <div id="topleft">
        <!--            书架左边的视频浮动-->
    </div>
    <div id="topright">
        <div id="shang_mian">
            <label id="login_name_label">
                商城管理员，欢迎
            </label>
        </div>
        <div id="xia_mian">
            <!--            登录表单-->
            <form action="http://localhost:8080/meiduo/login" method="post" id="login_form">
                <table id="login_info" width="550px">
                    <!--                        第一行-->
                    <tr id="first_line">
                        <td colspan="2">
                            &nbsp &nbsp &nbsp &nbsp
                            登录商城
                        </td>
                        <td></td>
                    </tr>
                    <tr id="second_line">
                        <td id="line2_td1">
                            <label for="input_name">用户</label>
                        </td>
                        <td>
                            <input type="text" name="username" id="input_name">
                        </td>
                    </tr>
                    <tr id="three_line">
                        <td id="line3_td1">
                            <label for="input_password">密码</label>
                        </td>
                        <td>
                            <input type="password" name="password" id="input_password">
                        </td>
                    </tr>
                    <tr id="forth_line">
                        <td></td>
                        <td id="forth_line_td2">
                            <input type="submit" name="登录" id="login_button" value="登录">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
<hr id style="border: 10px solid rgba(0, 0, 0, 0.33)" />
<div id="rooter">
        <span id="empty">
            <label id="rooter_call">
            版权所有：19级计算机科学与技术2班  史成龙
        </label>
        </span>
    <label id="rooter_last">
        email:2230307855@qq.com
    </label>
</div>
</body>
</html>