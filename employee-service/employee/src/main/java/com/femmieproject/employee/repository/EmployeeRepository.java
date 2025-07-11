package com.femmieproject.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.femmieproject.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}