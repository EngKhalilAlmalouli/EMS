package com.example.ems.employees;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
    private Integer emplyeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Integer department;
    private List<Integer> projectIds;
}
