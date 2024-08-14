package com.ibw.skylab.loyaltybackend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "corporate_companies")
public class CorporateCompany extends Company{

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "contact_person_first_name")
    private String contactPersonFirstName;

    @Column(name = "contact_person_last_name")
    private String contactPersonLastName;

    @Column(name = "contact_person_email")
    private String contactPersonEmail;

    @Column(name = "contact_person_phone_number")
    private String contactPersonPhoneNumber;

    @Column(name = "number_of_employees")
    private String numberOfEmployees;

    @Column(name = "company_website")
    private String companyWebsite;


}
