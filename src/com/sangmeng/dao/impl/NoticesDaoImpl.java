package com.sangmeng.dao.impl;

import com.sangmeng.dao.NoticesDao;
import com.sangmeng.entity.Notice;
import com.sangmeng.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class NoticesDaoImpl implements NoticesDao {
    @Override
    public boolean addNotice(Notice notice) {
        QueryRunner runner = new QueryRunner();
        String sql = "insert into notices values(?,?,?,?)";
        int result=1;
        Object[] objs = new Object[]{notice.getNotice_id(),notice.getNotice_date(),notice.getNotice_title(),notice.getNotice_content()};
        try {
            Connection conn = JDBCUtil.getConnection();
            result = runner.execute(conn,sql,objs);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return result==1?true:false;
    }

    @Override
    public Notice queryNotice(String notice_id) {
        QueryRunner runner = new QueryRunner();
        String sql = "select * from notices where notice_id = ?";
        Notice result=null;
        try {
            Connection conn = JDBCUtil.getConnection();
            result = runner.query(conn,sql,new BeanHandler<Notice>(Notice.class),notice_id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }

    @Override
    public long queryAllNoticeForNum() {
        QueryRunner runner = new QueryRunner();
        String sql = "select count(*) from notices";
        Long result=null;
        try {
            Connection conn = JDBCUtil.getConnection();
            result = runner.query(conn,sql,new ScalarHandler<>());
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return result==null?0:result;
    }

    @Override
    public List<Notice> queryAllNotic() {
        QueryRunner runner = new QueryRunner();
        String sql = "select * from notices";
        List<Notice> notices=null;
        try {
            Connection conn = JDBCUtil.getConnection();
            notices = runner.query(conn,sql,new BeanListHandler<Notice>(Notice.class));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return notices==null||notices.isEmpty()?null:notices;
    }

    @Override
    public List<Notice> queryNoticesByLimit(String sql) {
        QueryRunner runner = new QueryRunner();
        List<Notice> notices=null;
        try {
            Connection conn = JDBCUtil.getConnection();
            notices = runner.query(conn,sql,new BeanListHandler<Notice>(Notice.class));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return notices==null||notices.isEmpty()?null:notices;
    }

    @Override
    public int delete(String notice_ad) {
        QueryRunner runner = new QueryRunner();
        String sql = "delete from notices where notice_id = ?";
       int result = 1;
        try {
            Connection conn = JDBCUtil.getConnection();
            result = runner.execute(conn,sql,notice_ad);
        } catch (SQLException e) {
            e.printStackTrace();
            return -result;
        }
        return result;
    }
}
