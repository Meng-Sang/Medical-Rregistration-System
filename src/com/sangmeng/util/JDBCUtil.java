package com.sangmeng.util;
import com.sangmeng.entity.DataSourceEntity;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtil {
    private static ThreadLocal<Connection> threadLocal= new ThreadLocal<>();
    //开启事务
    public static Connection getConnection() throws SQLException {
        Connection conn = threadLocal.get();
        if(conn==null)
        {
            threadLocal.set(DataSourceUtil.getDataSourceByDBPC(new DataSourceEntity()).getConnection());
        }
        return threadLocal.get();
    }
    //连接事务
    public static  void beiginTransaction() throws SQLException {
        Connection conn = getConnection();
        conn.setAutoCommit(false);
    }
    //成功。提交事务
    public static void  commitTransaction() throws SQLException {
        Connection conn = getConnection();
        if(conn!=null)
        conn.commit();
    }
    //失败。回滚事务
    public static void rollbackTransaction() throws SQLException {
        Connection conn = getConnection();
        if(conn!=null)
        conn.rollback();
    }
    //关闭事务
    public static void close() throws SQLException {
        Connection conn = getConnection();
        if(conn==null)
            conn.close();
        threadLocal.remove();
        conn=null;

    }
}
