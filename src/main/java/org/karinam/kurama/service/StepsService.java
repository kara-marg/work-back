package org.karinam.kurama.service;

import lombok.RequiredArgsConstructor;
import org.karinam.kurama.entity.domain.exceptions.StepNotFoundException;
import org.karinam.kurama.entity.model.Step;
import org.karinam.kurama.repository.StepsRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StepsService {
    private final StepsRepository repository;

    public Step saveSteps(Step step){
        return repository.save(step);
    }

    public Step getByStepsId(Long id){
        return repository.findById(id).orElseThrow(() -> new StepNotFoundException(id));
    }
}
