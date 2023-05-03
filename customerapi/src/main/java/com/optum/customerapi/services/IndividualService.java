package com.optum.customerapi.services;

import com.optum.customerapi.models.Individual;
import com.optum.customerapi.repositories.IndividualRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IndividualService {
    @Autowired
    private IndividualRepo individualRepo;

    //insert

    public Individual addIndividual(Individual individual){

        return this.individualRepo.save(individual);
    }

    //select all

    public List<Individual> getAllIndividuals(){
        return this.individualRepo.findAll();
    }

    //select by id

    public Individual getIndividualById(long accountNo){
        return this.individualRepo.findById(accountNo).orElse(null);
    }

    //select by firstname
    public List<Individual> getIndividualByFirstName(String firstName){
        return this.individualRepo.findByFirstName(firstName);
    }

    //update
    public Individual updateIndividual(Individual individual){

        return this.individualRepo.save(individual);
    }


    //delete

    public boolean deleteIndividualById(long accountNo){
        boolean status=false;
        this.individualRepo.deleteById(accountNo);
        if (getIndividualById(accountNo)==null){
            status=true;
        }
        return status;
    }



}
