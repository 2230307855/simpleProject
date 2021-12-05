package service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import db_util.goods_tools;

@WebServlet(name = "deletegoods", value = "/deletegoods")
public class deletegoods extends HttpServlet {
    protected boolean checkin(String a){
        if(a==null||a.equals(""))
            return true;
        return false;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String bookname=request.getParameter("bookname");
        //如果输入框的信息是空的
        if(checkin(bookname)){
            request.setAttribute("emptyinput",true);
            request.getRequestDispatcher("deletegoods.jsp").forward(request,response);
            return;
        }
        else{
            goods_tools dt=new goods_tools();
            int k=dt.deleteGoods(Integer.parseInt(bookname));
            if(k==0){
                request.setAttribute("isexist",true);
                request.getRequestDispatcher("deletegoods.jsp").forward(request,response);
                return;
            }
            else {
                request.setAttribute("isfinish",true);
                request.getRequestDispatcher("deletegoods.jsp").forward(request,response);
                return;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
