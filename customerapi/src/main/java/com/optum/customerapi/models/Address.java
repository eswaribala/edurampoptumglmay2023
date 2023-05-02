package com.optum.customerapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="Address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Address_Id")
    private long addressId;
    @Column(name="Door_No",nullable = false,length = 10)
    private String doorNo;
    @Column(name="Street_Name",nullable = false,length = 150)
    private String streetName;
    @Column(name="City",nullable = false,length = 150)
    private String city;
    @Column(name="State",nullable = false,length = 150)
    private String state;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "Account_No"), name = "Account_No")
    private Customer customer;

}
