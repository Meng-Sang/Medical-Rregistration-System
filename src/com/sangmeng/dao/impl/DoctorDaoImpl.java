package com.sangmeng.dao.impl;

import com.sangmeng.dao.DoctorDao;
import com.sangmeng.entity.DataSourceEntity;
import com.sangmeng.entity.Doctor;
import com.sangmeng.util.DataSourceUtil;
import com.sangmeng.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.print.Doc;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DoctorDaoImpl implements DoctorDao {
    @Override
    public List<Doctor> queryByAd(String ad_no) {
        QueryRunner runner = new QueryRunner();
        List<Doctor> doctors = null;
        String sql = "select * from doctors where ad_no=?";
        try {
            Connection conn = JDBCUtil.getConnection();
            doctors=runner.query(conn,sql,new BeanListHandler<Doctor>(Doctor.class),ad_no);
        } catch (SQLException e) {
            return doctors;
        }
        return doctors;
    }

    @Override
    public Doctor queryByUsername(String username) {
        QueryRunner runner = new QueryRunner();
        Doctor doctor = null;
        String sql = "select * from doctors where username=?";
        try {
            Connection conn = JDBCUtil.getConnection();
            doctor=runner.query(conn,sql,new BeanHandler<Doctor>(Doctor.class),username);
        } catch (SQLException e) {
            e.printStackTrace();
            return doctor;
        }
        return doctor;
    }

    @Override
    public int addDoctor(Doctor doctor) {
        QueryRunner runner = new QueryRunner();
        int result = 1;
        String sql = "insert into doctors values(?,?,?,?,?,?,?,?,?,?)";
        Object[] objs = new Object[]{doctor.getUsername(),doctor.getAd_no(),doctor.getAd_name(),doctor.getSno(),doctor.getName(),doctor.getSelf_introduction(),doctor.getPhoto(),doctor.getCharge(),doctor.getLevel(),doctor.getAudit()};
        try {
            Connection conn = JDBCUtil.getConnection();
            result=runner.execute(conn,sql,objs);
        } catch (SQLException e) {
            e.printStackTrace();
            return -result;
        }
        return result;
    }

    @Override
    public long TotalDoctorForNum() {
        QueryRunner runner = new QueryRunner();
        Long result = null;
        String sql = "select count(*) from doctors ";
        try {
            Connection conn = JDBCUtil.getConnection();
            result = runner.query(conn,sql,new ScalarHandler<>());
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return result;
    }

    @Override
    public List<Doctor> QueryDoctor(String sql) {
        QueryRunner runner = new QueryRunner();
        List<Doctor> doctors = null;
        try {
            Connection conn = JDBCUtil.getConnection();
            doctors = runner.query(conn,sql,new BeanListHandler<Doctor>(Doctor.class));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return (doctors==null||doctors.isEmpty())?null:doctors;
    }

    @Override
    public int updateDoctor(String sql,Object[] objs) {
        QueryRunner runner = new QueryRunner();
        int result = 1;
        try {
            Connection conn = JDBCUtil.getConnection();
            result = runner.execute(conn,sql,objs);
        } catch (SQLException e) {
            e.printStackTrace();
            return -result;
        }
        return result;
    }
}
