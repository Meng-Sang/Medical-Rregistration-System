package com.sangmeng.dao.impl;

import com.sangmeng.dao.InvestDao;
import com.sangmeng.entity.Invest;
import com.sangmeng.entity.Invest;
import com.sangmeng.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class InvestDaoImpl implements InvestDao {
    @Override
    public Invest queryByInvestNumber(String investNumber) {
        Invest invest = null;
        String sql = "select * from invests where investnumber = ?";
        QueryRunner runner = new QueryRunner();
        try {
            Connection conn = JDBCUtil.getConnection();
            invest = runner.query(conn,sql,new BeanHandler<Invest>(Invest.class),investNumber);
        } catch (SQLException e) {
            e.printStackTrace();
            return invest;
        }
        return invest;
    }

    @Override
    public int addInvest(Invest invest) {
        String sql = "insert into invests values(?,?,?,?,?,?,?)";
        int result = 1;
        QueryRunner runner = new QueryRunner();
        Object[] objs = new Object[]{invest.getUsername(),invest.getInvestNumber(),invest.getAmount()
                ,invest.getCharge(),invest.getWay(),invest.getState(),invest.getDate()};
        try {
            Connection conn = JDBCUtil.getConnection();
            result = runner.execute(conn,sql,objs);
        } catch (SQLException e) {
            e.printStackTrace();
            return -result;
        }
        return result;
    }
    public long queryInvestNumForSelf(String sql ,String username) {
        Long result = null;
        try {
            QueryRunner runner = new QueryRunner();
            Connection connection = JDBCUtil.getConnection();
            result = runner.query(connection, sql, new ScalarHandler<>(), username);
            return result==null?0:result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result==null?0:result;
    }

    @Override
    public List<Invest> queryInvestForSelf(String sql, String username) {
        List<Invest> invests = null;
        try {
            QueryRunner runner = new QueryRunner();
            Connection connection = JDBCUtil.getConnection();
            invests = runner.query(connection, sql, new BeanListHandler<Invest>(Invest.class), username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (invests==null||invests.isEmpty())?null:invests;
    }

    @Override
    public long queryInvestNum(String sql) {
        Long result = null;
        try {
            QueryRunner runner = new QueryRunner();
            Connection connection = JDBCUtil.getConnection();
            result = runner.query(connection,sql,new ScalarHandler<>());
            return result == null ? 0: result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result==null ? 0: result;
    }

    @Override
    public List<Invest> queryInvest(String sql) {
        List<Invest> invests = null;
        try {
            QueryRunner runner = new QueryRunner();
            Connection connection = JDBCUtil.getConnection();
            invests = runner.query(connection, sql, new BeanListHandler<Invest>(Invest.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (invests==null||invests.isEmpty())?null:invests;
    }

    @Override
    public boolean completePay(String investNumber) {
        String sql = "update invests set state = 'paid' where investnumber = ?";
        int result = 1;
        try {
            QueryRunner runner = new QueryRunner();
            Connection connection = JDBCUtil.getConnection();
            result = runner.execute(connection,sql,investNumber);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return result==1?true:false;
    }
}
