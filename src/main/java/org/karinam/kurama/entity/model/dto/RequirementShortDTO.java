package org.karinam.kurama.entity.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.karinam.kurama.entity.model.Requirement;

@Getter
@Setter
@NoArgsConstructor
public class RequirementShortDTO {
    private Long id;

    private String name;

    private String description;

    private Long projectComponentId;

    private Long projectId;

    private String projectComponentName;

    private String projectName;

    public RequirementShortDTO(Requirement requirement) {
        this.id = requirement.getId();
        this.name = requirement.getRequirementName();
        this.description = requirement.getDescription();
        this.projectId = requirement.getProjectComponent().getProject().getId();
        this.projectComponentId = requirement.getProjectComponent().getId();
        this.projectName = requirement.getProjectComponent().getProject().getProjectName();
        this.projectComponentName = requirement.getProjectComponent().getName();

    }
}
