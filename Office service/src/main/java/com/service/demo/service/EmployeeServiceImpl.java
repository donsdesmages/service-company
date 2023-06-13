package com.service.demo.service;

import com.service.demo.db.EmployeeEntity;
import com.service.demo.db.OfficeEntity;
import com.service.demo.db.PositionEntity;
import com.service.demo.dto.EmployeeDto;
import com.service.demo.dto.EntityMapper;
import com.service.demo.dto.PositionEnum;
import com.service.demo.exception.NotPlacesInOfficeException;
import com.service.demo.logg.Const;
import com.service.demo.repository.EmployeeRepository;
import com.service.demo.service.impl.EmployeeService;
import com.service.demo.service.impl.OfficeService;
import com.service.demo.service.impl.PositionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repositoryEmployee;
    private final PositionService positionService;
    private final OfficeService officeService;

    private final EntityMapper mapper;

    @Override
    @Transactional
    public void saveEmployee(EmployeeDto employeeDto) {

        log.info(Const.CREAT_EMPLOYEE_HAS_BEEN_STARTED, employeeDto.getName());

        PositionEntity position = positionService.getPositionByName(employeeDto.getPositionName());
        EmployeeEntity employee = mapper.toEntity(employeeDto, position);

        employee.setSalary((employeeDto.getSalary() != null && employeeDto.getSalary() > 0)
            ? employeeDto.getSalary() : position.getSalary());

        if (!PositionEnum.LEAD.equals(employeeDto.getPositionName())) {
            Optional<EmployeeEntity> possibleLead = findEmployeeByPositionId(PositionEnum.LEAD)
                .stream().findFirst();

            possibleLead.ifPresent((lead) -> employee.setDirector(lead));

            OfficeEntity office = officeService.findOfficeEntityByOfficeNumber(employeeDto.getOfficeNumber());

            if (office.getCurrentWorkload() < office.getCapacity()) {
                office.setCurrentWorkload(office.getCurrentWorkload() + 1);
                officeService.save(office);
            } else {
                log.error(Const.ERROR_ADD_EMPLOYEE);
                throw new NotPlacesInOfficeException(employeeDto.getOfficeNumber());
            }

            employee.setOfficeId(office.getId());
            repositoryEmployee.save(employee);

            log.info(Const.CREAT_EMPLOYEE_FINISHED,
                employee.getId());
        } else {
            OfficeEntity office = officeService.findOfficeEntityByOfficeNumber(employeeDto.getOfficeNumber());

            if (office.getCurrentWorkload() < office.getCapacity()) {
                office.setCurrentWorkload(office.getCurrentWorkload() + 1);
                officeService.save(office);
            } else {
                log.error(Const.ERROR_ADD_EMPLOYEE);
                throw new NotPlacesInOfficeException(employeeDto.getOfficeNumber());
            }
            repositoryEmployee.save(employee);

            log.info(Const.CREAT_EMPLOYEE_FINISHED,
                employee.getId());
        }
    }

    @Override
    public List<EmployeeEntity> findEmployeeByPositionId(PositionEnum posId) {
        return repositoryEmployee.findAllByPositionId(posId.getId());
    }
}
