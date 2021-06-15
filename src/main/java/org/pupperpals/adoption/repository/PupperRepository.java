package org.pupperpals.adoption.repository;

import org.pupperpals.adoption.model.Pupper;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PupperRepository extends JpaRepository<Pupper, Long> {

}
