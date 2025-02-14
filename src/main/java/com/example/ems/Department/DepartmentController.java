package com.example.ems.Department;


import com.example.ems.configuration.NotFoundInDatabaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<?>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable Integer id) throws NotFoundInDatabaseException {
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> createDepartment(@PathVariable Integer id, @RequestBody DepartmentRequest request) throws NotFoundInDatabaseException {
        return ResponseEntity.ok(departmentService.createDepartment(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable Integer id, @RequestBody DepartmentRequest request) throws NotFoundInDatabaseException {
        return ResponseEntity.ok(departmentService.updateDepartment(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Integer id) throws NotFoundInDatabaseException {
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok().build();
    }
}
