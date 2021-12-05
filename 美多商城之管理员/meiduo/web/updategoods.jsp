<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/11/25
  Time: 0:04
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/11/24
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="bean.goods" %>
<html>
<head>
    <title>updategoods</title>
</head>
<link rel="stylesheet" href="css_style/updategoods.css">
<body background="source/shouye.jpg">
<jsp:include page="roof.jsp"></jsp:include>
<%
    //判断是否是addbook给的输入框空白的异常
    boolean emptyinput=false;
    if(request.getAttribute("emptyinput")!=null)
        emptyinput= (boolean) request.getAttribute("emptyinput");
    if(emptyinput){
        out.println("<script> alert(\"输入信息不完整\"); </script>");
        request.removeAttribute("emptyinput");
    }
%>
<%
    //插入成功的提示
    boolean isfinish=false;
    if(request.getAttribute("isfinish")!=null)
        isfinish= (boolean) request.getAttribute("isfinish");
    if(isfinish){
        out.println("<script> alert(\"商品已经更新成功啦，可以去查看了呦\"); </script>");
        request.removeAttribute("isfinish");
    }
%>
<%
    //数据库找不到要修改的书
    boolean isexist=false;
    if(request.getAttribute("isexist")!=null)
        isexist= (boolean) request.getAttribute("isexist");
    if(isexist){
        out.println("<script> alert(\"商城还没有该商品奥，您可以尝试去添加^-^\"); </script>");
        request.removeAttribute("isexist");
    }
%>
<%------------------------------------------------------------------------------------%>
<div id="addbody">
    <!--左部div-->
    <div id="dispageleft">
        <!--        左部-->
    </div>
    <!--中部div-->
    <div id="dispagemid">
        <div style="width: 1358px; height: 50px;
        /*background: rgba(0,0,0,0.15);*/
         border-radius:10px;border:1px solid rgba(0, 0, 0, 0);
         text-indent: 20px;
         font-size: 25px;
         font-family:微软雅黑;
         font-style: italic;
         font-weight: bolder;
         text-align: center;
         align-content: center;
         /*margin:auto auto;*/
         display:block;
         position:absolute;
         /*top:0;*/
         /*left:0;*/
         /*right:0;*/
         /*bottom:0;*/
"><label style=" color: black;">更新商品</label></div>
        <%--        中部添加表格框--%>
        <div style="
            width: 1358px;height: 760px;
            display:table-cell;
            /*vertical-align:middle; text-align: center;*/
            ">
            <div id="containtable">
                <%--                提交数据的表单--%>
                <form action="http://localhost:8080/meiduo/updategoods" method="post">
                    <table style="width: 768px;height: 600px;">
                        <!--                  第一行-->
                        <tr>
                            <td id="tr1td1">商品ID</td>
                            <td id="tr1td2"><input type="text" id="shuming" name="bookname"></td>
                        </tr>
                        <!--                  第二行-->
                        <tr>
                            <td id="tr2td1">商品名称</td>
                            <td><input type="text" id="zuozhe" name="bookauthor"></td>
                        </tr>
                        <!--                  第三行-->
                        <tr>
                            <td id="tr3td1">价格</td>
                            <td><input type="text" id="riqi" name="bookdate"></td>
                        </tr>
                        <!--                  第四行-->
                        <tr>
                            <td id="tr4td1">日期</td>
                            <td><input type="text" id="chubanshe" name="bookaddress"></td>
                        </tr>
                        <!--                  第五行-->
                        <tr>
                            <td colspan="2" id="tijiao">
                                &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                                <input id="tianjia" type="submit" value="更新">
                            </td>
                            <td></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
    <!--右部div-->
    <div id="dispageright">
        <!--        右部-->
    </div>
</div>
</body>
</html>

