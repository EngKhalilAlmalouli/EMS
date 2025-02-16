package com.example.ems.employees;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;


@Data
public class EmployeeRequest {
    @NotNull(message = "firstName should not be null")
    @NotEmpty(message = "firstName should not be null")
    @Size(min = 3, max = 20 , message = "firstName must be at least 3 characters long")
    @NotBlank(message = "Please provide a firstName")
    private String firstName;
    @NotNull(message = "lastName should not be null")
    @NotEmpty(message = "lastName should not be null")
    @NotBlank(message = "Please provide a lastName")
    private String lastName;
    @NotNull(message = "email should not be null")
    @NotEmpty(message = "email should not be null")
    @Email(message = "Please provide a email")
    private String email;
    @NotNull(message = "phone should not be null")
    @NotEmpty(message = "phone should not be null")
    @NotBlank(message = "Please provide a phone")
    private String phone;
    @NotNull(message = "department should not be null")
    @NotEmpty(message = "department should not be null")
    @NotBlank(message = "Please provide a department")
    private Integer department;
    @NotNull(message = "projectId should not be null")
    @NotEmpty(message = "projectId should not be null")
    @NotBlank(message = "Please provide a projectId")
    private List<Integer> projectId;
}
