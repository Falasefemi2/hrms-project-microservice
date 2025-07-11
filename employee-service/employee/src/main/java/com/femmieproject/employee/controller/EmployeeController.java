package com.femmieproject.employee.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.femmieproject.employee.client.DepartmentClient;
import com.femmieproject.employee.dto.DepartmentDto;
import com.femmieproject.employee.model.Employee;
import com.femmieproject.employee.repository.EmployeeRepository;
import com.femmieproject.employee.response.EmployeeResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final DepartmentClient departmentClient;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeRepository.save(employee));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/with-department")
    public ResponseEntity<EmployeeResponse> getEmployeeWithDepartment(@PathVariable Long id) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    EmployeeResponse response = new EmployeeResponse();
                    response.setEmployee(employee);

                    DepartmentDto dept = departmentClient.getDepartmentByCode(employee.getDepartmentCode());
                    response.setDepartment(dept);

                    return ResponseEntity.ok(response);
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
