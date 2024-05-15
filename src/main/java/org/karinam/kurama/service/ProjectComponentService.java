package org.karinam.kurama.service;

import lombok.RequiredArgsConstructor;
import org.karinam.kurama.entity.domain.exceptions.ProjectComponentNotFoundException;
import org.karinam.kurama.entity.domain.exceptions.ProjectNotFoundException;
import org.karinam.kurama.entity.model.ProjectComponent;
import org.karinam.kurama.entity.model.dto.ProjectComponentDTO;
import org.karinam.kurama.repository.ProjectComponentRepository;
import org.karinam.kurama.repository.ProjectRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectComponentService {
    private final ProjectComponentRepository projectComponentRepository;
    private final ProjectRepository projectRepository;

    public ProjectComponentDTO saveProjectComponent(ProjectComponentDTO projectComponentDTO) {
        ProjectComponent projectComponent = new ProjectComponent();
        projectComponent.setName(projectComponentDTO.getName());
        projectComponent.setDescription(projectComponentDTO.getDescription());
        projectComponent.setProject(projectRepository.getReferenceById(projectComponentDTO.getProjectId()));
        projectComponent.setFinished(projectComponentDTO.getFinished());
        return new ProjectComponentDTO(projectComponentRepository.save(projectComponent));
    }
    public ProjectComponentDTO getProjectComponentById(Long id){
        ProjectComponent projectComponent = projectComponentRepository.findById(id).orElseThrow(()
                -> new ProjectComponentNotFoundException(id));
        return new ProjectComponentDTO(projectComponent);
    }

    public List<ProjectComponentDTO> getAllProjectComponentDTO(){
        List<ProjectComponentDTO> projectComponentDTOList = new ArrayList<>();
        List<ProjectComponent> projectComponentList = projectComponentRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
        projectComponentList.forEach(projectComponent -> {
            ProjectComponentDTO projectComponentDTO = new ProjectComponentDTO(projectComponent);
            projectComponentDTOList.add(projectComponentDTO);
        });
        return projectComponentDTOList;
    }

    public List<ProjectComponentDTO> getAllByProjectId(Long projectId){
        List<ProjectComponentDTO> projectComponentDTOList = new ArrayList<>();
        List<ProjectComponent> projectComponentList = projectComponentRepository.findAllByProjectId(projectId, Sort.by(Sort.Direction.ASC,"id"));
        projectComponentList.forEach(projectComponent -> {
            ProjectComponentDTO projectComponentDTO = new ProjectComponentDTO(projectComponent);
            projectComponentDTOList.add(projectComponentDTO);
        });
        return projectComponentDTOList;
    }
}
