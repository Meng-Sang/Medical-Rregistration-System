package com.sangmeng.tag;
import com.sangmeng.entity.Administrative;
import com.sangmeng.service.impl.AdministrativeServiceImpl;
import com.sangmeng.util.TagUtil;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class OutAdministrativeTag extends SimpleTagSupport {
    private int num=4;
    public void setNum(int num) {
        this.num = num;
    }
    @Override
    public void doTag() throws JspException, IOException {
       this.getJspContext().getOut().write(new TagUtil().getResult(num));
    }

}
