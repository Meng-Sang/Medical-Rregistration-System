package com.sangmeng.servlet;

import com.sangmeng.entity.Administrative;
import com.sangmeng.entity.Doctor;
import com.sangmeng.entity.IdInformation;
import com.sangmeng.service.impl.AdministrativeServiceImpl;
import com.sangmeng.service.impl.DoctorServiceImpl;
import com.sangmeng.service.impl.IdInformationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ApplicationBecomeDoctorServlet")
public class ApplicationBecomeDoctorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Administrative> ads = new AdministrativeServiceImpl().queryAll();
        String username =(String)request.getSession().getAttribute("username");
        IdInformation information = new IdInformationServiceImpl().queryIdInformationByUsername(username);
        Doctor doctor = new DoctorServiceImpl().queryDoctorByUsername(username);
        if(information==null)
        {
            response.sendRedirect("inputIdInformationTip.jsp");
            return;
        }
        if(doctor!=null)
        {
            response.sendRedirect("AccessDoctorInformationServlet");
            return;
        }
        request.setAttribute("ads",ads);
        request.getRequestDispatcher("backstage/applicationBecomeDoctor.jsp").forward(request,response);
    }
}
