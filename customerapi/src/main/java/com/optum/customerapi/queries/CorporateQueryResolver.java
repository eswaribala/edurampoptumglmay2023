package com.optum.customerapi.queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.optum.customerapi.models.Corporate;
import com.optum.customerapi.models.Individual;
import com.optum.customerapi.services.CorporateService;
import com.optum.customerapi.services.IndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CorporateQueryResolver implements GraphQLQueryResolver {
    @Autowired
    private CorporateService corporateService;
    public List<Corporate> findAllCorporates(){
        return this.corporateService.getAllCorporates();
    }
    public Corporate findCorporateById(long accountNo){

        return this.corporateService.getCorporateById(accountNo);
    }
    public List<Corporate> findCorporateByName(String firstName){

        return this.corporateService.getCorporateByFirstName(firstName);
    }
}
