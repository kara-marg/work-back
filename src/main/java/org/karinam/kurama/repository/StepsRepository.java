package org.karinam.kurama.repository;


import org.karinam.kurama.entity.model.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepsRepository extends JpaRepository<Step, Long> {

//   public Optional<Steps> findById(Long id);

}
