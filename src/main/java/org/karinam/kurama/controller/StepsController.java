package org.karinam.kurama.controller;

import lombok.RequiredArgsConstructor;
import org.karinam.kurama.entity.model.Steps;
import org.karinam.kurama.service.StepsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/steps")
@RequiredArgsConstructor
public class StepsController {
    private final StepsService stepsService;

    @PostMapping("/save")
    public Steps saveSteps(@RequestBody Steps steps){
        return stepsService.saveSteps(steps);
    }

    @GetMapping("/{stepsId}")
    public Steps getById(@PathVariable Long stepsId){
        return  stepsService.getByStepsId(stepsId);
    }
}
