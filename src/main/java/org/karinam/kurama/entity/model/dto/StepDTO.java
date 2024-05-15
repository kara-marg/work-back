package org.karinam.kurama.entity.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.karinam.kurama.entity.model.Step;

@Data
@NoArgsConstructor
public class StepDTO {
    private Long id;
    private Long testCaseId;

    private Integer stepNumber;

    private String expectedResult;
    private String action;

    public StepDTO(Step step){
        this.id = step.getId();
        this.testCaseId = step.getTestCase().getId();
        this.stepNumber = step.getStepNumber();
        this.expectedResult = step.getExpectedResult();
        this.action = step.getAction();
    }
}
