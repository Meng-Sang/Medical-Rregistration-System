package com.sangmeng.service;

import com.sangmeng.entity.IdInformation;

public interface IdInformationService {
    public IdInformation queryIdInformationByUsername(String username);
    public int addIdInformation(IdInformation idInformation);
    public int updateIdInformation(IdInformation idInformation);

}
