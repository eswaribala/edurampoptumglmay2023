package com.optum.dgsproject.repositories;

import com.optum.dgsproject.domains.Organization;
import org.springframework.data.repository.CrudRepository;


public interface OrganizationRepository extends CrudRepository<Organization, Integer> {
}
