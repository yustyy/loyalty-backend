package com.ibw.skylab.loyaltybackend.entities.dtos.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCompanyDto {

    //type of company
    private String companyType;

    //common
    private String email;
    private String phoneNumber;
    private String address;
    private String industry;

    //corporate company
    private String companyName;
    private String taxNumber;
    private String registrationDate;
    private String contactPersonFirstName;
    private String contactPersonLastName;
    private String contactPersonEmail;
    private String contactPersonPhoneNumber;
    private String numberOfEmployees;
    private String companyWebsite;

    //individual company
    private String firstName;
    private String lastName;
    private String birthDate;

}
