package com.sangmeng.servlet;

import com.sangmeng.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page_option =request.getParameter("page_option");
        PageUtil pageUtil = (PageUtil) request.getSession().getAttribute("pageUtil");
        if("first_page".equals(page_option))
        {
            pageUtil.init(1,pageUtil.getPageSize(),pageUtil.getTotalCount());
        }
        if("last_page".equals(page_option))
        {
            pageUtil.init(pageUtil.getPageSize(),pageUtil.getPageSize(),pageUtil.getTotalCount());
        }
        if("pre_page".equals(page_option))
        {
            pageUtil.init(pageUtil.getCurrentPage()-1,pageUtil.getPageSize(),pageUtil.getTotalCount());
        }
        if("next_page".equals(page_option))
        {
            pageUtil.init(pageUtil.getCurrentPage()+1,pageUtil.getPageSize(),pageUtil.getTotalCount());
        }
        if("jump_page".equals(page_option))
        {
            int cunrrentPage = Integer.parseInt(request.getParameter("currentPage"));
            pageUtil.init(cunrrentPage,pageUtil.getPageSize(),pageUtil.getTotalCount());
        }
        if("page_size".equals(page_option))
        {
            int page_size = Integer.parseInt(request.getParameter("page_size"));
            pageUtil.init(1,page_size,pageUtil.getTotalCount());
        }
        System.out.println(page_option);
        System.out.println(pageUtil.toString());
        request.getSession().setAttribute("pageUtil",pageUtil);
//        response.sendRedirect("backstage/allOrderForSelf.jsp");
    }
}
