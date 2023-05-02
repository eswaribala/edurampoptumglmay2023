package com.optum.customerapi.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.optum.customerapi.models.*;
import com.optum.customerapi.services.CorporateService;
import com.optum.customerapi.services.IndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
public class CorporateMutation implements GraphQLMutationResolver {
    @Autowired
    private com.optum.customerapi.services.CorporateService CorporateService;

    public Corporate addCorporate(CorporateInput corporateInput){


        return this.CorporateService.addCorporate(new Corporate(0,new FullName(
                corporateInput.getName().getFirstName(),
                corporateInput.getName().getMiddleName(),
                corporateInput.getName().getLastName()),
                corporateInput.getEmail(),
                corporateInput.getPassword(),
                corporateInput.getContactNo(),
                CompanyType.valueOf (corporateInput.getCompanyType())));


    }
    public Corporate updateCorporate(CorporateInput corporateInput){
        return this.CorporateService.updateCorporate(new Corporate(0,new FullName(
                corporateInput.getName().getFirstName(),
                corporateInput.getName().getLastName(),
                corporateInput.getName().getMiddleName()),
                corporateInput.getEmail(),
                corporateInput.getPassword(),
                corporateInput.getContactNo(),
                CompanyType.valueOf (corporateInput.getCompanyType())));

    }
    public boolean deleteCorporate(long accountNo){
        return this.CorporateService.deleteCorporateById(accountNo);
    }
}
