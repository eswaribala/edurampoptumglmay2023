package com.optum.customerapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndividualContactNo {

    private long accountNo;
    private long contactNo;
    private String timestamp;
}
