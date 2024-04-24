package com.sangmeng.servlet;

import com.sangmeng.entity.IdInformation;
import com.sangmeng.service.impl.IdInformationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/AccessExamineIdInformationServlet")
public class AccessExamineIdInformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        if(username==null)
        {
            response.sendRedirect("../loginTip.jsp");
            return;
        }
        IdInformation idInformation = new IdInformationServiceImpl().queryIdInformationByUsername(username);
        HttpSession session = request.getSession();
        session.setAttribute("idInformation",idInformation);
        response.sendRedirect("backstage/examineIdInformation.jsp");
    }
}
