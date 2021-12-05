package service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import bean.people;
import db_util.people_tools;

@WebServlet(name = "login", value = "/login")
public class login extends HttpServlet {
    protected void error_handle(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
        String url="login.jsp";
        request.setAttribute("error","loginerror");
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        String name=request.getParameter("username");
        String password=request.getParameter("password");
        //账号或者密码没输入就直接登录
        if(name.equals("")||name==null||password.equals("")||password==null){
            error_handle(request,response);
            return;
        }
        else{
            people_tools du=new people_tools();//数据库验证
            people checkuser=du.is_exist_people(name);
            if(checkuser==null) {
                //无该用户，直接结束
                error_handle(request,response);
                return;
            }
        }
//         ---------------------------------------------------------------------------------------------------
        //用户首次登录
        HttpSession p= request.getSession();
        people logined= (people) p.getAttribute("loginuser");
//         ---------------------------------------------------------------------------------------------------
        if(logined==null){//如果第一次登录该网站，创建服务器Session
            people_tools du=new people_tools();//数据库验证
            people checkuser=du.is_exist_people(name);
            if(checkuser==null) {
                //无该用户，直接结束
                error_handle(request,response);
                return;
            }
//             out.println("realname is:"+checkuser.getId());
//             out.println("realpassword id:"+checkuser.getPassword());
            if(checkuser.getPid().equals(name)&&checkuser.getPpassword().equals(password)){//验证成功
                p.setAttribute("loginuser",checkuser);
                //为用户创建Cookie标识
                Cookie cookie=new Cookie("LOGINSESSIONID",p.getId());
                cookie.setMaxAge(60*30); //30分钟存活时间
                response.addCookie(cookie);
                out.println("<script> alert(\"登录成功！\"); </script>");
                //转到主页地址
                response.sendRedirect("visgoods.jsp");
            }
            else{
                //密码不对直接结束
                error_handle(request,response);
                return;
            }
        }//Session有效期内登录
        else{
            response.sendRedirect("visgoods.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doGet(request, response);
    }
}
