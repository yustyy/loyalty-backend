package com.ibw.skylab.loyaltybackend.business.concretes;

import com.ibw.skylab.loyaltybackend.business.abstracts.AuthService;
import com.ibw.skylab.loyaltybackend.business.abstracts.UserService;
import com.ibw.skylab.loyaltybackend.core.utilities.email.abstracts.EmailHelper;
import com.ibw.skylab.loyaltybackend.core.utilities.results.DataResult;
import com.ibw.skylab.loyaltybackend.core.utilities.results.Result;
import com.ibw.skylab.loyaltybackend.entities.dtos.user.LoginUserDto;
import com.ibw.skylab.loyaltybackend.entities.dtos.user.RegisterUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthManager implements AuthService {

    private final UserService userService;

    private final EmailHelper emailHelper;


    @Override
    public Result register(RegisterUserDto registerUserDto) {
        return null;
    }

    @Override
    public DataResult<String> login(LoginUserDto loginUserDto) {
        return null;
    }

    @Override
    public Result resetPassword(String email) {
        return null;
    }
}
