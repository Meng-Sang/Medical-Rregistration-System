package com.sangmeng.service.impl;

import com.sangmeng.dao.LoginDao;
import com.sangmeng.dao.impl.LoginDaoImpl;
import com.sangmeng.dao.impl.OrderDaoImpl;
import com.sangmeng.entity.Login;
import com.sangmeng.entity.Order;
import com.sangmeng.service.OrderService;
import com.sangmeng.util.JDBCUtil;
import com.sangmeng.util.PageUtil;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private String getLimit(PageUtil pageUtil){
        return PageUtil.getLimit(pageUtil);
    }
    @Override
    public boolean addOrder(Order order,int accountBalance){
        if(new OrderDaoImpl().addOrder(order)==1&&new LoginDaoImpl().updateBalance(order.getUsername(),accountBalance))
        {
            return true;
        }
        try {
            JDBCUtil.rollbackTransaction();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
    @Override
    public int queryTotalOrderNumForSelf(String username) {
        String sql = "select count(username) from orders  where username = ? ";
        return (int)(new OrderDaoImpl().queryOrderNumForSelf(sql,username));
    }

    @Override
    public int queryUnpaidOrderNumForSelf(String username) {
        String sql = "select count(username) from orders  where username = ? and charge_state='unpaid'";
        return (int)(new OrderDaoImpl().queryOrderNumForSelf(sql,username));
    }

    @Override
    public int queryPaidOrderNumForSelf(String username) {
        String sql = "select count(username) from orders  where username = ? and charge_state='paid'";
        return (int)(new OrderDaoImpl().queryOrderNumForSelf(sql,username));
    }

    @Override
    public List<Order> queryTotalOrderForSelf(String username,PageUtil pageUtil) {
        String sql = "select * from (select * from orders  where username = ? order by ordernumber desc) as a limit "+getLimit(pageUtil);
        return new OrderDaoImpl().queryOrderForSelf(sql,username);
    }

    @Override
    public List<Order> queryUnpaidOrderForSelf(String username,PageUtil pageUtil) {
        String sql = "select * from (select * from orders  where username = ? and charge_state='unpaid' order by ordernumber desc) as a limit "+getLimit(pageUtil);
        return new OrderDaoImpl().queryOrderForSelf(sql,username);
    }

    @Override
    public List<Order> queryPaidOrderForSelf(String username,PageUtil pageUtil) {
        String sql = "select * from (select * from orders  where username = ? and charge_state='paid' order by ordernumber desc) as a limit "+getLimit(pageUtil);
        return new OrderDaoImpl().queryOrderForSelf(sql,username);
    }

    @Override
    public int queryTotalOrderNum() {
        String sql = "select count(username) from orders";
        return (int)(new OrderDaoImpl().queryOrderNum(sql));
    }

    @Override
    public int queryUnpaidOrderNum() {
        String sql = "select count(username) from orders  where charge_state='unpaid'";
        return (int)(new OrderDaoImpl().queryOrderNum(sql));
    }

    @Override
    public int queryPaidOrderNum() {
        String sql = "select count(username) from orders  where  charge_state='paid'";
        return (int)(new OrderDaoImpl().queryOrderNum(sql));
    }

    @Override
    public List<Order> queryTotalOrder(PageUtil pageUtil) {
        String sql = "select * from (select * from orders order by ordernumber desc) as a limit "+getLimit(pageUtil);
        return new OrderDaoImpl().queryOrder(sql);
    }

    @Override
    public List<Order> queryUnpaidOrder(PageUtil pageUtil) {
        String sql = "select * from (select * from orders  where charge_state='unpaid' order by ordernumber desc) as a limit "+getLimit(pageUtil);
        return new OrderDaoImpl().queryOrder(sql);
    }

    @Override
    public List<Order> queryPaidOrder(PageUtil pageUtil) {
        String sql = "select * from (select * from orders  where  charge_state='paid' order by ordernumber desc) as a limit "+getLimit(pageUtil);
        return new OrderDaoImpl().queryOrder(sql);
    }

    @Override
    public int completeOrder(String orderNumber, String username) {
        int result = 1;
        Login login =new LoginServiceImpl().queryByUsername(username);
        Order order = new OrderDaoImpl().queryByOrderNumber(orderNumber);
        if(login.getAccountBalance()<order.getCharge())
        {
            return 0;
        }
        if(new LoginDaoImpl().updateBalance(username,login.getAccountBalance()-order.getCharge())&&new OrderDaoImpl().completePay(orderNumber))
        {
            return result;
        }else {
            try {
                JDBCUtil.rollbackTransaction();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return -result;
        }
    }
}
