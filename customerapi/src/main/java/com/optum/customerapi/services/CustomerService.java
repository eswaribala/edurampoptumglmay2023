package com.optum.customerapi.services;

import com.optum.customerapi.models.Customer;
import com.optum.customerapi.models.Individual;
import com.optum.customerapi.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
   @Autowired
    private CustomerRepo customerRepo;
    //select by firstname
    public List<Customer> getCustomerByFirstName(String firstName){
        return this.customerRepo.findByFirstName(firstName);
    }
}
