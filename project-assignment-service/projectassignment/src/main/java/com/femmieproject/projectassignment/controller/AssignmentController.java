package com.femmieproject.projectassignment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.femmieproject.projectassignment.client.EmployeeClient;
import com.femmieproject.projectassignment.dto.EmployeeDto;
import com.femmieproject.projectassignment.dto.ProjectAssignmentDto;
import com.femmieproject.projectassignment.model.EmployeeProjectAssignment;
import com.femmieproject.projectassignment.repository.EmployeeProjectAssignmentRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/assignments")
@RequiredArgsConstructor
public class AssignmentController {

    private final EmployeeProjectAssignmentRepository assignmentRepository;
    private final EmployeeClient employeeClient;

    @PostMapping
    public ResponseEntity<ProjectAssignmentDto> assignEmployeeToProject(
            @RequestBody EmployeeProjectAssignment assignment) {
        EmployeeProjectAssignment saved = assignmentRepository.save(assignment);
        EmployeeDto employee = employeeClient.getEmployeeById(saved.getEmployeeId());

        ProjectAssignmentDto dto = ProjectAssignmentDto.builder()
                .projectName(saved.getProjectName())
                .employee(employee)
                .build();

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<ProjectAssignmentDto>> getProjectsByEmployee(@PathVariable Long employeeId) {
        List<EmployeeProjectAssignment> assignments = assignmentRepository.findByEmployeeId(employeeId);
        EmployeeDto employee = employeeClient.getEmployeeById(employeeId);

        List<ProjectAssignmentDto> response = assignments.stream().map(assignment -> ProjectAssignmentDto.builder()
                .projectName(assignment.getProjectName())
                .employee(employee)
                .build()).collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/project/{projectName}")
    public ResponseEntity<List<EmployeeProjectAssignment>> getEmployeesByProject(@PathVariable String projectName) {
        return ResponseEntity.ok(assignmentRepository.findByProjectName(projectName));
    }

}
