package com.service.demo.service.impl;


import com.service.demo.db.EmployeeEntity;
import com.service.demo.dto.EmployeeDto;
import com.service.demo.dto.PositionEnum;

import java.util.List;


public interface EmployeeService  {

    void saveEmployee(EmployeeDto employeeDto);

    List<EmployeeEntity> findEmployeeByPositionId(PositionEnum posId);

}
