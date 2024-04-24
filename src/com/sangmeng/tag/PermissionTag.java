package com.sangmeng.tag;

import com.sangmeng.entity.Login;
import com.sangmeng.service.impl.LoginServiceImpl;
import com.sangmeng.util.TagUtil;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class PermissionTag extends SimpleTagSupport {
    private String role;
    public void setRole(String role) {
        this.role = role;
    }
    @Override
    public void doTag() throws JspException, IOException {
        HttpSession session = ((PageContext) this.getJspContext()).getSession();
        String username = (String)session.getAttribute("username");
        Login login = new LoginServiceImpl().queryByUsername(username);
        int user_level = TagUtil.map.get(login.getRole());
        int need_level = TagUtil.map.get(role);
        if(user_level>=need_level )
        {
            this.getJspBody().invoke(null);
        }
    }
}
