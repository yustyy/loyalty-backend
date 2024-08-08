package com.ibw.skylab.loyaltybackend.business.abstracts;

import com.ibw.skylab.loyaltybackend.core.utilities.results.DataResult;
import com.ibw.skylab.loyaltybackend.core.utilities.results.Result;
import com.ibw.skylab.loyaltybackend.entities.dtos.user.LoginUserDto;
import com.ibw.skylab.loyaltybackend.entities.dtos.user.RegisterUserDto;

public interface AuthService {

    Result register(RegisterUserDto registerUserDto);

    DataResult<String> login(LoginUserDto loginUserDto);

    Result resetPassword(String email);


}
