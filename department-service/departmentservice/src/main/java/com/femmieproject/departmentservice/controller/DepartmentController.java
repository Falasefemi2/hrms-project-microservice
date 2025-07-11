package com.femmieproject.departmentservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.femmieproject.departmentservice.model.Department;
import com.femmieproject.departmentservice.repository.DepartmentRepository;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentRepository departmentRepository;

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        return ResponseEntity.ok(departmentRepository.save(department));
    }

    @GetMapping("/{code}")
    public ResponseEntity<Department> getDepartmentByCode(@PathVariable String code) {
        return ResponseEntity.ok(departmentRepository.findByDepartmentCode(code));
    }
}
