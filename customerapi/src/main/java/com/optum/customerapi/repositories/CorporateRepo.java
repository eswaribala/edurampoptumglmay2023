package com.optum.customerapi.repositories;

import com.optum.customerapi.models.Corporate;
import com.optum.customerapi.models.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CorporateRepo extends JpaRepository<Corporate, Long> {
    @Query("Select c from Corporate c where c.name.firstName=:firstName")
    public List<Corporate> findByFirstName(@Param("firstName") String firstName);
}
