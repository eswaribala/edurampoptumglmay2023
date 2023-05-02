package com.optum.customerapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name="Customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Account_No")
    private long accountNo;
    //value object
    @Embedded
    private FullName name;
    @Column(name="Email",nullable = false,length = 150)
    private String email;
    @Column(name="Password",nullable = false,length = 10)
    private String password;
    @Column(name="Contact_No")
    private long contactNo;

}
