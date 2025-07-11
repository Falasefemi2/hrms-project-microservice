package com.femmieproject.employee.response;

import com.femmieproject.employee.dto.DepartmentDto;
import com.femmieproject.employee.model.Employee;

import lombok.Data;

@Data
public class EmployeeResponse {
    private Employee employee;
    private DepartmentDto department;
}