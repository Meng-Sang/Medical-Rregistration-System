package com.sangmeng.servlet;

import com.sangmeng.entity.Notice;
import com.sangmeng.service.impl.NoticeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AccessAddNoticesServlet")
public class AccessAddNoticesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if(id==null){
            request.getRequestDispatcher("backstage/addNotice.jsp").forward(request,response);
            return ;
        }
        Notice notice = new NoticeServiceImpl().queryByNotice_ad(id);
        request.setAttribute("notice",notice);
        request.getRequestDispatcher("backstage/addNotice.jsp").forward(request,response);
    }
}
