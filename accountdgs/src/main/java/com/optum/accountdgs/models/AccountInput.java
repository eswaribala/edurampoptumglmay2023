package com.optum.accountdgs.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountInput {
  private String accountId;

  private Integer runningTotal;

  private String openDate;

  private List<TransactionInput> transactions;

}
