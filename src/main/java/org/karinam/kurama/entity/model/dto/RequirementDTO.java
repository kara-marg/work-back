package org.karinam.kurama.entity.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.karinam.kurama.entity.model.Requirement;
import org.karinam.kurama.entity.model.TestCase;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class RequirementDTO {
    private Long id;

    private String name;

    private String description;

    private Long projectComponentId;

    private List<TestCaseDTO> testCases;

    public RequirementDTO(Requirement requirement) {
        this.id = requirement.getId();
        this.name = requirement.getRequirementName();
        this.projectComponentId = requirement.getProjectComponent().getId();
        this.description = requirement.getDescription();
        this.testCases = new ArrayList<>();
        for (TestCase testCase : requirement.getTestCases()) {
            this.testCases.add(new TestCaseDTO(testCase));
        }
    }
}
