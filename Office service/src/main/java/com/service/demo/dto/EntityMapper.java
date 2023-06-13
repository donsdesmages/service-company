package com.service.demo.dto;

import com.service.demo.db.EmployeeEntity;
import com.service.demo.db.PositionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EntityMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "positionId", source = "position.id")
    @Mapping(target = "name", source = "employee.name")
    @Mapping(target = "salary", source = "employee.salary")
    EmployeeEntity toEntity(EmployeeDto employee, PositionEntity position);
}
