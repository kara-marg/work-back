package org.karinam.kurama.repository;

import org.karinam.kurama.entity.model.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequirementRepository  extends JpaRepository<Requirement, Long> {
}
