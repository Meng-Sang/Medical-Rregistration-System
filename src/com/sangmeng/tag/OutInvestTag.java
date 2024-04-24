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

public class OutInvestTag extends SimpleTagSupport {
    private String per;

    public void setPer(String per) {
        this.per =  per;
    }

    @Override
    public void doTag() throws JspException, IOException {
        HttpSession session = ((PageContext) this.getJspContext()).getSession();
        String username = (String)session.getAttribute("username");
        PageUtil pageUtil = (PageUtil)session.getAttribute("pageUtil");
        List<Invest> invests = null;
        InvestServiceImpl investService = new InvestServiceImpl();
        if(per=="all_self"){
            invests =  investService.queryTotalInvestForSelf(username,pageUtil);
        }
        if(per=="unpaid_self")
        {
            invests = investService.queryUnpaidInvestForSelf(username,pageUtil);
        }
        if(per=="paid_self")
        {
            invests = investService.queryPaidInvestForSelf(username,pageUtil);
        }
        if(per=="all")
        {
            invests = investService.queryTotalInvest(pageUtil);
        }
        if(per=="unpaid")
        {
            invests = investService.queryUnpaidInvest(pageUtil);
        }
        if(per=="paid")
        {
            invests = investService.queryPaidInvest(pageUtil);
        }
        if(per.endsWith("_self"))
            this.getJspContext().getOut().write((new TagUtil().getInvest(invests,pageUtil,false)));
        else
            this.getJspContext().getOut().write((new TagUtil().getInvest(invests,pageUtil,true)));
    }
}
