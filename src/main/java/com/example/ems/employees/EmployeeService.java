package com.example.ems.employees;

import com.example.ems.Department.Department;
import com.example.ems.Department.DepartmentRepository;
import com.example.ems.Project.Project;
import com.example.ems.Project.ProjectRepository;
import com.example.ems.Project.ProjectRequest;
import com.example.ems.configuration.NotFoundInDatabaseException;
import com.example.ems.validation.ObjectValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final ProjectRepository projectRepository;
    private final ObjectValidator<EmployeeRequest> validator;


    public List<?> getAllEmployees() {
        return employeeRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public EmployeeResponse getEmployeeById(Integer id) {
        return employeeRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public EmployeeResponse createEmployee(EmployeeRequest request) {
        validator.validate(request);
        Department department = departmentRepository.findById(request.getDepartment())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        List<Project> projects = new ArrayList<>();
        for (Integer id : request.getProjectId()) {
            Project project = projectRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Project not found"));
            if (project != null) {
                projects.add(project);
            }
        }

        Employee employee = Employee.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .department(department)
                .projects(projects)
                .build();

        employeeRepository.save(employee);
        return mapToResponse(employee);
    }

    public EmployeeResponse updateEmployee(Integer id, EmployeeRequest request) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Department department = departmentRepository.findById(request.getDepartment())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        validator.validate(request);
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setDepartment(department);

        employee = employeeRepository.save(employee);
        return mapToResponse(employee);
    }

    public ResponseEntity<?> deleteEmployee(Integer id) throws NotFoundInDatabaseException {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundInDatabaseException("Employee not found"));

        projectRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Employee deleted successfully");
    }


    private EmployeeResponse mapToResponse(Employee employee) {
        List<Integer> employeesIds = new ArrayList<>();
        return EmployeeResponse.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .phone(employee.getPhone())
                .build();
    }
}
