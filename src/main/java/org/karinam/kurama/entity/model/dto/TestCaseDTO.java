package org.karinam.kurama.entity.model.dto;

import lombok.Data;
import org.karinam.kurama.entity.model.Requirement;
import org.karinam.kurama.entity.model.TestCase;

import java.util.ArrayList;
import java.util.List;

@Data
public class TestCaseDTO {
    private Long id;

    private List<Long> coveredRequirementsList;

    private String name;

    private boolean isAutomated;

    private String result;

    private String environment;

    private String prerequisites;

    private String postCondition;

    //private List<StepsDTO> stepsDTOList;

    public TestCaseDTO(TestCase testCase){
        this.id = testCase.getId();
        this.name = testCase.getTestCaseName();
        this.isAutomated = testCase.isAutomated();
        this.result = testCase.getResult();
        this.environment = testCase.getEnvironment();
        this.prerequisites = testCase.getPrerequisites();
        this.postCondition = testCase.getPostCondition();
        this.coveredRequirementsList = new ArrayList<>();
        for (Requirement requirement : testCase.getRequirementsCovered()) {
            this.coveredRequirementsList.add(requirement.getId());
        }
    }

}
