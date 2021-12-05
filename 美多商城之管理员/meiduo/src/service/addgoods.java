package service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import bean.goods;
import db_util.goods_tools;

@WebServlet(name = "addgoods", value = "/addgoods")
public class addgoods extends HttpServlet {
    protected boolean checkin(String a,String b,String c,String d){
        if(a==null||b==null||c==null||d==null||a.equals("")||b.equals("")||c.equals("")||d.equals(""))
            return true;
        return false;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String bookname=request.getParameter("bookname");
        String bookauthor=request.getParameter("bookauthor");
        String bookdate=request.getParameter("bookdate");
        String chubanshe=request.getParameter("bookaddress");
        //如果输入框的信息是空的
        if(checkin(bookname,bookauthor,bookdate,chubanshe)){
            request.setAttribute("emptyinput",true);
            request.getRequestDispatcher("addgoods.jsp").forward(request,response);
            return;
        }
        //输入框的信息均已经得到
        else{
            goods_tools dt=new goods_tools();
            goods newbook=new goods();
            newbook.setGid(Integer.parseInt(bookname));
            newbook.setGname(bookauthor);
            newbook.setGprice(Double.parseDouble(bookdate));
            newbook.setGdate(chubanshe);
            int k=dt.addGoods(newbook);
            if(k==0){
                request.setAttribute("isexist",true);
                request.getRequestDispatcher("addgoods.jsp").forward(request,response);
                return;
            }
            else {
                request.setAttribute("isfinish",true);
                request.getRequestDispatcher("addgoods.jsp").forward(request,response);
                return;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doGet(request, response);
    }
}
