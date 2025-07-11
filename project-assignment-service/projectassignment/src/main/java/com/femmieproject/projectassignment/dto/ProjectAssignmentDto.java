package com.femmieproject.projectassignment.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectAssignmentDto {
    private String projectName;
    private EmployeeDto employee;
}