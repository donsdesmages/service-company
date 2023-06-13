package com.service.demo.service.impl;

import com.service.demo.db.OfficeEntity;


public interface OfficeService {

    OfficeEntity findOfficeEntityByOfficeNumber(Long officeNumber);

    void save(OfficeEntity office);

    OfficeEntity findOfficeCurrentWorkLoad(Long current);
}
