package com.sangmeng.servlet;

import com.sangmeng.entity.Invest;
import com.sangmeng.service.InvestService;
import com.sangmeng.service.impl.InvestServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/CommitInvestServlet")
public class CommitInvestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String)request.getSession().getAttribute("username");
        String investNumber = Long.toString(System.currentTimeMillis());
        int amount = Integer.parseInt(request.getParameter("amount"));
        int  charge = amount;
        String way = request.getParameter("way");
        String state = "paid";
        java.util.Date dd=new Date();
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date =sim.format(dd);
        Invest invest = new Invest(username,investNumber,amount,charge,way,state,date);
        int accountBalance = (int)request.getSession().getAttribute("accountBalance")+amount;
        request.getSession().setAttribute("accountBalance",accountBalance);
        response.getWriter().write("error");
        if(new InvestServiceImpl().addInvest(invest,accountBalance))
        {
            response.getWriter().print("right");
            response.getWriter().flush();
            return ;
        }
        response.getWriter().print("error");
        response.getWriter().flush();
        System.out.println(amount);
        System.out.println(way);
    }
}
