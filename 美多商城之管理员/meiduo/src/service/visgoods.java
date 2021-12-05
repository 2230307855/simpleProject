package service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import db_util.goods_tools;
import bean.goods;

@WebServlet(name = "visgoods", value = "/visgoods")
public class visgoods extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out =response.getWriter();
        //从数据库中获取所有的书的列表
        goods_tools dt=new goods_tools();
        ArrayList<goods> bl=dt.selectAllGoods();
        HttpSession p=request.getSession();
        p.setAttribute("booklist",bl);
        Cookie cookie=new Cookie("JSESSIONID",p.getId());
        cookie.setMaxAge(60*30);
        cookie.setPath("visgoods.jsp");
        response.addCookie(cookie);
        response.sendRedirect("visgoods.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
