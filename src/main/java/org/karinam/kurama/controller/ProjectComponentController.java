package org.karinam.kurama.controller;

import lombok.RequiredArgsConstructor;
import org.karinam.kurama.entity.model.dto.ProjectComponentDTO;
import org.karinam.kurama.service.ProjectComponentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project-component")
@RequiredArgsConstructor
public class ProjectComponentController {
    final ProjectComponentService projectComponentService;

    @PostMapping("/save")
    public ProjectComponentDTO saveProject(@RequestBody ProjectComponentDTO projectComponent) {
        return projectComponentService.saveProjectComponent(projectComponent);
    }

    @GetMapping("/{projectComponentId}")
    public ProjectComponentDTO getById(@PathVariable Long projectComponentId) {
        return projectComponentService.getProjectComponentById(projectComponentId);
    }
    @GetMapping("/all")
    public List<ProjectComponentDTO>getAll(){
        return projectComponentService.getAllProjectComponentDTO();
    }

    @GetMapping("/project/{projectId}")
    public List<ProjectComponentDTO> getAllByProjectId(@PathVariable Long projectId){
        return projectComponentService.getAllByProjectId(projectId);
    }



}
