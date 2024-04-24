package com.sangmeng.tag;

import com.sangmeng.entity.Notice;
import com.sangmeng.service.impl.NoticeServiceImpl;
import com.sangmeng.util.PageUtil;
import com.sangmeng.util.TagUtil;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

public class outNoticeTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        HttpSession session = ((PageContext) this.getJspContext()).getSession();
        PageUtil pageUtil = (PageUtil)session.getAttribute("pageUtil");
        List<Notice> notices = new NoticeServiceImpl().queryNotice(pageUtil);
        this.getJspContext().getOut().write(new TagUtil().getNotices(notices,pageUtil));
    }
}
