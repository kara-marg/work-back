package org.karinam.kurama.entity.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.karinam.kurama.entity.model.*;

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
    private List<StepDTO> steps;


    public TestCaseDTO(TestCase testCase) {
        this.id = testCase.getId();
        this.name = testCase.getTestCaseName();
        this.description = testCase.getDescription();
        this.requirementShortDTOList = new ArrayList<>();
        this.steps = new ArrayList<>();
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
        if (testCase.getSteps() != null) {
            for (Step step : testCase.getSteps()) {
                this.steps.add(new StepDTO(step));
            }
        }


    }

}
