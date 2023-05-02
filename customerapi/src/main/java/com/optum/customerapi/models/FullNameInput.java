package com.optum.customerapi.models;

import lombok.Data;

@Data
public class FullNameInput {
    private String firstName;

    private String lastName;

    private String middleName;
}
