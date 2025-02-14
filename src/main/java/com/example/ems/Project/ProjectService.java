package com.example.ems.Project;


import com.example.ems.configuration.NotFoundInDatabaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public List<?> getAllProjects() {
        return projectRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public ResponseEntity<?> getProjectById(Integer id) throws NotFoundInDatabaseException {
        Project project = projectRepository.findById(id)
                .orElseThrow(()-> new NotFoundInDatabaseException("Project not found"));

        ProjectResponse response = mapToResponse(project);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    public ResponseEntity<?> createProject(ProjectRequest request){
        Project project = new Project();
        project.setName(request.getName());
        project.setDescription(request.getDescription());
        projectRepository.save(project);

        ProjectResponse response = mapToResponse(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

public ProjectResponse updateProject(Integer id, ProjectRequest request) throws NotFoundInDatabaseException {
        Project project = projectRepository.findById(id)
                .orElseThrow(()-> new NotFoundInDatabaseException("Project not found"));
        project.setName(request.getName());
        project.setDescription(request.getDescription());

        projectRepository.save(project);
        return mapToResponse(project);
}

public ResponseEntity<?> deleteProject(Integer id) throws NotFoundInDatabaseException {
        Project project = projectRepository.findById(id)
                .orElseThrow(()-> new NotFoundInDatabaseException("Project not found"));
        if (project == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Project not found");
        }

        projectRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Project deleted successfully");
}



    private ProjectResponse mapToResponse(Project project) {
        ProjectResponse response = ProjectResponse.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .build();
        return response;
    }
}