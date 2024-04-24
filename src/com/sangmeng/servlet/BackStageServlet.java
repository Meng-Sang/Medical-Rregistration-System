package com.sangmeng.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BackStageServlet")
public class BackStageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String username = (String)request.getSession().getAttribute("username");
            if(username==null)
            {
                response.sendRedirect("loginTip.jsp");
            }else {
                response.sendRedirect("backstage/index.jsp");
            }
    }
}
