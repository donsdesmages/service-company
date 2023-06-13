package com.service.demo.repository;

import com.service.demo.db.PositionEntity;
import com.service.demo.dto.PositionEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PositionRepository extends JpaRepository<PositionEntity, Long> {
    Optional<PositionEntity> findPositionEntityByName(PositionEnum position);
}
