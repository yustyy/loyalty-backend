package com.ibw.skylab.loyaltybackend.entities.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {

    private int firstName;

    private int lastName;

    private int username;

    private int email;

    private int phoneNumber;

    private int password;


}
