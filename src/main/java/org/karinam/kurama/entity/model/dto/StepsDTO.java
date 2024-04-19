package org.karinam.kurama.entity.model.dto;

import lombok.Data;
import org.karinam.kurama.entity.model.Steps;

@Data
public class StepsDTO {
    private Long id;
    private Long testCaseId;

    private String step;

    private String expectedResult;

    public StepsDTO(Steps steps){
        this.id = steps.getId();
        this.testCaseId = steps.getTestCase().getId();
        this.step = steps.getStep();
        this.expectedResult = steps.getExpectedResult();
    }
}
