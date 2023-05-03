package com.optum.customerapi.repositories;

import com.optum.customerapi.models.Customer;
import com.optum.customerapi.models.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,Long> {
    @Query("Select c from Customer c where c.name.firstName=:firstName")
    public List<Customer> findByFirstName(@Param("firstName") String firstName);
}
