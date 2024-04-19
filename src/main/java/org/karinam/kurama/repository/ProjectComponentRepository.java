package org.karinam.kurama.repository;

import org.karinam.kurama.entity.model.ProjectComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectComponentRepository extends JpaRepository<ProjectComponent, Long> {
}
