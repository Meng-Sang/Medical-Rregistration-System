package com.sangmeng.service.impl;

import com.sangmeng.dao.AdministrativeDao;
import com.sangmeng.dao.impl.AdministrativeDaoImpl;
import com.sangmeng.entity.Administrative;

import java.util.List;

public class AdministrativeServiceImpl implements AdministrativeDao {
    @Override
    public List<Administrative> queryAll() {
        return new AdministrativeDaoImpl().queryAll();
    }

    @Override
    public Administrative queryByAd_no(String ad_no) {
        return new AdministrativeDaoImpl().queryByAd_no(ad_no);
    }
}
