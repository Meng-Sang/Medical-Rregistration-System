package com.sangmeng.service;

import com.sangmeng.entity.Order;
import com.sangmeng.util.PageUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.util.List;

public interface OrderService {
    public boolean addOrder(Order order,int accountBalance);
    public int queryTotalOrderNumForSelf(String username);
    public int queryUnpaidOrderNumForSelf(String username);
    public int queryPaidOrderNumForSelf(String username);
    public List<Order> queryTotalOrderForSelf(String username,PageUtil pageUtil);
    public List<Order> queryUnpaidOrderForSelf(String username,PageUtil pageUtil);
    public List<Order> queryPaidOrderForSelf(String username,PageUtil pageUtil);
    public int queryTotalOrderNum();
    public int queryUnpaidOrderNum();
    public int queryPaidOrderNum();
    public List<Order> queryTotalOrder(PageUtil pageUtil);
    public List<Order> queryUnpaidOrder(PageUtil pageUtil);
    public List<Order> queryPaidOrder(PageUtil pageUtil);
    public int completeOrder(String ordernumber,String username);
}
