package org.karinam.kurama.repository;

import org.karinam.kurama.entity.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
    public Optional<TestCase> findByTestCaseName(String testCaseName);
}
