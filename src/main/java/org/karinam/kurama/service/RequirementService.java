package org.karinam.kurama.service;

import lombok.RequiredArgsConstructor;
import org.karinam.kurama.entity.domain.exceptions.RequirementNotFoundException;
import org.karinam.kurama.entity.model.Requirement;
import org.karinam.kurama.entity.model.dto.RequirementDTO;
import org.karinam.kurama.repository.RequirementRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequirementService {
    private final RequirementRepository repository;

    public RequirementDTO getRequirementById(Long id) {
        Requirement requirement = repository.findById(id).orElseThrow(()
                -> new RequirementNotFoundException(id));
        return new RequirementDTO(requirement);
    }


}
