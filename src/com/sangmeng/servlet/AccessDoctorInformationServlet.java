package com.sangmeng.servlet;

import com.sangmeng.entity.Doctor;
import com.sangmeng.service.impl.DoctorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AccessDoctorInformationServlet")
public class AccessDoctorInformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        Doctor doctor = new DoctorServiceImpl().queryDoctorByUsername(username);
        request.setAttribute("doctor",doctor);
        request.getRequestDispatcher("backstage/accessDoctorInformation.jsp").forward(request,response);
    }
}
