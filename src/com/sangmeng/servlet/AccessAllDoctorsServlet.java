package com.sangmeng.servlet;

import com.sangmeng.service.impl.DoctorServiceImpl;
import com.sangmeng.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AccessAllDoctorsServlet")
public class AccessAllDoctorsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageUtil pageUtil = PageUtil.getInstance();
        int totalCount = new DoctorServiceImpl().queryDoctorsNum();
        pageUtil.init(1, 10, totalCount);
        request.getSession().setAttribute("pageUtil", pageUtil);
        response.sendRedirect("backstage/allDoctor.jsp");
        return ;
    }
}
