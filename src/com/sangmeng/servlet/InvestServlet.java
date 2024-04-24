package com.sangmeng.servlet;

import com.sangmeng.util.ScopeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/InvestServlet")
public class InvestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("username")==null)
        {
            response.sendRedirect("loginTip.jsp");
        }else {
            if(ScopeUtil.getAccountBalanceForScope(request.getSession(),(String)(request.getSession().getAttribute("username"))))
            response.sendRedirect("invest.jsp");
            else
                System.out.println("出现错误；");
        }
    }
}
