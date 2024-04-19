package org.karinam.kurama.repository;


import org.karinam.kurama.entity.model.Steps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface StepsRepository extends JpaRepository<Steps, Long> {

//   public Optional<Steps> findById(Long id);

}
