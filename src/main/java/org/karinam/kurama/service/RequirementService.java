package org.karinam.kurama.service;

import lombok.RequiredArgsConstructor;
import org.karinam.kurama.entity.domain.exceptions.RequirementNotFoundException;
import org.karinam.kurama.entity.model.Project;
import org.karinam.kurama.entity.model.ProjectComponent;
import org.karinam.kurama.entity.model.Requirement;
import org.karinam.kurama.entity.model.dto.RequirementDTO;
import org.karinam.kurama.entity.model.dto.RequirementShortDTO;
import org.karinam.kurama.repository.ProjectComponentRepository;
import org.karinam.kurama.repository.ProjectRepository;
import org.karinam.kurama.repository.RequirementRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequirementService {
    private final ProjectComponentRepository projectComponentRepository;
    private final RequirementRepository repository;
    private final ProjectRepository projectRepository;

    public RequirementDTO getRequirementById(Long id) {
        Requirement requirement = repository.findById(id).orElseThrow(()
                -> new RequirementNotFoundException(id));
        return new RequirementDTO(requirement);
    }

    public List<RequirementShortDTO> getAllRequirementsByProjectId(Long projectId) {
        Project project = projectRepository.getReferenceById(projectId);
        List<RequirementShortDTO> requirementShortDTOList = new ArrayList<>();
        if (project.getProjectComponents() != null) {
            for (ProjectComponent projectComponent : project.getProjectComponents()) {
                if (projectComponent.getRequirements() != null) {
                    for (Requirement requirement : projectComponent.getRequirements()) {
                        RequirementShortDTO requirementShortDTO = new RequirementShortDTO(requirement);
                        requirementShortDTOList.add(requirementShortDTO);

                    }
                }
            }
        }
        return requirementShortDTOList;
    }

    public RequirementDTO saveRequirement(RequirementDTO requirementDTO) {
        Requirement requirement = new Requirement();
        requirement.setRequirementName(requirementDTO.getName());
        requirement.setDescription(requirementDTO.getDescription());
        requirement.setProjectComponent(projectComponentRepository.getReferenceById(requirementDTO.getProjectId()));
        requirement.setProjectComponent(projectComponentRepository.getReferenceById(requirementDTO.getProjectComponentId()));
        return new RequirementDTO(repository.save(requirement));
    }

}
