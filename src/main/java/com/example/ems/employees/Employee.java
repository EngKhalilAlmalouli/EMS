package com.example.ems.employees;

import com.example.ems.Department.Department;
import com.example.ems.Project.Project;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "EMPLOYEES")
public class Employee {
    @Id
    @Column(name = "EMPLOYEE_ID")
    @GeneratedValue
    private Integer id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    private String lastName;
    private String email;
    private String phone;


    @ManyToOne
    private Department department;

    @ManyToMany(mappedBy = "employees")
    private List<Project> projects;
}