package com.sangmeng.dao.impl;

import com.sangmeng.dao.LoginDao;
import com.sangmeng.entity.Login;
import com.sangmeng.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class LoginDaoImpl implements LoginDao {

    private static LoginDaoImpl getLoginDaoImpl()
    {
        return new LoginDaoImpl();
    }
    public Login queryByUserName(String username) {
        List<Login> logins = null;
        String sql = "select * from logins where username=?";
        logins = getLoginDaoImpl().query(sql,username);
        return logins==null||logins.isEmpty()?null:logins.get(0);
    }
    @Override
    public int update(String sql, Object... objs){
        QueryRunner runner = new QueryRunner();
        Connection conn = null;
        int result=-1;
        try {
            conn = JDBCUtil.getConnection();
            result=runner.update(conn,sql,objs);
        } catch (SQLException e) {
            return result;
        }
        catch (Exception e)
        {
            return result;
        }
        return result;
    }
    @Override
    public List<Login> query(String sql, Object... objs) {
        QueryRunner runner = new QueryRunner();
        List<Login> logins = null;
        try {
            Connection conn = JDBCUtil.getConnection();
            logins=runner.query(conn,sql,new BeanListHandler<Login>(Login.class),objs);
        } catch (SQLException e) {
            e.printStackTrace();
            return logins;
        }catch (Exception e)
        {
            e.printStackTrace();
            return logins;
        }
        return logins;
    }

    @Override
    public boolean updateBalance(String username, int accountBalance) {
        QueryRunner runner = new QueryRunner();
        int result = 1;
        String sql = "update logins set accountbalance = ? where username = ?";
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();
            result = runner.update(conn,sql,accountBalance,username);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return result==1?true:false;
    }
}
