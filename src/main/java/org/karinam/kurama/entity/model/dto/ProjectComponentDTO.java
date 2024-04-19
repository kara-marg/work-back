package org.karinam.kurama.entity.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.karinam.kurama.entity.model.ProjectComponent;
import org.karinam.kurama.entity.model.Requirement;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class ProjectComponentDTO {
    private Long id;

    private String name;

    private String description;

    private Boolean finished;

    private Long projectId;

    private List<RequirementDTO> requirements;

    public ProjectComponentDTO(ProjectComponent projectComponent) {
        this.id = projectComponent.getId();
        this.name = projectComponent.getName();
        this.description = projectComponent.getDescription();
        this.finished = projectComponent.getFinished();
        this.projectId = projectComponent.getProject().getId();
        this.requirements = new ArrayList<>();
        for (Requirement requirement : projectComponent.getRequirements()) {
            this.requirements.add(new RequirementDTO(requirement));
        }
    }
}
