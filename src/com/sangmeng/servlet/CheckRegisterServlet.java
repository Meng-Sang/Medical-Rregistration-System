package com.sangmeng.servlet;

import com.sangmeng.dao.impl.LoginDaoImpl;
import com.sangmeng.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CheckRegisterServlet")
public class CheckRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        response.setCharacterEncoding("UTF-8");
        if(new LoginServiceImpl().queryByUsername(username)!=null)
        {
            response.getWriter().write("账号已存在");
            return;
        }else {
            response.getWriter().write("");
            return;
        }
    }
}
