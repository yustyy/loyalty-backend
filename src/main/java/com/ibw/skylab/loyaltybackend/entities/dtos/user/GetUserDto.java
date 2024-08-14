package com.ibw.skylab.loyaltybackend.entities.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetUserDto {

    private int id;

    private String firstName;

    private String lastName;

    private String imageUrl;

    private String username;

    private String email;

    private String phoneNumber;

    private String blockchainAddress;

}
