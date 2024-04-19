package org.karinam.kurama.entity.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.karinam.kurama.entity.model.Project;
import org.karinam.kurama.entity.model.ProjectComponent;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProjectDTO {
    private Long id;

    private String name;

    private String description;

    private List<ProjectComponentDTO> projectComponents;


    public ProjectDTO(Project project) {
        this.id = project.getId();
        this.name = project.getProjectName();
        this.description = project.getDescription();
        this.projectComponents = new ArrayList<>();
        for (ProjectComponent projectComponent : project.getProjectComponents()) {
            this.projectComponents.add(new ProjectComponentDTO(projectComponent));
        }
    }
}
