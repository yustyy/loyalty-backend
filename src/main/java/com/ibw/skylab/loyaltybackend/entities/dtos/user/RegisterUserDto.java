package com.ibw.skylab.loyaltybackend.entities.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDto {

    private String email;

    private String password;

}
