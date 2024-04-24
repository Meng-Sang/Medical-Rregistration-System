package com.sangmeng.servlet;

import com.sangmeng.entity.Login;
import com.sangmeng.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");
        int accountBalance = 0;
        Login login = new Login(username,password,"custum","normal",email,tel,accountBalance);
        int result = new LoginServiceImpl().register(login);
        if(result==1)
        {
            System.out.println("注册成功");
            request.getSession().setAttribute("username",username);
            response.sendRedirect("index.jsp");
            return ;
        }else if(result==0)
        {
            System.out.println("账号已存在");
            response.sendRedirect("register.jsp");
            return;
        }
        else
        {
            System.out.println("系统异常");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
