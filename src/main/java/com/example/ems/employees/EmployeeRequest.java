package com.example.ems.employees;

import lombok.Data;

import java.util.List;


@Data
public class EmployeeRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Integer department;
    private List<Integer> projectId;
}
