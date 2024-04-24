package com.sangmeng.dao;

import com.sangmeng.entity.Administrative;

import java.util.List;

public interface AdministrativeDao {
    public List<Administrative> queryAll();
    public Administrative queryByAd_no(String ad_no);
}
