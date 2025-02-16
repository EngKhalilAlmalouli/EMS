package com.example.ems.Department;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DepartmentRequest {
    @NotNull(message = "departmentName should not be null")
    @NotEmpty(message = "departmentName should not be null")
    @NotBlank(message = "Please provide a departmentName")
    private String departmentName;
    @NotNull(message = "departmentDescription should not be null")
    @NotEmpty(message = "departmentDescription should not be null")
    @NotBlank(message = "Please provide a departmentDescription")
    private String departmentDescription;

}
