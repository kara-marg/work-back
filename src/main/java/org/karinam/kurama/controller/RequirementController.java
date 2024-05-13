package org.karinam.kurama.controller;

import lombok.RequiredArgsConstructor;
import org.karinam.kurama.entity.model.dto.RequirementDTO;
import org.karinam.kurama.entity.model.dto.RequirementShortDTO;
import org.karinam.kurama.service.RequirementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requirement")
@RequiredArgsConstructor
public class RequirementController {
    private final RequirementService requirementService;

    @PostMapping("/save")
    public RequirementDTO saveRequirement(@RequestBody RequirementDTO requirement){
        return requirementService.saveRequirement(requirement);
    }

    @GetMapping("/{requirementId}")
    public RequirementDTO getById(@PathVariable long requirementId) {
        return requirementService.getRequirementById(requirementId);
    }
    @GetMapping("/project/{projectId}")
    public List<RequirementShortDTO> getAllRequirementsByProjectId(@PathVariable long projectId){
        return requirementService.getAllRequirementsByProjectId(projectId);
    }

}
