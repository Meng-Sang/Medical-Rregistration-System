package com.sangmeng.tag;

import com.sangmeng.entity.Doctor;
import com.sangmeng.service.impl.DoctorServiceImpl;
import com.sangmeng.util.TagUtil;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

public class OutDoctorTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        PageContext pageContext = (PageContext) this.getJspContext();
        String ad_class = (String) pageContext.getSession().getAttribute("ad_class");
        if(ad_class!=null) {
            List<Doctor> doctors = new DoctorServiceImpl().queryAllDoctorsByAd_no(ad_class);
            getJspContext().getOut().write(new TagUtil().getThumbnail(doctors));
        }
    }
}
