package com.sangmeng.service;

import com.sangmeng.entity.Doctor;
import com.sangmeng.util.PageUtil;

import java.util.List;

public interface DoctorService {
    public boolean addDoctor(Doctor doctor);
    public List<Doctor> queryAllDoctorsByAd_no(String ad_no);
    public Doctor queryDoctorByUsername(String username);
    public List<Doctor> queryTotalDoctors(PageUtil pageUtil);
    public List<Doctor> queryAuditDoctors(PageUtil pageUtil);
    public List<Doctor> queryAuditedDoctors(PageUtil pageUtil);
    public int queryDoctorsNum();
    public boolean updateDoctorState(String username,String state);
}
