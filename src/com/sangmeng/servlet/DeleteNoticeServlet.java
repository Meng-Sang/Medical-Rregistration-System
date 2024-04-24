package com.sangmeng.servlet;

import com.sangmeng.service.impl.NoticeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteNoticeServlet")
public class DeleteNoticeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = (String)request.getParameter("id");
        request.setCharacterEncoding("UTF-8");
        if(id==null)
        {
            return ;
        }
        if(new NoticeServiceImpl().deleteNotices(id))
        {
            response.getWriter().write("ok");
        }
    }
}
