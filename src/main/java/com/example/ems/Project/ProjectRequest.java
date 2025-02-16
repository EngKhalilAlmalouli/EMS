package com.example.ems.Project;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProjectRequest {


    @NotNull(message = "id should not be null")
    @NotEmpty(message = "id should not be null")
    private Integer id;
    @NotNull(message = "name should not be null")
    @NotEmpty(message = "name should not be null")
    @NotBlank(message = "Please provide a name")
    private String name;
    @NotNull(message = "description should not be null")
    @NotEmpty(message = "description should not be null")
    @NotBlank(message = "Please provide a description")
    private String description;

}
