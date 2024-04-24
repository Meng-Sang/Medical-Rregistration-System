package com.sangmeng.service.impl;
import com.sangmeng.dao.impl.DoctorDaoImpl;
import com.sangmeng.entity.Doctor;
import com.sangmeng.service.DoctorService;
import com.sangmeng.util.PageUtil;

import javax.print.MultiDocPrintService;
import java.util.List;
public class DoctorServiceImpl implements DoctorService {
    @Override
    public boolean addDoctor(Doctor doctor) {
        Doctor old_doctor =new DoctorServiceImpl().queryDoctorByUsername(doctor.getUsername());
        if(old_doctor!=null)
        {
            return false;
        }
        if(new DoctorDaoImpl().addDoctor(doctor)==1) {
            return true;
        }
        return false;
    }

    @Override
    public List<Doctor> queryAllDoctorsByAd_no(String ad_no) {
        return new DoctorDaoImpl().queryByAd(ad_no);
    }

    @Override
    public Doctor queryDoctorByUsername(String username) {
        return new DoctorDaoImpl().queryByUsername(username);
    }

    @Override
    public List<Doctor> queryTotalDoctors(PageUtil pageUtil) {
        String sql = "select * from (select * from doctors order by photo desc) as new   limit"+PageUtil.getLimit(pageUtil);
        return new DoctorDaoImpl().QueryDoctor(sql);
    }

    @Override
    public List<Doctor> queryAuditDoctors(PageUtil pageUtil) {
        String sql = "select * from (select * from doctors where audit = 'audit' order by photo desc) as new limit"+PageUtil.getLimit(pageUtil);
        return new DoctorDaoImpl().QueryDoctor(sql);
    }

    @Override
    public List<Doctor> queryAuditedDoctors(PageUtil pageUtil) {
        String sql = "select * from (select * from doctors where audit = 'audited' order by photo desc) as new limit"+PageUtil.getLimit(pageUtil);
        return new DoctorDaoImpl().QueryDoctor(sql);
    }

    @Override
    public int queryDoctorsNum() {
        return (int)new DoctorDaoImpl().TotalDoctorForNum();
    }

    @Override
    public boolean updateDoctorState(String username, String state) {
        String sql = "update doctors set audit=? where username = ?";
        Object[] objs = new Object[]{state,username};
        return new DoctorDaoImpl().updateDoctor(sql,objs)==1?true:false;
    }
}
