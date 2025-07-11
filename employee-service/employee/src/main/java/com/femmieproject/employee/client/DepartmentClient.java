package com.femmieproject.employee.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.femmieproject.employee.dto.DepartmentDto;

@FeignClient(name = "department-service")
public interface DepartmentClient {

    @GetMapping("/api/departments/{code}")
    DepartmentDto getDepartmentByCode(@PathVariable("code") String code);
}
