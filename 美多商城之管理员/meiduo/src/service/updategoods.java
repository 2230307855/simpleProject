package service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import bean.goods;
import db_util.goods_tools;

@WebServlet(name = "updategoods", value = "/updategoods")
public class updategoods extends HttpServlet {
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
            request.getRequestDispatcher("updategoods.jsp").forward(request,response);
            return;
        }
        else{
            goods_tools dt=new goods_tools();
            goods bi=new goods();
            int Gid=Integer.parseInt(bookname);
            String Gname=bookauthor;
            double Gprice=Double.parseDouble(bookdate);
            String Gdate=chubanshe;
            boolean k=dt.updateGoods(Gid,Gname,Gprice,Gdate);
            if(k==false){
                request.setAttribute("isexist",true);
                request.getRequestDispatcher("updategoods.jsp").forward(request,response);
                return;
            }
            else {
                request.setAttribute("isfinish",true);
                request.getRequestDispatcher("updategoods.jsp").forward(request,response);
                return;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doGet(request, response);
    }
}
