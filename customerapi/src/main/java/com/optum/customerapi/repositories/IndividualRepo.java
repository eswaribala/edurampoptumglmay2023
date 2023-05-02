package com.optum.customerapi.repositories;

import com.optum.customerapi.models.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IndividualRepo extends JpaRepository<Individual, Long> {
    @Query("Select i from Individual i where i.name.firstName=:firstName")
    public List<Individual> findByFirstName(@Param("firstName") String firstName);
}