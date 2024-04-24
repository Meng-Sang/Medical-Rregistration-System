package com.sangmeng.dao.impl;

import com.sangmeng.dao.OrderDao;
import com.sangmeng.entity.DataSourceEntity;
import com.sangmeng.entity.Order;
import com.sangmeng.util.DataSourceUtil;
import com.sangmeng.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class OrderDaoImpl implements OrderDao {
    @Override
    public boolean isExsit(String orderNumber) {
        return queryByOrderNumber(orderNumber)==null?false:true;
    }

    @Override
    public Order queryByOrderNumber(String orderNumber) {
        QueryRunner runner = new QueryRunner();
        Order order = null;
        String sql = "select * from orders where ordernumber=?";
        try {
            Connection conn = JDBCUtil.getConnection();
            order = runner.query(conn,sql,new BeanHandler<Order>(Order.class),orderNumber);
        } catch (SQLException e) {
            e.printStackTrace();
            return  order;
        }
        return order;
    }
    @Override
    public int addOrder(Order order) {
        int result = 1;
        String sql = "insert into orders values(?,?,?,?,?,?,?,?,?)";
        Object [] objs = new Object[]{order.getUsername(),order.getName(),order.getOrderNumber(),order.getSno(),order.getDoc_name(),
        order.getDate(),order.getCharge(),order.getCharge_state(),order.getAd_no()};
        QueryRunner runner = new QueryRunner();
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();
            result = runner.execute(conn,sql,objs);
        } catch (SQLException e) {
            e.printStackTrace();
            return -result;
        }
        return result;
    }

    @Override
    public long queryOrderNumForSelf(String sql ,String username) {
        Long result = null;
        try {
            QueryRunner runner = new QueryRunner();
            Connection connection = JDBCUtil.getConnection();
            result = runner.query(connection,sql,new ScalarHandler<>(),username);
            return result==null?0:result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result==null?0:result;
    }

    @Override
    public List<Order> queryOrderForSelf(String sql, String username) {
        List<Order> orders = null;
        try {
            QueryRunner runner = new QueryRunner();
            Connection connection = JDBCUtil.getConnection();
            orders = runner.query(connection, sql, new BeanListHandler<Order>(Order.class), username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (orders==null||orders.isEmpty())?null:orders;
    }

    @Override
    public long queryOrderNum(String sql) {
        Long result = null;
        try {
            QueryRunner runner = new QueryRunner();
            Connection connection = JDBCUtil.getConnection();
            result = runner.query(connection, sql, new ScalarHandler<>());
            return result==null?0:result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result==null?0:result;
    }

    @Override
    public List<Order> queryOrder(String sql) {
        List<Order> orders = null;
        try {
            QueryRunner runner = new QueryRunner();
            Connection connection = JDBCUtil.getConnection();
            orders = runner.query(connection, sql, new BeanListHandler<Order>(Order.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (orders==null||orders.isEmpty())?null:orders;
    }

    @Override
    public boolean completePay(String orderNumber) {
        String sql = "update orders set charge_state = 'paid' where ordernumber = ?";
        int result = 1;
        try {
            QueryRunner runner = new QueryRunner();
            Connection connection = JDBCUtil.getConnection();
            result = runner.execute(connection,sql,orderNumber);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return result==1?true:false;
    }
}
