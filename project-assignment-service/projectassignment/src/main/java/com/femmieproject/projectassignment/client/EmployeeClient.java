package com.femmieproject.projectassignment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.femmieproject.projectassignment.dto.EmployeeDto;

@FeignClient(name = "employee-service")
public interface EmployeeClient {

    @GetMapping("/api/employees/{id}")
    EmployeeDto getEmployeeById(@PathVariable Long id);
}