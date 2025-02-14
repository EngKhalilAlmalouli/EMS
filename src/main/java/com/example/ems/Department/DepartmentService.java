package com.example.ems.Department;

import com.example.ems.configuration.NotFoundInDatabaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<?> getAllDepartments() {
        return departmentRepository.findAll();
    }


    public ResponseEntity<?> getDepartmentById(Integer id) throws NotFoundInDatabaseException {
        Department department = departmentRepository.findById(id).orElseThrow(NotFoundInDatabaseException::new);

        DepartmentResponse response = mapToResponse(department);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    public ResponseEntity<?> createDepartment(DepartmentRequest request) {
        Department department = Department.builder()
                .name(request.getDepartmentName())
                .description(request.getDepartmentName())
                .build();

        DepartmentResponse response = mapToResponse(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    public DepartmentResponse updateDepartment(Integer id, DepartmentRequest request) throws NotFoundInDatabaseException {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundInDatabaseException("Department not found"));
        department.setName(request.getDepartmentName());
        department.setDescription(request.getDepartmentName());

        departmentRepository.save(department);
        return mapToResponse(department);

    }


    public ResponseEntity<?> deleteDepartment(Integer id) throws NotFoundInDatabaseException {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundInDatabaseException("Department not found"));

        if (department == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department not found");
        }
        departmentRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Department deleted successfully");
    }



    private DepartmentResponse mapToResponse(Department department) {
        return DepartmentResponse.builder()
                .name(department.getName())
                .description(department.getDescription())
                .build();

    }
}
