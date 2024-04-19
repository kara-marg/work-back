package org.karinam.kurama.service;

import lombok.RequiredArgsConstructor;
import org.karinam.kurama.entity.domain.exceptions.StepNotFoundException;
import org.karinam.kurama.entity.model.Steps;
import org.karinam.kurama.repository.StepsRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StepsService {
    private final StepsRepository repository;

    public Steps saveSteps(Steps steps){
        return repository.save(steps);
    }

    public Steps getByStepsId(Long id){
        return repository.findById(id).orElseThrow(() -> new StepNotFoundException(id));
    }
}
