package org.karinam.kurama.repository;

import org.karinam.kurama.entity.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    public Optional<Project> findByProjectName(String name);
//    public Optional<Project> findById(Long id);


}
