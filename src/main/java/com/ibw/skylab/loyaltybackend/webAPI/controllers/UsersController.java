package com.ibw.skylab.loyaltybackend.webAPI.controllers;

import com.ibw.skylab.loyaltybackend.business.abstracts.UserService;
import com.ibw.skylab.loyaltybackend.entities.dtos.user.CreateUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {


    private final UserService userService;

    @PostMapping("/addUser")
    public void addUser(@RequestBody CreateUserDto createUserDto) {
        return;
    }

}
