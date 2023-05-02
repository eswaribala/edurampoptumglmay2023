package com.optum.customerapi.services;

import com.optum.customerapi.models.Corporate;

import com.optum.customerapi.repositories.CorporateRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorporateService {
    @Autowired
    private CorporateRepo corporateRepo;

    //insert

    public Corporate addCorporate(Corporate corporate){

        return this.corporateRepo.save(corporate);
    }

    //select all

    public List<Corporate> getAllCorporates(){
        return this.corporateRepo.findAll();
    }

    //select by id

    public Corporate getCorporateById(long accountNo){
        return this.corporateRepo.findById(accountNo).orElse(null);
    }

    //select by firstname
    public List<Corporate> getCorporateByFirstName(String firstName){
        return this.corporateRepo.findByFirstName(firstName);
    }

    //update
    public Corporate updateCorporate(Corporate corporate){

        return this.corporateRepo.save(corporate);
    }


    //delete

    public boolean deleteCorporateById(long accountNo){
        boolean status=false;
        this.corporateRepo.deleteById(accountNo);
        if (getCorporateById(accountNo)==null){
            status=true;
        }
        return status;
    }

}
