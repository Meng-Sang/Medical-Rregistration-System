package com.sangmeng.service;

import com.sangmeng.entity.Invest;
import com.sangmeng.util.PageUtil;

import java.util.List;

public interface InvestService {
    public boolean addInvest(Invest invest,int accountBalance);
    public int queryTotalInvestNumForSelf(String username);
    public int queryUnpaidInvestNumForSelf(String username);
    public int queryPaidInvestNumForSelf(String username);
    public List<Invest> queryTotalInvestForSelf(String username, PageUtil pageUtil);
    public List<Invest> queryUnpaidInvestForSelf(String username,PageUtil pageUtil);
    public List<Invest> queryPaidInvestForSelf(String username,PageUtil pageUtil);
    public int queryTotalInvestNum();
    public int queryUnpaidInvestNum();
    public int queryPaidInvestNum();
    public List<Invest> queryTotalInvest(PageUtil pageUtil);
    public List<Invest> queryUnpaidInvest(PageUtil pageUtil);
    public List<Invest> queryPaidInvest(PageUtil pageUtil);
    public int completeInvest(String investnumber,String username);
}
