package com.ibw.skylab.loyaltybackend.entities.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserDto {

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String phoneNumber;

    private String blockchainAddress;

}
