package com.optum.customerapi.queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.optum.customerapi.models.Customer;
import com.optum.customerapi.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/*
query($firstName:String){
  searchByFirstName(firstName:$firstName){
    __typename
    ... on Individual{
      name{firstName}
    }
    ... on Corporate{
      email
    }
  }
}
 */
@Component
public class CustomerQueryResolver implements GraphQLQueryResolver {
    @Autowired
    private CustomerService customerService;
    public List<Customer> searchByFirstName(String firstName){
           return this.customerService.getCustomerByFirstName(firstName);
    }
}
