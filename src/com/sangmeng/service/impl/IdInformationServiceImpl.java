package com.sangmeng.service.impl;

import com.sangmeng.dao.impl.IdInformationDaoImpl;
import com.sangmeng.entity.IdInformation;
import com.sangmeng.service.IdInformationService;

public class IdInformationServiceImpl implements IdInformationService {
    @Override
    public IdInformation queryIdInformationByUsername(String username) {
        return new IdInformationDaoImpl().queryByUsername(username);
    }

    @Override
    public int addIdInformation(IdInformation idInformation) {
        String sql = "insert into idinformations values(?,?,?,?,?,?,?,?,?)";
        Object[] objs = new Object[]{idInformation.getUsername(),idInformation.getName(),idInformation.getId(),
            idInformation.getProvince(),idInformation.getCity(),idInformation.getAddress(),idInformation.getDate(),
            idInformation.getIdp(),idInformation.getIdn()};
        return new IdInformationDaoImpl().update(idInformation,sql,objs);
    }

    @Override
    public int updateIdInformation(IdInformation idInformation) {
        String sql = "update idinformations set name=?,id=?,province=?,city=?,address=?,date=?,idp=?,idn=? where username=?";
        Object[] objs = new Object[]{idInformation.getName(),idInformation.getId(),
                idInformation.getProvince(),idInformation.getCity(),idInformation.getAddress(),idInformation.getDate(),
                idInformation.getIdp(),idInformation.getIdn(),idInformation.getUsername()};
        return new IdInformationDaoImpl().update(idInformation,sql,objs);
    }
}
