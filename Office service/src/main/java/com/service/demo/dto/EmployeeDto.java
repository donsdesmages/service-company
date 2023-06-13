package com.service.demo.dto;

import com.service.demo.db.DepartmentEntity;
import com.service.demo.db.EmployeeEntity;
import com.service.demo.db.OfficeEntity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
public class EmployeeDto {
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotBlank
    private Integer age;
    @NotBlank
    private LocalDate birthdate;
    private Long salary;
    @NotBlank
    private DepartmentEntity department;
    @NotBlank
    private PositionEnum positionName;
    @NotBlank
    private Long officeNumber;
    @NotBlank
    private Long getCurrent;
    @NotBlank
    private EmployeeEntity director;

}
