package com.sangmeng.servlet;

import com.sangmeng.entity.Order;
import com.sangmeng.service.impl.OrderServiceImpl;
import com.sangmeng.util.ScopeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        String name = request.getParameter("name");
        String orderNumber = Long.toString(System.currentTimeMillis());
        String sno = request.getParameter("sno");
        String doc_name = request.getParameter("doc_name");
        String date = request.getParameter("date");
        int charge = Integer.parseInt(request.getParameter("charge"));
        String charge_state =  "unpaid";
        String ad_no = request.getParameter("ad_no");
        Order order = new Order(username,name,orderNumber,sno,doc_name,date,charge,charge_state,ad_no);
        if(!ScopeUtil.getAccountBalanceForScope(request.getSession(),username))
        {
            response.sendRedirect("appointmentFail.jsp");
            return;
        }
        int accountBalance = (int)(request.getSession().getAttribute("accountBalance"));
        int balance = accountBalance-charge;
        if(balance>=0)
        {
            order.setCharge_state("paid");
            accountBalance = balance;
        }
        if(new OrderServiceImpl().addOrder(order,accountBalance))
        {
            if(balance>=0) {
                response.sendRedirect("appointmentSucess.jsp");
                return;
            }else
            {
                response.sendRedirect("investTip.jsp");
                return ;
            }
        }
        else{
            response.sendRedirect("appointmentFail.jsp");
            return;
        }

//        if(new OrderServiceImpl().addOrder(order))
//        {
//
//        }else {
//
//        }
    }
}
