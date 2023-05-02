package com.optum.customerapi.models;

import lombok.Data;

@Data
public class IndividualInput {
    private long accountNo;
    private FullNameInput name;
    private String email;
    private String	password;
    private long contactNo;
    private String dob;
    private Gender gender;
}
