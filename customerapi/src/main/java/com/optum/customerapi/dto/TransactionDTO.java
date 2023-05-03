package com.optum.customerapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    private long transactionId;
    private long amount;
    private String timeStamp;
    private String sender;
    private String receiver;
}
