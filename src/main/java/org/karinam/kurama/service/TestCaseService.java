package org.karinam.kurama.service;

import lombok.RequiredArgsConstructor;
import org.karinam.kurama.entity.domain.exceptions.TestCaseNotFoundException;
import org.karinam.kurama.entity.model.Step;
import org.karinam.kurama.entity.model.TestCase;
import org.karinam.kurama.entity.model.dto.RequirementShortDTO;
import org.karinam.kurama.entity.model.dto.StepDTO;
import org.karinam.kurama.entity.model.dto.TestCaseDTO;
import org.karinam.kurama.repository.RequirementRepository;
import org.karinam.kurama.repository.TestCaseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestCaseService {
    private final TestCaseRepository repository;
    private final RequirementRepository requirementRepository;

    public TestCaseDTO getTestCaseById(Long id){
        TestCase testCase = repository.findById(id).orElseThrow(()
                -> new TestCaseNotFoundException(id));
        return new TestCaseDTO(testCase);
    }

    public TestCaseDTO saveTestCase(TestCaseDTO testCaseDTO){
        TestCase testCase = new TestCase();
        testCase.setSteps(new ArrayList<>());

        if (testCaseDTO.getId() != null) {
            testCase = repository.getReferenceById(testCaseDTO.getId());
        }
        testCase.setTestCaseName(testCaseDTO.getName());
        testCase.setDescription(testCaseDTO.getDescription());
        if (testCaseDTO.getRequirementShortDTOList() != null) {
            List<Long> requirementsIds = new ArrayList<>();
            for (RequirementShortDTO requirementShortDTO : testCaseDTO.getRequirementShortDTOList()) {
                requirementsIds.add(requirementShortDTO.getId());
            }

            testCase.setRequirements(requirementRepository.findAllByIdIn(requirementsIds));
        }
        if (testCaseDTO.getSteps() != null) {
            testCase.getSteps().clear();
            for (StepDTO step : testCaseDTO.getSteps()) {
                testCase.getSteps().add(new Step(step.getId(), testCase, step.getAction(), step.getExpectedResult(), step.getStepNumber()));
            }
        }
        return new TestCaseDTO(repository.save(testCase));
    }


}
