package com.sangmeng.dao.impl;

import com.sangmeng.dao.AdministrativeDao;
import com.sangmeng.entity.Administrative;
import com.sangmeng.util.DataSourceUtil;
import com.sangmeng.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AdministrativeDaoImpl implements AdministrativeDao {

    @Override
    public List<Administrative> queryAll() {
        QueryRunner runner = new QueryRunner();
        List<Administrative> administratives = null;
        String sql = "select * from administratives";
        try {
            Connection conn = JDBCUtil.getConnection();
            administratives = runner.query(conn,sql,new BeanListHandler<Administrative>(Administrative.class));
        } catch (SQLException e) {
            e.printStackTrace();
            return administratives;
        }
        return administratives;
    }

    @Override
    public Administrative queryByAd_no(String ad_no) {
        QueryRunner runner = new QueryRunner();
        Administrative administrative = null;
        String sql = "select * from administratives where ad_no=?";
        try {
            Connection conn = JDBCUtil.getConnection();
            administrative = runner.query(conn,sql,new BeanHandler<Administrative>(Administrative.class),ad_no);
        } catch (SQLException e) {
            return administrative;
        }
        return administrative;
    }
}
