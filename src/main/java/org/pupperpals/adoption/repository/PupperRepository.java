package org.pupperpals.adoption.repository;

import org.pupperpals.adoption.model.Pupper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PupperRepository extends JpaRepository<Pupper, Long> {

    @Modifying
    @Query("Update Pupper p set p.name = :name where p.id = :id")
    void updatePupperName(@Param("name") String name, @Param("id") Long id);

}
