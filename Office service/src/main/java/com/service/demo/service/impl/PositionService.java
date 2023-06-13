package com.service.demo.service.impl;

import com.service.demo.db.PositionEntity;
import com.service.demo.dto.PositionEnum;

public interface PositionService {
    PositionEntity getPositionByName(PositionEnum position);
}
