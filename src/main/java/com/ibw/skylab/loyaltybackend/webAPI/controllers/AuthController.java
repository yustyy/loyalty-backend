package com.ibw.skylab.loyaltybackend.webAPI.controllers;

import com.ibw.skylab.loyaltybackend.business.abstracts.AuthService;
import com.ibw.skylab.loyaltybackend.core.utilities.results.DataResult;
import com.ibw.skylab.loyaltybackend.core.utilities.results.Result;
import com.ibw.skylab.loyaltybackend.entities.dtos.user.CreateUserDto;
import com.ibw.skylab.loyaltybackend.entities.dtos.user.LoginUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<DataResult<String>> login(@RequestBody LoginUserDto loginUserDto) {
       var result = authService.login(loginUserDto);

       if (result.isSuccess()) {
           return ResponseEntity.ok(result);
       }

         return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/register")
    public ResponseEntity<Result> register(@RequestBody CreateUserDto createUserDto){
        var result = authService.register(createUserDto);

        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.badRequest().body(result);
    }

}
