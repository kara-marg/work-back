package org.karinam.kurama.service;

import lombok.RequiredArgsConstructor;
import org.karinam.kurama.entity.domain.exceptions.ProjectComponentNotFoundException;
import org.karinam.kurama.entity.domain.exceptions.ProjectNotFoundException;
import org.karinam.kurama.entity.model.ProjectComponent;
import org.karinam.kurama.entity.model.dto.ProjectComponentDTO;
import org.karinam.kurama.repository.ProjectComponentRepository;
import org.karinam.kurama.repository.ProjectRepository;
import org.springframework.stereotype.Service;

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


}
