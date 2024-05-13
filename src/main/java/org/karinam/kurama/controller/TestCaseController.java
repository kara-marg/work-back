package org.karinam.kurama.controller;

import lombok.RequiredArgsConstructor;
import org.karinam.kurama.entity.model.TestCase;
import org.karinam.kurama.entity.model.dto.TestCaseDTO;
import org.karinam.kurama.service.TestCaseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test-case")
@RequiredArgsConstructor
public class TestCaseController {
    private final TestCaseService testCaseService;

    @GetMapping("/{testCaseId}")
    public TestCaseDTO getById(@PathVariable long testCaseId){
        return testCaseService.getTestCaseById(testCaseId);
    }
    @PostMapping("/save")
    public TestCaseDTO saveTestCase(@RequestBody TestCaseDTO testCase){
        return testCaseService.saveTestCase(testCase);
    }
    


}
