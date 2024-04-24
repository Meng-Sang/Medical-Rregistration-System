package com.sangmeng.dao;

import com.sangmeng.entity.Doctor;

import java.util.List;

public interface DoctorDao {
    public List<Doctor> queryByAd(String ad_no);
    public Doctor queryByUsername(String username);
    public int addDoctor(Doctor doctor);
    public long TotalDoctorForNum();
    public List<Doctor> QueryDoctor(String sql);
    public int updateDoctor(String sql,Object[] objs);
}
