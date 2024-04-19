package org.karinam.kurama.controller;

import lombok.RequiredArgsConstructor;
import org.karinam.kurama.entity.model.TestCase;
import org.karinam.kurama.service.TestCaseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test-case")
@RequiredArgsConstructor
public class TestCaseController {
    private final TestCaseService testCaseService;

    @PostMapping("/save")
    public TestCase saveTestCase(@RequestBody TestCase testCase){
        return testCaseService.saveTestCase(testCase);
    }

    @GetMapping("/{testCaseId}")
    public TestCase getById(@PathVariable Long testCaseId){
        return testCaseService.getByTestCaseId(testCaseId);
    }

}
