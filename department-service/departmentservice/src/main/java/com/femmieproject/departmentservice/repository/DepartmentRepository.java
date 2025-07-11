package com.femmieproject.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.femmieproject.departmentservice.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentCode(String code);
}