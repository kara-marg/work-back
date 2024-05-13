package org.karinam.kurama.entity.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.karinam.kurama.entity.model.Project;
import org.karinam.kurama.entity.model.ProjectComponent;
import org.karinam.kurama.entity.model.Requirement;
import org.karinam.kurama.entity.model.TestCase;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class TestCaseDTO {
    private Long id;

    private String name;

    private String description;

    private Long projectId;

    private Long projectComponentId;

    private String projectName;

    private String projectComponentName;

    private List<RequirementShortDTO> requirementShortDTOList;


    public TestCaseDTO(TestCase testCase) {
        this.id = testCase.getId();
        this.name = testCase.getTestCaseName();
        this.description = testCase.getDescription();
        this.requirementShortDTOList = new ArrayList<>();
        if (testCase.getRequirements() != null) {
            for (Requirement requirement : testCase.getRequirements()) {
                this.requirementShortDTOList.add(new RequirementShortDTO(requirement));
            }

            if (!testCase.getRequirements().isEmpty()) {
                Project project = testCase.getRequirements().getFirst().getProjectComponent().getProject();
                this.projectName = project.getProjectName();
                this.projectId = project.getId();
                ProjectComponent projectComponent = testCase.getRequirements().getFirst().getProjectComponent();
                this.projectComponentId = projectComponent.getId();
                this.projectComponentName = projectComponent.getName();
            }
        }


    }

}
