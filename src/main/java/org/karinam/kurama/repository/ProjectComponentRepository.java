package org.karinam.kurama.repository;

import org.karinam.kurama.entity.model.ProjectComponent;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectComponentRepository extends JpaRepository<ProjectComponent, Long> {
    List<ProjectComponent> findAllByProjectId(Long projectId, Sort sort);
}
