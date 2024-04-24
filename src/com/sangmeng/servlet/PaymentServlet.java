package com.sangmeng.servlet;

import com.sangmeng.entity.Invest;
import com.sangmeng.entity.Order;
import com.sangmeng.service.impl.InvestServiceImpl;
import com.sangmeng.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String result = "";
        String username = (String) request.getSession().getAttribute("username");
        String charge_option = request.getParameter("charge_option");
        if("order".equals(charge_option))
        {
            String orderNumber = request.getParameter("orderNumber");
            result = Integer.toString(new OrderServiceImpl().completeOrder(orderNumber,username));
        }else if("invest".equals(charge_option))
        {
            String investNumber = request.getParameter("investNumber");
            result = Integer.toString(new InvestServiceImpl().completeInvest(investNumber,username));
        }
        System.out.println(charge_option+"   "+result);
        response.getWriter().write(result);
    }
}
