package org.karinam.kurama.controller;

import lombok.RequiredArgsConstructor;
import org.karinam.kurama.entity.model.Step;
import org.karinam.kurama.service.StepsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/steps")
@RequiredArgsConstructor
public class StepsController {
    private final StepsService stepsService;

    @PostMapping("/save")
    public Step saveSteps(@RequestBody Step step){
        return stepsService.saveSteps(step);
    }

    @GetMapping("/{stepsId}")
    public Step getById(@PathVariable Long stepsId){
        return  stepsService.getByStepsId(stepsId);
    }
}
