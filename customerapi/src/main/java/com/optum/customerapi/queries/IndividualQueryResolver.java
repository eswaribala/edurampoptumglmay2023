package com.optum.customerapi.queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.optum.customerapi.models.Customer;
import com.optum.customerapi.models.Individual;
import com.optum.customerapi.services.IndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IndividualQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private IndividualService individualService;

    public List<Individual> findAllIndividuals(){
          return this.individualService.getAllIndividuals();
    }
    public Individual findIndividualById(long accountNo){

        return this.individualService.getIndividualById(accountNo);
    }
    public List<Individual> findIndividualByName(String firstName){

        return this.individualService.getIndividualByFirstName(firstName);
    }



}
