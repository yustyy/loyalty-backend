package com.ibw.skylab.loyaltybackend.business.concretes;

import com.ibw.skylab.loyaltybackend.business.abstracts.AuthService;
import com.ibw.skylab.loyaltybackend.business.abstracts.UserService;
import com.ibw.skylab.loyaltybackend.business.constants.AuthMessages;
import com.ibw.skylab.loyaltybackend.core.utilities.email.abstracts.EmailHelper;
import com.ibw.skylab.loyaltybackend.core.utilities.jwt.JwtHelper;
import com.ibw.skylab.loyaltybackend.core.utilities.results.*;
import com.ibw.skylab.loyaltybackend.entities.dtos.user.CreateUserDto;
import com.ibw.skylab.loyaltybackend.entities.dtos.user.LoginUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthManager implements AuthService {

    private final UserService userService;

    private final EmailHelper emailHelper;

    private final JwtHelper jwtHelper;

    private final AuthenticationManager authenticationManager;


    @Override
    public Result register(CreateUserDto createUserDto) {
        var userEmailResult = userService.getUserByEmail(createUserDto.getEmail());

        if(!userEmailResult.isSuccess()){
            return userEmailResult;
        }

        var userUsernameResult = userService.getUserByUsername(createUserDto.getUsername());

        if (!userUsernameResult.isSuccess()) {
            return userUsernameResult;
        }

        userService.addUser(createUserDto);
        emailHelper.sendEmail(createUserDto.getEmail(), "Welcome to our platform", "You have successfully registered to our platform");

        return new SuccessResult(AuthMessages.userRegistered);

    }

    @Override
    public DataResult<String> login(LoginUserDto loginUserDto) {

        if (loginUserDto.getEmail().isEmpty()) {
            return new ErrorDataResult<>(AuthMessages.emailCannotBeNull);
        }

        if (loginUserDto.getPassword().isEmpty()) {
            return new ErrorDataResult<>(AuthMessages.passwordCannotBeNull);
        }

        var email = loginUserDto.getEmail();
        var password = loginUserDto.getPassword();

        var userResult = userService.getUserByEmail(email);

        if (!userResult.isSuccess()) {
            return new ErrorDataResult<>(userResult.getMessage());
        }

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        if (authentication.isAuthenticated()) {
            var token = jwtHelper.generateToken(email);

            return new SuccessDataResult<>(token, AuthMessages.tokenGeneratedSuccessfully);
        }

        return new ErrorDataResult<>(AuthMessages.invalidUsernameOrPassword);

    }

    @Override
    public Result resetPassword(String email) {
        //will be written
        return null;
    }
}
