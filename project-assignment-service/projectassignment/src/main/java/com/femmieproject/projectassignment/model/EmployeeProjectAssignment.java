package com.femmieproject.projectassignment.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee_project_assignments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeProjectAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private String projectName;

}
