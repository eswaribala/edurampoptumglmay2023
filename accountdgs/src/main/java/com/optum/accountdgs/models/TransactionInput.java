package com.optum.accountdgs.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionInput {
  private String transactionId;

  private Integer amount;

  private String timeStamp;

  private String sender;

  private String receiver;

  private AccountInput account;

}
