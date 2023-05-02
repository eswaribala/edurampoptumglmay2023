package com.optum.customerapi.repositories;

import com.optum.customerapi.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Long> {
}
