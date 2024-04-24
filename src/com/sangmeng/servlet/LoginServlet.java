package com.sangmeng.servlet;

import com.sangmeng.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        response.setContentType("text/html;charset=UTF-8");
        if(new LoginServiceImpl().checkLogin(username,password))
        {
            request.getSession().setAttribute("username",username);
            response.getWriter().write("true");
            return;
        }else
        {
            response.getWriter().write("账号或密码错误");
        }
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        System.out.println(username);
//        System.out.println(password);
//        if(new LoginServiceImpl().checkLogin(username,password))
//        {
//            response.getWriter().write("true");
//        }
//        else
//        {
//            response.getWriter().write("false");
//        }
    }
}
