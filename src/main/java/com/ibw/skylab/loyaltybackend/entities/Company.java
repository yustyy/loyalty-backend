package com.ibw.skylab.loyaltybackend.entities;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
public class Company extends BaseEntity{

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "tax_number")
    private String taxNumber;

    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "industry")
    private String industry;

}
