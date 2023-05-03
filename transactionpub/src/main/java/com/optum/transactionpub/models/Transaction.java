package com.optum.transactionpub.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private long transactionId;
    private long amount;
    private String timeStamp;
    private String sender;
    private String receiver;
}
