package com.sangmeng.servlet;

import com.sangmeng.entity.Notice;
import com.sangmeng.service.impl.NoticeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/AddNoticesServlet")
public class AddNoticesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String notice_id = request.getParameter("id");
        if(notice_id!=null)
        {
            if(new NoticeServiceImpl().deleteNotices(notice_id)) {
                notice_id = Long.toString(System.currentTimeMillis());
            }
        }
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        response.setCharacterEncoding("UTF-8");
        Date date = new Date(System.currentTimeMillis());
        String notice_date = date.toString();
        System.out.println(notice_date);
        if(new NoticeServiceImpl().addNotice(new Notice(notice_id,title,content,notice_date))){
        response.getWriter().write("ok");
        return;
        }
    }
}
