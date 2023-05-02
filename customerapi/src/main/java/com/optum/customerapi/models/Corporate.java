package com.optum.customerapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name="Corporate")
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)

public class Corporate extends Customer{
    @Enumerated(EnumType.STRING)
    @Column(name="Company_Type")
    private CompanyType companyType;

    public Corporate(long accountNo, FullName name, String email, String password, long contactNo, CompanyType companyType) {
        super(accountNo, name, email, password, contactNo);
        this.companyType = companyType;
    }
}
