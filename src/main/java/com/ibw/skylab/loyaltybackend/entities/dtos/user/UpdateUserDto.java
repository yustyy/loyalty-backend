package com.ibw.skylab.loyaltybackend.entities.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateUserDto {

    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String blockchainAddress;
}
