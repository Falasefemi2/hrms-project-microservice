package com.femmieproject.projectassignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.femmieproject.projectassignment.model.EmployeeProjectAssignment;

public interface EmployeeProjectAssignmentRepository extends JpaRepository<EmployeeProjectAssignment, Long> {
    List<EmployeeProjectAssignment> findByEmployeeId(Long employeeId);

    List<EmployeeProjectAssignment> findByProjectName(String projectName);
}