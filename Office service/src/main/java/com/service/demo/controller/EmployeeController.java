package com.service.demo.controller;

import com.service.demo.dto.EmployeeDto;
import com.service.demo.dto.DefaultResponseDto;
import com.service.demo.service.impl.EmployeeService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public DefaultResponseDto saveEmployee(@RequestBody EmployeeDto employeeDto) {
        employeeService.saveEmployee(employeeDto);

        return DefaultResponseDto.builder().date(LocalDateTime.now()).build();
    }
}
