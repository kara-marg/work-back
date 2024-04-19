package org.karinam.kurama.controller;

import lombok.RequiredArgsConstructor;
import org.karinam.kurama.entity.model.Project;
import org.karinam.kurama.entity.model.dto.ProjectDTO;
import org.karinam.kurama.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/save")
    public Project saveProject(@RequestBody Project project){
        return projectService.saveProject(project);
    }

    @GetMapping("/{projectId}")
    public ProjectDTO getById(@PathVariable Long projectId) {
        return projectService.getByProjectId(projectId);
    }


    @GetMapping("/all")
    public  List<ProjectDTO>getAll() {
        return projectService.getAllProjectDTO();
    }


}
