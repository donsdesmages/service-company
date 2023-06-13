package com.service.demo.repository;

import com.service.demo.db.OfficeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OfficeRepository extends JpaRepository<OfficeEntity, Long> {

    Optional<OfficeEntity> findOfficeEntityByNumberOffice(Long number);

   OfficeEntity findOfficeEntityByCurrentWorkload(Long current);
}
