<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/12/1
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="bean.goods" %>
<%@ page import="java.util.ArrayList" %>
<%@ page errorPage="visgoodserror.jsp" %>
<html>
<head>
    <title>visgoods</title>
</head>
<link rel="stylesheet" href="css_style/visgoods.css.css">
<body id="bo" background="source/shouye.jpg">
<jsp:include page="roof.jsp"></jsp:include>
<!------------------------------------------------------------------------------------------------>
<div id="addbody">
    <!--左部div-->
    <div id="dispageleft">
        <!--        左部-->
    </div>
    <!--中部div-->
    <div id="dispagemid">
        <%--中部导航栏--%>
        <div style="width: 1358px; height: 50px;
         /*background: rgba(0,0,0,0.34);*/
         border-radius:10px;border:1px solid rgba(0, 0, 0, 0);
         text-indent: 20px;
         font-size: 25px;
         font-family:微软雅黑;
         font-style: italic;
         font-weight: bolder;
         text-align: center;
         align-content: center;
         /*margin:auto auto;*/
         /*display:block;*/
         /*position:absolute;*/
         /*top:0;*/
         /*left:0;*/
         /*right:0;*/
         /*bottom:0;*/
         ">
            <label style=" color: rgba(0,0,0,0.4);">商城商品如下</label>
        </div>
        <div style="width: 1358px; height: 50px;"></div>
        <div style="width: 1358px; height: 80px;
               /*background: rgba(0,0,0,0.34);*/
               border-radius:20px;border:1px solid rgba(0, 0, 0, 0);
               text-indent: 20px;
               font-size: 25px;
              font-family:微软雅黑;
                font-style: italic;
                font-weight: bolder;
               text-align: center;
               align-content: center;">
            <label style=" color: rgba(0,0,0,0.71);">商品ID&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                商品名&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp价格&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp日期</label>
        </div></br>
        <%--书籍输出--%>
        <%
            HttpSession now=request.getSession();
            ArrayList<goods> booklist= (ArrayList<goods>) now.getAttribute("booklist");
            if(booklist==null){
                out.println("<script> alert(\"还没有商品奥，请添加！\"); </script>");
                response.sendRedirect("http://localhost:8080/meiduo/visgoods");
//                到添加页面进行添加
            }
            for(goods k:booklist) {
                out.println("         <div style=\"width: 1358px; height: 80px; background: rgba(0,0,0,0.15);" +
                        "                border-radius:20px;border:1px solid rgba(0, 0, 0, 0);" +
                        "                text-indent: 20px;" +
                        "                font-size: 25px;" +
                        "                font-family:微软雅黑;" +
                        "                font-style: italic;" +
                        "                font-weight: bolder;" +
                        "                text-align: center;" +
                        "                align-content: center;" +
                        "                \">" +
                        "                <label style=\" color: biack;\">\n"+k.getGid() + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+
                        k.getGname()+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+ k.getGprice()+"元/斤&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+ k.getGdate()+"</label>"+
                        "        </div></br>");
            }
        %>
    </div>
    <!--右部div-->
    <div id="dispageright">
        <!--        右部-->
    </div>
</div>
<!------------------------------------------------------------------------------------------------>
</body>
</html>
