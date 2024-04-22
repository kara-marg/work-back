package org.karinam.kurama.controller;

import lombok.RequiredArgsConstructor;
import org.karinam.kurama.entity.model.dto.RequirementDTO;
import org.karinam.kurama.service.RequirementService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requirement")
@RequiredArgsConstructor
public class RequirementController {
    private final RequirementService requirementService;

    @GetMapping("/{requirementId}")
    public RequirementDTO getById(@PathVariable long requirementId) {
        return requirementService.getRequirementById(requirementId);
    }
}
