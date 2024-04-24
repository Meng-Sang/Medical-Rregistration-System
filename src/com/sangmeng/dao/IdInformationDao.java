package com.sangmeng.dao;

import com.sangmeng.entity.IdInformation;

public interface IdInformationDao {
    public IdInformation queryByUsername(String username);
    public int update(IdInformation idInformation,String sql,Object...objs);
}
