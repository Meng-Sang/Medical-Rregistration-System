package com.sangmeng.dao;

import com.sangmeng.entity.Invest;
import com.sangmeng.entity.Invest;

import java.util.List;

public interface InvestDao {
    public Invest queryByInvestNumber(String investNumber);
    public int addInvest(Invest invest);
    public long queryInvestNumForSelf(String sql,String username);
    public List<Invest> queryInvestForSelf(String sql, String username);
    public long queryInvestNum(String sql);
    public List<Invest> queryInvest(String sql);
    public boolean completePay(String InvestNumber);
}
