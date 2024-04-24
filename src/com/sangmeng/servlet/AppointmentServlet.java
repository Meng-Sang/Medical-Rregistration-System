package com.sangmeng.servlet;

import com.sangmeng.entity.Doctor;
import com.sangmeng.entity.IdInformation;
import com.sangmeng.service.impl.DoctorServiceImpl;
import com.sangmeng.service.impl.IdInformationServiceImpl;
import com.sangmeng.util.ScopeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/AppointmentServlet")
public class AppointmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
//        HttpSession session = request.getSession();
        String doc_username = request.getParameter("doc_username");
        if(username==null)
        {
            response.sendRedirect("loginTip.jsp");
            return ;
        }else if(!ScopeUtil.getidInformationForScope(request,username))
        {
            response.sendRedirect("backstage/addInformationTip.jsp");
            return ;
        }else if(doc_username==null)
        {
            response.sendRedirect("appointmentTip.jsp");
            return;
        }else {
            boolean resulet1 =ScopeUtil.getDoctorForScope(request,doc_username);
            boolean resulet2 =ScopeUtil.getAdForScope(request,((Doctor) request.getAttribute("doctor")).getAd_no());
            boolean resulet3 =ScopeUtil.getLoginForScope(request,username);
            if(resulet1&&resulet2)
            {
                request.getRequestDispatcher("appointment.jsp").forward(request,response);
                return ;
            } else
            {
                response.sendRedirect("administrativeInformation.jsp");
                return ;
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
