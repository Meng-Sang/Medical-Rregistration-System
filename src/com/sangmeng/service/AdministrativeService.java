package com.sangmeng.service;

import com.sangmeng.entity.Administrative;

import java.util.List;

public interface AdministrativeService {
    public List<Administrative> queryAll();
    public Administrative queryByAd_no(String ad_no);
}
