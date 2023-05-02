package com.optum.customerapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name="Individual")
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)

public class Individual extends Customer{
   @Enumerated(EnumType.STRING)
   @Column(name="Gender")
    private Gender gender;
   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
   @Column(name="DOB")
    private LocalDate dob;

    public Individual(long accountNo, FullName name, String email, String password, long contactNo, Gender gender, LocalDate dob) {
        super(accountNo, name, email, password, contactNo);
        this.gender = gender;
        this.dob = dob;
    }
}
