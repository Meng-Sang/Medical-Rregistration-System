package com.sangmeng.service.impl;

import com.sangmeng.dao.impl.InvestDaoImpl;
import com.sangmeng.dao.impl.LoginDaoImpl;
import com.sangmeng.entity.Invest;
import com.sangmeng.entity.Login;
import com.sangmeng.service.InvestService;
import com.sangmeng.util.JDBCUtil;
import com.sangmeng.util.PageUtil;

import java.sql.SQLException;
import java.util.List;

public class InvestServiceImpl implements InvestService {
    private String getLimit(PageUtil pageUtil){
        return PageUtil.getLimit(pageUtil);
    }
    @Override
    public boolean addInvest(Invest invest,int accountBalance) {
        InvestDaoImpl investDaoImpl = new InvestDaoImpl();
        if(investDaoImpl.queryByInvestNumber(invest.getInvestNumber())!=null)
        {
            return false;
        }
        if(investDaoImpl.addInvest(invest)==1&&new LoginDaoImpl().updateBalance(invest.getUsername(),accountBalance))
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
    public int queryTotalInvestNumForSelf(String username) {
        String sql = "select count(*) from invests where username= ?";
        return (int)(new InvestDaoImpl().queryInvestNumForSelf(sql,username));
    }

    @Override
    public int queryUnpaidInvestNumForSelf(String username) {
        String sql = "select count(*) from invests where username= ? and state = 'unpaid'";
        return (int)(new InvestDaoImpl().queryInvestNumForSelf(sql,username));
    }

    @Override
    public int queryPaidInvestNumForSelf(String username) {
        String sql = "select count(*) from invests where username= ? and state = 'paid'";
        return (int)(new InvestDaoImpl().queryInvestNumForSelf(sql,username));
    }

    @Override
    public List<Invest> queryTotalInvestForSelf(String username, PageUtil pageUtil) {
        String sql = "select *  from (select * from invests where username = ? order by investnumber desc) as new limit"+getLimit(pageUtil);
        return new InvestDaoImpl().queryInvestForSelf(sql,username);
    }

    @Override
    public List<Invest> queryUnpaidInvestForSelf(String username, PageUtil pageUtil) {
        String sql = "select *  from (select * from invests where username= ? and state='unpaid' order by investnumber desc) as new limit"+getLimit(pageUtil);
        return new InvestDaoImpl().queryInvestForSelf(sql,username);
    }

    @Override
    public List<Invest> queryPaidInvestForSelf(String username, PageUtil pageUtil) {
        String sql = "select *  from (select * from invests where username = ? and state='paid' order by investnumber desc) as new limit"+getLimit(pageUtil);
        return new InvestDaoImpl().queryInvestForSelf(sql,username);
    }

    @Override
    public int queryTotalInvestNum() {
        String sql = "select count(username) from invests";
        return (int)(new InvestDaoImpl().queryInvestNum(sql));
    }

    @Override
    public int queryUnpaidInvestNum() {
        String sql = "select count(username) from invests where state='unpaid'";
        return (int)(new InvestDaoImpl().queryInvestNum(sql));
    }

    @Override
    public int queryPaidInvestNum() {
        String sql = "select count(username) from invests where state='paid'";
        return (int)(new InvestDaoImpl().queryInvestNum(sql));
    }

    @Override
    public List<Invest> queryTotalInvest(PageUtil pageUtil) {
        String sql = "select *  from (select * from invests order by investnumber desc) as new limit"+getLimit(pageUtil);
        return new InvestDaoImpl().queryInvest(sql);
    }

    @Override
    public List<Invest> queryUnpaidInvest(PageUtil pageUtil) {
        String sql = "select *  from (select * from invests where state='unpaid' order by investnumber desc) as new limit"+getLimit(pageUtil);
        return new InvestDaoImpl().queryInvest(sql);
    }

    @Override
    public List<Invest> queryPaidInvest(PageUtil pageUtil) {
        String sql = "select *  from (select * from invests where state='paid' order by investnumber desc) as new limit"+getLimit(pageUtil);
        return new InvestDaoImpl().queryInvest(sql);
    }

    @Override
    public int completeInvest(String investNumber, String username) {
        Login login = new LoginDaoImpl().queryByUserName(username);
        Invest invest = new InvestDaoImpl().queryByInvestNumber(investNumber);
        int result = 1;
        if(new LoginDaoImpl().updateBalance(username,login.getAccountBalance()+invest.getAmount())&&new InvestDaoImpl().completePay(investNumber)){
            return result;
        }
        else
        {
            try {
                JDBCUtil.rollbackTransaction();
            } catch (SQLException e) {
                e.printStackTrace();
                return -result;
            }
        }
        return 0;
    }
}
