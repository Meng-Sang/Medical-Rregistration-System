package com.sangmeng.tag;
import com.sangmeng.util.TagUtil;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
public class LoginTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        PageContext pageContext = (PageContext) getJspContext();
        String username = (String) pageContext.getSession().getAttribute("username");
        this.getJspContext().getOut().write(new TagUtil().getLoginInformation(username));
    }
}
