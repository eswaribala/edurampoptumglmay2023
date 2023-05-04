package com.optum.dgsproject.fetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import com.optum.dgsproject.domains.Organization;
import com.optum.dgsproject.domains.OrganizationInput;
import com.optum.dgsproject.repositories.OrganizationRepository;


@DgsComponent
public class OrganizationMutation {

    OrganizationRepository repository;

    OrganizationMutation(OrganizationRepository repository) {
        this.repository = repository;
    }

    @DgsData(parentType = "MutationResolver", field = "newOrganization")
    public Organization newOrganization(@InputArgument("organization") OrganizationInput organizationInput) {
        return repository.save(new Organization(null, organizationInput.getName(), null, null));
    }

}
