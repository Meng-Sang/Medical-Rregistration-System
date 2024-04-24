package com.sangmeng.tag;

import com.sangmeng.entity.Invest;
import com.sangmeng.entity.Order;
import com.sangmeng.service.impl.InvestServiceImpl;
import com.sangmeng.service.impl.OrderServiceImpl;
import com.sangmeng.util.PageUtil;
import com.sangmeng.util.TagUtil;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

public class OutOrderTag extends SimpleTagSupport {
    String per;
    public void setPer(String per) {
        this.per = per;
    }
    @Override
    public void doTag() throws JspException, IOException {
        HttpSession session = ((PageContext) this.getJspContext()).getSession();
        String username = (String)session.getAttribute("username");
        PageUtil pageUtil = (PageUtil)session.getAttribute("pageUtil");
        List<Order> orders = null;
        OrderServiceImpl orderService = new OrderServiceImpl();
        if(per=="all_self"){
            orders =  orderService.queryTotalOrderForSelf(username,pageUtil);
        }
        if(per=="unpaid_self")
        {
            orders = orderService.queryUnpaidOrderForSelf(username,pageUtil);
        }
        if(per=="paid_self")
        {
            orders = orderService.queryPaidOrderForSelf(username,pageUtil);
        }
        if(per=="all")
        {
            orders = orderService.queryTotalOrder(pageUtil);
        }
        if(per=="unpaid")
        {
            orders = orderService.queryUnpaidOrder(pageUtil);
        }
        if(per=="paid")
        {
            orders = orderService.queryPaidOrder(pageUtil);
        }
        if(per.endsWith("_self"))
            this.getJspContext().getOut().write((new TagUtil().getOrder(orders,pageUtil,false)));
        else
            this.getJspContext().getOut().write((new TagUtil().getOrder(orders,pageUtil,true)));

    }
}
