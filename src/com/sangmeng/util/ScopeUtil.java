package com.sangmeng.util;

import com.sangmeng.entity.Administrative;
import com.sangmeng.entity.Doctor;
import com.sangmeng.entity.IdInformation;
import com.sangmeng.entity.Login;
import com.sangmeng.service.impl.AdministrativeServiceImpl;
import com.sangmeng.service.impl.DoctorServiceImpl;
import com.sangmeng.service.impl.IdInformationServiceImpl;
import com.sangmeng.service.impl.LoginServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ScopeUtil {

    public static boolean getDoctorForScope(HttpServletRequest request,String doc_username)
    {
        Doctor doctor = new DoctorServiceImpl().queryDoctorByUsername(doc_username);
        if(doctor==null)
        {
            return false;
        }
        request.setAttribute("doctor",doctor);
        return true;
    }
    public static boolean getidInformationForScope(HttpServletRequest request,String username)
    {
        IdInformation idInformation = new IdInformationServiceImpl().queryIdInformationByUsername(username);
        if(idInformation==null)
        {
            return false;
        }
        request.setAttribute("idInformation",idInformation);
        return true;
    }
    public  static boolean getAdForScope(HttpServletRequest request, String ad_no)
    {
        Administrative administrative = new AdministrativeServiceImpl().queryByAd_no(ad_no);
        if(administrative==null)
        {
            return false;
        }
        request.setAttribute("administrative",administrative);
        return true;
    }
    public  static boolean getLoginForScope(HttpServletRequest request, String username)
    {
        Login login = new LoginServiceImpl().queryByUsername(username);
        if(login==null)
        {
            return false;
        }
        request.setAttribute("login",login);
        return true;
    }
    public  static boolean getAccountBalanceForScope(HttpSession session,String username)
    {
        Login login = new LoginServiceImpl().queryByUsername(username);
        System.out.println(login.getAccountBalance());
        if(login==null)
        {
            return false;
        }
        session.setAttribute("accountBalance",login.getAccountBalance());
        return true;
    }
}
