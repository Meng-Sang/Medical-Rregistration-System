package com.sangmeng.dao;

import com.sangmeng.entity.Order;

import java.util.List;

public interface OrderDao {
    public boolean isExsit(String orderNumber);
    public Order queryByOrderNumber(String orderNumber);
    public int addOrder(Order order);
    public long queryOrderNumForSelf(String sql,String username);
    public List<Order> queryOrderForSelf(String sql, String username);
    public long queryOrderNum(String sql);
    public List<Order> queryOrder(String sql);
    public boolean completePay(String orderNumber);
}
