package com.femmieproject.projectassignment.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String department;
}