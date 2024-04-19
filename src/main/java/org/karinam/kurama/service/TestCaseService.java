package org.karinam.kurama.service;

import lombok.RequiredArgsConstructor;
import org.karinam.kurama.entity.domain.exceptions.ProjectNotFoundException;
import org.karinam.kurama.entity.domain.exceptions.TestCaseNotFoundException;
import org.karinam.kurama.entity.model.TestCase;
import org.karinam.kurama.repository.TestCaseRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestCaseService {
    private final TestCaseRepository repository;

    public TestCase saveTestCase(TestCase testCase){
        return repository.save(testCase);
    }

    public TestCase getByTestCaseId(Long id){
        return repository.findById(id).orElseThrow(() -> new TestCaseNotFoundException(id));
    }




}
