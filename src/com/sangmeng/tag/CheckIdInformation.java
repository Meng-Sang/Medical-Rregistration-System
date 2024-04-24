package com.sangmeng.tag;

import com.sangmeng.entity.IdInformation;
import com.sangmeng.service.impl.IdInformationServiceImpl;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class CheckIdInformation extends SimpleTagSupport {
    int num ;
    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public void doTag() throws JspException, IOException {
        HttpSession session = ((PageContext) this.getJspContext()).getSession();
        String username = (String)session.getAttribute("username");
        IdInformation idInformation = new IdInformationServiceImpl().queryIdInformationByUsername(username);
        if(idInformation!=null&&num==1)
        {
            this.getJspBody().invoke(null);
        }
        if(idInformation==null&&num==0)
        {
            this.getJspBody().invoke(null);
        }
    }
}
