package com.service.demo.service;

import com.service.demo.db.OfficeEntity;
import com.service.demo.exception.NotOfficeNumberException;
import com.service.demo.repository.OfficeRepository;
import com.service.demo.service.impl.OfficeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OfficeServiceImpl implements OfficeService {

    private final OfficeRepository officeRepository;

    @Override
    public OfficeEntity findOfficeEntityByOfficeNumber(Long officeNumber) {
        return officeRepository.findOfficeEntityByNumberOffice(officeNumber)
            .orElseThrow(() -> { throw new NotOfficeNumberException(officeNumber); });
    }

    @Override
    public void save(OfficeEntity office) {
        officeRepository.save(office);
    }

    @Override
    public OfficeEntity findOfficeCurrentWorkLoad(Long current) {
        return officeRepository.findOfficeEntityByCurrentWorkload(current);
    }

}
