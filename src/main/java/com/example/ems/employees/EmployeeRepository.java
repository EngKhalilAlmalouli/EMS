package com.example.ems.employees;

import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Entity
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
