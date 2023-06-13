package com.service.demo.service;

import com.service.demo.db.PositionEntity;
import com.service.demo.dto.PositionEnum;
import com.service.demo.exception.NotSpecifiedSalaryException;
import com.service.demo.repository.PositionRepository;
import com.service.demo.service.impl.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;

    @Override
    public PositionEntity getPositionByName(PositionEnum position) {
        return positionRepository.findPositionEntityByName(position)
            .orElseThrow(() -> { throw new NotSpecifiedSalaryException(position.name()); });
    }
}
