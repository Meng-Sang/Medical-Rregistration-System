package com.sangmeng.tag;

import com.sangmeng.entity.Doctor;
import com.sangmeng.service.impl.DoctorServiceImpl;
import com.sangmeng.util.PageUtil;
import com.sangmeng.util.TagUtil;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

public class OutBackDoctorTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        HttpSession session = ((PageContext) this.getJspContext()).getSession();
        PageUtil pageUtil = (PageUtil)session.getAttribute("pageUtil");
        List<Doctor>  doctors = new DoctorServiceImpl().queryTotalDoctors(pageUtil);
        this.getJspContext().getOut().write(new TagUtil().getDoctors(doctors,pageUtil));
    }
}
