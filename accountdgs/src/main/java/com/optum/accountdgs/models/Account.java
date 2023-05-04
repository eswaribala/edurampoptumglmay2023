package com.optum.accountdgs.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="Account")
public class Account {
  @Id
  @Column(name="Account_Id",nullable = false,length = 20)
  private String accountId;
  @Column(name="Running_Total")
  private Integer runningTotal;
  @Column(name="Open_Date",nullable = false,length = 12)
  private String openDate;
  @OneToMany(fetch = FetchType.LAZY,mappedBy = "account")
  //@JsonIgnore
  private List<Transaction> transactions;


}
