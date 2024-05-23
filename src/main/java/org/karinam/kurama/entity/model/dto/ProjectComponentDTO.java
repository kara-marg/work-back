package org.karinam.kurama.entity.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.karinam.kurama.entity.model.ProjectComponent;
import org.karinam.kurama.entity.model.Requirement;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProjectComponentDTO {
    private Long id;

    private String name;

    private String description;

    private Boolean finished;

    private Long projectId;

    private String projectName;

    private List<RequirementDTO> requirements;

    private Double coverage;

    public ProjectComponentDTO(ProjectComponent projectComponent) {
        this.id = projectComponent.getId();
        this.name = projectComponent.getName();
        this.description = projectComponent.getDescription();
        this.finished = projectComponent.getFinished();
        this.projectId = projectComponent.getProject().getId();
        this.projectName = projectComponent.getProject().getProjectName();
        this.requirements = new ArrayList<>();
        if (projectComponent.getRequirements() != null) {
            for (Requirement requirement : projectComponent.getRequirements()) {
                this.requirements.add(new RequirementDTO(requirement));
            }
        }
        calculateCoverage();
    }

    private void calculateCoverage(){
        double requirementsNumber = this.requirements != null ? this.requirements.size() : 0;
        if (requirementsNumber == 0 ) {
            this.coverage = 0d;
            return;
        }

        double coveredRequirements = 0;
        for (RequirementDTO requirement : this.requirements) {
            if (requirement.getTestCases() != null && !requirement.getTestCases().isEmpty()) {
                coveredRequirements++;
            }
        }

        this.coverage = (double) (coveredRequirements/requirementsNumber)*100;
    }
}
