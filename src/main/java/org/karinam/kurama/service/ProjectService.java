package org.karinam.kurama.service;

import lombok.RequiredArgsConstructor;
import org.karinam.kurama.entity.domain.exceptions.ProjectNotFoundException;
import org.karinam.kurama.entity.model.Project;
import org.karinam.kurama.entity.model.User;
import org.karinam.kurama.entity.model.dto.ProjectDTO;
import org.karinam.kurama.repository.ProjectRepository;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository repository;

    public Project saveProject(Project project) {
        return repository.save(project);
    }

//    public Project getByProjectName(String projectName) {
//        return repository.findByProjectName(projectName).orElseThrow(() -> new UsernameNotFoundException("Project не найден"));
//    }

    public ProjectDTO getByProjectId(Long id) {
        Project project = repository.findById(id).orElseThrow(()
                -> new ProjectNotFoundException(id));
        return new ProjectDTO(project);
    }
    public List<ProjectDTO> getAllProjectDTO(){
        List<ProjectDTO> projectDTOList = new ArrayList<>();
        List<Project> projectList = repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        projectList.forEach(project -> {
            ProjectDTO projectDTO = new ProjectDTO(project);
            projectDTOList.add(projectDTO);
        });
        return projectDTOList;
    }
}

