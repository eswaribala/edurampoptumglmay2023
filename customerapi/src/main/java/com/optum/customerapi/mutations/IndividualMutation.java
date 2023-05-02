package com.optum.customerapi.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.optum.customerapi.models.FullName;
import com.optum.customerapi.models.Gender;
import com.optum.customerapi.models.Individual;
import com.optum.customerapi.models.IndividualInput;
import com.optum.customerapi.services.IndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class IndividualMutation implements GraphQLMutationResolver {

    @Autowired
    private IndividualService individualService;

    public Individual addIndividual(IndividualInput individualInput){


        return this.individualService.addIndividual(new Individual(0,new FullName(
                individualInput.getName().getFirstName(),
                individualInput.getName().getMiddleName(),
                individualInput.getName().getLastName()),
                individualInput.getEmail(),
                individualInput.getPassword(),
                individualInput.getContactNo(),

                Gender.valueOf(individualInput.getGender()),
                LocalDate.parse(individualInput.getDob())));

    }
    public Individual updateIndividual(IndividualInput individualInput){
        return this.individualService.updateIndividual(new Individual(0,new FullName(
                individualInput.getName().getFirstName(),
                individualInput.getName().getMiddleName(),
                individualInput.getName().getLastName()),
                individualInput.getEmail(),
                individualInput.getPassword(),
                individualInput.getContactNo(),

                Gender.valueOf(individualInput.getGender()),
                LocalDate.parse(individualInput.getDob())));

    }
    public boolean deleteIndividual(long accountNo){
        return this.individualService.deleteIndividualById(accountNo);
    }
}
