package com.sangmeng.util;

import com.sangmeng.entity.*;
import com.sangmeng.service.impl.AdministrativeServiceImpl;

import javax.print.Doc;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TagUtil {
    public static Map<String,Integer> map;
    static {
        map = new HashMap<>();
        map.put("custom",1);
        map.put("doctor",2);
        map.put("manager",3);
    }
    public String getLoginInformation(String username)
    {
        String str = "<li><a href=\"register.jsp\">注册</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li><li><a href=\"login.jsp\">登陆</a>|</li>";
        if(username!=null)
        {
            str = "<li><a href=\"LogoutServlet\">退出</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li><li><a href=\"BackStageServlet\">个人中心</a>|</li><li>欢迎您<a class=\"username\"href=\"#\">"+username+"</a>|</li>";

        }
        return str;
    }
    public String getThumbnail(List<Doctor> doctors){
        String str = "<h2>该科室暂无网上预约医生，请到医院进行挂号预约</h2>";
        if(doctors==null||doctors.isEmpty())
            return str;
        str="";
        for (Doctor doc:
                doctors) {
            String doc_username = doc.getUsername();
            String name = doc.getName();
            String self_introduction = doc.getSelf_introduction();
            String photo = doc.getPhoto();
            if(self_introduction.isEmpty()||self_introduction==null)
            {
                self_introduction="暂无介绍";
            }
            str+=getOne(doc_username,name,self_introduction,photo,"进行预约","进行咨询");
        }
        return  str;
    }

    private String getOne(String doc_username,String name, String self_introduction,String photo,String button1,String button2) {
        return
            "<div class=\"col-sm-6 col-md-4 text-center\">"
		    +"<div class=\"thumbnail\">"
            +"<img src=\"upload/doc_photo\\"+photo+"\" alt=\"我帅吗\" style=\"width:275px;height:370px;\">"
		    +"<div class=\"caption\">"
            +"<h3>"+name+"</h3>"
            +"<p>"+self_introduction+"</p>"
            +"<p><div><a href=\"AppointmentServlet?doc_username="+doc_username+"\" class=\"btn btn-primary\" role=\"button\">"+button1+"</a> <a href=\"#\" class=\"btn btn-default\" role=\"button\">"+button2+"</a></div></p>"
            +"</div>"
		    +"</div>"
		    +"</div>"  ;
    }


    public String getResult(int num)
    {
        List<Administrative> administratives = new AdministrativeServiceImpl().queryAll();
        String str = "";
        if(administratives==null)
        {
            return str;
        }
        for(int i=0;i<administratives.size();i+=4)
        {
            String t_str = "";
            for(int j=i;j<i+num;j++)
            {
                String s = j>=administratives.size()?getTd(null):getTd(administratives.get(j));
                t_str+=s;
            }
            str+=getTr(t_str);
        }
        return str;
    }

    private String getTd(Administrative administrative){
        return administrative==null?"<td></td>":"<td>"+"<a href=\"DoctorByAdServlet?ad_class="+administrative.getAd_no()+"\">"+administrative.getAd_name()+"</a></td>";
    }
    private  String getTr(String str)
    {
        return "<tr>"+str+"</tr>";
    }

    public String getOrder(List<Order> orders,PageUtil page,boolean flag)
    {
        String str="";
        if(orders==null)
            return str;
        for (int i=0;i<orders.size();i++) {
            int no = (page.getCurrentPage()-1)*page.getPageSize()+i+1;
            str+=getTRForOrder(orders.get(i),no,flag);
        }
        return str;
    }

    private String getTRForOrder(Order order,int no,boolean flag) {
        Administrative ad = new AdministrativeServiceImpl().queryByAd_no(order.getAd_no());
        String ad_name = ad.getAd_name();
        String charge_state = order.getCharge_state().equals("paid") ? "<td>已支付</td>" : "<td class=\"completePay\"><a>去支付</a></td>";
        if(flag) {
            charge_state = order.getCharge_state().equals("paid") ? "<td>已支付</td>" : "<td class=\"completePay\">未支付</td>";
        }
        String time = TimeUtil.timesOne(order.getOrderNumber());
        return "<tr class=\"orderRow\">"
                +"<td>"+no+"</td>"
                +"<td>"+order.getUsername()+"</td>"
                +"<td>"+order.getName()+"</td>"
                +"<td>"+ad_name+"</td>"
                +"<td>"+order.getDoc_name()+"</td>"
                +"<td>"+order.getDate()+"</td>"
                +"<td>"+order.getCharge()+"</td>"
                +charge_state
                +"<td>"+time+"</td>"
                +"<td class=\"orderNumber\">"+order.getOrderNumber()+"</td>"
                +"</tr>";
    }
    public String getInvest(List<Invest> invests,PageUtil page,boolean flag)
    {
        String str="";
        if(invests==null)
            return str;
        for (int i=0;i<invests.size();i++) {
            int no = (page.getCurrentPage()-1)*page.getPageSize()+i+1;
            str+=getTRForInvest(invests.get(i),no,flag);
        }
        return str;
    }
    private String getTRForInvest(Invest invest,int no, boolean flag) {
        String time = TimeUtil.timesOne(invest.getInvestNumber());
        String state = "paid".equals(invest.getState())?"<td>已支付</td>" : "<td class=\"completePay\"><a>去支付</a></td>";
        if(flag)
        {
            state = "paid".equals(invest.getState())?"<td>已支付</td>" : "<td class=\"completePay\">未支付</td>";
        }
        return     "<tr class=\"investRow\">"
                                    +"<td>"+no+"</td>"
                                    +"<td>"+invest.getUsername()+"</td>"
                                    +"<td>"+invest.getAmount()+"</td>"
                                    +"<td>"+invest.getCharge()+"</td>"
                                    +"<td>"+invest.getWay()+"</td>"
                                    +state
                                    +"<td>"+time+"</td>"
                                    +"<td class=\"investNumber\">"+invest.getInvestNumber()+"</td>"
                                +"</tr>";
    }
    public String getNotices(List<Notice> notices,PageUtil page)
    {
        String str="";
        if(notices==null)
            return str;
        for (int i=0;i<notices.size();i++) {
            int no = (page.getCurrentPage()-1)*page.getPageSize()+i+1;
            str+=getTRForNotice(no,notices.get(i));
        }
        return str;
    }
    public String getTRForNotice(int num,Notice notice)
    {
        return "<tr class=\"rowNotice\">"
                        +"<td>"+num+"</td>"
                        +"<td class=\"id\">"+notice.getNotice_id()+"</td>"
                        +"<td>"+notice.getNotice_title()+"</td>"
                        +"<td>"+notice.getNotice_date()+"</td>"
                        +"<td><a href=\"../AccessAddNoticesServlet?id="+notice.getNotice_id()+"\">查看</a></td>"
                        +"<td class=\"delete\"><a >删除<a></td>"
                    +"</tr>";
    }
    public String getDoctors(List<Doctor> doctors,PageUtil page)
    {
        String str="";
        if(doctors==null)
            return str;
        for (int i=0;i<doctors.size();i++) {
            int no = (page.getCurrentPage()-1)*page.getPageSize()+i+1;
            str+=getBackDoctor(no,doctors.get(i));
        }
        return str;
    }
    public String getBackDoctor(int num, Doctor doctor)
    {
        String level = "profession".equals(doctor.getLevel())?"专家":"医师";
        String state = "";
        if("audited".equals(doctor.getAudit()))
        {
            state = "通过";
        }else if("audit".equals(doctor.getAudit()))
        {
            state = "未通过";
        }else
        {
            state = "<span class=\"glyphicon glyphicon-ok\" id=\"approve\" style=\"color: green; margin-right: 20%\"></span><span class=\"glyphicon glyphicon-remove\" id=\"disapprove\" style=\"color: red;\"></span>";
        }
        return "<tr class=\"backDoctorRow\">"
                                    +"<td>"+num+"</td>"
                                    +"<td>"+doctor.getUsername()+"</td>"
                                    +"<td>"+doctor.getAd_name()+"</td>"
                                    +"<td>"+doctor.getSno()+"</td>"
                                    +"<td>"+doctor.getName()+"</td>"
                                    +"<td>"+doctor.getSelf_introduction()+"</td>"
                                    +"<td>"+level+"</td>"
                                    +"<td class=\""+doctor.getUsername()+"\">"+state+"</td>"
                                +"</tr>";
    }

}
