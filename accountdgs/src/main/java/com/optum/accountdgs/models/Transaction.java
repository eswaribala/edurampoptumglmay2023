package com.optum.accountdgs.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Transaction")
public class Transaction {
  @Id
  @Column(name="Transaction_Id",nullable = false,length = 20)
  private String transactionId;
  @Id
  @Column(name="Amount")
  private Integer amount;
  @Column(name="TimeStamp",nullable = false,length = 20)
  private String timeStamp;
  @Column(name="Sender",nullable = false,length = 100)
  private String sender;
  @Column(name="Receiver",nullable = false,length = 100)
  private String receiver;
  @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
  @JoinColumn(foreignKey = @ForeignKey(name = "Account_Id"), name = "Account_Id")
  private Account account;

}
